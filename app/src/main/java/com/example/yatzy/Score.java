package com.example.yatzy;

public class Score {
    private final String Name;
    private int val;

    public Score(String Name){
        this.Name = Name;
    }

    public void addVal(int val){
        this.val = val;
    }

    public int getVal(){
        return this.val;
    }

    public String getName(){
        return this.Name;
    }
}
