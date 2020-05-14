package com.example.retrofit.myhttp;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
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

    private LinkedBlockingDeque<Runnable> mQueue = new LinkedBlockingDeque<>();

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
    }

    //创建核心线程

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Runnable runn = null;
            try {
                runn = mQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadPoolExecutor.execute(runn);
        }
    };
}
