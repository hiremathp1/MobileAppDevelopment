package com.personalplaylist;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Context ctxMain;
    TextView btnOne,btnTwo,btnThree;
    TextView btnTwoPause,btnOnePause,btnThreePause,txtSongTitle;
    MediaPlayer mediaPlayer,mediaPlayer1,mediaPlayer2;
    LinearLayout lin1,lin2,lin3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctxMain=this;
        btnOne=(TextView)findViewById(R.id.btnOne);
        btnTwo=(TextView)findViewById(R.id.btnTwo);
        btnThree=(TextView)findViewById(R.id.btnThree);

        btnOnePause=(TextView)findViewById(R.id.btnOnePause);
        btnTwoPause=(TextView)findViewById(R.id.btnTwoPause);
        btnThreePause=(TextView)findViewById(R.id.btnThreePause);

        txtSongTitle=(TextView)findViewById(R.id.txtSongTitle);

        lin1=(LinearLayout)findViewById(R.id.lin1) ;
        lin2=(LinearLayout)findViewById(R.id.lin2) ;
        lin3=(LinearLayout)findViewById(R.id.lin3) ;


        mediaPlayer=new MediaPlayer();
        mediaPlayer1=new MediaPlayer();
        mediaPlayer2=new MediaPlayer();




        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSongTitle.setText("Play1");

                btnOne.setVisibility(View.GONE);
                btnTwo.setVisibility(View.GONE);
                btnThree.setVisibility(View.GONE);


                lin2.setVisibility(View.GONE);
                lin3.setVisibility(View.GONE);
                lin1.setVisibility(View.VISIBLE);

                btnOnePause.setVisibility(View.VISIBLE);
                btnTwoPause.setVisibility(View.GONE);
                btnThreePause.setVisibility(View.GONE);

                mediaPlayer=  MediaPlayer.create(getApplicationContext(),R.raw.mp3one);
                mediaPlayer.start();
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSongTitle.setText("Play2");

                btnOne.setVisibility(View.GONE);
                btnTwo.setVisibility(View.GONE);
                btnThree.setVisibility(View.GONE);

                lin1.setVisibility(View.GONE);
                lin2.setVisibility(View.VISIBLE);
                lin3.setVisibility(View.GONE);

                btnOnePause.setVisibility(View.GONE);
                btnTwoPause.setVisibility(View.VISIBLE);
                btnThreePause.setVisibility(View.GONE);

                mediaPlayer1=MediaPlayer.create(getApplicationContext(),R.raw.mp3two);
                mediaPlayer1.start();
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtSongTitle.setText("Play3");

                btnOne.setVisibility(View.GONE);
                btnTwo.setVisibility(View.GONE);
                btnThree.setVisibility(View.GONE);

                lin2.setVisibility(View.GONE);
                lin1.setVisibility(View.GONE);
                lin3.setVisibility(View.VISIBLE);

                btnOnePause.setVisibility(View.GONE);
                btnTwoPause.setVisibility(View.GONE);
                btnThreePause.setVisibility(View.VISIBLE);

                mediaPlayer2=MediaPlayer.create(getApplicationContext(),R.raw.mp3one);
                mediaPlayer2.start();

            }
        });

        //Pause Functionality
        btnOnePause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                lin1.setVisibility(View.VISIBLE);
                lin2.setVisibility(View.VISIBLE);
                lin3.setVisibility(View.VISIBLE);

                btnOne.setVisibility(View.VISIBLE);
                btnTwo.setVisibility(View.VISIBLE);
                btnThree.setVisibility(View.VISIBLE);

                mediaPlayer.stop();
            }
        });
        btnTwoPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                lin1.setVisibility(View.VISIBLE);
                lin2.setVisibility(View.VISIBLE);
                lin3.setVisibility(View.VISIBLE);

                btnOne.setVisibility(View.VISIBLE);
                btnTwo.setVisibility(View.VISIBLE);
                btnThree.setVisibility(View.VISIBLE);

                mediaPlayer1.stop();
            }
        });
        btnThreePause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                lin1.setVisibility(View.VISIBLE);
                lin2.setVisibility(View.VISIBLE);
                lin3.setVisibility(View.VISIBLE);

                btnOne.setVisibility(View.VISIBLE);
                btnTwo.setVisibility(View.VISIBLE);
                btnThree.setVisibility(View.VISIBLE);

                mediaPlayer2.stop();
            }
        });
    }
}
