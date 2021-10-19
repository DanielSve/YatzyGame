package com.company;

import java.util.Random;

public class DiceGenerator {

    public DiceGenerator(){}

    public int[] getDice(){
        Random random = new Random();
        int [] d = new int[5];

        for (int i = 0; i<d.length; i++)
            d[i] = 1 +random.nextInt(6);
        return d;
    }

    public int changeDice(){
        Random random = new Random();
        return 1 + random.nextInt(6);
    }
}
