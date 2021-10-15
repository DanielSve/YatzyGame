package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountNumbers {
    int[] numbers;
    int summa;
    int lowerSumma;
    JButton button;
    public CountNumbers(int[] numbers, JButton button){
        this.numbers = numbers;
        this.button = button;
    }

    public int getSumma() {
        return summa;
    }
    public int getLowerSumma(){
        return lowerSumma;
    }

    public void addToSumma(int sum) {this.summa = sum;
    }

    public void addToLowerSumma(int sum){
        this.lowerSumma = sum;
    }


    public int sumEttor(){
        int sum = 0;
        for(int i = 0; i<numbers.length; i++) {
            if (numbers[i] == 1)
                sum = sum + numbers[i];
        }
        addToSumma(sum);
        return sum;
    }

    public int sumTvåor(){
        int sum = 0;
        for(int i = 0; i<numbers.length; i++) {
            if (numbers[i] == 2)
                sum = sum + numbers[i];
        }
        addToSumma(sum);
        return sum;
    }
    public int sumTreor(){
        int sum = 0;
        for(int i = 0; i<numbers.length; i++) {
            if (numbers[i] == 3)
                sum = sum + numbers[i];;
        }
        addToSumma(sum);
        return sum;
    }
    public int sumFyror(){
        int sum = 0;
        for(int i = 0; i<numbers.length; i++) {
            if (numbers[i] == 4)
                sum = sum + numbers[i];
        }
        addToSumma(sum);
        return sum;
    }
    public int sumFemmor(){
        int sum = 0;
        for(int i = 0; i<numbers.length; i++) {
            if (numbers[i] == 5)
                sum = sum + numbers[i];
        }
        addToSumma(sum);
        return sum;
    }
    public int sumSexor(){
        int sum = 0;
        for(int i = 0; i<numbers.length; i++) {
            if (numbers[i] == 6)
                sum = sum + numbers[i];
        }
        addToSumma(sum);
        return sum;
    }
    public int sumEttPar(){
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
                else if(numbers[i] == numbers[j] && isSame) {
                    sameNumber2 = numbers[i];
                }
            }
        }
        sum = Math.max(sameNumber1, sameNumber2)*2;
        addToLowerSumma(sum);
        return sum;
    }

    public int sumTvåPar(){
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
                else if(numbers[i] == numbers[j] && isSame) {
                    sameNumber2 = numbers[i];
                }
            }
        }
        if(sameNumber1==0 || sameNumber2==0){
            sum = 0;
        } else {
            sum = (sameNumber1 * 2) + (sameNumber2 * 2);
            addToLowerSumma(sum);
        }
        return sum;
    }

    public int sumTreTal() {
        int sum;
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
        if (sameNumberCounter<3){
            sum = 0;
        } else {
            sum = sameNumber*3;
        }
        addToLowerSumma(sum);
        return sum;
    }

    public int sumFyrTal(){
        int sum;
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
        if (sameNumberCounter<4){
            sum = 0;
        } else {
            sum = sameNumber*4;
        }
        addToLowerSumma(sum);
        return sum;
    }

    public int sumLitenStege(){
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
        addToLowerSumma(sum);
        return sum;
    }

    public int sumStorStege(){
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
        addToLowerSumma(sum);
        return sum;
    }

    public int sumKåk(){
        int sum;
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
        System.out.println(sameNumber1Counter + " " + sameNumber1);
        System.out.println(sameNumber2Counter + " " + sameNumber2);
        if (sameNumber1Counter<3 || sameNumber2Counter<2) {
            sum = 0;
        } else {
            sum = sameNumber1 * 3 + sameNumber2*2;
        }
        addToLowerSumma(sum);
        return sum;
    }

    public int sumChans(){
        int sum =0;
        for (int i = 0; i <numbers.length ; i++) {
            sum = sum + numbers[i];
        }
        addToLowerSumma(sum);
        return sum;
    }

    public int sumYatzy(){
        int sum=0;
        int sameNumber = 0;
        int sameNumberCounter = 1;
        for (int i = 0; i < numbers.length && sameNumberCounter<5; i++) {
            sameNumberCounter=1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    sameNumber = numbers[i];
                    sameNumberCounter++;
                }
            }
        }
        if (sameNumberCounter<5){
            sum = 0;
        } else {
            sum = 50;
        }
        addToLowerSumma(sum);
        return sum;
    }
}
