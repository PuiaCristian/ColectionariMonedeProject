package com.example.puya_.colectionarimonedeproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;



public class LicitatiiCustomAdapter extends ArrayAdapter<LicitatiiJavaClass> {


    List<LicitatiiJavaClass> date;
    public LicitatiiCustomAdapter(Context context, int resource, List<LicitatiiJavaClass> licitatii) {
        super(context, resource, licitatii);
        this.date=licitatii;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater li = LayoutInflater.from(getContext());

        View customView = li.inflate(R.layout.layout_licitatie,null);

        TextView t1 = (TextView) customView.findViewById(R.id.nume_licitatie_tv);
        TextView t2 = (TextView) customView.findViewById(R.id.descriere_licitatie_tv);
        TextView t3 = (TextView) customView.findViewById(R.id.pret_licitatie_tv);

        LicitatiiJavaClass lic = date.get(position);

        t1.setText(lic.getNume());
        t2.setText(lic.getDescriere());
        t3.setText(lic.getPretPornire());

        return customView;
    }
}
