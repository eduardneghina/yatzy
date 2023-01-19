package com.example.yatzy;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class Game extends Activity {
    private ScoreTable st;
    private String gameType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.gameType = new String("normal");
        String[] scoreNames = new String[]{"1" ,"2", "3", "4", "5", "6"};
        String[] players = new String[]{"Burlu", "Burlu2"};

        this.st = new ScoreTable(scoreNames, players);

        this.drawTable();
    }

    private void drawTable(){
        setContentView(R.layout.activity_main);
        TableLayout stk = (TableLayout) findViewById(R.id.table_main);

        Player[] players = this.st.getPlayers();
        //Header
        TableRow tbrow = new TableRow(this);
        tbrow.setBackgroundResource(R.drawable.border);
        TextView tv = new TextView(this);
        tv.setText("Scores");
        tv.setTextColor(Color.BLACK);
        tv.setBackgroundResource(R.drawable.border);
        tbrow.addView(tv);
        stk.addView(tbrow);

        Score[] scores = players[0].getScores();
        for(Score score:scores){
            tbrow = new TableRow(this);
            tbrow.setBackgroundResource(R.drawable.border);
            tv = new TextView(this);
            tv.setText(score.getName());
            tv.setTextColor(Color.BLACK);
            tv.setBackgroundResource(R.drawable.border);
            tbrow.addView(tv);
            stk.addView(tbrow);
        }


        for(Player player : players){
            tbrow = (TableRow) stk.getChildAt(0);
            tv = new TextView(this);
            tv.setText(player.getName());
            tv.setTextColor(Color.BLACK);
            tv.setBackgroundResource(R.drawable.border);
            tbrow.addView(tv);

            scores = player.getScores();
            for(int i=0; i < scores.length; i++){
                tv = new TextView(this);
                tv.setTextColor(Color.BLACK);
                tv.setBackgroundResource(R.drawable.border);
                scores[i].addView(tv);

                tbrow = (TableRow) stk.getChildAt(i+1);
                tbrow.addView(tv);
            }
        }


    }
}
