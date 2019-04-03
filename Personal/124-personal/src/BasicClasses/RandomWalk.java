package BasicClasses;

import java.util.Random;

public class RandomWalk {
    private Random rng;
    private int currValue;
    private int maxVal = 255;
    private int minVal = 0;

    public RandomWalk(int num, int max, int min) {
        rng = new Random();
        currValue = num;
        maxVal = max;
        minVal = min;
    }

    public int getValue() {
        return currValue;
    }

    public int advanceValue() {
        if (rng.nextBoolean()) {
            if (currValue < maxVal) {
                currValue += 1;
            } else {
                currValue -= 1;
            }
        } else {
            if (currValue > minVal) {
                currValue -= 1;
            } else {
                currValue += 1;
            }
        }
        return getValue();
    }

}

