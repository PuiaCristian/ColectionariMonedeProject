package com.example.puya_.colectionarimonedeproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Licitatii extends AppCompatActivity {

    public  static ListView listViewLicitatii;
    public static List<LicitatiiJavaClass> listaLicitatii= new ArrayList<LicitatiiJavaClass>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_licitatii);


        Button adaugaLicitatie = (Button)findViewById(R.id.adaugaLicitatie_licitatii_button);
        adaugaLicitatie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),AdaugaLicitatie.class);
                startActivity(it);
            }
        });



        LicitatiiCustomAdapter adp = new LicitatiiCustomAdapter(this,R.layout.layout_licitatie,listaLicitatii);

        listViewLicitatii= (ListView)findViewById(R.id.licitatii_Licitatii_listView);
        listViewLicitatii.setAdapter(adp);
    }
}
