package myFirstGUI;

import javax.swing.JFrame;
import javax.swing.JLabel; // After this line, WindowBuilder will add other imports related to other components you add there

// Change the name of this class to the name of your program
public class MyFirstGUI extends JFrame {
	// Here you can define class or instance variables needed in your application

	// This is the Class Constructor method. It has the same name as the Class name 
	public MyFirstGUI (){
		super("My First App"); // Calling the constructor method of the superclass JFrame to create a JFrame with the given title
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null); // Sets the JFrame's container with a null Layout Manager (Absolute positioning)
		setBounds(0,0,350,159); // Sets the size of the JFrame
		setLocationRelativeTo(null);  // Positioning the JFrame (Window) at the center of the computer's screen
		
		// Adding and positioning UI components in the container
		JLabel label1 = new JLabel ("Just one label in my GUI");
		label1.setBounds(10,10,150,20);	
		getContentPane().add(label1); // After this line, WindowBuilder will add code of other components you add via WindowBuilder
				
	}
	
	// This is the entry point for your application
	public static void main(String[] args) {
		MyFirstGUI frame = new MyFirstGUI();
		frame.setVisible(true);
	}
}
