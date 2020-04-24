package com.example.myapplication.util;

import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetUrlBitmap {
    public Bitmap bitmap;
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
}
