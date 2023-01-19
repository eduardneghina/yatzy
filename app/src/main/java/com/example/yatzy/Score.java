package com.example.yatzy;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

public class Score implements View.OnClickListener{
    private final String name;
    private int val;
    private int temp_val;
    private TextView tv;

    public Score(String name){
        this.name = name;
        this.val = -1;
    }

    public void addVal(int val){
        this.val = val;
    }

    public String getVal(){
        return String.valueOf(this.val);
    }

    public String getName(){
        return this.name;
    }

    public void addView(TextView tv){
        this.tv = tv;
        this.tv.setOnClickListener(this);
    }

    public void addScore(){
        tv.setText(this.val);
    }

    @Override
    public void onClick(View view) {
        this.val = this.val + 1;
        this.tv.setTextColor(Color.BLACK);
        this.tv.setText(this.getVal());
    }
}
