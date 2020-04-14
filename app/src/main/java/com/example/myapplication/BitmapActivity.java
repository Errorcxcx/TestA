package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.bumptech.glide.RequestBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.http.Url;

public class BitmapActivity extends AppCompatActivity {
    public ImageView webImage;
    public Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
        webImage = findViewById(R.id.image_web);
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what){
                    case 1 :
                        show();
                }
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                byte[] data = getBitmapBytes("http://img04.sogoucdn.com/app/a/100520024/388117fce2d37aa9a19656c7643e2a9c");
                bitmap = BitmapFactory.decodeByteArray(data,0,data.length);
                Message message  = handler.obtainMessage();
                message.what = 1;
                message.obj = bitmap;
                handler.sendMessage(message);
            }
        }).start();
    }
//    public Bitmap getBitmap(String url){
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .get()
//                .url(url)
//                .build();
//        Bitmap bitmap = null;
//        try{
//            Response response = client.newCall(request).execute();
//            int code = response.code();
//            System.out.println(code+"-----------"+code+response.body().string().getBytes());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return bitmap;
//    }
    public byte[] getBitmapBytes(String url){
        byte[] data = null;
        try {
            URL url1 = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            InputStream inputStream = connection.getInputStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[]  bytes = new byte[1024];
            int len = 0;
            while((len=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
            }
            data  = outputStream.toByteArray();
            outputStream.flush();
            outputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data ;
    }
    public void show(){
        if(bitmap!=null){
            webImage.setImageBitmap(bitmap);
        }
    }
    public void getConnect(String url){

    }

}
