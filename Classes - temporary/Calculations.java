import java.util.Random;

public class Calculations {

}

class Dice {

    public static int getRandomNumberForDice() {
        final int min = 1;
        final int max = 6;
        final int random = new Random().nextInt((max - min) + 1) + min;
        return random;
    }

    int diceRandomNumber = getRandomNumberForDice();
}


