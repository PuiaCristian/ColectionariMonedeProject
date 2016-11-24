package com.example.puya_.colectionarimonedeproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by puya_ on 11/24/2016.
 */

public class EvenimenteCustomAdapter extends ArrayAdapter {

    List<EvenimenteJavaClass> evenimente;

    public EvenimenteCustomAdapter(Context context, int resource, List<EvenimenteJavaClass> ev) {
        super(context, resource);
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

       // EvenimenteJavaClass e = evenimente.get(position);

        nume.setText(AdaugaEvenimente._nume);
        locatie.setText(AdaugaEvenimente._locatie);
        descriere.setText(AdaugaEvenimente._descriere);

        
        return customView;
    }
}
