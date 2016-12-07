package com.example.puya_.colectionarimonedeproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class AdaugaEvenimente extends AppCompatActivity {

    public  String _nume;
    public  String _locatie;
    public  String _descriere;
    public  String _data;
    public  String _site;
    //public static List<EvenimenteJavaClass> listaEvenimente=new ArrayList<>();

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
                TextView site = (TextView) findViewById(R.id.site_adaugaEv_et);

                 _nume=nume.getText().toString();
                 _locatie=locatie.getText().toString();
                 _descriere=descriere.getText().toString();
                _data = data.getText().toString();
                _site = site.getText().toString();


                EvenimenteJavaClass ev = new EvenimenteJavaClass(_nume,_locatie,_descriere,_data,_site);
                Evenimente.lista.add(ev);
                AducereInformatii_JSON.listaEvenimenteJson.add(ev);


//                Intent i = new Intent(getApplicationContext(),Evenimente.class);
//                startActivity(i);


                finish();

            }
        });
    }
}
