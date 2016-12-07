package com.example.puya_.colectionarimonedeproject;

import android.content.ClipData;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by rusuvalentin on 25/11/2016.
 */

public class ListaUtilizatoriFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lista_utilizatori,container,false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,SignUp.listaUtilizatori);
        ListView lv = (ListView) view.findViewById(R.id.utilizatori_Fragmentutilizatori_lv);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nume = SignUp.listaUtilizatori.get(position);

                String asd = "asd";
            }
        });

        return view;

    }
}
