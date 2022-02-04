package gui.labels;

import javax.swing.*;
import java.awt.*;

public class LabelGenerator extends JLabel {
    JLabel titleLabel, sumLabel, bonusLabel, totalSumLabel, label1, label2, label3, label4, label5, infoLabel;

    private Color myColor = new Color(239,240,239);
    private Color myColor2 = new Color(207,208, 223);

    public LabelGenerator(String player){
        titleLabel = new JLabel(player);
        sumLabel = new JLabel("Upper Score ");
        bonusLabel = new JLabel("Bonus ");
        totalSumLabel = new JLabel("TOTAL");
        setLabel(sumLabel);
        setLabel(bonusLabel);
        setLabel(totalSumLabel);
        setLabel(titleLabel);
        titleLabel.setBackground(myColor2);

        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label1.setIcon(new ImageIcon("assets/images/dice1.jpg"));
        label2.setIcon(new ImageIcon("assets/images/dice2.jpg"));
        label3.setIcon(new ImageIcon("assets/images/dice3.jpg"));
        label4.setIcon(new ImageIcon("assets/images/dice4.jpg"));
        label5.setIcon(new ImageIcon("assets/images/dice5.jpg"));

        infoLabel = new JLabel("Select to keep");
        infoLabel.setForeground(Color.GRAY);
    }

    public void setLabel(JLabel label){
        label.setBackground(myColor);
        label.setOpaque(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public JLabel getSumLabel() {
        return sumLabel;
    }

    public JLabel getBonusLabel() {
        return bonusLabel;
    }

    public JLabel getTotalSumLabel() {
        return totalSumLabel;
    }

    public JLabel getInfoLabel() {
        return infoLabel;
    }

    public JLabel[] getDiceLabels(){
        JLabel[] diceLabels = {label1, label2, label3, label4, label5};
        return diceLabels;
    }
}
