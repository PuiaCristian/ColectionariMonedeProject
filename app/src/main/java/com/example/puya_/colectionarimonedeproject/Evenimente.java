package com.example.puya_.colectionarimonedeproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Evenimente extends AppCompatActivity {

    public static List<EvenimenteJavaClass> lista = new ArrayList<EvenimenteJavaClass>();
    public static ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evenimente);

        EvenimenteCustomAdapter e = new EvenimenteCustomAdapter(this,R.layout.layout_evenimente,lista);
        lv = (ListView) findViewById(R.id.listView_Evenimente);
        lv.setAdapter(e);

        Button adaugaEvenimente = (Button)findViewById(R.id.adaugaEvenimente_evenimente_button);
        adaugaEvenimente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),AdaugaEvenimente.class);
                startActivity(it);
            }
        });



    }
}
