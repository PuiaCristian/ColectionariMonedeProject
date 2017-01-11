package com.example.puya_.colectionarimonedeproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.SingleLineTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    Context ctx = this;
    public static String _user;


    public static List<UtilizatorJavaClass> utilizatorJavaClassListVali = new ArrayList<UtilizatorJavaClass>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //sharedPreferences
        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        String userSP = sp.getString("username","");
        String parolaSP = sp.getString("password","");

        ((EditText)findViewById(R.id.user_logIn_editView)).setText(userSP);
        ((EditText)findViewById(R.id.password_logIn_editText)).setText(parolaSP);

       // ctx.deleteDatabase(MyDatabase.DATABASE_NAME);


        Button login = (Button) findViewById(R.id.logIn_logIn_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText user = (EditText) findViewById(R.id.user_logIn_editView);
                EditText pass = (EditText) findViewById(R.id.password_logIn_editText);

                 _user = user.getText().toString();
                String _pass = pass.getText().toString();


                MyDatabase database = new MyDatabase(ctx);
                SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
                String count = "SELECT count(*) FROM user";
                Cursor cursor = sqLiteDatabase.rawQuery(count, null);
                cursor.moveToFirst();



                Cursor cUtil = database.getUserDataVali(database);
                cUtil.moveToFirst();


                int index = cursor.getInt(0);

                if (index <= 0) {

                    Toast.makeText(Login.this, "Este necesara crearea unui cont!", Toast.LENGTH_SHORT).show();
                } else {


                    if (_user.isEmpty() || _pass.isEmpty()) {
                        Toast.makeText(Login.this, "Nu ati completat!", Toast.LENGTH_SHORT).show();
                    } else {

                        Cursor c = database.getUserData(database);
                        c.moveToFirst();
                        SignUp.listaUtilizatori.clear();
                        //int ixx = 0;
                        do {
                            SignUp.listaUtilizatori.add(c.getString(0));
                            String l = SignUp.listaUtilizatori.get(0);
                            //ixx++;

                        } while (c.moveToNext());

                        boolean stare = false;
                        c.moveToFirst();


                        do {

                            if (_user.equals(c.getString(0)) && (_pass.equals(c.getString(1)))) {

                                stare = true;

                                SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();

                                editor.putString("username",_user);
                                editor.putString("password",_pass);
                                editor.commit();


                            }

                        }
                        while (c.moveToNext());


                        if (stare) {
                            utilizatorJavaClassListVali.clear();

                            do {


                                String id = cUtil.getString(0);
                                String nume = cUtil.getString(1);
                                String prenume = cUtil.getString(2);
                                String username = cUtil.getString(3);
                                String parola = cUtil.getString(4);
                                String data = cUtil.getString(5);
                                String email = cUtil.getString(6);
                                String sex = cUtil.getString(7);

                                UtilizatorJavaClass ut = new UtilizatorJavaClass(id, nume, prenume, username, parola, data, email, sex);
                                utilizatorJavaClassListVali.add(ut);



                            } while (cUtil.moveToNext());

                            Intent i = new Intent(getApplicationContext(), MeniuPrincipal.class);
                            startActivity(i);
                        } else {

                            Toast.makeText(Login.this, "User sau parola gresita!", Toast.LENGTH_SHORT).show();

                        }
                    }

                }
            }
        });

        Button signUp = (Button) findViewById(R.id.signUp_logIn_btn);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SignUp.class);
                startActivity(i);
            }
        });


    }
}
