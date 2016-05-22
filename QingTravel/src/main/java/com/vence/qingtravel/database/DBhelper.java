package com.vence.qingtravel.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * 数据库操作工具类
 * @author xys
 *
 */
public final class DBhelper extends SQLiteOpenHelper {

	public DBhelper(Context context) {
		super(context, "mycourse.db", null, 1);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table memo_edit(_id integer primary key autoincrement,cn varchar,date varchar,memo_con varchar)");
		db.execSQL("create table course_infor(_id integer primary key autoincrement,week_day integer,first_name varchar,first_address varchar,second_name varchar," +
				"second_address varchar,third_name varchar,third_address varchar,fourth_name varchar,fourth_address varchar," +
				"fifth_name varchar,fifth_address varchar)");
		db.execSQL("create table is_add(_id integer primary key autoincrement,week_day integer,is_add integer)");
		db.execSQL("create table person_infor(_id integer primary key autoincrement,school_name varchar,date varchar,department varchar,major varchar,qq varchar,mobile varchar)");
		db.execSQL("create table user_infor(_id integer primary key autoincrement,username varchar,password varchar,phonenumber varchar,imageurl varchar)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
