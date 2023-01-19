package com.example.yatzy;

public class Player {
    private final int id;
    private final String name;
    private Score[] Scores;

    public Player(int id, String name, Score[] Scores){
        this.id = id;
        this.name = name;
        this.Scores = Scores;
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }

    public Score[] getScores(){

        return this.Scores;
    }
}


