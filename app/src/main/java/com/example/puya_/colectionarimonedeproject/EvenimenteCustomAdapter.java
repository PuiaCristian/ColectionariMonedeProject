package com.example.puya_.colectionarimonedeproject;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by puya_ on 11/24/2016.
 */

public class EvenimenteCustomAdapter extends ArrayAdapter {

    List<EvenimenteJavaClass> evenimente;

    public EvenimenteCustomAdapter(Context context, int resource, List<EvenimenteJavaClass> ev) {
        super(context, resource,ev);
        evenimente=ev;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.layout_evenimente,null);

        TextView nume = (TextView) customView.findViewById(R.id.nume_evenimente_textView);
        TextView locatie = (TextView) customView.findViewById(R.id.locatie_evenimente_textView);
        TextView descriere = (TextView) customView.findViewById(R.id.descriere_evenimente_textView);
        TextView data = (TextView) customView.findViewById(R.id.data_evenimente_tv);
        TextView site = (TextView) customView.findViewById(R.id.site_evenimente_tv);

        EvenimenteJavaClass e = evenimente.get(position);



//            nume.setText(ed.getNume().toString());
//            locatie.setText(ed.getNume().toString());
//            descriere.setText(ed.getNume().toString());
//            data.setText(ed.getNume().toString());

//

//        EvenimenteJavaClass c = new EvenimenteJavaClass(a._nume,a._locatie,a._descriere,a._data);



//        nume.setText(Evenimente.lista.);
//        locatie.setText(a._descriere);
//        descriere.setText(a._locatie);
//        data.setText(a._data);

//        for (EvenimenteJavaClass v : Evenimente.lista ) {
//            nume.setText(v.getNume());
//            nume.setText(v.getLocatie());
//            nume.setText(v.getDescriere());
//            nume.setText(v.getData());
//
//        }
        nume.setText(e.getNume());
        locatie.setText(e.getLocatie());
        descriere.setText(e.getDescriere());
        data.setText(e.getData());
        site.setText(e.getSite());




        return customView;
    }
}
