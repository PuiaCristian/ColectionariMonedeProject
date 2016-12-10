package com.example.puya_.colectionarimonedeproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class ListaDetalii extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_detalii);

        ListView lv = (ListView) findViewById(R.id.frag_simplu_listView);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                UtilizatorJavaClass u = Login.utilizatorJavaClassListVali.get(i);

                TextView nume = (TextView) findViewById(R.id.nume_fragDetalii_tv);
                TextView prenume =(TextView) findViewById(R.id.prenume_fragDetalii_tv);
                TextView email = (TextView) findViewById(R.id.email_fragDetalii_tv);

                nume.setText(u.getNume());
                prenume.setText(u.getPrenume());
                email.setText(u.getEmail());

            }
        });
    }
}
