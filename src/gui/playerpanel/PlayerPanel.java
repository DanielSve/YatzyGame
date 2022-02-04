package gui.playerpanel;

import gamelogic.CountNumbers;
import gui.buttons.Btn;
import gui.buttons.ButtonGenerator;
import gui.labels.LabelGenerator;
import gui.textfields.TextFieldGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerPanel extends JPanel implements ActionListener {

    private int[] numbers;
    private CountNumbers countNumbers;
    private PlayerPanelListener playerPanelListener;

    public int emptyFields;
    private int sum;
    public int totalSum;
    private int bonus;
    private boolean validField;
    public boolean otherPlayersTurn;
    private boolean hasBonus;
    private String player;

    Btn clicked;
    JTextField sumField, bonusField, totalSumField;
    JLabel titleLabel, sumLabel, bonusLabel, totalSumLabel;
    JTextField [] categoryFields;
    Btn [] buttons;

    public PlayerPanel(String player){
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(
                2,2,2,2),BorderFactory.createLineBorder(Color.LIGHT_GRAY)));

        emptyFields = 15;
        validField = true;
        otherPlayersTurn = false;
        hasBonus = false;
        bonus = 0;
        this.player = player;

        getAllComponents();
        layoutAllComponents();
    }

    public void retrieveNumbers(int[] numbers ){
       this.numbers = numbers;
    }

    public void setPlayerPanelListener(PlayerPanelListener playerPanelListener) {
        this.playerPanelListener = playerPanelListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!otherPlayersTurn && numbers!=null) {
            clicked = (Btn) e.getSource();
            countNumbers = new CountNumbers(numbers, clicked);
            validField = true;

            printNumbers();
            if (validField) {
                emptyFields--;
                updateSumma();
                updateTotalSumma();
                otherPlayersTurn = true;
                playerPanelListener.otherPlayersTurn(otherPlayersTurn);
            }
        }
    }

    public void printNumbers(){
        validField = false;
        for (int i = 0; i <buttons.length ; i++) {
            if (clicked == buttons[i] && categoryFields[i].getText().equals("")){
                categoryFields[i].setText(Integer.toString(countNumbers.getSum()));
                validField = true;
            }
        }
    }

    public void checkBonus(){
        if (sum>=50 && !hasBonus) {
            hasBonus = true;
            bonus = 50;
            bonusField.setText("" + bonus);
            totalSum = totalSum + bonus;
        }
    }
    
    public void updateSumma(){
        sum = 0;
        for (int i = 0; i <=5 ; i++) {
            if(!categoryFields[i].getText().equals("")) {
                sum = sum + Integer.parseInt(categoryFields[i].getText());
            }
        }
        sumField.setText(Integer.toString(sum));
        checkBonus();
        if(sum != 0) {
            sumField.setText("" + sum);
        }
    }
    
    public void updateTotalSumma(){
        totalSum = 0;
        for (int i = 0; i <categoryFields.length ; i++) {
            if(!categoryFields[i].getText().equals("")) {
                totalSum = totalSum + Integer.parseInt(categoryFields[i].getText());
            }
        }
        if(hasBonus){
            totalSum = totalSum + Integer.parseInt(bonusField.getText());
        }
        totalSumField.setText(Integer.toString(totalSum));
    }
    
    public void reset(){
        emptyFields = 15;
        validField = true;
        otherPlayersTurn = false;
        hasBonus = false;
        bonus = 0;

        for (JTextField j: categoryFields) {
                j.setText("");
        }
        sumField.setText("");
        bonusField.setText("");
        totalSumField.setText("");
    }

    public void getAllComponents(){
        ButtonGenerator buttonGenerator = new ButtonGenerator(this);
        TextFieldGenerator textFieldGenerator = new TextFieldGenerator();
        LabelGenerator labelGenerator = new LabelGenerator(player);
        buttons = buttonGenerator.getButtons();
        categoryFields = textFieldGenerator.getCategoryFields();

        sumField = textFieldGenerator.getSumField();
        bonusField = textFieldGenerator.getBonusField();
        totalSumField = textFieldGenerator.getTotalSumField();

        titleLabel = labelGenerator.getTitleLabel();
        sumLabel = labelGenerator.getSumLabel();
        bonusLabel = labelGenerator.getBonusLabel();
        totalSumLabel = labelGenerator.getTotalSumLabel();
    }

    public void layoutAllComponents(){
        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.ipady = 12;
        gc.insets = new Insets(25,6,5,3);
        gc.gridwidth = 2;
        add(titleLabel, gc);

        gc.gridwidth = 1;
        gc.ipady = 0;
        gc.insets = new Insets(0,0,0,0);
        for (int i = 0; i <= 5 ; i++) {
            gc.gridy = i + 1;
            add(buttons[i], gc);
        }

        gc.gridy = 7;
        gc.ipady = 4;
        gc.insets = new Insets(0,7,0,5);
        add(sumLabel, gc);

        gc.ipady = 4;
        gc.gridy = 8;
        add(bonusLabel, gc);

        gc.insets = new Insets(0,0,0,0);
        gc.ipady = 0;
        for (int i = 9; i <buttons.length+3 ; i++) {
            gc.gridy = i;
            add(buttons[i-3], gc);
        }

        gc.ipady = 4;
        gc.gridy = 18;
        gc.insets = new Insets(0,7,15,5);
        add(totalSumLabel, gc);

        //-----next column--------//

        gc.ipady = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.gridx = 1;
        for (int i = 0; i <=5 ; i++) {
            gc.gridy = i + 1;
            add(categoryFields[i], gc);
        }
        gc.gridy = 7;
        add(sumField, gc);

        gc.gridy = 8;
        add(bonusField, gc);

        for (int i = 9; i < categoryFields.length + 3 ; i++) {
            gc.gridy = i ;
            add(categoryFields[i - 3], gc);
        }
        gc.gridy = 18;
        gc.insets = new Insets(0,0,15,0);
        add(totalSumField, gc);
    }
}
