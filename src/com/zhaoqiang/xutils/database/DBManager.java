package com.zhaoqiang.xutils.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.zhaoqiang.xutils.model.Book;

/**
 * Created by zhaoQiang on 2015/10/9.
 */
public class DBManager {
    //
    private static DBManager ourInstance;

    public static  DBManager newInstance(Context context){
        if (context!=null){
            if (ourInstance == null) {
                ourInstance = new DBManager(context);
            }
        }else {
            throw new IllegalArgumentException("Context must be set");
        }
        return ourInstance;
    }

    public static DBManager getInstance() {

        if(ourInstance==null){
            throw new IllegalStateException("Please invoke newInstance() before this method");
        }

        return ourInstance;
    }

    private Context context;

    private DBHelper helper;
    private DBManager(Context context) {
        this.context=context;
        helper = new DBHelper(context);
    }


    public long insertBook(Book book){

        long ret = 0;
        if (book!=null) {
            SQLiteDatabase db = helper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("title", book.getTitle());
            values.put("price", book.getPrice());
            values.put("author", book.getAuthor());
            ret = db.insert("books", null, values);
            db.close();
        }
        return ret;
    }

    public Book finalById(long id){
        return null;
    }


}
