package com.example.retrofit.myhttp;

import android.util.Log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManager {
    private static class ThreadPoolManagerHolder{
        private static final ThreadPoolManager INSTANCE = new ThreadPoolManager();
    }

    public static final ThreadPoolManager getInstance(){
        return ThreadPoolManagerHolder.INSTANCE;
    }

    //创建延迟队列
    private DelayQueue<HttpTask> mDelayQueue = new DelayQueue<>();

    //将httptask添加到失败队列
    public void addDelayTask(HttpTask ht){
        if(ht == null){
            ht.setDelayTime(3000);
            mDelayQueue.offer(ht);

        }

    }

    //请求队列
    private LinkedBlockingQueue<Runnable> mQueue = new LinkedBlockingQueue<>();

    public void addTask(Runnable runnable){
        if(runnable!=null){
            try {
                mQueue.put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //创建线程池
    private ThreadPoolExecutor threadPoolExecutor;
    private ThreadPoolManager(){
        threadPoolExecutor = new ThreadPoolExecutor(3, 10, 15, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(4), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                addTask(r);
            }
        });
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(delayThread);
    }

    //创建核心线程

    public Runnable runnable = new Runnable() {
        Runnable runn = null;
        @Override
        public void run() {
            while(true){
                try {
                    runn = mQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadPoolExecutor.execute(runn);

            }
        }
    };

    //创建处理延迟队列的线程
    public Runnable delayThread = new Runnable() {
        HttpTask ht = null;
        @Override
        public void run() {
            while (true){
                try {
                    ht = mDelayQueue.take();
                    if(ht.getRetryCount()<3){
                        threadPoolExecutor.execute(ht);
                        ht.setRetryCount(ht.getRetryCount()+1);
                        Log.d("httptask", "重试机制"+ht.getRetryCount()+"次数");

                    }else {
                        Log.d("httptask", "失败太多");

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    };
}
