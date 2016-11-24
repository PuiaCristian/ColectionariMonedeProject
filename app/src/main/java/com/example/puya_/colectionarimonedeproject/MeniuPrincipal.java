package com.example.puya_.colectionarimonedeproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MeniuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meniu_principal);


        Button evenimente = (Button)findViewById(R.id.evenimente_meniuPinrcipal_button);
        evenimente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),Evenimente.class);
                startActivity(it);
            }
        });


        Button licitatii = (Button)findViewById(R.id.licitatii_meniuPinrcipal_button);
        licitatii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),Licitatii.class);
                startActivity(it);
            }
        });

        Button profil = (Button)findViewById(R.id.profil_meniuPinrcipal_button);
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),Profil.class);
                startActivity(it);
            }
        });



        Button utilizatori = (Button)findViewById(R.id.utilizatori_meniuPinrcipal_button);
        utilizatori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),Utilizatori.class);
                startActivity(it);
            }
        });

        Button about = (Button)findViewById(R.id.about_meniuPinrcipal_button);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),About.class);
                startActivity(it);
            }
        });
    }
}
