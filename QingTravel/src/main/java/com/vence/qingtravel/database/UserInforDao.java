package com.vence.qingtravel.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.vence.qingtravel.demon.UserInfor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xys on 2016/5/18.
 *
 * @author xyz
 * @version $Rev$
 * @time 2016/5/18 15:31
 * @updateAuthor $Author$
 * @updateDate $Date$
 */
public class UserInforDao {
    private DBhelper mBhelper;
    public static  final String TAG = "UserInforDao";


    public UserInforDao(Context context) {
        mBhelper = new DBhelper(context);
    }

    //登录查询
    public UserInfor loginSelect(String userName) {
        SQLiteDatabase db = mBhelper.getReadableDatabase();
        String sql = "select * from user_infor where username =?";
        UserInfor infor =null;
        Cursor cursor = db.rawQuery(sql, new String[]{userName});
        while (cursor.moveToNext()) {
            String userNam = cursor.getString(1);
            String passWord = cursor.getString(2);
            String imageUrl = cursor.getString(3);

            infor = new UserInfor();
            infor.setUserName(userNam);
            infor.setPassWord(passWord);
            infor.setImageUrl(imageUrl);
        }
        return infor;
    }

    //注册添加
    public boolean adduserInfor(UserInfor infor) {
        SQLiteDatabase db = mBhelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",infor.getUserName());
        values.put("password",infor.getPassWord());
        values.put("phonenumber",infor.getPhoneNum());
        long line = db.insert("user_infor", null, values);
        if (line > 0) {
            return true;
        } else {
            return false;
        }
    }

    //图片信息更新
    public void addImageUrl(String imageUrl) {
        SQLiteDatabase db = mBhelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("imageurl", imageUrl);
        long line = db.update("user_infor", values, "_id=?", new String[]{0 + ""});
        Log.d(TAG, "addImageUrl: " + line);
    }

    //修改密码
    public boolean editPassWord(String phoneNum,String passWord) {
        SQLiteDatabase db = mBhelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("password", passWord);
        long line = db.update("user_infor",values,"phonenumber=?",new String[]{phoneNum});
        Log.d(TAG, "editPassWord: " + line);
        return false;
    }

    //忘记密码验证
    public List<UserInfor> isCorrect(String phoneNum) {
        SQLiteDatabase db = mBhelper.getReadableDatabase();
        String sql = "select * from user_infor where phonenumber =?";
        List<UserInfor> data = new ArrayList<UserInfor>();
        Cursor cursor = db.rawQuery(sql, new String[]{phoneNum});
        while (cursor.moveToNext()) {
            String useraName = cursor.getString(1);
            String passWord = cursor.getString(2);

            UserInfor infor = new UserInfor();
            infor.setUserName(useraName);
            infor.setPassWord(passWord);
            data.add(infor);
        }
        return data;
    }

    //清除用户信息
    public void deteUserInfor() {
        SQLiteDatabase db = mBhelper.getReadableDatabase();
        long line = db.delete("user_infor",null,null);
        Log.d(TAG, "deteUserInfor: " + line);
    }
}
