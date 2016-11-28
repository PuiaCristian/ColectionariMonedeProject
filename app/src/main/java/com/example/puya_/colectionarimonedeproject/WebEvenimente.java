package com.example.puya_.colectionarimonedeproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebEvenimente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_evenimente);


        String site = getIntent().getExtras().getString("site");
        WebView webView = (WebView) findViewById(R.id.webEv_webEvenimente_web);
        webView.loadUrl(site);
    }
}
