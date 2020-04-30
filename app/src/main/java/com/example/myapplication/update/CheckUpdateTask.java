package com.example.myapplication.update;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.google.gson.Gson;

public class CheckUpdateTask extends AsyncTask<Void,Void,String> {

    private Context mContext;
    private boolean mShowDialog;
    private int mType;
    private AlertDialog alertDialog;
    private static final String url = "http://ate.sys.miui.com/mtbf/apk/checkVersionByPra.spring?path=apk";
    CheckUpdateTask(Context context,int type,boolean showDialog){
        mContext = context;
        mType = type;
        mShowDialog = showDialog;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if(mShowDialog){
            Log.d("UpdateChecker", "onPreExecute: ");
            alertDialog = MyDialog.setProgressDialog(mContext,"正在检查版本");

        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if(alertDialog!=null&&alertDialog.isShowing()){
            alertDialog.dismiss();
        }
        if (!TextUtils.isEmpty(result)) {
            parseJson(result);
            Log.d("UpdateChecker", "onPostExecute: "+result);
        }
    }
    private void parseJson(String result){
        Log.d("UpdateChecker", "parseJson: 解析json数据");
        try{
            Gson gson = new Gson();
            UpdateInfo updateInfo = gson.fromJson(result,UpdateInfo.class);
            String apkUrl2 = "http://ate.sys.miui.com/mtbf/download.spring?filename=signed_PLATFORM_app-debug.apk&path=apk";
            String apkUrl1 = "http://ate.sys.miui.com/mtbf/download.spring?filename=signed_PLATFORM_app-debug-androidTest.apk&path=apk";
            String  apkCode = updateInfo.getVersionName();
            float remoteVersion = Float.parseFloat(apkCode);
            String   apklocal =  AppUtils.getVersionName(mContext);
            float localeversion=Float.parseFloat(apklocal);
            Log.d("UpdateChecker", "parseJson: 解析json数据"+remoteVersion+"--"+localeversion);
            if(remoteVersion>localeversion){
                showDialog(mContext,updateInfo.updateMessage,apkUrl1,apkUrl2);
            }else if(mShowDialog){
                Toast.makeText(mContext, "已经是最新版本", Toast.LENGTH_SHORT).show();

            }
        }catch (Exception e){
            Log.d("UpdateChecker", "parseJson: 解析json数据失败");

            e.printStackTrace();
        }
    }

    private void showDialog(Context context,String content,String apkUrl,String apkUrl2) {
        UpdateDialog.show(context,content,apkUrl,apkUrl2);
    }

    @Override
    protected String doInBackground(Void... args) {
        Log.d("UpdateChecker", "doInBackground: ");

        return HttpUtil.getHttpReturn(url);
    }

}
