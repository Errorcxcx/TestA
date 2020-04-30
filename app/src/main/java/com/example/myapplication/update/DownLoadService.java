package com.example.myapplication.update;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Message;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.media.app.NotificationCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.http.Url;

public class DownLoadService extends IntentService {
    private static final int BUFFER_SIZE = 10 * 1024; // 8k ~ 32K
    private static final int NOTIFICATION_ID = 0;
    private NotificationManager mNotifyManager;
    public DownLoadService() {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("UpdateChecker", "onHandleIntent:下载的service ");
        String appName = getString(getApplicationInfo().labelRes);
        int icon = getApplicationInfo().icon;
        String urlStr = intent.getStringExtra("url1");
        Log.d("UpdateChecker", "onHandleIntent: "+urlStr);
        InputStream is = null;
        OutputStream out = null;
        try {
            URL url  = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(false);
            connection.setConnectTimeout(10*1000);
            connection.setReadTimeout(10*1000);
            connection.setRequestProperty("Connection","Keep-Alive");
            connection.setRequestProperty("Charset","UTF-8");
            connection.setRequestProperty("Accept-Encoding","gzip,deflate");
            connection.connect();
            long bytetotal = connection.getContentLength();
            long bytesum = 0;
            int byteread = 0;
            is = connection.getInputStream();
            String apkName = urlStr.split("=")[1].split("&")[0];
            String Filename="/sdcard/"+apkName;
            File apkFile = new File( Filename);
            out = new FileOutputStream(apkFile);
            byte[] buffer = new byte[BUFFER_SIZE];
            int oldprogress = 0;
            Log.d("UpdateChecker", "onHandleIntent: 在写数据"+bytetotal);

            while((byteread = is.read(buffer))!=-1){
                bytesum+=byteread;
                Log.d("UpdateChecker", "onHandleIntent: 在写数据");
                out.write(buffer,0,byteread);
                int progress = (int) (bytesum*100L/bytetotal);
                if(progress!=oldprogress){
                    Message message = UpdateDialog.handler.obtainMessage();
                    message.arg1 = (int)progress;
                    UpdateDialog.handler.sendMessage(message);
                    if(progress == 100){
                        break;
                    }
                    oldprogress = progress;
                }
            }
            // 下载完成
            if (Filename.endsWith("apk")) {
                Log.i("UpdateChecker","下载完成");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
