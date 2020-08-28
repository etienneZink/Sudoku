package com.github.etienneZink.controller.listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.github.etienneZink.controller.Controller;
import com.github.etienneZink.view.JSudokuTextField;

// Eine extra Klasse als Listener ist in dem Fall besser, da du dann einfach nur ein Objekt dieser Klasse erstellen musst.
// Dann haben alle Instanzen die gleiche Methode.

public class ValidateInputListener extends KeyAdapter {

   private Controller controller;

   public ValidateInputListener(Controller controller) {
      this.controller = controller;
   }

   public void keyPressed(KeyEvent e) {
      JSudokuTextField component = (JSudokuTextField) e.getSource();
      String value = component.getText();
      int l = value.length();
      if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
         component.setEditable(true);
         if (controller.getBOARD_SIZE() < 10) {
            if (l < 1) {
               component.setEditable(true);
            } else {
               component.setEditable(false);
            }
         } else {
            if (l < 2) {
               component.setEditable(true);
            } else {
               component.setEditable(false);
            }
         }
      } else {
         if (e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
            component.setEditable(true);
         } else {
            component.setEditable(false);
         }
      }
   }      
}