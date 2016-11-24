package com.example.puya_.colectionarimonedeproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdaugaLicitatie extends AppCompatActivity {

    public String numeLicitatie;
    public String descriereLicitatie;
    public String pretLicitatie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_licitatie);


        Button add = (Button) findViewById(R.id.adaugaLicitatie_AdaugaLicitatie_button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView nume = (TextView) findViewById(R.id.nume_adaugaLicitatie_et);
                TextView descriere = (TextView) findViewById(R.id.descriere_adaugaLicitatie_et);
                TextView pret = (TextView) findViewById(R.id.pret_adaugaLicitatie_et);

                numeLicitatie=nume.getText().toString();
                descriereLicitatie=descriere.getText().toString();
                pretLicitatie=pret.getText().toString();


                LicitatiiJavaClass lic = new LicitatiiJavaClass(numeLicitatie,descriereLicitatie,pretLicitatie);
                Licitatii.listaLicitatii.add(lic);
                finish();

            }
        });
    }
}
