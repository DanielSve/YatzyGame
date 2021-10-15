package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerPanel extends JPanel implements ActionListener {
    private int[] numbers;
    private CountNumbers countNumbers;
    private PlayerPanelListener playerPanelListener;
    private Color myColor = new Color(239,240,239);
    public int emptyFields;
    private boolean validField;
    public boolean nextRound;
    private boolean hasBonus;
    private int summa;
    public int totalSumma;
    private int bonus;

    JTextField ettorField, tvåorField, treorField, fyrorField, femmorField, sexorField, summaField, bonusField,
        ettParField, tvåParField, treTalField, fyrTalField, litenStegeField, storStegeField, kåkField, chansField
        ,yatzyField, totalSummaField;

    Btn clicked, ettorButton, tvåorButton, treorButton, fyrorButton, femmorButton, sexorButton, ettParButton, tvåParButton
        ,treTalButton, fyrTalButton, litenStegeButton, storStegeButton, kåkButton, chansButton, yatzyButton;

    JLabel summaLabel, bonusLabel, totalSummaLabel;

    public PlayerPanel(){
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(
                2,2,2,2),BorderFactory.createLineBorder(Color.GRAY)));

        emptyFields = 15;
        validField = true;
        nextRound = false;
        hasBonus = false;
        bonus = 0;

        ettorField = new JTextField(5);
        tvåorField = new JTextField(5);
        treorField = new JTextField(5);
        fyrorField = new JTextField(5);
        femmorField = new JTextField(5);
        sexorField = new JTextField(5);
        summaField = new JTextField(5);
        bonusField = new JTextField(5);
        ettParField = new JTextField(5);
        tvåParField = new JTextField(5);
        treTalField = new JTextField(5);
        fyrTalField = new JTextField(5);
        litenStegeField = new JTextField(5);
        storStegeField = new JTextField(5);
        kåkField = new JTextField(5);
        chansField = new JTextField(5);
        yatzyField = new JTextField(5);
        totalSummaField = new JTextField(5);

        ettorButton = new Btn("Ettor: ",this);
        tvåorButton = new Btn("Tvåor: ",this);
        treorButton = new Btn("Treor: ",this);
        fyrorButton = new Btn("Fyror: ", this);
        femmorButton = new Btn("Femmor: ", this);
        sexorButton = new Btn("Sexor: ", this);
        summaLabel = new JLabel("Summa: ");
        bonusLabel = new JLabel("Bonus: ");
        ettParButton = new Btn("Ett par: ", this);
        tvåParButton = new Btn("Två par: ",this);
        treTalButton = new Btn("Tretal: ", this);
        fyrTalButton = new Btn("Fyrtal: ", this);
        litenStegeButton = new Btn("Liten stege: ", this);
        storStegeButton = new Btn("Stor stege: ", this);
        kåkButton  = new Btn("Kåk: ", this);
        chansButton = new Btn("Chans: ", this);
        yatzyButton = new Btn("Yatzy: ", this);
        totalSummaLabel = new JLabel("Totalsumma:");

        setLabel(summaLabel);
        setLabel(bonusLabel);
        setLabel(totalSummaLabel);
        summaField.setBackground(myColor);
        bonusField.setBackground(myColor);
        totalSummaField.setBackground(myColor);

        layoutAllComponents();
    }

    public void retrieveNumbers(int[] numbers ){
       this.numbers = numbers;
    }

    public void setPlayerPanelListener(PlayerPanelListener playerPanelListener) {
        this.playerPanelListener = playerPanelListener;
    }

    public void setLabel(JLabel label){
        label.setBackground(myColor);
        label.setOpaque(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!nextRound) {
            clicked = (Btn) e.getSource();
            countNumbers = new CountNumbers(numbers, clicked);
            validField = true;

            printNumbers();
            if (validField) {
                emptyFields--;
                updateSumma();
                updateTotalSumma();
                nextRound = true;
                playerPanelListener.nextRound(nextRound);
            }
        }
    }

    public void printNumbers(){
        if (clicked==ettorButton && ettorField.getText().equals(""))
            ettorField.setText(Integer.toString(countNumbers.sumEttor()));
        else if (clicked==tvåorButton && tvåorField.getText().equals(""))
            tvåorField.setText(Integer.toString(countNumbers.sumTvåor()));
        else if (clicked==treorButton && treorField.getText().equals(""))
            treorField.setText(Integer.toString(countNumbers.sumTreor()));
        else if (clicked==fyrorButton && fyrorField.getText().equals(""))
            fyrorField.setText(Integer.toString(countNumbers.sumFyror()));
        else if (clicked==femmorButton && femmorField.getText().equals(""))
            femmorField.setText(Integer.toString(countNumbers.sumFemmor()));
        else if (clicked==sexorButton && sexorField.getText().equals(""))
            sexorField.setText(Integer.toString(countNumbers.sumSexor()));
        else if (clicked==ettParButton && ettParField.getText().equals(""))
            ettParField.setText(Integer.toString(countNumbers.sumEttPar()));
        else if (clicked==tvåParButton && tvåParField.getText().equals(""))
            tvåParField.setText(Integer.toString(countNumbers.sumTvåPar()));
        else if (clicked==treTalButton && treTalField.getText().equals(""))
            treTalField.setText(Integer.toString(countNumbers.sumTreTal()));
        else if (clicked==fyrTalButton && fyrTalField.getText().equals(""))
            fyrTalField.setText(Integer.toString(countNumbers.sumFyrTal()));
        else if (clicked==litenStegeButton && litenStegeField.getText().equals(""))
            litenStegeField.setText(Integer.toString(countNumbers.sumLitenStege()));
        else if (clicked==storStegeButton && storStegeField.getText().equals(""))
            storStegeField.setText(Integer.toString(countNumbers.sumStorStege()));
        else if (clicked==kåkButton && kåkField.getText().equals(""))
            kåkField.setText(Integer.toString(countNumbers.sumKåk()));
        else if (clicked==chansButton && chansField.getText().equals(""))
            chansField.setText(Integer.toString(countNumbers.sumChans()));
        else if (clicked==yatzyButton && yatzyField.getText().equals(""))
            yatzyField.setText(Integer.toString(countNumbers.sumYatzy()));
        else
            validField=false;
    }

    public void checkBonus(){
        if (summa>=50 && !hasBonus) {
            hasBonus = true;
            bonus = 50;
            bonusField.setText("" + bonus);
            totalSumma = totalSumma+bonus;
        }
    }
    public void updateSumma(){
        summa = summa + countNumbers.getSumma();
        checkBonus();
        if(summa!=0) {
            summaField.setText("" + summa);
        }
    }
    public void updateTotalSumma(){
        totalSumma = totalSumma + countNumbers.getSumma() + countNumbers.getLowerSumma();
        totalSummaField.setText(""+totalSumma);
    }
    public void reset(){
        emptyFields = 15;
        validField = true;
        nextRound = false;
        hasBonus = false;
        bonus = 0;

        JTextField[] fields = {ettorField,tvåorField,treorField,fyrorField,femmorField,sexorField,summaField, bonusField,
                ettParField,tvåParField, treTalField,fyrTalField,litenStegeField,storStegeField,kåkField,chansField,
                yatzyField,totalSummaField};

        for (JTextField j: fields) {
                j.setText("");
        }
    }

    public void layoutAllComponents(){
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;
        gc.gridx = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(ettorButton, gc);
        gc.gridy = 1;
        add(tvåorButton, gc);
        gc.gridy = 2;
        add(treorButton, gc);
        gc.gridy = 3;
        add(fyrorButton, gc);
        gc.gridy = 4;
        add(femmorButton, gc);
        gc.gridy = 5;
        add(sexorButton, gc);
        gc.gridy = 6;
        gc.ipady = 4;

        gc.insets = new Insets(0,7,0,5);
        add(summaLabel, gc);
        gc.ipady = 4;
        gc.gridy = 7;
        add(bonusLabel, gc);

        gc.ipady = 0;
        gc.gridy = 8;
        gc.insets = new Insets(0,0,0,0);
        add(ettParButton, gc);
        gc.gridy = 9;
        add(tvåParButton, gc);
        gc.gridy = 10;
        add(treTalButton, gc);
        gc.gridy = 11;
        add(fyrTalButton, gc);
        gc.gridy = 12;
        add(litenStegeButton, gc);
        gc.gridy = 13;
        add(storStegeButton, gc);
        gc.gridy = 14;
        add(kåkButton, gc);
        gc.gridy = 15;
        add(chansButton, gc);
        gc.gridy = 16;
        add(yatzyButton, gc);

        gc.ipady = 4;
        gc.gridy = 17;
        gc.insets = new Insets(0,7,0,5);
        add(totalSummaLabel, gc);
        //-----next column--------//
        gc.ipady = 0;
        gc.gridy = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.gridx = 1;
        add(ettorField, gc);
        gc.gridy = 1;
        add(tvåorField, gc);
        gc.gridy = 2;
        add(treorField, gc);
        gc.gridy = 3;
        add(fyrorField, gc);
        gc.gridy = 4;
        add(femmorField, gc);
        gc.gridy = 5;
        add(sexorField, gc);
        gc.gridy = 6;
        add(summaField, gc);
        gc.gridy = 7;
        add(bonusField, gc);
        gc.gridy = 8;
        add(ettParField, gc);
        gc.gridy = 9;
        add(tvåParField, gc);
        gc.gridy = 10;
        add(treTalField, gc);
        gc.gridy = 11;
        add(fyrTalField, gc);
        gc.gridy = 12;
        add(litenStegeField, gc);
        gc.gridy = 13;
        add(storStegeField, gc);
        gc.gridy = 14;
        add(kåkField, gc);
        gc.gridy = 15;
        add(chansField, gc);
        gc.gridy = 16;
        add(yatzyField, gc);
        gc.gridy = 17;
        gc.ipady = 0;
        add(totalSummaField, gc);
    }
}
