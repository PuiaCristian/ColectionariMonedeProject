package com.example.puya_.colectionarimonedeproject;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Utilizatori extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilizatori);

        int screenOrintation= getResources().getConfiguration().orientation;

        if(screenOrintation == Configuration.ORIENTATION_PORTRAIT)
        {
            hideSidePanel();
        }


    }

    private void hideSidePanel(){
        View sidePane= findViewById(R.id.fragment_lista_utilizatori);
        if(sidePane.getVisibility() == View.VISIBLE)
        {
            sidePane.setVisibility(View.GONE);
        }
    }
}
