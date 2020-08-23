package com.github.etienneZink.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.github.etienneZink.model.sudoku.framework.fields.Field;

import java.awt.Font;
import java.awt.Toolkit;

public class GUI extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -1647492041239001724L;

    final int BOARD_SIZE_ROOT;
    final int BOARD_SIZE;
    final int borderWidth = 1;
    private JPanel contentPane;
    private JSudokuTextField[][] tfArray;

    public GUI(Field[][] fields) {
        this.BOARD_SIZE = fields.length;
        this.BOARD_SIZE_ROOT = (int) Math.sqrt(BOARD_SIZE);
        tfArray = new JSudokuTextField[BOARD_SIZE][BOARD_SIZE];
        setTitle("Sudoku");
        setSize(600, 600);
        //setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE + 1));

        JSudokuTextField tempJSTF;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                // wird eigene Klasse JSudokuTextFiled verwendet, um row und column der
                // Componente ab zu speichern
                tempJSTF = new JSudokuTextField(row, col);
                // adds the JSTF to the list, to address it later
                tfArray[row][col] = tempJSTF;
                // hier musst du beim Erstellen einfach einen neuen Listener an dem Feld
                // anmelden
                tempJSTF.addKeyListener(new AlfredsListener());
                // müsste noch dynamisch an die Größe des Models angepasst werden
                if (row % BOARD_SIZE_ROOT == 0) {
                    if (col % BOARD_SIZE_ROOT == 0) {
                        // Top left corner, draw all sides
                        tempJSTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    } else {
                        // Top edge, draw all sides except left edge
                        tempJSTF.setBorder(
                                BorderFactory.createMatteBorder(borderWidth, 0, borderWidth, borderWidth, Color.BLACK));
                    }
                } else {
                    if (col % BOARD_SIZE_ROOT == 0) {
                        // Left-hand edge, draw all sides except top
                        tempJSTF.setBorder(
                                BorderFactory.createMatteBorder(0, borderWidth, borderWidth, borderWidth, Color.BLACK));
                    } else {
                        // Neither top edge nor left edge, skip both top and left lines
                        tempJSTF.setBorder(
                                BorderFactory.createMatteBorder(0, 0, borderWidth, borderWidth, Color.BLACK));
                    }
                }
                tempJSTF.setHorizontalAlignment(JTextField.CENTER);
                tempJSTF.setFont(new Font("Arial", Font.PLAIN, (int) screenSize.getWidth() / 50));
                contentPane.add(tempJSTF);
            }
        }
        setContentPane(contentPane);
        initialize(fields);
        setVisible(true);
    }

    public void changeValue(int row, int column, int value){
        tfArray[row][column].setText(String.valueOf(value));
    }

    public void changeValues(Field[][] fields){
        int tempValue;
        for(int row = 0; row < BOARD_SIZE; ++row){
            for(int column = 0; column < BOARD_SIZE; ++column){
                if((tempValue = fields[row][column].getValue()) != -1){
                    tfArray[row][column].setText(String.valueOf(tempValue));
                }
            }
        }
    }

    private void initialize(Field[][] fields){
        int tempValue;
        JSudokuTextField tempJSTF;
        for(int row = 0; row < BOARD_SIZE; ++row){
            for(int column = 0; column < BOARD_SIZE; ++column){
                if((tempValue = fields[row][column].getValue()) != -1){
                    tempJSTF = tfArray[row][column];
                    tempJSTF.setText(String.valueOf(tempValue));
                    tempJSTF.setEditable(false);
                    tempJSTF.setEnabled(false);
                }
            }
        }
    }
}
