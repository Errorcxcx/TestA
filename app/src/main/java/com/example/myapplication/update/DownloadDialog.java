package com.example.myapplication.update;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

public class DownloadDialog {
    public static ProgressBar setProgressDialog(Context context) {

        int llPadding = 30;
        LinearLayout ll = new LinearLayout(context);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setPadding(llPadding, llPadding, llPadding, llPadding);
        ll.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams llParam = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        llParam.gravity = Gravity.CENTER;
        ll.setLayoutParams(llParam);

        ProgressBar progressBar = new ProgressBar(context,null,android.R.attr.progressBarStyleHorizontal);
//        progressBar.setIndeterminate(true);
//        progressBar.setPadding(0, 0, llPadding, 0);
//        progressBar.setLayoutParams(llParam);
        progressBar.setProgress(50);
        llParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        llParam.gravity = Gravity.CENTER;
//        TextView tvText = new TextView(context);
//        tvText.setTextColor(Color.parseColor("#000000"));
//        tvText.setTextSize(20);
//        tvText.setLayoutParams(llParam);

        ll.addView(progressBar);
//        ll.addView(tvText);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(true);
        builder.setView(ll);

        AlertDialog dialog = builder.create();
        dialog.setTitle("正在下载");
        dialog.setMessage("下载了下载了下载了");
        dialog.show();
        Window window = dialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(dialog.getWindow().getAttributes());
            layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT;
            layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setAttributes(layoutParams);
        }
        return progressBar;
    }
}
