package com.zhaoqiang.xutils;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.db.sqlite.WhereBuilder;
import com.lidroid.xutils.exception.DbException;
import com.zhaoqiang.xutils.database.DBHelper;
import com.zhaoqiang.xutils.database.DBManager;
import com.zhaoqiang.xutils.model.Book;

import java.util.List;


public class BooksActivity extends Activity
    {

        private DBHelper helper;
        private DbUtils dbUtils;

        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);

            helper = new DBHelper(getApplicationContext());

            setContentView(R.layout.books_activity);

//            //1，使用纯手工Sqlite操作数据库   也可以使用第三方xUtils操作数据库简化：
//            DBManager.newInstance(getApplicationContext());
//            initData();

            //2，简化  使用xUtils  操作数据库：
//            指定数据对象的内容    然后直接存储：
            dbUtils = DbUtils.create(getApplicationContext(), "book.db");


        }

        @Override
        protected void onResume() {
            super.onResume();

//            //添加数据：
//            for(int i=0;i<5;i++){
//                addBook();
//            }

            //查询数据：
            selectData();

            //删除数据：
            deleteData();

        }

        //删除  数据：
        private void deleteData() {
            //使用 whereBuilder删除数据：
            //1，准备WhereBuilder
            WhereBuilder builder=
                    WhereBuilder
                            .b("price","=",1000.0f);
            //
            try {
                dbUtils.delete(Book.class, builder);
            } catch (DbException e) {
                e.printStackTrace();
            }
        }

        private void selectData() {
            try {
//                //根据Id  // select * from books where _id = 5
                Book book = dbUtils.findById(Book.class,5L);
                Log.i("selectbook","第五条数据："+book);

                //自定义查询条件：
                Selector selector =
                        Selector.from(Book.class)
                                .where("price","=",1000.0f)
                                .and("_id","=",2L);
                List<Book> list = dbUtils.findAll(selector);

                for(Book bo:list){
                    Log.i("selectB","自定义查询条件："+bo);
                }

            } catch (DbException e) {
                e.printStackTrace();
            }
        }

        private void addBook() {
            //添加数据：
            Book book = new Book();
            book.setTitle("10天学会android");
            book.setPrice(1000.0f);
            book.setAuthor("zhaoqiang");

            try {
                //添加一个记录     对应的就是insert语句
                //内容   并没有设置Id   代表对象直接添加：
                dbUtils.save(book);
            } catch (DbException e) {
                e.printStackTrace();
            }
        }

        private void initData() {
            //使用dbManager 封装SQLite的数据库操作  避免每次都要获取SQLiteDatabase
            DBManager dbM = DBManager.getInstance();
            Book book = new Book();

            book.setTitle("书名");
            book.setPrice(1000.0f);
            book.setAuthor("张哥");
            long bid = dbM.insertBook(book);

            Log.d("DB", "book id" + bid);
        }

        public Book findById(long id)
        {
            Book ret = null;
            SQLiteDatabase db = helper.getReadableDatabase();

            Cursor cursor = db.query(
                    "books"
                    , null
                    , "_id = ?"
                    , new String[]{Long.toString(id)}
                    , null
                    , null
                    , null
            );

            if (cursor != null)
            {
                //TODO 解析
                if (cursor.moveToNext()) {
                    int index = cursor.getColumnIndex("_id");
                    if (index != -1)
                    {
                        ret.setId(cursor.getLong(index));
                    }
                    index = cursor.getColumnIndex("title");
                    if (index != -1)
                    {
                        ret.setTitle(cursor.getString(index));
                    }
                    index = cursor.getColumnIndex("price");
                    if (index != -1)
                    {
                        ret.setPrice(cursor.getFloat(index));
                    }
                    index = cursor.getColumnIndex("author");
                    if (index != -1)
                    {
                        ret.setAuthor(cursor.getString(index));
                    }

                }
            }
            return ret;
        }
    }
