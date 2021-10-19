package com.company;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Btn extends JButton {
    public Btn(String text, ActionListener a) {

        this.setText(text);
        this.addActionListener(a);
        this.setFocusable(false);
    }
}
