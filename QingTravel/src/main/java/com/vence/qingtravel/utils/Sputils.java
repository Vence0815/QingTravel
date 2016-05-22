package com.vence.qingtravel.utils;

import android.content.Context;
import android.content.SharedPreferences;

/*
 * Created by vence on 16/2/24.
 *
 * sp存储的工具类
 */
public class Sputils {

    private static SharedPreferences sp;
    private static Sputils instance = new Sputils();

    private Sputils() {
    }

    public static Sputils getInstance(Context context) {
        if (sp == null) {
            sp = context.getSharedPreferences("ms", Context.MODE_PRIVATE);
        }
        return instance;
    }

    /*
     * 1. 保存数据
     */
    public void save(String key, Object value) {
        if (value instanceof Integer) {
            sp.edit().putInt(key, (Integer) value).commit();
        } else if (value instanceof String) {
            sp.edit().putString(key, (String) value).commit();
        } else if (value instanceof Boolean) {
            sp.edit().putBoolean(key, (Boolean) value).commit();
        }
    }

    /*
     * 2. 读取数据
     */
    public int getInt(String key, int defValue) {
        return sp.getInt(key, defValue);
    }

    public String getString(String key, String defValue) {
        return sp.getString(key, defValue);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return sp.getBoolean(key, defValue);
    }

    /**
     * 读取数据
     *
     * @param key
     * @param defValue
     * @return
     */
    public <T> T get(String key, T defValue) {
        T t = null;
        if (defValue instanceof String || defValue == null) {
            String value = sp.getString(key, (String) defValue);
            t = (T) value;
        } else if (defValue instanceof Integer) {
            Integer value = sp.getInt(key, (Integer) defValue);
            t = (T) value;
        } else if (defValue instanceof Boolean) {
            Boolean value = sp.getBoolean(key, (Boolean) defValue);
            t = (T) value;
        }
        return t;
    }

    /*
     * 3. 移除数据
     */
    public void remove(String key) {
        sp.edit().remove(key).commit();
    }
}
