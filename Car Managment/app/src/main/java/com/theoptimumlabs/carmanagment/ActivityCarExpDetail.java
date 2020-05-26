package com.theoptimumlabs.carmanagment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.theoptimumlabs.carmanagment.Helper.Constance;
import com.theoptimumlabs.carmanagment.Helper.Utility;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

/**
 * Created by optimum2 on 9/8/19.
 */

public class ActivityCarExpDetail extends AppCompatActivity {

    Context ctxcarExpDetail;
    int total=0,no=0;
    String date;
    TextView txtdate;

    PieChart pieChart ;
    ArrayList<Entry> entries ;
    ArrayList<String> PieEntryLabels ;
    PieDataSet pieDataSet ;
    PieData pieData ;
    float f1,f2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_exp_detail);
        ctxcarExpDetail=this;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtdate=(TextView)findViewById(R.id.txtdate);

        if(!Utility.isStringNullOrBlank(Utility.getSharedPreferences(ctxcarExpDetail, Constance.Date)))
        {
            date=Utility.getSharedPreferences(ctxcarExpDetail, Constance.Date);
            txtdate.setText(date);
        }

        if(!Utility.isStringNullOrBlank(Utility.getSharedPreferences(ctxcarExpDetail,Constance.TotalAmount)))
        {
            total=Integer.parseInt(Utility.getSharedPreferences(ctxcarExpDetail,Constance.TotalAmount));
        }


        no=(100-total);
        /*PieChartView pieChartView = findViewById(R.id.chart);
        List<SliceValue> pieData = new ArrayList<>();*/

        /*pieData.add(new SliceValue(total, Color.BLUE));
        pieData.add(new SliceValue(25, Color.GRAY));
        pieData.add(new SliceValue(10, Color.RED));
        pieData.add(new SliceValue(60, Color.MAGENTA));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartView.setPieChartData(pieChartData);*/


        pieChart = (PieChart) findViewById(R.id.chart1);

        entries = new ArrayList<>();

        PieEntryLabels = new ArrayList<String>();

        AddValuesToPIEENTRY();
        AddValuesToPieEntryLabels();
        pieDataSet = new PieDataSet(entries, "");
        pieData = new PieData(PieEntryLabels, pieDataSet);
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.setData(pieData);
        pieChart.animateY(3000);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
    public void AddValuesToPIEENTRY(){

        entries.add(new BarEntry(2f, 0));
        entries.add(new BarEntry(4f, 1));
        entries.add(new BarEntry(6f, 2));
        entries.add(new BarEntry(8f, 3));
        entries.add(new BarEntry(7f, 4));
        entries.add(new BarEntry(3f, 5));

    }
    public void AddValuesToPieEntryLabels(){

        PieEntryLabels.add("January");
        PieEntryLabels.add("February");
        PieEntryLabels.add("March");
        PieEntryLabels.add("April");
        PieEntryLabels.add("May");
        PieEntryLabels.add("June");

    }

}
