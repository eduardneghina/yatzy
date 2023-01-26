package com.example.yatzy;

public class Player {
    private final int id;
    private final String name;
    private ScoreTable scoreTable;

    public Player(int id, String name, ScoreTable st){
        this.id = id;
        this.name = name;
        this.scoreTable = st;
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }

    public ScoreTable getScoreTable(){

        return this.scoreTable;
    }
}


