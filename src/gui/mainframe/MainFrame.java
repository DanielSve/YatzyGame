package gui.mainframe;

import gamelogic.StoreNumbers;
import gui.dicepanel.DicePanel;
import gui.dicepanel.DicePanelListener;
import gui.playerpanel.PlayerPanel;
import gui.playerpanel.PlayerPanelListener;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    DicePanel dicePanel;
    PlayerPanel player1Panel;
    PlayerPanel player2Panel;
    Boolean gameFinished;

    public MainFrame(){
        setLayout(new GridBagLayout());
        setTitle("Yatzy");
        setPreferredSize(new Dimension(800,800));

        dicePanel = new DicePanel();
        player1Panel = new PlayerPanel("Player 1");
        player2Panel = new PlayerPanel("Player 2");
        setPanelEnabled(player2Panel,false);
        gameFinished = false;

        dicePanel.setDicePanelListener(new DicePanelListener() {
            @Override
            public void numbersStored(StoreNumbers storeNumbers) {
                if (player1Panel.isEnabled()) {
                    player1Panel.otherPlayersTurn = false;
                    int[] numbers = storeNumbers.getNumbers();
                    player1Panel.retrieveNumbers(numbers);
                } else {
                    player2Panel.otherPlayersTurn = false;
                    int[] numbers = storeNumbers.getNumbers();
                    player2Panel.retrieveNumbers(numbers);
                }
            }
        });

        player1Panel.setPlayerPanelListener(new PlayerPanelListener() {
            @Override
            public void otherPlayersTurn(Boolean b) {
                if (player1Panel.otherPlayersTurn) {
                    dicePanel.clearCheckBoxes();
                    dicePanel.rollsLeft = 3;
                    setPanelEnabled(player1Panel,false);
                    setPanelEnabled(player2Panel,true);
                }
            }
        });

        player2Panel.setPlayerPanelListener(new PlayerPanelListener() {
            @Override
            public void otherPlayersTurn(Boolean b) {
                if (player2Panel.otherPlayersTurn) {
                    dicePanel.clearCheckBoxes();
                    dicePanel.rollsLeft = 3;
                    setPanelEnabled(player2Panel,false);
                    setPanelEnabled(player1Panel,true);
                    gameFinished = setFinished();
                    if(gameFinished){
                        JOptionPane.showMessageDialog(null,getWinner());
                        player1Panel.reset();
                        player2Panel.reset();
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
            gameFinished = true;
        }
        else
            gameFinished = false;
        return gameFinished;
    }

    public String getWinner(){
        String player1 = "Player 1 wins!";
        String player2 = "Player 2 wins!";
        String draw = "It's a draw!";
        if (player1Panel.totalSum == player2Panel.totalSum)
            return draw;
        else if(player1Panel.totalSum>player2Panel.totalSum)
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
        add(dicePanel, gc);

        gc.weightx =0.5;
        gc.weighty = 0.5;
        gc.fill = GridBagConstraints.BOTH;
        gc.gridy = 1;
        gc.gridwidth =1;
        add(player1Panel, gc);

        gc.gridx = 1;
        add(player2Panel, gc);
    }
}
