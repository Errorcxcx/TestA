package com.example.utils;

import android.accounts.NetworkErrorException;
import android.os.Build;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NetUtils {
    public static String post(String url, String name, String age) {
        HttpURLConnection connection = null;
        try {
            URL mUrl = new URL(url);
            connection = (HttpURLConnection) mUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            String data = "name=" + URLEncoder.encode(name, "UTF-8") +
                    "&age=" + URLEncoder.encode(age, "UTF-8");
            connection.setUseCaches(false);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
            dataOutputStream.writeBytes(data);
            dataOutputStream.flush();
            dataOutputStream.close();

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                String result = null;
                while ((line = bufferedReader.readLine()) != null) {
                    result = result+line;
                }
                bufferedReader.close();
                return result;
            }else {
                throw new NetworkErrorException("response status is"+responseCode);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NetworkErrorException e) {
            e.printStackTrace();
        } finally {
            if(connection!=null) {
                connection.disconnect();
            }
        }
        return null;

    }
    public static String A() throws Exception{
        System.out.println("111111111111");

//        int u = 1/0;
        System.out.println("222222222");
        try {
//            int i = 1/0;
            System.out.println("a22222a");

        }catch (Exception e){
            System.out.println("0000000000000");
            throw e;
        }finally {
            System.out.println("aaaa333aaaaa");

        }
        System.out.println("bbbbbbbbbb");

        return "555";
    }
    public static void main(String[] args) throws Exception {
//        Queue list = new LinkedList();

//       String i = A();
//       System.out.println(i);
//        sort(new int[]{4,5,8,6,1,});
        String[] cmd = { "/system/xbin/su", "-c", "cat /sys/kernel/debug/dma_buf/dmaprocs |grep "+770 };

        String[] list;
        // List<String> memInfo = new ArrayList<String>();
        Process p = Runtime.getRuntime().exec(cmd);
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String strLine = br.readLine();
        System.out.println(strLine);



//		if(strLine == null){
//			memInfo.set(num, memInfo.get(num)+","+0);
//		}
    }
    public static void sort(int[] strings){
        for(int i = 0;i<strings.length-1;i++){
            for(int j = 0;j<strings.length-i-1;j++){
                int tmp;
                if(strings[j]<strings[j+1]){
                    tmp = strings[j];
                    strings[j] = strings[j+1];
                    strings[j+1] = tmp;
                }
            }
        }
        for (int i:strings
             ) {
            System.out.println(i);

        }
    }
}
