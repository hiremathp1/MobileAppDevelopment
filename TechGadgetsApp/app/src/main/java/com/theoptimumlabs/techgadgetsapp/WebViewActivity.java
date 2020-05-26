package com.theoptimumlabs.techgadgetsapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;

/**
 * Created by optimum2 on 21/6/19.
 */

public class WebViewActivity extends AppCompatActivity {

    Context ctxWeb;
    WebView webview;
    String strName;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_activity);
        ctxWeb=this;
        strName=getIntent().getStringExtra("name");
        webview=(WebView)findViewById(R.id.webview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        if(strName.equals("phone XS"))
        {
            getSupportActionBar().setTitle(""+strName);
            webview.loadUrl("https://www.apple.com/iphone-xs/");


        }else if(strName.equals("Samsung S 10+"))
        {
            getSupportActionBar().setTitle(""+strName);
            webview.loadUrl("https://www.samsung.com/us/mobile/galaxy-s10/");
        }
        else if(strName.equals("Pixel 3"))
        {
            getSupportActionBar().setTitle(""+strName);
            webview.loadUrl("https://store.google.com/product/pixel_3");
        }
        else if(strName.equals("MacBookPro"))
        {
            getSupportActionBar().setTitle(""+strName);
            webview.loadUrl("https://www.apple.com/macbook-pro/");

        }else if(strName.equals("Apple Watch S 4"))
        {
            getSupportActionBar().setTitle(""+strName);
            webview.loadUrl("https://www.apple.com/apple-watch-series-4/");
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
