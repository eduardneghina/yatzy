package com.example.yatzy;


import java.util.ArrayList;
import java.util.List;

public class ScoreTable{
    private final Score[] scores;

    public ScoreTable(String[] ScoreNames){

        this.scores = new Score[ScoreNames.length];
        List<Score> temp_scores = new ArrayList<Score>();
        for(int i=0; i < ScoreNames.length; i++){
            String name = ScoreNames[i];

            if (name.equals("Yatzy")){
                scores[i] = new ScoreYatzy(ScoreNames[i]);

                temp_scores.add(scores[i]);
                continue;
            }
            if (name.equals("Bonus")){
                scores[i] = new ScoreBonus(ScoreNames[i], scores[i - 1]);

                temp_scores.add(scores[i]);
                continue;
            }
            if (name.equals("Total")){
                scores[i] = new ScoreTotal(ScoreNames[i], temp_scores);

                temp_scores.clear();
                temp_scores.add(scores[i]);
                continue;
            }
            if (name.matches(".*s")){
                scores[i] = new ScoreNumber(ScoreNames[i], this.getIntForScoreNumber(name));
                temp_scores.add(scores[i]);
                continue;
            }
            if (name.matches(".*of a kind")){
                scores[i] = new ScoreOfAKind(ScoreNames[i], this.getIntForScoreOfAKind(name));
                temp_scores.add(scores[i]);
                continue;
            }
            if (name.matches(".*Straight")){
                scores[i] = new ScoreStraight(ScoreNames[i], this.getIntForScoreStraight(name));
                temp_scores.add(scores[i]);
                continue;
            }
            if (name.equals("Full House")){
                scores[i] = new ScoreFullHouse(ScoreNames[i]);
                temp_scores.add(scores[i]);
                continue;
            }
            if (name.equals("Chance")){
                scores[i] = new ScoreChance(ScoreNames[i]);
                temp_scores.add(scores[i]);
                continue;
            }
        }
    }

    public Score[] getScores(){
        return this.scores;
    }

    private int getIntForScoreNumber(String name){
        switch(name){
            case "Ones" : return 1;
            case "Twos" : return 2;
            case "Threes" : return 3;
            case "Fours" : return 4;
            case "Fives" : return 5;
            case "Sixes" : return 6;
        }
        return -1;
    }

    private int getIntForScoreOfAKind(String name){
        if(name.startsWith("Three")) return 3;
        if(name.startsWith("Four")) return 4;

        return -1;
    }

    private int[] getIntForScoreStraight(String name){
        if(name.startsWith("Small")) return new int[]{4, 30};
        if(name.startsWith("Large")) return new int[]{5, 40};

        return new int[]{-1};
    }
}
