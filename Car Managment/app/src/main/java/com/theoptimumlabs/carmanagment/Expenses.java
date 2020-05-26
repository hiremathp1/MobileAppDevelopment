package com.theoptimumlabs.carmanagment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.theoptimumlabs.carmanagment.Helper.Constance;
import com.theoptimumlabs.carmanagment.Helper.Utility;

import java.util.Calendar;

public class Expenses extends AppCompatActivity {

    Context ctxMain;
    TextView btnDate,btnOk,txtdate;
    private int mYear, mMonth, mDay;
    String sdate,sTotal;
    EditText edtAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);
        ctxMain=this;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnDate=(TextView)findViewById(R.id.btnDate);
        btnOk=(TextView)findViewById(R.id.btnOk);
        txtdate=(TextView)findViewById(R.id.txtdate);
        edtAmount=(EditText) findViewById(R.id.edtAmount);

        //Moving on Managment List activity through intent on click of button
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(ctxMain,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                txtdate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                sdate=""+dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                                Utility.setSharedPreference(ctxMain, Constance.Date,sdate);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sTotal=edtAmount.getText().toString();
                Utility.setSharedPreference(ctxMain,Constance.TotalAmount,sTotal);
                Intent intent=new Intent(ctxMain,ActivityCarExpDetail.class);
                startActivity(intent);
            }
        });


        //Image used
        //https://www.fors-online.org.uk/cms/wp-content/uploads/2019/03/Logo-Car-Van-FME.png
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
