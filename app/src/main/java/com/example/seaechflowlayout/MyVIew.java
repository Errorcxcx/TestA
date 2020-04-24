package com.example.seaechflowlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class MyVIew extends View {

    //文字
    private String mText;

    //文本颜色
    private int mTextColor;

    //
    private int mTextSize;

    //绘制时控制文本绘制的范围
    private Rect mBound;
    private Paint mPaint;

    public MyVIew(Context context){
        this(context,null);
    }
    public MyVIew(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public MyVIew(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //初始化
        mText = "Udf32fA";
        mTextColor = Color.BLACK;
        mTextSize = 100;

        mPaint = new Paint();
        mPaint.setTextSize(mTextSize);
        mPaint.setColor(mTextColor);
        //获得绘制文本的宽和高
        mBound = new Rect();
        mPaint.getTextBounds(mText, 0, mText.length(), mBound);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawText(mText,getWidth()/2-mBound.width()/2,getHeight() / 2 + mBound.height() / 2,mPaint);
    }
}
