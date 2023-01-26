package com.example.yatzy;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public abstract class Score implements View.OnClickListener{
    private final String name;
    private int val;
    private int temp_val;
    private TextView tv;

    public Score(String name){
        this.name = name;
        this.val = -1;
    }

    protected void addVal(int val){
        this.val = val;
    }

    public int getVal(){
        return this.val;
    }

    public String getName(){
        return this.name;
    }

    public void addView(TextView tv){
        this.tv = tv;
        this.tv.setOnClickListener(this);
    }

    protected void addScore(){
        tv.setText(this.val);
        tv.setTextColor(Color.BLACK);
    }

    @Override
    public void onClick(View view) {
        this.val = this.val + 1;
        this.tv.setTextColor(Color.RED);
        this.tv.setText(this.getVal());
    }

    public abstract int getPosibleScore(int[] dice_values);

    protected HashMap<Integer, Integer> getFrequecy(int[] nums){
        HashMap<Integer, Integer> result = new HashMap<>();
        for(int num: nums){
            if (result.containsKey(num)) result.put(num, result.get(num) + 1);
            else result.put(num, 1);
        }
        return result;
    }

    protected int sum(int[] nums){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        return sum;
    }

    protected int sum(List<Score> scores){
        int sum = 0;
        for(Score score : scores){
            sum += score.getVal();
        }
        return sum;
    }
}

class ScoreNumber extends Score{
    private int num;

    public ScoreNumber(String name, int num) {
        super(name);
        this.num = num;
    }

    @Override
    public int getPosibleScore(int[] dice_values) {
        int count = 0;
        for (int num : dice_values){
            if (num == this.num){
                count ++;
            }
        }
        return count * this.num;
    }
}

class ScoreBonus extends Score{
    private Score score;
    public ScoreBonus(String name, Score score) {
        super(name);
        this.score = score;
    }

    @Override
    public int getPosibleScore(int[] dice_values) {
        if(this.score.getVal() > 63) {
            this.addVal(50);
            this.addScore();
        }
        return 0;
    }
}

class ScoreTotal extends Score{
    private List<Score> scores;
    public ScoreTotal(String name, List<Score> scores) {
        super(name);
        this.scores = scores;
    }

    @Override
    public int getPosibleScore(int[] dice_values) {
        return this.sum(this.scores);
    }
}

class ScoreStraight extends Score{
    private int num;
    private int score;
    public ScoreStraight(String name, int[] num) {
        super(name);
        this.num = num[0];
        this.score = num[1];
    }

    @Override
    public int getPosibleScore(int[] dice_values) {
        HashMap<Integer, Integer> frequency = getFrequecy(dice_values);
        int count = 0;

        for(int i = 1; i <= 6; i++){
            if (frequency.containsKey(i)){
                count ++;
                if (count >= this.num){
                    return this.score;
                }
            }
            else{
                count = 0;
            }
        }
        return 0;
    }
}

class ScoreOfAKind extends Score{
    private int num;
    public ScoreOfAKind(String name, int num) {
        super(name);
        this.num = num;
    }

    @Override
    public int getPosibleScore(int[] dice_values) {
        HashMap<Integer, Integer> frequency = this.getFrequecy(dice_values);
        for (int num : dice_values){
            if (frequency.containsKey(num) && frequency.get(num) >= this.num){
                return sum(dice_values);
            }
        }
        return 0;
    }
}

class ScoreChance extends Score{

    public ScoreChance(String name) {
        super(name);
    }

    @Override
    public int getPosibleScore(int[] dice_values) {
        return sum(dice_values);
    }
}

class ScoreFullHouse extends Score{

    public ScoreFullHouse(String name) {
        super(name);
    }

    @Override
    public int getPosibleScore(int[] dice_values) {
        HashMap<Integer, Integer> frequency = this.getFrequecy(dice_values);
        int three_check = 0;
        int two_check = 0;
        for(int i = 1; i <= 6; i++){
            if(!frequency.containsKey(i)) continue;

            if(frequency.get(i) == 2){
                two_check = 1;
                continue;
            }
            if(frequency.get(i) == 3){
                three_check = 1;
                continue;
            }
        }
        if((two_check == 1 )&& (three_check == 1)){
            return 25;
        }
        return 0;
    }
}

class ScoreYatzy extends Score{

    public ScoreYatzy(String name) {
        super(name);
    }

    @Override
    public int getPosibleScore(int[] dice_values) {
        HashMap<Integer, Integer> frequency = getFrequecy(dice_values);
        for(int i = 1; i<=6; i++){
            if(frequency.containsKey(i) && frequency.get(i) == 5){
                this.updateVal();
            }
        }
        return 0;
    }

    private void updateVal(){
        if (this.getVal() == -1){
            this.addVal(50);
        }
        else{
            this.addVal(this.getVal() + 100);
        }
    }
}
