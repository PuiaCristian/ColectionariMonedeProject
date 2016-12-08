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


public class MyDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "user.db";
    public static final String TABLE_NAME = "user";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USER = "user";
    public static final String COLUMN_NUME = "nume";
    public static final String COLUMN_PRENUME = "prenume";
    public static final String COLUMN_DATA = "data";
    public static final String COLUMN_SEX = "sex";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";


    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USER + " TEXT UNIQUE, " + COLUMN_NUME + " TEXT, " + COLUMN_PRENUME + " TEXT, " +
                COLUMN_DATA + " DATE, " + COLUMN_SEX + " TEXT, " + COLUMN_EMAIL +
                " TEXT, " + COLUMN_PASSWORD + " TEXT " + ");";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }


    public void AdaugaElemente(User u) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER, u.getUser());
        values.put(COLUMN_NUME, u.getNume());
        values.put(COLUMN_PRENUME, u.getPrenume());
        values.put(COLUMN_DATA, u.getData());
        values.put(COLUMN_SEX, u.getSex());
        values.put(COLUMN_EMAIL, u.getEmail());
        values.put(COLUMN_PASSWORD, u.getParola());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_NAME, null, values);
        Log.d("date", "Datele au fost inserate");
        db.close();
    }


    public Cursor getUserData(MyDatabase database) {

        SQLiteDatabase sqLiteDatabase = database.getReadableDatabase();
        //// TODO: 12/2/2016 tot pt id
        String[] coloane = {COLUMN_USER, COLUMN_PASSWORD};
        Cursor c = sqLiteDatabase.query(TABLE_NAME, coloane, null, null, null, null, null);
        return c;
    }


    public Cursor userValid(MyDatabase database) {
        SQLiteDatabase sqLiteDatabase = database.getReadableDatabase();
        String[] col = {COLUMN_USER};
        Cursor c = sqLiteDatabase.query(TABLE_NAME, col, null, null, null, null, null);
        return c;
    }


    public Cursor getUserDataVali(MyDatabase database){

        SQLiteDatabase sqLiteDatabase = database.getReadableDatabase();
        //// TODO: 12/2/2016 tot pt id
        String[] coloane = {COLUMN_ID,COLUMN_NUME,COLUMN_PRENUME,COLUMN_USER,COLUMN_PASSWORD,COLUMN_DATA,COLUMN_EMAIL,COLUMN_SEX};
        Cursor c = sqLiteDatabase.query(TABLE_NAME,coloane,null,null,null,null,null);
        return c;
    }

}
