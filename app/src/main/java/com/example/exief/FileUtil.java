package com.example.exief;

import java.io.File;

public class FileUtil {
    public void deleteImage(File file){
        if(file.exists()){
            if(file.isDirectory()){
                if(file.listFiles().length>0){
                    for (File childFile:file.listFiles()
                    ) {
                        deleteImage(childFile);
                    }
                }
            }else {
                file.delete();
            }
        }
    }
}
