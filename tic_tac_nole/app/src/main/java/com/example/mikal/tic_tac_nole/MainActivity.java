package com.example.mikal.tic_tac_nole;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    int garnet = Color.parseColor("#540115");
    int gold = Color.parseColor("#CDC092");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Action Bar Logo
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        SpannableString appTitle = new SpannableString(getSupportActionBar().getTitle());
        appTitle.setSpan(new ForegroundColorSpan(gold), 0, appTitle.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(appTitle);
        getSupportActionBar().setIcon(R.drawable.fsu);

        // Created By Label
        TextView createdByLbl = (TextView) findViewById(R.id.createdByLbl);
        createdByLbl.setTextColor(gold);
        createdByLbl.setBackgroundColor(garnet);

        // Turn Label
        TextView turnLbl = (TextView) findViewById(R.id.turnLbl);
        turnLbl.setTextColor(gold);
        turnLbl.setBackgroundColor(garnet);


        // Play Label
        Button playBtn = (Button) findViewById(R.id.playBtn);
        playBtn.setTextColor(gold);
        playBtn.setBackgroundColor(garnet);

    }
}
