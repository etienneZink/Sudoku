import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class Feld{

	final int borderWidth = 1;
    final int rows = 9;
    final int cols = 9;
  
	public Feld(JTextField test1){
	for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
            
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
            
        }
    } 
	return;
    
	}
}
