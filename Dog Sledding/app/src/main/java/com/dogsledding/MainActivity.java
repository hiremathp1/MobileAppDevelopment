package com.dogsledding;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Context ctxMain;
    int mYear,mMonth,mDay;
    TextView txtTime;
    String sDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctxMain=this;

        txtTime=(TextView)findViewById(R.id.txtTime);

        txtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(ctxMain,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                txtTime.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                sDate=""+(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                Intent intent=new Intent(ctxMain,SecondActivity.class);
                                intent.putExtra("Date",""+sDate);
                                startActivity(intent);

                            }
                        }, mYear, mMonth, mDay);

                datePickerDialog.show();

            }
        });

    }
}
