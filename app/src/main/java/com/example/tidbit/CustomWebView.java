package com.example.tidbit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
//import android.webkit.WebViewClient;


public class CustomWebView extends AppCompatActivity {

    Toolbar toolbar;
    WebView webView;
    ImageView image,share;
    ImageButton backButton;
    //ArrayList<ModelClass> modelClassArrayList;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
//        toolbar=findViewById(R.id.toolbar1);
        webView=findViewById(R.id.webview1);
        image = findViewById(R.id.fetchedImg);
        backButton = findViewById(R.id.back);
        share = findViewById(R.id.share);

        backButton.setBackgroundColor(getResources().getColor(R.color.button_background_color));

        Intent intent = getIntent();
        String urlToImage = intent.getStringExtra("urlToImage");
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

        if (urlToImage != null && !urlToImage.isEmpty()) {
            Glide.with(this)
                    .load(urlToImage)
                    .into(image);
        } else {
            // Handle the case where no image URL is available
            image.setVisibility(View.GONE);
        }



        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(CustomWebView.this, MainActivity.class);
//                startActivity(i);
                  finish();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT,"title " + title);
                i.putExtra(Intent.EXTRA_TEXT,"Check out this news article: "+url);

                if(i.resolveActivity(getPackageManager())!= null){
                    startActivity(Intent.createChooser(i,"Share via"));
                }else{
                    Toast.makeText(getApplicationContext(), "No app available to handle this request", Toast.LENGTH_SHORT).show();
                }
            }
        });



//        setSupportActionBar(toolbar);


//        try {
//            Picasso.get().load(urlToImage).into(image);
//        }catch(Exception e){
//            e.printStackTrace();
//            Log.d("TAG", "Unable to fetch the image" + e.getMessage());
//
//        }

    }
}