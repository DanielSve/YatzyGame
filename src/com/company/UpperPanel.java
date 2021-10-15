package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.Random;

public class UpperPanel extends JPanel {
    JButton button;
    JToolBar toolBar;
    JLabel infoLabel;
    DiceGenerator diceGenerator;
    JTextField [] jTextFields = new JTextField[5];
    JCheckBox [] jCheckBoxes = new JCheckBox[5];
    int []dice;
    int throwsLeft;
    UpperPanelListener upperPanelListener;


    public UpperPanel(){
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(1000,140));
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(
                2,2,2,2),BorderFactory.createLineBorder(Color.GRAY))
                );

        toolBar = new JToolBar();
        button = new JButton("Throw dices");
        diceGenerator = new DiceGenerator();
        throwsLeft = 3;
        infoLabel = new JLabel("Select to keep");
        infoLabel.setForeground(Color.GRAY);
        dice = new int[5];

        for (int i =0; i <jCheckBoxes.length; i++)
            jCheckBoxes[i] = new JCheckBox();

        for (int i =0; i <jTextFields.length; i++) {
            jTextFields[i] = new JTextField(1);
            jTextFields[i].setHorizontalAlignment(JTextField.CENTER);
            jTextFields[i].setEditable(false);
            jTextFields[i].setFocusable(false);
        }

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throwDices();
                throwsLeft--;

                StoreNumbers storeNumbers= new StoreNumbers(this,dice);

                if(upperPanelListener!=null)
                    upperPanelListener.numbersStored(storeNumbers);
            }
        });


        GridBagConstraints gc = new GridBagConstraints();

        gc.insets = new Insets(5,0,0,0);

        gc.gridy = 0;
        gc.gridx = 0;
        gc.ipady = 10;
        gc.ipadx = 30;
        add(jTextFields[0], gc);

        gc.gridy = 0;
        gc.gridx = 1;
        add(jTextFields[1], gc);

        gc.gridy = 0;
        gc.gridx = 2;
        add(jTextFields[2], gc);

        gc.gridy = 0;
        gc.gridx = 3;
        add(jTextFields[3], gc);

        gc.gridy = 0;
        gc.gridx = 4;
        add(jTextFields[4], gc);

        gc.gridy = 1;
        gc.gridx = 0;
        gc.insets = new Insets(0,30,0,0);
        add(jCheckBoxes[0], gc);

        gc.gridy = 1;
        gc.gridx = 1;
        add(jCheckBoxes[1], gc);

        gc.gridy = 1;
        gc.gridx = 2;
        add(jCheckBoxes[2], gc);

        gc.gridy = 1;
        gc.gridx = 3;
        add(jCheckBoxes[3], gc);

        gc.gridy = 1;
        gc.gridx = 4;
        add(jCheckBoxes[4], gc);

        gc.insets = new Insets(0,23,0,0);
        gc.gridy = 2;
        gc.gridx = 1;
        gc.weightx = 0;
        gc.gridwidth = 3;
        gc.ipady=5;
        add(infoLabel, gc);

        gc.insets = new Insets(0,0,0,0);
        gc.gridy = 3;
        gc.gridx = 0;
        gc.weightx = 0;
        gc.gridwidth = 5;
        gc.ipady=5;

        add(button, gc);
    }

    public void throwDices() {
        if (throwsLeft == 3) {
            dice = diceGenerator.getDice();
            for (int i = 0; i < dice.length; i++) {
                jTextFields[i].setText("" + dice[i]);
            }
        }
        else if (throwsLeft>0 && throwsLeft<3)
            throwAgain();
    }

    public void throwAgain(){
        for (int i = 0; i < jCheckBoxes.length; i++)
            if (!jCheckBoxes[i].isSelected()) {
                    dice[i] = diceGenerator.changeDice();
                    jTextFields[i].setText("" + dice[i]);
                }
    }

    public void setUpperPanelListener(UpperPanelListener upperPanelListener) {
        this.upperPanelListener = upperPanelListener;
    }

    public void clearCheckBoxes(){
        for(int i =0; i<jCheckBoxes.length; i++)
            jCheckBoxes[i].setSelected(false);
    }
}
