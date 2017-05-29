package com.example.android.soundtrack;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;


public class Player extends AppCompatActivity {


    ImageView imageStart;
    ImageView forward;
    ImageView back;
    ImageView mix;
    ImageView like;
    ImageView playlist;
    Toolbar toolbar;
    LayoutInflater inflater;
    Toast toast;
    View view;
    RelativeLayout rel;
    TextView textPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        imageStart = (ImageView) findViewById(R.id.start);
        forward = (ImageView) findViewById(R.id.forward);
        back = (ImageView) findViewById(R.id.back);
        mix = (ImageView) findViewById(R.id.mix);
        like = (ImageView) findViewById(R.id.like);
        playlist = (ImageView) findViewById(R.id.playlist);
        imageStart.setColorFilter(Color.parseColor("#880E4F"));
        forward.setColorFilter(Color.parseColor("#880E4F"));
        back.setColorFilter(Color.parseColor("#880E4F"));
        mix.setColorFilter(Color.parseColor("#880E4F"));
        like.setColorFilter(Color.parseColor("#880E4F"));
        playlist.setColorFilter(Color.parseColor("#880E4F"));


        inflater = getLayoutInflater();
        view = inflater.inflate(R.layout.toast_message, (ViewGroup) findViewById(R.id.toastPlayer));// Inflate the Layout
        view.setBackgroundResource(R.drawable.toast); // Set shape for Toast Message
        textPlayer = (TextView) view.findViewById(R.id.textDicrp3); // Set the Text to show in TextView
        textPlayer.setText(getResources().getText(R.string.text_3));
        toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 10, 0); // Set Toast on the Bottom of the screen
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();











    }
}
