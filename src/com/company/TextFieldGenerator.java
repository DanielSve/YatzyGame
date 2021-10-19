package com.company;

import javax.swing.*;
import java.awt.*;

public class TextFieldGenerator {

    JTextField onesField, twosField, threesField, foursField, fivesField, sixesField, sumField, bonusField,
            onePairField, twoPairsField, threeOfAKindField, fourOfAKindField, smallStraightField, largeStraightField,
            fullHouseField, chanceField, yatzyField, totalSumField;

    private Color myColor = new Color(239,240,239);

    public TextFieldGenerator(){
        onesField = new JTextField(6);
        twosField = new JTextField(6);
        threesField = new JTextField(6);
        foursField = new JTextField(6);
        fivesField = new JTextField(6);
        sixesField = new JTextField(6);
        sumField = new JTextField(6);
        bonusField = new JTextField(6);
        onePairField = new JTextField(6);
        twoPairsField = new JTextField(6);
        threeOfAKindField = new JTextField(6);
        fourOfAKindField = new JTextField(6);
        smallStraightField = new JTextField(6);
        largeStraightField = new JTextField(6);
        fullHouseField = new JTextField(6);
        chanceField = new JTextField(6);
        yatzyField = new JTextField(6);
        totalSumField = new JTextField(6);

        sumField.setBackground(myColor);
        bonusField.setBackground(myColor);
        totalSumField.setBackground(myColor);
    }

    public JTextField[] getCategoryFields(){
        JTextField [] fields = {onesField, twosField, threesField, foursField, fivesField, sixesField, onePairField,
                twoPairsField, threeOfAKindField,fourOfAKindField, smallStraightField, largeStraightField, fullHouseField,
                chanceField, yatzyField};
        for (JTextField j: fields) {
            j.setFocusable(false);
        }
        return fields;
    }

    public JTextField getSumField(){
        JTextField jTextField = sumField;
        sumField.setFocusable(false);
        return jTextField;
    }

    public JTextField getBonusField(){
        JTextField jTextField = bonusField;
        bonusField.setFocusable(false);
        return jTextField;
    }
    public JTextField getTotalSumField(){
        JTextField jTextField = totalSumField;
        totalSumField.setFocusable(false);
        return jTextField;
    }
}
