package com.dogsledding;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by optimum2 on 27/6/19.
 */

public class SecondActivity extends AppCompatActivity {

    Context ctxSec;
    TextView txtTime,txtdate;
    String sDate;
    int mYear,mMonth,mDay;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        ctxSec=this;

        sDate=getIntent().getStringExtra("Date");
        txtTime=(TextView)findViewById(R.id.txtTime);
        txtdate=(TextView)findViewById(R.id.txtdate);

        txtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(ctxSec,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {


                                txtdate.setText("Your Reservation is set for "+dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                sDate=""+(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);


                            }
                        }, mYear, mMonth, mDay);

                datePickerDialog.show();
            }
        });

    }
}
