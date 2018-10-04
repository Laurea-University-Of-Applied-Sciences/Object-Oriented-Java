package myFirstGUI;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFirstGUI {
	public static void main(String[] args) {
		JFrame myFrame = new JFrame("My First App");
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// getContentPane() returns the root container associated to myFrame 
		// Sets the JFrame's container with a null Layout Manager (Absolute positioning)
		myFrame.getContentPane().setLayout(null); 
		
		myFrame.setBounds(0,0,350,159); // Sets the size of the JFrame
		
		// Positioning the JFrame (Window) at the center of the computer's screen
		myFrame.setLocationRelativeTo(null);  
		
		// Adding and positioning UI components in the container
		JLabel label1 = new JLabel ("Just one label in my GUI");
		label1.setBounds(10,10,150,20);	
		myFrame.getContentPane().add(label1);
				
		myFrame.setVisible(true);
	}
}
