package com.amtraktrain;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import com.amtraktrain.Helper.Constance;
import com.amtraktrain.Helper.Utility;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private int mHour, mMinute;
    TextView txtHrs,txtMin,btnBoarding,btnTripTime,btnArivalTime,txtTripTimeMin;
    Context ctxMain;
    String sBHrs,sBMin,sTTMin;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctxMain=this;
        txtHrs=(TextView)findViewById(R.id.txtHrs);
        txtMin=(TextView)findViewById(R.id.txtMin);
        btnBoarding=(TextView)findViewById(R.id.btnBoarding);
        btnTripTime=(TextView)findViewById(R.id.btnTripTime);
        btnArivalTime=(TextView)findViewById(R.id.btnArivalTime);
        txtTripTimeMin=(TextView)findViewById(R.id.txtTripTimeMin);

        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        if(!Utility.isStringNullOrBlank(Utility.getSharedPreferences(ctxMain,Constance.boardHrs))&&
        !Utility.isStringNullOrBlank(Utility.getSharedPreferences(ctxMain,Constance.boardMin))&&
                !Utility.isStringNullOrBlank(Utility.getSharedPreferences(ctxMain,Constance.trainTrip)))
        {
            txtHrs.setText(""+Utility.getSharedPreferences(ctxMain,Constance.boardHrs) );
            txtMin.setText(""+Utility.getSharedPreferences(ctxMain,Constance.boardMin));
            txtTripTimeMin.setText(""+Utility.getSharedPreferences(ctxMain,Constance.trainTrip));
        }

        btnBoarding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(ctxMain,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                txtHrs.setText(""+hourOfDay );
                                txtMin.setText(""+minute);


                                Utility.setSharedPreference(ctxMain, Constance.boardHrs,sBHrs);
                                Utility.setSharedPreference(ctxMain, Constance.boardMin,sBMin);
                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();
            }
        });

        btnTripTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(ctxMain,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {


                                txtTripTimeMin.setText(""+minute);
                                //sTTMin=""+minute;
                                Utility.setSharedPreference(ctxMain, Constance.trainTrip,sTTMin);
                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();
            }
        });

        btnArivalTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sBHrs=txtHrs.getText().toString();
                sBMin=txtMin.getText().toString();
                sTTMin=txtTripTimeMin.getText().toString();
                if(!Utility.isStringNullOrBlank(sBHrs)&&
                        !Utility.isStringNullOrBlank(sBMin)&&
                        !Utility.isStringNullOrBlank(sTTMin))
                {
                    Intent i = new Intent(ctxMain, ActivityArival.class);
                    i.putExtra("BHours", sBHrs);
                    i.putExtra("BMinutes", sBMin);
                    i.putExtra("TTMinutes", sTTMin);
                    startActivity(i);
                }
            }
        });

    }
}
