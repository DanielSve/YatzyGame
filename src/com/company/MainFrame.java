package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    UpperPanel upperPanel;
    PlayerPanel player1Panel;
    PlayerPanel player2Panel;
    Boolean finished;

    public MainFrame(){
        setLayout(new GridBagLayout());
        setTitle("Yatzy");
        upperPanel = new UpperPanel();
        setPreferredSize(new Dimension(800,700));
        player1Panel = new PlayerPanel();
        player2Panel = new PlayerPanel();
        finished = false;

        upperPanel.setUpperPanelListener(new UpperPanelListener() {
            @Override
            public void numbersStored(StoreNumbers storeNumbers) {
                if (player1Panel.isEnabled()) {
                    player1Panel.nextRound = false;
                    int[] numbers = storeNumbers.getNumbers();
                    player1Panel.retrieveNumbers(numbers);
                } else {
                    player2Panel.nextRound = false;
                    int[] numbers = storeNumbers.getNumbers();
                    player2Panel.retrieveNumbers(numbers);
                }
            }
        });

        player1Panel.setPlayerPanelListener(new PlayerPanelListener() {
            @Override
            public void nextRound(Boolean b) {
                if (player1Panel.nextRound) {
                    upperPanel.clearCheckBoxes();
                    upperPanel.throwsLeft = 3;
                    setPanelEnabled(player1Panel,false);
                    setPanelEnabled(player2Panel,true);
                }
            }
        });

        player2Panel.setPlayerPanelListener(new PlayerPanelListener() {
            @Override
            public void nextRound(Boolean b) {
                if (player2Panel.nextRound) {
                    upperPanel.clearCheckBoxes();
                    upperPanel.throwsLeft = 3;
                    setPanelEnabled(player2Panel,false);
                    setPanelEnabled(player1Panel,true);
                    finished=setFinished();
                    if(finished){
                        JOptionPane.showMessageDialog(null,getWinner());
                        player1Panel.reset();
                        player2Panel.reset();
                        System.out.println("layout klar");
                    }
                }
            }
        });

        layoutPanels();
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
    }

    void setPanelEnabled(JPanel panel, Boolean isEnabled) {
        panel.setEnabled(isEnabled);

        Component[] components = panel.getComponents();

        for(int i = 0; i < components.length; i++) {
            if(components[i].getClass().getName() == "javax.swing.JPanel") {
                setPanelEnabled((JPanel) components[i], isEnabled);
            }
            components[i].setEnabled(isEnabled);
        }
    }
    public boolean setFinished(){

        if (player1Panel.emptyFields==0 && player2Panel.emptyFields==0) {
            finished = true;
        }
        else
            finished = false;
        return finished;
    }
    public String getWinner(){
        String player1 = "Player 1 wins!";
        String player2 = "Player 2 wins!";
        String draw = "It's a draw!";
        if (player1Panel.totalSumma==player2Panel.totalSumma)
            return draw;
        else if(player1Panel.totalSumma>player2Panel.totalSumma)
            return player1;
        else
            return player2;
    }

    public void layoutPanels(){
        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 0;
        gc.weighty = 0;
        gc.gridy = 0;
        gc.gridx = 0;
        gc.gridwidth=2;
        add(upperPanel, gc);

        gc.weightx =0.5;
        gc.weighty = 0.5;
        gc.fill = GridBagConstraints.BOTH;
        gc.gridy = 1;
        gc.gridx = 0;
        gc.gridwidth =1;
        add(player1Panel, gc);

        gc.gridy = 1;
        gc.gridx = 1;
        add(player2Panel, gc);
    }
}
