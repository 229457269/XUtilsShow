package com.zhaoqiang.xutils.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zhaoQiang on 2015/10/9.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "app.db";
    public static final int DB_VER = 1;
    public static final String CREATE_TABLE_BOOKS =
            "create table books (" +
                    " _id integer primary key autoincrement," +
                    "title text not null,"+
                    "price real default 0,"+
                    "author text default 'None'"+
                    ")";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override//仅用于第一次初始化数据库
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_BOOKS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
