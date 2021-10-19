package com.company;

import java.awt.event.ActionListener;

public class ButtonGenerator {

    Btn onesButton, twosButton, threesButton, foursButton, fivesButton, sixesButton, onePairButton, twoPairsButton
            ,threeOfAKindButton, fourOfAKindButton, smallStraightButton, largeStraightButton, fullHouseButton,
            chanceButton, yatzyButton;

    public ButtonGenerator(ActionListener a){
        onesButton = new Btn("Ones ",a);
        twosButton = new Btn("Twos ",a);
        threesButton = new Btn("Threes ",a);
        foursButton = new Btn("Fours ", a);
        fivesButton = new Btn("Fives ", a);
        sixesButton = new Btn("Sixes ", a);
        onePairButton = new Btn("One Pair ", a);
        twoPairsButton = new Btn("Two Pairs ",a);
        threeOfAKindButton = new Btn("3 of a Kind ", a);
        fourOfAKindButton = new Btn("4 of a Kind ", a);
        smallStraightButton = new Btn("Small Straight ", a);
        largeStraightButton = new Btn("Large Straight ", a);
        fullHouseButton  = new Btn("Full House ", a);
        chanceButton = new Btn("Chance ", a);
        yatzyButton = new Btn("Yatzy ", a);
    }

    public Btn[] getButtons(){
        Btn [] buttons = {onesButton, twosButton, threesButton, foursButton, fivesButton, sixesButton, onePairButton,
                twoPairsButton,threeOfAKindButton, fourOfAKindButton, smallStraightButton, largeStraightButton,
                fullHouseButton, chanceButton, yatzyButton};
        return buttons;
    }
}
