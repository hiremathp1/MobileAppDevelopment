package com.theoptimumlabs.carmanagment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by optimum2 on 19/7/19.
 */

public class ManagmentList  extends AppCompatActivity {
    Context ctxMangment;
    ListView list;
   ArrayList<String> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managment_list);
        ctxMangment=this;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        arrayList.add("Vehicles expenses");
        arrayList.add("Services");
        arrayList.add("Mantainance need");

        MangmentAdapter adapter = new
                MangmentAdapter(ctxMangment, arrayList);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(ctxMangment, "You Clicked at " +arrayList.get(position), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        onBackPressed();
        return super.onOptionsItemSelected(item);
    }


}