package gamelogic;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountNumbers {
    private int[] numbers;
    private int sum;
    private JButton button;

    public CountNumbers(int[] numbers, JButton button){
        this.numbers = numbers;
        this.button = button;
        checkCategory();
    }

    public void checkCategory(){
        switch (button.getText()){
            case "Ones " -> sum = sumOnes();
            case "Twos " -> sum = sumTwos();
            case "Threes " -> sum = sumThrees();
            case "Fours " -> sum = sumFours();
            case "Fives " -> sum = sumFives();
            case "Sixes " -> sum = sumSixes();
            case "One Pair " -> sum = sumOnePair();
            case "Two Pairs " -> sum = sumTwoPairs();
            case "3 of a Kind " -> sum = sumThreeOfAKind();
            case "4 of a Kind " -> sum = sumFourOfAKind();
            case "Small Straight " -> sum = sumSmallStraight();
            case "Large Straight " -> sum = sumLargeStraight();
            case "Full House " -> sum = sumFullHouse();
            case "Chance " -> sum = sumChance();
            case "Yatzy " -> sum = sumYatzy();
        }
    }

    public int getSum() {
        return sum;
    }

    public int sumOnes(){
        int sum = 0;
        for(int i = 0; i<numbers.length; i++) {
            if (numbers[i] == 1)
                sum = sum + numbers[i];
        }
        return sum;
    }

    public int sumTwos(){
        int sum = 0;
        for(int i = 0; i<numbers.length; i++) {
            if (numbers[i] == 2)
                sum = sum + numbers[i];
        }
        return sum;
    }

    public int sumThrees(){
        int sum = 0;
        for(int i = 0; i<numbers.length; i++) {
            if (numbers[i] == 3)
                sum = sum + numbers[i];;
        }
        return sum;
    }

    public int sumFours(){
        int sum = 0;
        for(int i = 0; i<numbers.length; i++) {
            if (numbers[i] == 4)
                sum = sum + numbers[i];
        }
        return sum;
    }

    public int sumFives(){
        int sum = 0;
        for(int i = 0; i<numbers.length; i++) {
            if (numbers[i] == 5)
                sum = sum + numbers[i];
        }
        return sum;
    }

    public int sumSixes(){
        int sum = 0;
        for(int i = 0; i<numbers.length; i++) {
            if (numbers[i] == 6)
                sum = sum + numbers[i];
        }
        return sum;
    }

    public int sumOnePair(){
        int sum = 0;
        int sameNumber1=0;
        int sameNumber2=0;
        boolean isSame = false;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j <i ; j++) {
                if (numbers[i]== numbers[j] && !isSame) {
                    sameNumber1 = numbers[i];
                    isSame=true;
                }
                else if(numbers[i] == numbers[j] && isSame && numbers[i]!=sameNumber1) {
                    sameNumber2 = numbers[i];
                }
            }
        }
        sum = Math.max(sameNumber1, sameNumber2)*2;
        return sum;
    }

    public int sumTwoPairs(){
        int sum = 0;
        int sameNumber1=0;
        int sameNumber2=0;
        boolean isSame = false;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j <i ; j++) {
                if (numbers[i]== numbers[j] && !isSame) {
                    sameNumber1 = numbers[i];
                    isSame=true;
                }
                else if (numbers[i] == numbers[j] && isSame && numbers[i]!=sameNumber1) {
                    sameNumber2 = numbers[i];
                }
            }
        }
        if (sameNumber1 > 0 && sameNumber2 > 0) {
            sum = (sameNumber1 * 2) + (sameNumber2 * 2);
        }
        return sum;
    }

    public int sumThreeOfAKind() {
        int sum = 0;
        int sameNumber = 0;
        int sameNumberCounter = 1;
        for (int i = 0; i < numbers.length && sameNumberCounter<3; i++) {
            sameNumberCounter=1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    sameNumber = numbers[i];
                    sameNumberCounter++;
                }
            }
        }
        if (sameNumberCounter >= 3){
            sum = sameNumber*3;
        }
        return sum;
    }

    public int sumFourOfAKind(){
        int sum = 0;
        int sameNumber = 0;
        int sameNumberCounter = 1;
        for (int i = 0; i < numbers.length && sameNumberCounter<3; i++) {
            sameNumberCounter=1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    sameNumber = numbers[i];
                    sameNumberCounter++;
                }
            }
        }
        if (sameNumberCounter>=4) {
            sum = sameNumber*4;
        }
        return sum;
    }

    public int sumSmallStraight(){
        int sum = 0;
        int counter = 0;
        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        for (int j = 0; j <list.size() ; j++) {
            if(list.contains(j+1))
                counter++;
        }
        if(counter==5) {
            sum = 15;
        }
        return sum;
    }

    public int sumLargeStraight(){
        int sum = 0;
        int counter = 0;
        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        for (int j = 0; j <list.size() ; j++) {
            if(list.contains(j+2))
                counter++;
        }
        if(counter==5) {
            sum = 20;
        }
        return sum;
    }

    public int sumFullHouse(){
        int sum = 0;
        int sameNumber1 = 0;
        int sameNumber2 = 0;
        int sameNumber1Counter = 1;
        int sameNumber2Counter = 1;
        for (int i = 0; i < numbers.length && sameNumber1Counter<3; i++) {
            sameNumber1Counter=1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    sameNumber1 = numbers[i];
                    sameNumber1Counter++;
                }
            }
        }
        for (int i = 0; i <numbers.length ; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i]==numbers[j] && numbers[i]!=sameNumber1) {
                    sameNumber2 = numbers[i];
                    sameNumber2Counter++;
                }
            }
        }
        if (sameNumber1Counter>=3 && sameNumber2Counter>=2) {
            sum = sameNumber1 * 3 + sameNumber2*2;
        }
        return sum;
    }

    public int sumChance(){
        int sum =0;
        for (int i = 0; i <numbers.length ; i++) {
            sum = sum + numbers[i];
        }
        return sum;
    }

    public int sumYatzy(){
        int sum=0;
        int sameNumberCounter = 1;
        for (int i = 0; i < numbers.length && sameNumberCounter<5; i++) {
            sameNumberCounter=1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    sameNumberCounter++;
                }
            }
        }
        if (sameNumberCounter>=5){
            sum = 50;
        }
        return sum;
    }
}
