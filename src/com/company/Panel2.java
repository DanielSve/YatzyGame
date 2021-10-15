package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Panel2 extends JPanel {
    JTextField ettorField;
    JTextField tvåorField;
    JTextField treorField;
    JTextField fyrorField;
    JTextField femmorField;
    JTextField sexorField;
    JTextField summaField;
    JTextField bonusField;
    JLabel ettorLabel;
    JLabel tvåorLabel;
    JLabel treorLabel;
    JLabel fyrorLabel;
    JLabel femmorLabel;
    JLabel sexorLabel;
    JLabel summaLabel;
    JLabel bonusLabel;
    Dimension dimension;

    public Panel2(Dimension dimension){
        this.dimension = dimension;
        setPreferredSize(this.dimension);
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));


        ettorField = new JTextField(5);
        tvåorField = new JTextField(5);
        treorField = new JTextField(5);
        fyrorField = new JTextField(5);
        femmorField = new JTextField(5);
        sexorField = new JTextField(5);
        summaField = new JTextField(5);
        bonusField = new JTextField(5);

        ettorLabel = new JLabel("Ettor: ");
        tvåorLabel = new JLabel("Tvåor: ");
        treorLabel = new JLabel("Treor: ");
        fyrorLabel = new JLabel("Fyror: ");
        femmorLabel = new JLabel("Femmor: ");
        sexorLabel = new JLabel("Sexor: ");
        summaLabel = new JLabel("Summa: ");
        bonusLabel = new JLabel("Bonus: ");


        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;
        gc.gridx = 0;
        add(ettorLabel, gc);

        gc.gridx = 1;
        add(ettorField, gc);


        gc.gridy = 1;
        gc.gridx = 0;
        add(tvåorLabel, gc);

        gc.gridx = 1;
        add(tvåorField, gc);

        gc.gridy = 2;
        gc.gridx = 0;
        add(treorLabel, gc);

        gc.gridx = 1;
        add(treorField, gc);

        gc.gridy = 3;
        gc.gridx = 0;
        add(fyrorLabel, gc);

        gc.gridx = 1;
        add(fyrorField, gc);

        gc.gridy = 4;
        gc.gridx = 0;
        add(femmorLabel, gc);

        gc.gridx = 1;
        add(femmorField, gc);

        gc.gridy = 5;
        gc.gridx = 0;
        add(sexorLabel, gc);

        gc.gridx = 1;
        add(sexorField, gc);

        gc.gridy = 6;
        gc.gridx = 0;
        add(summaLabel, gc);

        gc.gridx = 1;
        add(summaField, gc);

        gc.gridy = 7;
        gc.gridx = 0;
        add(bonusLabel, gc);

        gc.gridx = 1;
        add(bonusField, gc);


    }

}