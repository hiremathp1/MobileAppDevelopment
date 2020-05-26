package com.theoptimumlabs.carmanagment.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.theoptimumlabs.carmanagment.ActivityCarExpDetail;
import com.theoptimumlabs.carmanagment.Expenses;
import com.theoptimumlabs.carmanagment.MangmentAdapter;
import com.theoptimumlabs.carmanagment.R;

import java.util.ArrayList;

/**
 * Created by optimum2 on 19/7/19.
 */

public class ManagmentListFrag  extends Fragment {

    Context ctxFragManag;
    ListView list;
    ArrayList<String> arrayList=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_managment_list, container, false);
        ctxFragManag = getActivity();

        arrayList.add("Vehicles expenses");
        arrayList.add("Services");
        arrayList.add("Mantainance need");
        arrayList.add("Expenses Detail");

        MangmentAdapter adapter = new
                MangmentAdapter(ctxFragManag, arrayList);
        list=(ListView)view.findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(ctxFragManag, "You Clicked at " +arrayList.get(position), Toast.LENGTH_SHORT).show();
                if(position==0)
                {
                    Intent i=new Intent(ctxFragManag, Expenses.class);
                    startActivity(i);
                }else if(position ==3)
                {
                    Intent i=new Intent(ctxFragManag, ActivityCarExpDetail.class);
                    startActivity(i);
                }

            }
        });
        return view;
    }

}
