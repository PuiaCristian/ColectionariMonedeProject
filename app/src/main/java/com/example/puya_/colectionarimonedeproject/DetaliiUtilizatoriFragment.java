package com.example.puya_.colectionarimonedeproject;

import android.app.Activity;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;



public class DetaliiUtilizatoriFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detalii_utilizatori,null);


        return view;
    }




//    public static DetaliiUtilizatoriFragment newInstance(int index){
//
//        DetaliiUtilizatoriFragment f = new DetaliiUtilizatoriFragment();
//
//        Bundle args = new Bundle();
//        args.putInt("index",index);
//
//        f.setArguments(args);
//
//        return  f;
//    }
//
//    public  int getShownIndex()
//    {
//        return  getArguments().getInt("index",0);
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//        ScrollView scroller = new ScrollView(getActivity());
//
//        TextView text = new TextView(getActivity());
//
//        int padding = (int)
//                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,4,getActivity().getResources().getDisplayMetrics());
//
//        text.setPadding(padding,padding,padding,padding);
//
//        scroller.addView(text);
//
//        text.setText(Login.utilizatorJavaClassListVali.get(getShownIndex()).getId());
//        return  scroller;
//    }
}
