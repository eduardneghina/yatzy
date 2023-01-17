package com.example.yatzy;

import static com.google.android.material.internal.ContextUtils.getActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ScoreTable{
    Player[] Players;

    public ScoreTable(String[] ScoreNames, String[] PlayerNames){
        this.Players = new Player[PlayerNames.length];
        for(int i = 0; i < PlayerNames.length; i++){

            Score[] Scores = new Score[ScoreNames.length];
            for(int j=0; j < ScoreNames.length; j++){
                Scores[j] = new Score(ScoreNames[j]);
            }

            this.Players[i] = new Player(i, PlayerNames[i], Scores);
        }
    }

    public Player[] getPlayers(){
        return this.Players;
    }
}
