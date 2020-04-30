package com.example.myapplication.update;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.util.Log;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

public class UpdateDialog {
    public static Handler handler;
    static void show(final Context context,String content,final String downloadUrl,final String downloadurl2){
        final ProgressBar progressBar;
        progressBar = DownloadDialog.setProgressDialog(context);
        if(isContextValid(context)){
            final String[] title = {null};
            AlertDialog.Builder builder =new AlertDialog.Builder(context);
            builder.setTitle("发现新版本");
            builder.setMessage("新版本福利多多，抢新体验")
                    .setPositiveButton("立即下载", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if((downloadUrl!=null)&&(downloadurl2!=null)){
                                goToDownload(context,downloadUrl);
//                                goToDownload(context,downloadurl2);

                            }

                        }
                    })
                    .setNegativeButton("下次一定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog dialog = builder.create();
            //点击对话框外面,对话框不消失
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        }
        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                Log.d("UpdateChecker", "handleMessage: "+msg.arg1);
                progressBar.setProgress(msg.arg1);
            }
        };
    }

    private static boolean isContextValid(Context context) {
        return context instanceof Activity && !((Activity) context).isFinishing();
    }
    public static void goToDownload(Context context, String downloadUrl) {
        Intent intent = new Intent(context.getApplicationContext(), DownLoadService.class);
        intent.putExtra("url1", downloadUrl);
        context.startService(intent);
    }
}
