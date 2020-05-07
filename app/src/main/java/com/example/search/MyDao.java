package com.example.search;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyDao {
    private MySqliteHelper sqliteHelper ;
    private static volatile MyDao myDao;
    SQLiteDatabase db;
    private MyDao(Context context) {
        sqliteHelper = new MySqliteHelper(context);
    }

    public static MyDao getInstance(Context context){
        if(myDao == null){
            synchronized (MyDao.class){
                if(myDao == null){
                    myDao = new MyDao(context);
                }
            }
        }
        return myDao;
    }

    //判断是否含有该搜索记录
    public boolean isHasRecord(String record){
        boolean isHasRecord = false;
        db = sqliteHelper.getReadableDatabase();
        Cursor cursor = db.query("records",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            if(record.equals(cursor.getString(cursor.getColumnIndexOrThrow("name")))){
                isHasRecord = true;
                break;
            }
        }
        db.close();
        cursor.close();
        return isHasRecord;
    }

    //添加搜索记录
    public void addRecords(String record){
        if(!isHasRecord(record)){
            db = sqliteHelper.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("name",record);
            db.insert("records",null,cv);
            db.close();
        }
    }
    //获取全部搜索记录
    public List<String> getRecordsList(){
        List<String> list = new ArrayList<>();
        db = sqliteHelper.getReadableDatabase();
        Cursor cursor = db.query("records",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            String record = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            list.add(record);
        }
        db.close();
        cursor.close();
        return list;
    }

    //模糊查询
    public List<String> querySimlarRecord(String record){
        String queryStr = "select * from records where name like '%"+record+"%' order by name";
        Log.d("MyAdapter", "querySimlarRecord: "+queryStr);
        db = sqliteHelper.getReadableDatabase();
        List<String> similarRecords = new ArrayList<>();

        Cursor cursor = db.rawQuery(queryStr,null);
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            similarRecords.add(name);
        }
        db.close();
        cursor.close();
        return similarRecords;
    }

    //清空搜索记录
    public void deleteAllRecords(){
        db = sqliteHelper.getWritableDatabase();
        db.execSQL("DELETE FROM records");

        db.close();
    }
}
