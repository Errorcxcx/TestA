package com.example.exief;

import android.media.ExifInterface;
import android.media.MediaMetadata;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class GetExiefMessage {
    private static File Dir = null;
    public static String PRIMARY_STORAGE_PATH = "/storage/sfdcard0";
    public static String SECONDARY_STORAGE_PATH = "storage/sdcard1";
    public static String THIRDLY_STORAGE_PATH = "/storage/emulated/0/";
    private static final String TAG = "GetExiefMessage";
    public FileUtil fileUtil = new FileUtil();
    public static HashMap exifMap = new HashMap();

    private GetExiefMessage() {

    }

    private GetExiefMessage(String clear) {

    }

    /**
     * 单例获取实例
     */

    private static class getExiefMessageHolder {
        private static final GetExiefMessage getExiefMessage = new GetExiefMessage("clear");

    }

    public static GetExiefMessage getInstance() {
        return getExiefMessageHolder.getExiefMessage;

    }

    /**
     * 删除Camera中的图片
     *
     * @return
     * @throws IOException
     */
    public void clearCameraPhoto() throws IOException {
        Log.d(TAG, "clearCameraPhoto:Start");
        if (Build.VERSION.SDK_INT > 12) {
            Dir = new File(THIRDLY_STORAGE_PATH + "DICM/Camera/");
            Log.d(TAG, "clearCameraPhoto-THIRDLY_STORAGE_PATH: " + Dir.getPath());
        } else {
            if (Environment.getExternalStorageState(new File(SECONDARY_STORAGE_PATH)).equals("mounted")) {
                Dir = new File(SECONDARY_STORAGE_PATH + "DICM/Camera/");
                Log.d(TAG, "clearCameraPhoto-SECONDARY_STORAGE_PATH: " + Dir.getPath());

            } else if ((new File(PRIMARY_STORAGE_PATH)).exists()) {
                Dir = new File(PRIMARY_STORAGE_PATH + "DICM/Camera/");
                Log.d(TAG, "clearCameraPhoto-PRIMARY_STORAGE_PATH: " + Dir.getPath());

            }
        }
        if (Dir.exists() && Dir.listFiles().length > 0) {
            fileUtil.deleteImage(Dir);
        }
    }

    /**
     * 根据范围判断ISO
     *
     * @param exif   照片信息
     * @param maxISO 最大ISO
     * @param minISO 最小ISO
     */
    public void judgeImageISO(ExifInterface exif, int maxISO, int minISO) throws Exception {
        int iso;
        if (exif.getAttribute(ExifInterface.TAG_ISO_SPEED_RATINGS) != null) {
            iso = Integer.valueOf(exif.getAttribute(ExifInterface.TAG_ISO_SPEED_RATINGS));
            exifMap.put("ISO", iso);
            Log.d(TAG, "judgeImageISO: The iso is" + iso);
            if ((iso < minISO) || (iso > maxISO)) {
                fail("ISO value is out of bounds" + iso);
            }
        } else {
            assertNotNull(" ISO cannot be NUll", exif.getAttribute(ExifInterface.TAG_ISO_SPEED_RATINGS));

        }
    }

    /**
     * 判断图片的一些其他信息
     *
     * @param exif 照片信息
     */
    public String[] judgePhotoOtherInfo(ExifInterface exif) {
        String deviceBrand = exif.getAttribute(ExifInterface.TAG_MAKE);
        String deviceMode = exif.getAttribute(ExifInterface.TAG_MODEL);
        exifMap.put("DeviceBand", deviceBrand);
        exifMap.put("DeviceMode", deviceMode);
        //设备品牌
        assertNotNull(" MAKE Value cannot be NUll", exif.getAttribute(ExifInterface.TAG_MAKE));
        //设备型号
        assertNotNull(" MODEL Value cannot be NUll", exif.getAttribute(ExifInterface.TAG_MODEL));
        return new String[]{deviceBrand, deviceMode};
    }

    /**
     * 判断图像的光圈值
     *
     * @param exif          照片信息
     * @param imageAperture
     */
    public boolean judgeImageAperture(ExifInterface exif, String imageAperture) {
        boolean result = false;
        String realAperture = exif.getAttribute(ExifInterface.TAG_APERTURE_VALUE);
        exifMap.put("Aperture", realAperture);
        Log.d(TAG, "judgeImageAperture: image aperture " + realAperture);
        if (realAperture == null) {

            Assert.assertNotNull(" Image Main APERTURE cannot be NUll", null);
        } else {
            if (realAperture.equals(imageAperture)) {
                result = true;
            } else {
                result = false;
            }


        }
        return result;

    }

    /**
     * 图像的焦距
     *
     * @param exif             照片信息
     * @param imageFocalLength 焦距
     */
    public static boolean getImageFocalLength(ExifInterface exif, String imageFocalLength) {
        boolean result = false;
        String realFocalLength = exif.getAttribute(ExifInterface.TAG_FOCAL_LENGTH);
        exifMap.put("FocalLength", realFocalLength);
        Log.d(TAG, "judgeImageAperture: image focallength " + realFocalLength);
        if (realFocalLength == null) {
            Assert.assertNotNull(" Image Main focallength cannot be NUll", null);

        } else {
            if (realFocalLength.equals(imageFocalLength)) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;

    }

    /**
     * 判断是否是闪光灯模式下拍照
     */
    public boolean isFlashMode(String fileName) throws Exception {
        boolean result = false;
        Metadata mediaMetadata = JpegMetadataReader.readMetadata(new File(fileName));
        for (Directory directory : mediaMetadata.getDirectories()) {
            Log.d("getMessage", "isFlashMode: ---------");

            for (Tag tag : directory.getTags()) {
                Log.d("getMessage", "isFlashMode: " + tag);
                if (tag.getTagName().contains("Flash") && tag.getDescription().contains("flash fired")) {
                    result = true;
                }
            }
        }
        exifMap.put("flash_fired", result);

        return result;
    }

    /**
     * 获取图片分辨率
     */
    public void getImageSize(ExifInterface exif) throws Exception {
        String imagePhotoSize = exif.getAttribute(ExifInterface.TAG_IMAGE_WIDTH) + "*" + exif.getAttribute(ExifInterface.TAG_IMAGE_LENGTH);
        if ((exif.getAttribute(ExifInterface.TAG_IMAGE_WIDTH) == null) || (exif.getAttribute(ExifInterface.TAG_IMAGE_LENGTH)==null)) {

        }
    }


}
