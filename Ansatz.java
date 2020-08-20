import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Ansatz extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int borderWidth = 1;
    final int rows = 9;
    final int cols = 9;
    JTextField test1;
  
	public Ansatz(){
		
		
		setTitle("GUI");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(9, 9));

	for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
            this.test1 = new JTextField();
            if (row == 0 || row == 3 || row == 6 || row == 9) {
                if (col == 0 || col == 3 || col == 6 || col == 9) {
                    // Top left corner, draw all sides
                    test1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }
                else {
                    // Top edge, draw all sides except left edge
                    test1.setBorder(BorderFactory.createMatteBorder(borderWidth, 
                                                                    0, 
                                                                    borderWidth, 
                                                                    borderWidth, 
                                                                    Color.BLACK));
                }
            }
            else {
                if (col == 0 || col == 3 || col == 6 || col == 9) {
                    // Left-hand edge, draw all sides except top
                    test1.setBorder(BorderFactory.createMatteBorder(0, 
                                                                    borderWidth, 
                                                                    borderWidth, 
                                                                    borderWidth, 
                                                                    Color.BLACK));
                }
                else {
                    // Neither top edge nor left edge, skip both top and left lines
                    test1.setBorder(BorderFactory.createMatteBorder(0, 
                                                                    0, 
                                                                    borderWidth, 
                                                                    borderWidth, 
                                                                    Color.BLACK));
                }
            
           
        }
            pane.add(test1);
            setVisible(true);
            test1.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                   String value = test1.getText();
                   int l = value.length();
                   if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                      test1.setEditable(true);
                      if (l < 1) {
                    	  test1.setEditable(true);
                      }
                      else {
                    	  test1.setEditable(false);
                      }
                      
                   } else {
                      if (ke.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                    	  test1.setEditable(true);
                      }
                      else {
                    	  test1.setEditable(false);
                      }
                   }
                }
             });
        }
    } 
	
    
	}
	public static void main(String[] args) {
		new Ansatz();
	}
}
