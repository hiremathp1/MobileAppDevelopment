package com.theoptimumlabs.techgadgetsapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Context ctxMain;
    LinearLayout lin1,lin2,lin3,lin4,lin5;
    TextView txt1,txt2,txt3,txt4,txt5;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctxMain=this;
        lin1=(LinearLayout)findViewById(R.id.lin1);
        lin2=(LinearLayout)findViewById(R.id.lin2);
        lin3=(LinearLayout)findViewById(R.id.lin3);
        lin4=(LinearLayout)findViewById(R.id.lin4);
        lin5=(LinearLayout)findViewById(R.id.lin5);

        txt1=(TextView)findViewById(R.id.txt1);
        txt2=(TextView)findViewById(R.id.txt2);
        txt3=(TextView)findViewById(R.id.txt3);
        txt4=(TextView)findViewById(R.id.txt4);
        txt5=(TextView)findViewById(R.id.txt5);

        lin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str=txt1.getText().toString();

                Intent intent =new Intent(ctxMain,ActivityInformation.class);
                intent.putExtra("name",str);
                startActivity(intent);
            }
        });

        lin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str=txt2.getText().toString();

                Intent intent =new Intent(ctxMain,ActivityInformation.class);
                intent.putExtra("name",str);
                startActivity(intent);
            }
        });
        lin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str=txt3.getText().toString();

                Intent intent =new Intent(ctxMain,ActivityInformation.class);
                intent.putExtra("name",str);
                startActivity(intent);
            }
        });
        lin4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str=txt4.getText().toString();

                Intent intent =new Intent(ctxMain,ActivityInformation.class);
                intent.putExtra("name",str);
                startActivity(intent);
            }
        });
        lin5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str=txt5.getText().toString();

                Intent intent =new Intent(ctxMain,ActivityInformation.class);
                intent.putExtra("name",str);
                startActivity(intent);
            }
        });
    }
}
