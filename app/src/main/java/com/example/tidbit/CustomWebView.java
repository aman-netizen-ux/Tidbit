package com.example.tidbit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.squareup.picasso.Picasso;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import java.util.ArrayList;
//import android.webkit.WebViewClient;


public class CustomWebView extends AppCompatActivity {

    Toolbar toolbar;
    WebView webView;
    ImageView image;
    ArrayList<ModelClass> modelClassArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        toolbar=findViewById(R.id.toolbar1);
        webView=findViewById(R.id.webview1);
        // = findViewById(R.id.fetchedImg);

//        Picasso.get().load(modelClassArrayList.get.into(image);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}