package com.example.puya_.colectionarimonedeproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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






        Button adaugaEvenimente = (Button)findViewById(R.id.adaugaEvenimente_evenimente_button);
        adaugaEvenimente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),AdaugaEvenimente.class);
                startActivity(it);
            }
        });






        AducereInformatii_JSON aJson = new AducereInformatii_JSON(){
            @Override
            protected void onPostExecute(List<EvenimenteJavaClass> evenimente) {
                ListView lv = (ListView)findViewById(R.id.listView_Evenimente);
                final List<String> listaNumeEvenimente = new ArrayList<String>();
                for(EvenimenteJavaClass c:evenimente)
                {
                    listaNumeEvenimente.add(c.getNume());

                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,listaNumeEvenimente);
                lv.setAdapter(adapter);

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(getApplicationContext(),WebEvenimente.class);
                        i.putExtra("site",listaEvenimenteJson.get(position).getSite());
                        startActivity(i);
                    }
                });

            }
        };
        aJson.execute("https://node-rusuvalentin.c9users.io/android/JSON.txt");




    }


}


