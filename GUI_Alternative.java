import java.awt.Container;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;;


public class GUI_Alternative extends JFrame{
	static JTextField test1;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GUI_Alternative() {
		setTitle("GUI");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(9, 9));

	
	   
	    pane.add(test1);
	    setVisible(true);
	    }
		
	public static void main(String[] args) {
		new GUI_Alternative();
		new Feld(test1);
	}
}
