package com.theoptimumlabs.techgadgetsapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by optimum2 on 20/6/19.
 */

public class ActivityInformation extends AppCompatActivity {

    Context ctxInfo;
    TextView txtName,txtDiscription;
    LinearLayout linLast;
    ImageView imgGajet;
    String strName;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ctxInfo=this;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        strName=getIntent().getStringExtra("name");
        txtName=(TextView)findViewById(R.id.txtName);
        txtDiscription=(TextView)findViewById(R.id.txtDiscription);
        linLast=(LinearLayout)findViewById(R.id.linLast);
        imgGajet=(ImageView) findViewById(R.id.imgGajet);

        if(strName.equals("phone XS"))
        {
            txtName.setText(""+strName);
            txtDiscription.setText(getResources().getString(R.string.iphonexs));
            imgGajet.setImageResource(R.drawable.iphone_xs);

        }else if(strName.equals("Samsung S 10+"))
        {
            txtName.setText(""+strName);
            txtDiscription.setText(getResources().getString(R.string.iphonexs));
            imgGajet.setImageResource(R.drawable.galaxy_s_10);
        }
        else if(strName.equals("Pixel 3"))
        {
            txtName.setText(""+strName);
            txtDiscription.setText(getResources().getString(R.string.googlepixel3));
            imgGajet.setImageResource(R.drawable.googlepixel3);
        }
        else if(strName.equals("MacBookPro"))
        {
            txtName.setText(""+strName);
            txtDiscription.setText(getResources().getString(R.string.macbookpro));
            imgGajet.setImageResource(R.drawable.macbookpro);

        }else if(strName.equals("Apple Watch S 4"))
        {
            txtName.setText(""+strName);
            txtDiscription.setText(getResources().getString(R.string.applewatchs4));
            imgGajet.setImageResource(R.drawable.applewatch4);
        }

        linLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ctxInfo,WebViewActivity.class);
                intent.putExtra("name",strName);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
