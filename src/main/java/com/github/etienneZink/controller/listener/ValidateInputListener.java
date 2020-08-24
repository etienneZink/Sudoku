package com.github.etienneZink.controller.listener;

import java.awt.event.ActionEvent;
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

   public void keyReleased(KeyEvent ke) {
      JSudokuTextField component = (JSudokuTextField) ke.getSource();
      component.getActionListeners()[0].actionPerformed(new ActionEvent(component, 1, "perform"));
   }

   public void keyPressed(KeyEvent e) {
      validate(e);
   }

   private JSudokuTextField validate(KeyEvent ke) {
      JSudokuTextField component = (JSudokuTextField) ke.getSource();
      String value = component.getText();
      int l = value.length();
      if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
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
         if (ke.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
            component.setEditable(true);
         } else {
            component.setEditable(false);
         }
      }
      return component;
   }
}