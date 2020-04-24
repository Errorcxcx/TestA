package com.example.showbeatuy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetBitmap {
    public List<String> pathList;
    public String DIR = "/storage/emulated/0/DCIM/Camera/";
    public List<Bitmap> bitmapList;
    public List<Bitmap> getBitmaps(){
        File file = new File(DIR);
        if (file.exists()){
            pathList = Arrays.asList(file.list());
        }
        if(pathList.size()>0){
            bitmapList = new ArrayList<>();
            Matrix matrix = new Matrix();
            matrix.postScale(3f,3f);
            for (String path:pathList
                 ) {
                if(path.endsWith(".jpg")){
                    Log.d("beauty", "getBitmaps: "+path);
                    BitmapFactory.Options opt = new BitmapFactory.Options();
                    opt.inPreferredConfig = Bitmap.Config.RGB_565;
                    Bitmap bitmap = BitmapFactory.decodeFile("/storage/emulated/0/DCIM/Camera/"+path, opt);
                    Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
                    bitmapList.add(resizeBmp);
                }

            }

            Log.d("beauty", "getBitmaps: "+bitmapList.size()+"------"+pathList.size());

        }
        return bitmapList;

    }
}
