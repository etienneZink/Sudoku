package com.github.etienneZink.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import com.github.etienneZink.model.sudoku.framework.boards.ClassicSudoku;
import com.github.etienneZink.model.sudoku.framework.fields.Field;

import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class GUI extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -1647492041239001724L;

    final int borderWidth = 1;
    private int BOARD_SIZE_ROOT;
    private int BOARD_SIZE;
    private JFrame frame;
    private JPanel contentPane, buttonPane;
    private JSudokuTextField[][] jstfArray;
    private JButton clear, solve, check, newSudoku;
    private JMenuBar menu;
    private JMenu spiel;
    private JMenuItem viermalvier;
    private JMenuItem neunmalneun;
    private JMenuItem sechzehnmalsechzehn;
    private int screenWidth;
    private int screenHeight;
    private ClassicSudoku sudoku;

    public GUI(File file) {
        frame = new JFrame();
        if(file.exists()){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                sudoku = (ClassicSudoku) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            sudoku = new ClassicSudoku(9); 
        }

        buttonPane = new JPanel();

        clear = new JButton("Clear");
        solve = new JButton("Solve");
        check = new JButton("Check");
        newSudoku = new JButton("New Sudoku");

        buttonPane.add(clear);
        buttonPane.add(solve);
        buttonPane.add(check);
        buttonPane.add(newSudoku);

        menu = new JMenuBar();
        spiel = new JMenu("Size");
        viermalvier = new JMenuItem("4x4");
        neunmalneun = new JMenuItem("9x9");
        sechzehnmalsechzehn = new JMenuItem("16x16");

        setJMenuBar(menu);
        spiel.add(viermalvier);
        spiel.add(neunmalneun);
        spiel.add(sechzehnmalsechzehn);
        menu.add(spiel);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        screenWidth = gd.getDisplayMode().getWidth();
        screenHeight = gd.getDisplayMode().getHeight();
        frame.setTitle("Sudoku");
        frame.setSize(600, 600);
        frame.setLocation(screenWidth/2-300, screenHeight/2-300);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initializeContentPane(sudoku.getFields());
        frame.setVisible(true);
    }

    /**
     * Changes the text of all the <code>JSudokuTextFields</code> to the values of
     * the <code>Field[][]</code>.
     * 
     * @param fields
     */
    public void changeValues(Field[][] fields) {
        int tempValue;
        for (int row = 0; row < BOARD_SIZE; ++row) {
            for (int column = 0; column < BOARD_SIZE; ++column) {
                if ((tempValue = fields[row][column].getValue()) != -1) {
                    jstfArray[row][column].setText(String.valueOf(tempValue));
                }
            }
        }
    }

    /**
     * Initializes the GUI with a new <code>contentPane</code> and the values of the
     * <code>Field[][]</code>.
     * 
     * @param fields
     */
    public void initializeContentPane(Field[][] fields) {
        int tempValue;

        // keine Überprüfung notwendig, da im model richtig gesetzt
        BOARD_SIZE = fields.length;
        BOARD_SIZE_ROOT = (int) Math.sqrt(BOARD_SIZE);
        if(contentPane != null){
            frame.remove(contentPane);
        }
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        jstfArray = new JSudokuTextField[BOARD_SIZE][BOARD_SIZE];

        JSudokuTextField tempJSTF;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        for (int row = 0; row < BOARD_SIZE; ++row) {
            for (int column = 0; column < BOARD_SIZE; ++column) {
                // wird eigene Klasse JSudokuTextFiled verwendet, um row und column der
                // Componente ab zu speichern
                tempJSTF = new JSudokuTextField(row, column);
                // adds the JSTF to the list, to address it later
                jstfArray[row][column] = tempJSTF;
                if ((tempValue = fields[row][column].getValue()) != -1) {
                    tempJSTF = jstfArray[row][column];
                    tempJSTF.setText(String.valueOf(tempValue));
                    if(fields[row][column].isInitial()){
                        tempJSTF.setEditable(false);
                    }
                }
                if (row % BOARD_SIZE_ROOT == 0) {
                    if (column % BOARD_SIZE_ROOT == 0) {
                        // Top left corner, draw all sides
                        tempJSTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    } else {
                        // Top edge, draw all sides except left edge
                        tempJSTF.setBorder(
                                BorderFactory.createMatteBorder(borderWidth, 0, borderWidth, borderWidth, Color.BLACK));
                    }
                } else {
                    if (column % BOARD_SIZE_ROOT == 0) {
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
        frame.add(contentPane, BorderLayout.CENTER);
        frame.add(buttonPane, BorderLayout.SOUTH);
        frame.add(menu, BorderLayout.NORTH);
        frame.setVisible(true);

    }

    public JButton getClearBTN() {
        return clear;
    }

    public JButton getNewSudokuBTN() {
        return newSudoku;
    }

    public JButton getSolveBTN() {
        return solve;
    }

    public JButton getCheckBTN() {
        return check;
    }

    public JSudokuTextField[][] getJSTF() {
        return jstfArray;
    }

    public JMenuItem getMenuVierMalVier() {
        return viermalvier;
    }

    public JMenuItem getMenuNeunMalNeun() {
        return neunmalneun;
    }

    public JMenuItem getMenuSechzehnMalSechzehn() {
        return sechzehnmalsechzehn;
    }

    public JFrame getFrame(){
        return frame;
    }
}
