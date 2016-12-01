package com.example.puya_.colectionarimonedeproject;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import static android.R.attr.data;
import static android.R.attr.id;

/**
 * Created by rusuvalentin on 24/11/2016.
 */

public class MyDatabase extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="user.db";
    public static final String TABLE_NAME="user";
    public static final String COLUMN_ID="id";
    public static final String COLUMN_USER="user";
    public static final String COLUMN_NUME="nume";
    public static final String COLUMN_PRENUME="prenume";
    public static final String COLUMN_DATA="data";
    public static final String COLUMN_SEX="sex";
    public static final String COLUMN_EMAIL="email";
    public static final String COLUMN_PASSWORD="password";



//    public static final String CREARE= "create table user (id integer primary key not null auto_increment , " +
//            " user text not null , "

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USER + " TEXT, " + COLUMN_NUME + " TEXT, " + COLUMN_PRENUME + " TEXT, " +
                COLUMN_DATA + " DATE, " + COLUMN_SEX + " TEXT, " + COLUMN_EMAIL +
                " TEXT, " + COLUMN_PASSWORD + " TEXT " + ");";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }


    public void AdaugaElemente(User u){

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER,u.getUser());
        values.put(COLUMN_NUME,u.getNume());
        values.put(COLUMN_PRENUME,u.getPrenume());
        values.put(COLUMN_DATA,u.getData());
        values.put(COLUMN_SEX,u.getSex());
        values.put(COLUMN_EMAIL,u.getEmail());
        values.put(COLUMN_PASSWORD,u.getParola());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_NAME,null,values);
        Log.d("date","Datele au fost inserate");
        db.close();
    }

//    public boolean validare(String utilizator, String parola) {
//        String query = "select * from " + TABLE_NAME + " where " + COLUMN_USER + " = " +
//                "'" + utilizator + "'" + " and " + COLUMN_PASSWORD + " = " + "'" + parola + "'";
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor c = db.rawQuery(query, null);
////        c.moveToFirst();
////
////        if(c.getCount() > 0)
////        {
////            return true;
////        }
////        c.close();
////        db.close();
////        return false;
//
//        if (c.moveToFirst()) {
//            do {
//                utilizator = c.getString(c.getColumnIndex(COLUMN_USER));
//                parola = c.getString(c.getColumnIndex(COLUMN_PASSWORD));
//                // do what ever you want here
//            } while (c.moveToNext());
//
//        }
//        if(c.getCount() > 0)
//            return true;
//        c.close();
//        return false;
//    }


    public Cursor getUserData(MyDatabase database){
       // MyDatabase d = new MyDatabase(this);
       SQLiteDatabase sqLiteDatabase = database.getReadableDatabase();
        String[] coloane = {COLUMN_USER,COLUMN_PASSWORD};
        Cursor c = sqLiteDatabase.query(TABLE_NAME,coloane,null,null,null,null,null);
        return c;
    }

    public String getPasswordData(String pass){
        return pass;
    }

}
