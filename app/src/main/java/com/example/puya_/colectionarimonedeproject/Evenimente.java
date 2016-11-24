package com.example.puya_.colectionarimonedeproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    }
}
