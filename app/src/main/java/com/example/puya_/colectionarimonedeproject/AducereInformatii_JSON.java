package com.example.puya_.colectionarimonedeproject;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



public class AducereInformatii_JSON extends AsyncTask<String,Void,List<EvenimenteJavaClass>>{

    public static List<EvenimenteJavaClass> listaEvenimenteJson = new ArrayList<>();
    @Override
    protected List<EvenimenteJavaClass> doInBackground(String... params) {


        try{
            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            InputStream is = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(inputStreamReader);


            StringBuilder json = new StringBuilder();
            String line = null;
            while ((line=reader.readLine()) != null)
            {
                json.append(line);
            }

            JSONObject jsonObject = new JSONObject(json.toString());


            JSONObject obj = jsonObject.getJSONObject("evenimente");

            JSONArray lista = obj.getJSONArray("eveniment");

            if(listaEvenimenteJson.isEmpty()) {
                for (int i = 0; i < lista.length(); i++) {
                    JSONObject element = lista.getJSONObject(i);
                    EvenimenteJavaClass evenimente = new EvenimenteJavaClass(element.getString("nume"),
                            element.getString("locatie"),
                            element.getString("descriere"),
                            element.getString("data"),
                            element.getString("site"));

                    listaEvenimenteJson.add(evenimente);

                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listaEvenimenteJson;
    }
}
