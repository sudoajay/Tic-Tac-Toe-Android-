package com.sudoajay.tic_tac_toe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sudoajay on 2/6/18.
 */

public class Double_Data_Base extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Double_Data_Table.db";
    public static  String DATABASE_TABLE_NAME = "Double_Type_Table";
    public static final String col_1 = "ID";
    public static final String col_2 = "first_Name";
    public static final String col_3 = "second_Name";
    public Double_Data_Base(Context context  )
    {
        super(context, DATABASE_NAME, null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DATABASE_TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , " +
                "first_Name TEXT,second_Name TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_NAME);
        onCreate(db);
    }
    public void Fill_It(String first_Name , String second_Name ){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2,first_Name);
        contentValues.put(col_3,second_Name);
        sqLiteDatabase.insert(DATABASE_TABLE_NAME,null,contentValues);
    }
    public boolean check_For_Empty(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+DATABASE_TABLE_NAME,null);
        cursor.moveToFirst();
        int count = cursor.getCount();
        if(count > 0) {
            return false;
            }
        return true;
    }
    public Cursor Get_All_Data(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+DATABASE_TABLE_NAME,null);
        return cursor;
    }
    public void Update_The_Table(String id , String first_Name , String second_Name ){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,id);
        contentValues.put(col_2,first_Name);
        contentValues.put(col_3,second_Name);
        sqLiteDatabase.update(DATABASE_TABLE_NAME,contentValues,"ID = ?",new String[] { id });
    }

}
