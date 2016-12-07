package com.example.puya_.colectionarimonedeproject;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        AducereInformatii ai = new AducereInformatii(){
            @Override
            protected void onPostExecute(String s) {
                TextView tv  = (TextView)findViewById(R.id.descriere_about_tv);
                tv.setText(s);

            }
        };
        ai.execute("https://node-rusuvalentin.c9users.io/android/text.txt");
    }
}
class AducereInformatii extends AsyncTask<String,Void,String>
{

    @Override
    protected String doInBackground(String... params) {
        StringBuilder sb = new StringBuilder();

        try{
            URL url = new URL(params[0]);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            InputStream is = http.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);

            String line = null;
            while ((line = reader.readLine())!=null)
            {
                sb.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  sb.toString();
    }
}