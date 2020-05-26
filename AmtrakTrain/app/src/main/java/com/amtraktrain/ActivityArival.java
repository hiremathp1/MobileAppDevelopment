package com.amtraktrain;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amtraktrain.Helper.Constance;
import com.amtraktrain.Helper.Utility;

/**
 * Created by optimum2 on 2/7/19.
 */

public class ActivityArival extends AppCompatActivity {

    Context ctxArival;
    TextView txtArrivalMin,txtArrivalHours;
    String sBHrs,sBMin,sTTMin,sArivalHr,sArivalMin;
    String diffrence;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrival);
        ctxArival=this;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sBHrs=getIntent().getStringExtra("BHours");
        sBMin=getIntent().getStringExtra("BMinutes");
        sTTMin=getIntent().getStringExtra("TTMinutes");

        txtArrivalMin=(TextView)findViewById(R.id.txtArrivalMin);
        txtArrivalHours=(TextView)findViewById(R.id.txtArrivalHours);



        sArivalMin=String.valueOf(Integer.parseInt(sBMin) + Integer.parseInt(sTTMin));
        if(Integer.parseInt(sArivalMin)>=60)
        {
            diffrence=""+(Integer.parseInt(sArivalMin)-60);
            if((diffrence).equals("0"))
            {
                diffrence="00";

            }else if((diffrence).equals("1"))
            {
                diffrence="01";
            }
            else if((diffrence).equals("2"))
            {
                diffrence="02";
            }
            else if((diffrence).equals("3"))
            {
                diffrence = "03";
            }
            else if((diffrence).equals("4"))
            {
                diffrence="04";
            }
            else if((diffrence).equals("5"))
            {
                diffrence="05";
            }
            else if((diffrence).equals("6"))
            {
                diffrence="06";
            }
            else if((diffrence).equals("7"))
            {
                diffrence="07";
            }
            else if((diffrence).equals("8"))
            {
                diffrence="08";
            }
            else if((diffrence).equals("9"))
            {
                diffrence="09";
            }
            sArivalHr=String.valueOf(Integer.parseInt(sBHrs)+1);
            txtArrivalHours.setText(""+sArivalHr);
            txtArrivalMin.setText(""+diffrence);

            Utility.setSharedPreference(ctxArival, Constance.AHours,sArivalHr);
            Utility.setSharedPreference(ctxArival, Constance.AMinutes,""+diffrence);
            hrsMidNight(sBHrs,diffrence);


        }
        else
        {
            sArivalHr=""+sBHrs;
            txtArrivalHours.setText(""+sArivalHr);
            txtArrivalMin.setText(""+sArivalMin);

            Utility.setSharedPreference(ctxArival, Constance.AHours,sArivalHr);
            Utility.setSharedPreference(ctxArival, Constance.AMinutes,sArivalMin);
        }


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    public  void hrsMidNight(String sBHrs,String sdiff)
    {
        if(Integer.parseInt(sBHrs)==00)
        {
            midNightMessg();
        }
        else if(Integer.parseInt(sBHrs)==01)
        {
            midNightMessg();
        }
        else if(Integer.parseInt(sBHrs)==02)
        {
            midNightMessg();
        }
        else if(Integer.parseInt(sBHrs)==03&&Integer.parseInt(sdiff)==00)
        {
            midNightMessg();
        }
    }

    public void midNightMessg()
    {
        final Dialog dialog = new Dialog(ctxArival);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.popup);
        //dialog.setTitle("Number Score Game...");
        dialog.setCancelable(false);

        // set the custom dialog components - text, image and button
        LinearLayout dialogButtonPlay = (LinearLayout) dialog.findViewById(R.id.btnrePlay);


        dialogButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });



        dialog.show();
        Window window = dialog.getWindow();
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }

}
