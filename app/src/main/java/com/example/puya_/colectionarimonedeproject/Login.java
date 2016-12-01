package com.example.puya_.colectionarimonedeproject;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);





        Button login = (Button) findViewById(R.id.logIn_logIn_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText user = (EditText) findViewById(R.id.user_logIn_editView);
                EditText pass = (EditText) findViewById(R.id.password_logIn_editText);

                String _user = user.getText().toString();
                String _pass = pass.getText().toString();

                if(_user.isEmpty() || _pass.isEmpty()){
                    Toast.makeText(Login.this, "Nu ati completat!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    MyDatabase database = new MyDatabase(ctx);
                    Cursor c=database.getUserData(database);
                    boolean stare = false;
                    c.moveToFirst();



                    do{
                        if(_user.equals(c.getString(0)) && (_pass.equals(c.getString(1)))){
                            stare = true;
                            String u = c.getString(0);
                            String p = c.getString(1);
                        }

                    }
                    while(c.moveToNext());

                    if(stare){
                        Intent i = new Intent(getApplicationContext(),MeniuPrincipal.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(Login.this, "Nu aveti cont!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Button signUp = (Button) findViewById(R.id.signUp_logIn_btn);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(),SignUp.class);
                startActivity(i);
            }
        });


    }
}
