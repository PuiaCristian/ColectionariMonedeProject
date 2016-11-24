package com.example.puya_.colectionarimonedeproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Licitatii extends AppCompatActivity {

    public  static ListView listViewLicitatii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_licitatii);

        MeniuPrincipal.listaLicitatii = new ArrayList<LicitatiiJavaClass>();

        MeniuPrincipal.listaLicitatii.add(new LicitatiiJavaClass("moneda1","asd","170"));
        MeniuPrincipal.listaLicitatii.add(new LicitatiiJavaClass("moneda2","asd","170"));
        MeniuPrincipal.listaLicitatii.add(new LicitatiiJavaClass("moneda3","asd","170"));

        LicitatiiCustomAdapter adp = new LicitatiiCustomAdapter(this,R.layout.layout_licitatie,MeniuPrincipal.listaLicitatii);
        listViewLicitatii= (ListView)findViewById(R.id.licitatii_Licitatii_listView);
        listViewLicitatii.setAdapter(adp);
    }
}
