package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FieldsPanel extends JPanel implements ActionListener {
    JButton ettorButton, tvåorButton, treorButton, fyrorButton, femmorButton, sexorButton, ettParButton, tvåParButton
            ,treTalButton, fyrTalButton, litenStegeButton, storStegeButton, kåkButton, chansButton, yatzyButton;

    public FieldsPanel (){
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        button(ettorButton,this);
        button(tvåorButton, this);
        button(treorButton, this);
        button(fyrorButton, this);
        button(femmorButton, this);
        button(sexorButton, this);
        button(ettParButton, this);
        button(tvåParButton, this);
        button(treTalButton, this);
        button(fyrTalButton, this);
        button(litenStegeButton, this);
        button(storStegeButton, this);
        button(kåkButton, this);
        button(chansButton, this);
    }

    public void button(JButton button, ActionListener a){
        button = new JButton();
        button.addActionListener(a);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
