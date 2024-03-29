package com.example.app1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper
{public DBHelper(Context context) {
    super(context, "Userdata.db", null, 1);
}

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL(" create table Userdetails( name TEXT primary key)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL(" drop Table if exists Userdetails");

    }
    public Boolean insertuserdata(String name){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        long result=DB.insert("Userdetails",null,contentValues);
        if (result==-1){
            return false;
        }
        else {
            return true;
        }}
    public Cursor getData(){
        SQLiteDatabase DB=this.getWritableDatabase();

        Cursor cursor=DB.rawQuery(" Select * from Userdetails",null);

        return cursor;
    }

}
