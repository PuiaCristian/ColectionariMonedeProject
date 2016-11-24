package com.example.puya_.colectionarimonedeproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    MyDatabase database = new MyDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);




        Button add = (Button)  findViewById(R.id.add_signUp_btn);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText user = (EditText) findViewById(R.id.user_signUp_editText);
                EditText nume = (EditText) findViewById(R.id.nume_signUp_editText);
                EditText prenume = (EditText) findViewById(R.id.prenume_signUp_editText);
                EditText data = (EditText) findViewById(R.id.dataNasterii_signUp_editText);
                RadioGroup sex = (RadioGroup) findViewById(R.id.sex_signUp_radioGroup);
                EditText email = (EditText) findViewById(R.id.email_signUp_editText);
                EditText password = (EditText) findViewById(R.id.password_signUp_editView);
                EditText retypePassword = (EditText) findViewById(R.id.retypepassword_signUp_editView);

                String _user = user.getText().toString();
                String _nume = nume.getText().toString();
                String _prenume = prenume.getText().toString();
                String _data = data.getText().toString();


//                if(sex.getCheckedRadioButtonId()!=-1){
//                    int idRadio= sex.getCheckedRadioButtonId();
//                    View radioButton = sex.findViewById(idRadio);
//                    int radioId = sex.indexOfChild(radioButton);
//                    RadioButton radioBtn = (RadioButton) sex.getChildAt(radioId);
//                    String _sex =  radioBtn.getText().toString();
//                }


                int a = sex.getCheckedRadioButtonId();
                RadioButton rb  = (RadioButton) sex.findViewById(a);
                String _sex = rb.getText().toString();



                String _email = email.getText().toString();
                String _password = password.getText().toString();
                String _retypePaswword = retypePassword.getText().toString();

                if(!_password.equals(_retypePaswword))
                {
                    Toast.makeText(SignUp.this, "Parola nu se potriveste!", Toast.LENGTH_SHORT).show();
                }

                else if (_user.isEmpty() || _nume.isEmpty() || _prenume.isEmpty() || _data.isEmpty() || _sex.isEmpty()
                        || _email.isEmpty() || _password.isEmpty()){

                    Toast.makeText(SignUp.this, "Nu ati completate corespunzator", Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(SignUp.this, "Merge", Toast.LENGTH_SHORT).show();

                    User u = new User(user.getText().toString(),nume.getText().toString(),prenume.getText().toString(),
                            data.getText().toString(),_sex,email.getText().toString(),password.getText().toString());
//                    u.setUser(_user);
//                    u.setNume(_nume);
//                    u.setPrenume(_prenume);
//                    u.setData(_data);
//                    u.setSex(_sex);
//                    u.setEmail(_email);
//                    u.setParola(_password);

                    database.AdaugaElemente(u);
                    Intent i = new Intent(getApplicationContext(),Login.class);
                    startActivity(i);

                }
            }
        });



    }
}
