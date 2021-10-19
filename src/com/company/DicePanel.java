package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DicePanel extends JPanel {

    private DiceGenerator diceGenerator = new DiceGenerator();
    private DicePanelListener dicePanelListener;
    private JCheckBox [] jCheckBoxes = new JCheckBox[5];
    private JLabel [] diceLabels;
    private String [] filenames;
    private int [] dice = new int[5];
    private JButton rollButton;
    private JLabel infoLabel;
    public int rollsLeft;

    public DicePanel() {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(1000, 140));
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(
                2, 2, 2, 2), BorderFactory.createLineBorder(Color.GRAY))
        );

        rollsLeft = 3;
        setFilenamesArray();
        setCheckBoxes();
        LabelGenerator labelGenerator = new LabelGenerator("");
        infoLabel = labelGenerator.getInfoLabel();
        diceLabels = labelGenerator.getDiceLabels();
        rollButton = new JButton("Roll Dice");
        rollButton.setFocusable(false);

        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollDice();
                rollsLeft--;

                StoreNumbers storeNumbers = new StoreNumbers(this, dice);

                if (dicePanelListener != null)
                    dicePanelListener.numbersStored(storeNumbers);
            }
        });

        layoutAllComponents();
    }

    public void rollDice() {
        if (rollsLeft == 3) {
            dice = diceGenerator.getDice();
            for (int i = 0; i < dice.length; i++) {
                diceLabels[i].setIcon(new ImageIcon(filenames[dice[i]-1]));
            }
        }
        else if (rollsLeft > 0 && rollsLeft < 3)
            rollAgain();
    }

    public void rollAgain(){
        for (int i = 0; i < jCheckBoxes.length; i++)
            if (!jCheckBoxes[i].isSelected()) {
                    dice[i] = diceGenerator.changeDice();
                diceLabels[i].setIcon(new ImageIcon(filenames[dice[i]-1]));
            }
    }

    public void setDicePanelListener(DicePanelListener upperPanelListener) {
        this.dicePanelListener = upperPanelListener;
    }

    public void clearCheckBoxes(){
        for(int i =0; i<jCheckBoxes.length; i++)
            jCheckBoxes[i].setSelected(false);
    }

    public void setFilenamesArray(){
        filenames = new String[] {"dice1.jpg", "dice2.jpg", "dice3.jpg", "dice4.jpg", "dice5.jpg", "dice6.jpg"};
    }

    public void setCheckBoxes(){
        for (int i = 0; i <jCheckBoxes.length; i++) {
            jCheckBoxes[i] = new JCheckBox();
            jCheckBoxes[i].setFocusable(false);
        }
    }

    public void layoutAllComponents(){
            GridBagConstraints gc = new GridBagConstraints();

            gc.insets = new Insets(10,25,0,0);
            gc.gridy = 0;
            gc.ipady = 17;
            gc.ipadx = 30;
            for (int i = 0; i < diceLabels.length ; i++) {
                gc.gridx = i;
                add(diceLabels[i], gc);
            }

            gc.ipady = 10;
            gc.gridy = 1;
            gc.insets = new Insets(0,25,0,0);
            for (int i = 0; i < jCheckBoxes.length ; i++) {
                gc.gridx = i;
                add(jCheckBoxes[i], gc);
            }

            gc.insets = new Insets(0,23,0,0);
            gc.gridy = 2;
            gc.gridx = 1;
            gc.weightx = 0;
            gc.gridwidth = 3;
            gc.ipady = 5;
            add(infoLabel, gc);

            gc.insets = new Insets(0,0,10,0);
            gc.gridy = 3;
            gc.gridx = 0;
            gc.gridwidth = 5;
            add(rollButton, gc);
        }
}
