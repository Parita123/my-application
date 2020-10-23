package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Userss.db";
    public static final String TABLE_NAME="users_table";
    public static final String COL_1="ID";
    public static final String COL_2="MOBILENUMBER";
    public static final String COL_3="PASSWORD";


    public DatabaseHelper(Context cn){
        super(cn,DATABASE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,MOBILENUMBER TEXT,PASSWORD TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          db.execSQL("drop table if exists " + TABLE_NAME);
          onCreate(db);
    }

    public boolean insertData(String mobile,String password){

        SQLiteDatabase sdb=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_2,mobile);
        cv.put(COL_3,password);

        long success = sdb.insert(TABLE_NAME,null,cv);

        if(success == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase sdb = this.getReadableDatabase();
        Cursor cs = sdb.rawQuery("select * from " + TABLE_NAME,null);
        return cs;
    }



}
