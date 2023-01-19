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
    private final Score[] scores;

    public ScoreTable(String[] ScoreNames){

        this.scores = new Score[ScoreNames.length];
        for(int j=0; j < ScoreNames.length; j++){
            scores[j] = new Score(ScoreNames[j]);
        }
    }

    public Score[] getScores(){
        return this.scores;
    }
}
