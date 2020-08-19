package com.github.etienneZink.view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class AlfredsListener extends KeyAdapter{
    public void keyPressed(KeyEvent ke) {
        JTextField component = (JTextField) ke.getSource();
        String value = component.getText();
        int l = value.length();
        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
            component.setEditable(true);
           if (l < 1) {
            component.setEditable(true);
           }
           else {
            component.setEditable(false);
           }
           
        } else {
           if (ke.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
            component.setEditable(true);
           }
           else {
            component.setEditable(false);
           }
        }
     }
}   