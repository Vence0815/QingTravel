package com.vence.qingtravel.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 作者：杨光福 on 2016/3/23 15:29
 * 微信：yangguangfu520
 * QQ号：541433511
 * 作用：数据缓存工具类
 */
public class CacheUtils {
    /**
     * 保存数据
     * @param context
     * @param key
     * @param value
     */
    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences("atguigu", Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).apply();

    }

    /**
     * 得到缓存数据
     *
     * @param context
     * @param key
     * @return
     */
    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences("atguigu", Context.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

    /**
     * 保持String类型数据
     *
     * @param context
     * @param key
     * @param values
     */
    public static void putString(Context context, String key, String values) {
        //判断是否有sdcard，如果存在就保持到sdcard里面
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            try {
                String fileName = MD5Encoder.encode(key);//lkj;lskl;skl;skl

                //mnt/scard/beijingnews/lkj;lskl;skl;skl (这是一个图片文件)
                File file = new File(Environment.getExternalStorageDirectory() + "/beijingnews3", fileName);

                File parentfile = file.getParentFile();
                if (!parentfile.exists()) {
                    parentfile.mkdirs();
                }
                //创建文本文件
                if(!file.exists()){
                    file.createNewFile();
                }

                FileOutputStream fos = new FileOutputStream(file);
                fos.write(values.getBytes());
                fos.flush();
                fos.close();

                //保持文件-文本信息

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{
            SharedPreferences sp = context.getSharedPreferences("atguigu", Context.MODE_PRIVATE);
            sp.edit().putString(key, values).apply();
        }

    }

    /**
     * 得到保持的String类型数据
     * @param context
     * @param key
     * @return
     */
    public static String getString(Context context, String key) {
        String result = "";
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){

            try {
                String fileName = MD5Encoder.encode(key);//lkj;lskl;skl;skl
                //mnt/scard/beijingnews/lkj;lskl;skl;skl (这是一个图片文件)
                File file = new File(Environment.getExternalStorageDirectory() + "/beijingnews3", fileName);

                if(file.exists()){

                    int lenth = -1;
                    byte[] buffer = new byte[1024];
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    FileInputStream fis = new FileInputStream(file);
                    while((lenth =fis.read(buffer))!=-1){
                        stream.write(buffer,0,lenth);
                    }

                    fis.close();
                    stream.close();
                    result = stream.toString();
                    return  result;

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            SharedPreferences sp = context.getSharedPreferences("atguigu", Context.MODE_PRIVATE);
            return sp.getString(key, "");
        }

        return  result;

    }
}
