package com.example.retrofit;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class retrofitTest {
    InputStream inputStream;
    OutputStream outputStream;
    public Context mContext;
    public Handler mHandler;
    public InfoGson mInfoGson;
    public ArrayList<InfoGson> list;
    public retrofitTest(Context context,Handler handler) {
        mContext = context;
        mHandler = handler;
        list = new ArrayList<>();
    }

    public List<InfoGson> main(String category,int page) {
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://gank.io/api/v2/data/category/"+category+"/type/Girl/page/"+page+"/count/20")
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(mContext,"获取数据失败",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("retrofit", "onResponse: "+response.isSuccessful());
                if(response.isSuccessful()){
//                    inputStream= response.body().byteStream();
//                    byte[] bytes = new byte[5096];
//                    int b = 0;
//                    String result = "";
//                    String line = "";
//                    while ((b=inputStream.read(bytes))!=-1){
//                        result = new String(bytes,0,b,"UTF-8");
//                        line = line+result;
//                    }
//                    inputStream.close();
//                    String line = response.body().string();
//                    Log.d("retrofit", "onResponse: "+line);

                    Gson gson = new Gson();
//                    mInfoGson = gson.fromJson(line, InfoGson.class);
                    String jsonData = response.body().string();
                    Log.d("retrofit", "onResponse: "+jsonData);
                    JsonObject Jobject = null;
                    try {
                        Jobject = new JsonParser().parse(jsonData).getAsJsonObject();
                        JsonArray jsonArray = Jobject.getAsJsonArray("data");
                        for (JsonElement info:jsonArray
                             ) {
                            Log.d("retrofit", "onResponse: "+info);
                           InfoGson infoGson =  gson.fromJson(info,new TypeToken<InfoGson>(){}.getType());
                           list.add(infoGson);
                        }

//                         Datas data= gson.fromJson(jsonData, new TypeToken<Datas>(){}.getType());
//                        Log.d("retrofit", "onResponse: "+((Datas)data).data.get(1).getUrl());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

//                    JSONArray Jarray = null;
//                    try {
//                        Jarray = Jobject.getJSONArray("data");
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//                    for (int i = 0; i < Jarray.length(); i++) {
//                        try {
//                            JSONObject object     = Jarray.getJSONObject(i);
//                            Log.d("retrofit", "onResponse: "+object.getString("url"));
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    Log.d("retrofit", "onResponse: "+((InfoGson)list.get(1)).getUrl());
                    mHandler.sendEmptyMessage(1);
              }
            }
        });

//        Retrofit retrofit = new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl("https://www.v2ex.com/api/")
//                .build();
//        Api api = retrofit.create(Api.class);
//        Call<ResponseBody> call = api.getINfo("Livid");
//        byte[] fileReader = new byte[4096];
//
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//
//                inputStream = response.body().byteStream();
//                int b = 0;
//                try{
//                    while ((b = inputStream.read(fileReader))!=-1){
//                    String str = new String(fileReader,"UTF-8");
//                        Log.d("retrofit", "onResponse: "+str);
//                }
//                    Log.d("retrofit", "onResponse: 请求成功");
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.d("retrofit", "onResponse: 请求失败");
//
//            }
//        });
        return list;
    }
}
