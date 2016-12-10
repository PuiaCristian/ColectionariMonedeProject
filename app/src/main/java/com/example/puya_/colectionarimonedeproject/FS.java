package com.example.puya_.colectionarimonedeproject;


import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by puya_ on 12/10/2016.
 */

public class FS extends Fragment {

//
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_simplu,null);

        ArrayList<String> l = new ArrayList<String>();
        for(UtilizatorJavaClass u : Login.utilizatorJavaClassListVali){
            l.add(u.getUser());
        }

        ArrayAdapter<String> adp = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,l);
        ListView lv = (ListView) view.findViewById(R.id.frag_simplu_listView);
        lv.setAdapter(adp);

        return view;
    }
}
