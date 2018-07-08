package com.example.mikal.tic_tac_nole;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private BoardView boardView;
    private GameEngine gameEngine;

    int garnet = Color.parseColor("#540115");
    int gold = Color.parseColor("#CDC092");

    static char test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boardView = (BoardView) findViewById(R.id.board);
        gameEngine = new GameEngine();
        boardView.setGameEngine(gameEngine);
        boardView.setMainActivity(this);

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
        playBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                newGame();
            }
        });

    }

    public void gameEnded(char c) {
        String msg = (c == 'T') ? "Game Ended. Tie" : "Game Ended. " + c + " win";

        new AlertDialog.Builder(this).setTitle("Tic Tac Nole").
                setMessage(msg).
                setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        newGame();
                    }
                }).show();
    }

    private void newGame() {
        TextView turnLbl = (TextView) findViewById(R.id.turnLbl);
        gameEngine.newGame();
        boardView.invalidate();
        turnLbl.setText("It's Your Turn X");
    }

    public void setPlayer(char c) {
        TextView turnLbl = (TextView) findViewById(R.id.turnLbl);
        turnLbl.setText("Try to Win!");
    }

}
