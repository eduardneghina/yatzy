package com.example.yatzy;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Game extends Activity {
    private ScoreTable st;
    private String gameType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.gameType = new String("normal");
        String[] scoreNames = new String[]{"x3", "x4"};
        String[] players = new String[]{"Burlu"};

        this.st = new ScoreTable(scoreNames, players);

        this.drawTable();
    }

    private void drawTable(){
        setContentView(R.layout.activity_main);
        TableLayout stk = (TableLayout) findViewById(R.id.table_main);
        TableRow tbrow = new TableRow(this);
        tbrow.setBackgroundResource(R.drawable.border);

        // Header
        TextView tv = new TextView(this);
        tv.setText("Scores");
        tv.setTextColor(Color.BLACK);
        tv.setBackgroundResource(R.drawable.border);
        tbrow.addView(tv);

        Player[] players = st.getPlayers();
        for (Player p : players){
            tv = new TextView(this);
            tv.setText(p.getName());
            tv.setTextColor(Color.BLACK);
            tv.setBackgroundResource(R.drawable.border);
            tbrow.addView(tv);
        }

        stk.addView(tbrow);

        // Scores

        Score[] scores = players[0].getScores();
        for (Score score : scores){
            tbrow = new TableRow(this);
            TextView tv_score_name = new TextView(this);
            tv_score_name.setText(score.getName());
            tv_score_name.setTextColor(Color.BLACK);
            tv_score_name.setBackgroundResource(R.drawable.border);
            tbrow.addView(tv_score_name);

            for(Player player : players){
                tv = new TextView(this);
                tv.setText("Score_" + player.getName());
                tv.setTextColor(Color.BLACK);
                tv.setBackgroundResource(R.drawable.border);
                tbrow.addView(tv);
            }
            stk.addView(tbrow);
        }
        Log.d("Test", "drawn table");
    }
}
