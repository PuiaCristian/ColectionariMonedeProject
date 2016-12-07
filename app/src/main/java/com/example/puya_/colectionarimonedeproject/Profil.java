package com.example.puya_.colectionarimonedeproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Profil extends AppCompatActivity {

    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        MyDatabase database = new MyDatabase(ctx);
        SQLiteDatabase sql = database.getWritableDatabase();
        Cursor cursor= database.getUserDataVali(database);
        String count = "select count(*) from user";
        Cursor c = sql.rawQuery(count,null);
        c.moveToFirst();
        int index = c.getInt(0);
        cursor.moveToFirst();

        if(index > 0) {
            //String s = Login._user;


            do {
                if (Login._user.equals(cursor.getString(3))) {
                    TextView user = (TextView) findViewById(R.id.user_profil_tv);
                    TextView nume = (TextView) findViewById(R.id.nume_profil_tv);
                    TextView prenume = (TextView) findViewById(R.id.prenume_profil_tv);

                    user.setText(cursor.getString(3));
                    nume.setText(cursor.getString(1));
                    prenume.setText(cursor.getString(2));
                }
            }
            while (cursor.moveToNext());
        }
    }
}
