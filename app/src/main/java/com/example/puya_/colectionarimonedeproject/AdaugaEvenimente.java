package com.example.puya_.colectionarimonedeproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdaugaEvenimente extends AppCompatActivity {

    public static String _nume;
    public static String _locatie;
    public static String _descriere;
    public static String _data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_evenimente);



        Button add = (Button) findViewById(R.id.add_adaugaEv_button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView nume = (TextView) findViewById(R.id.nume_adaugaEv_et);
                TextView locatie = (TextView) findViewById(R.id.locatie_adaugaEv_et);
                TextView descriere = (TextView) findViewById(R.id.descriere_adaugaEv_et);
                TextView data = (TextView) findViewById(R.id.data_adaugaEv_ev);


                 _nume=nume.getText().toString();
                 _locatie=locatie.getText().toString();
                 _descriere=descriere.getText().toString();
                _data = data.getText().toString();


                EvenimenteJavaClass ev = new EvenimenteJavaClass(_nume,_locatie,_descriere,_data);
                Evenimente.lista.add(ev);
                finishActivity(0);


            }
        });
    }
}
