package com.personalplaylist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * Created by optimum2 on 10/7/19.
 */

public class ActivitySplash  extends AppCompatActivity {

    Context ctxSplash;
    Handler handler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ctxSplash=this;
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide();

        handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                    Intent in = new Intent(ctxSplash, MainActivity.class);
                    startActivity(in);
                    finish();

            }
        };
        handler.postDelayed(runnable, 4000);

    }

}