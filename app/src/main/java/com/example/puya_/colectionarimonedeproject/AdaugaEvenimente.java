package com.example.puya_.colectionarimonedeproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdaugaEvenimente extends AppCompatActivity {

    public   String _nume;
    public   String _locatie;
    public   String _descriere;
    public    String _data;

    public static List<EvenimenteJavaClass> listaEvenimente=new ArrayList<EvenimenteJavaClass>();



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

               // AdaugaEvenimente a = new AdaugaEvenimente();
                EvenimenteJavaClass ev = new EvenimenteJavaClass(_nume,_locatie,_descriere,_data);
                Evenimente.lista.add(ev);
                listaEvenimente.add(ev);
//                Intent it = new Intent(getApplicationContext(),Evenimente.class);
//                it.putExtra("nume",_nume);
//                it.putExtra("locatie",_locatie);
//                it.putExtra("descriere",_descriere);
//                it.putExtra("data",_data);

           //     startActivity(it);
               finish();


            }
        });
    }
}
