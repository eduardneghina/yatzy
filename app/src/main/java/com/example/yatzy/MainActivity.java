package com.example.yatzy;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        add_table(1, 20);
    }

    protected void add_table(int players, int scores_count){
        TableLayout stk = (TableLayout) findViewById(R.id.table_main);
        TableRow tbrow0 = new TableRow(this);
        tbrow0.setBackgroundResource(R.drawable.border);

        // Header
        TextView tv0 = new TextView(this);
        tv0.setText("Scores");
        tv0.setTextColor(Color.BLACK);
        tv0.setBackgroundResource(R.drawable.border);
        tbrow0.addView(tv0);

        for (int i = 0; i<players; i++){
            TextView tv = new TextView(this);
            tv.setText("Player_" + (i+1));
            tv.setTextColor(Color.BLACK);
            tv.setBackgroundResource(R.drawable.border);
            tbrow0.addView(tv);
        }

        stk.addView(tbrow0);

        // Scores
        for (int i = 0; i < scores_count; i++){
            TableRow tbrow = new TableRow(this);
            TextView tv_score_name = new TextView(this);
            tv_score_name.setText("Score_name_" + (i+1));
            tv_score_name.setTextColor(Color.BLACK);
            tv_score_name.setBackgroundResource(R.drawable.border);
            tbrow.addView(tv_score_name);

            for(int j = 0; j < players; j++){
                TextView tv = new TextView(this);
                tv.setText("Score_" + (i+1) + "_Player_" + (j+1));
                tv.setTextColor(Color.BLACK);
                tv.setBackgroundResource(R.drawable.border);
                tbrow.addView(tv);
            }
            stk.addView(tbrow);
        }
        return;
    }
}