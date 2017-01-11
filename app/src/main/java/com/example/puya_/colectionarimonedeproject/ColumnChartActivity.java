package com.example.puya_.colectionarimonedeproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ColumnChartActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        List<LicitatiiJavaClass> lLicitatii = new ArrayList<>();
//        lLicitatii.add(new LicitatiiJavaClass("Licitatie 1","Descriere","10"));
//        lLicitatii.add(new LicitatiiJavaClass("Licitatie 1","Descriere","40"));
//        lLicitatii.add(new LicitatiiJavaClass("Licitatie 1","Descriere","100"));
        setContentView(new ColumnChart(getApplicationContext(),Licitatii.listaLicitatii));
    }
}
