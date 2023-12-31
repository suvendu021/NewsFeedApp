package com.example.newsfeedapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webView extends AppCompatActivity {
    private Toolbar toolbar;
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(),R.color.purple));

        toolbar=findViewById(R.id.toolbar);
        webView=findViewById(R.id.webView);

        setSupportActionBar(toolbar);
        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}