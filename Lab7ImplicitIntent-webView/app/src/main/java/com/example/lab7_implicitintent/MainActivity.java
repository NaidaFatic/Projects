package com.example.lab7_implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private WebView web;
    private static final String HOME_URL = "https://ibu.edu.ba";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = findViewById(R.id.web_view);
        web.setWebViewClient(new WebViewClient());//to make that every time this page loads when prompt
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);

        Intent intent = getIntent();
        if(intent.getData()!=null){
            Uri uri = intent.getData();
            web.loadUrl(HOME_URL+uri.getPath());
        }else
            web.loadUrl(HOME_URL);
    }

}