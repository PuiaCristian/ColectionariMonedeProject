package com.example.puya_.colectionarimonedeproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentDetalii extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_detalii);

        ListView lv = (ListView) findViewById(R.id.listaView_fragmentUtilizatori_lv);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                UtilizatorJavaClass u = Login.utilizatorJavaClassListVali.get(i);
                TextView nume = (TextView) findViewById(R.id.nume_fragmentDetaliiUtilizatori_tv);

                nume.setText(u.getNume());
            }
        });
    }
}
