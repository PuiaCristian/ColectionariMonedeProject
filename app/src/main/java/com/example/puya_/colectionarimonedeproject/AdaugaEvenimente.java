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

                 _nume=nume.getText().toString();
                 _locatie=locatie.getText().toString();
                 _descriere=descriere.getText().toString();
                _data = data.getText().toString();


                EvenimenteJavaClass ev = new EvenimenteJavaClass(_nume,_locatie,_descriere,_data);
                Evenimente.lista.add(ev);



//                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//                try {
//                    DocumentBuilder builder = factory.newDocumentBuilder() ;
//                    Document doc = builder.newDocument();
//
//                    Element radacina = doc.createElement("evenimente");
//                    Element adaugare = doc.createElement("adaugareEveniment");
//                    Element numeElement = doc.createElement("nume");
//                    Element locatieElement = doc.createElement("locatie");
//                    Element descriereElement = doc.createElement("descriere");
//                    Element dataElement = doc.createElement("data");
//
//                    Text t1 = doc.createTextNode(_nume);
//                    Text t2 = doc.createTextNode(_locatie);
//                    Text t3 = doc.createTextNode(_descriere);
//                    Text t4 = doc.createTextNode(_data);
//
//                    numeElement.appendChild(t1);
//                    locatieElement.appendChild(t2);
//                    descriereElement.appendChild(t3);
//                    dataElement.appendChild(t4);
//
//                    adaugare.appendChild(numeElement);
//                    adaugare.appendChild(locatieElement);
//                    adaugare.appendChild(descriereElement);
//                    adaugare.appendChild(dataElement);
//
//                    radacina.appendChild(adaugare);
//                    doc.appendChild(radacina);
//
//                    Transformer t = TransformerFactory.newInstance().newTransformer();
//                    t.transform(new DOMSource(doc),new StreamResult(new FileOutputStream(f)));
//
//                    //DOMSource source = new DOMSource(doc);
//
//
//                    //StreamResult result = new StreamResult(new File("C:\\Users\\puya_\\AndroidStudioProjects\\ColectionariMonedeProject\\fisierXml.xml"));
//
////                    t.transform(source,result);
//                   Log.d("fisier","s-a creat fisierul");
//
//
//                    //StreamResult rez = new StreamResult(System.out);
//
//
//                } catch (ParserConfigurationException e) {
//                    e.printStackTrace();
//                } catch (TransformerConfigurationException e) {
//                    e.printStackTrace();
//                } catch (TransformerException e) {
//                    e.printStackTrace();
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }

                try {
                    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    InputSource x = new InputSource("citire_xml.xml");
                    Document doc = builder.parse(x);

                    if(doc != null)
                    {
                        NodeList evenimente = doc.getElementsByTagName("eveniment");

                        for(int i=0;i<evenimente.getLength();i++){
                            Node nod = evenimente.item(i);
                            if(nod.getNodeType() == Node.ELEMENT_NODE){
                                Element elem = (Element) nod;
                                EvenimenteJavaClass ejc = new EvenimenteJavaClass();
                                ejc.setNume(elem.getElementsByTagName("nume").item(0).getTextContent());
                                ejc.setLocatie(elem.getElementsByTagName("locatie").item(0).getTextContent());
                                ejc.setDescriere(elem.getElementsByTagName("descriere").item(0).getTextContent());
                                ejc.setData(elem.getElementsByTagName("data").item(0).getTextContent());
                                ReadXmlEvenimente.l.add(ejc);
                            }
                        }
                    }
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                finish();
                Intent i = new Intent(getApplicationContext(),ReadXmlEvenimente.class);
                startActivity(i);

            }
        });
    }
}
