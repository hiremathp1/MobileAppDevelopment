package com.theoptimumlabs.techgadgetsapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by optimum2 on 20/6/19.
 */

public class WelcomeActivity extends AppCompatActivity {

    Context ctxWelcome;
    TextView txtWelcome;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wlcome);
        ctxWelcome=this;
        txtWelcome=(TextView)findViewById(R.id.txtWelcome);
        txtWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ctxWelcome,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
