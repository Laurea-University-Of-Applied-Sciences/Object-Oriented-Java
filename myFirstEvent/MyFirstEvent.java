package myFirstEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

// Change the name of this class to the name of your program
public class MyFirstEvent extends JFrame {
	/* The following components can not be declared as local variables in the constructor MyFirstEvent()
	 * because they will need to be accessed from within the actionPerfomred method. These are therefore
	 * declared as static variables 
	 */
	static JLabel lblSay = new JLabel("");
	static JButton btnYes = new JButton ("Say \"Yes\"");
	static JButton btnSaySomething = new JButton("Say something...");
	
	// This is the Class Constructor method. It has the same name as the Class name 
	public MyFirstEvent (){
		super("My First Event"); /* Calling the constructor method of 
		the superclass JFrame to create a JFrame with the given title */
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null); // Sets the JFrame's container with a null Layout Manager (Absolute positioning)
		setBounds(0,0,436,200); // Sets the size of the JFrame
		setLocationRelativeTo(null);  // Positioning the JFrame (Window) at the center of the computer's screen
		
		// Adding and positioning UI components in the container
		btnYes.setBounds(10,10,135,22);	
		getContentPane().add(btnYes);
		
		btnSaySomething.setBounds(166, 9, 135, 23);
		getContentPane().add(btnSaySomething);
		
		JLabel lblYouAskedMe = new JLabel("You asked me to say:");
		lblYouAskedMe.setBounds(10, 62, 135, 14);
		getContentPane().add(lblYouAskedMe);
		
		lblSay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSay.setBounds(10, 87, 370, 63);
		getContentPane().add(lblSay);
		
		// Creating a MyEventHandler to handle events generated by the command buttons
		// Registering the event handler (MyEventHandler) for both buttons
		MyEventHandler commandHandler = new MyEventHandler();
		btnYes.addActionListener(commandHandler);
		btnSaySomething.addActionListener(commandHandler);
	}
	
	// This class will handle the Action events generated by both buttons in the GUI
	private class MyEventHandler implements ActionListener
	{
		// In this method we will process the Action events generated by both buttons in the GUI
		public void actionPerformed (ActionEvent myEvent)
		{
			if (myEvent.getSource() == btnYes){
				lblSay.setText("Yes");
			}
			else if (myEvent.getSource() == btnSaySomething){
				lblSay.setText("Java is fun!");
			}
			else {
				lblSay.setText("Some strange event was captured...");
			}
		}
	}
	
	// This is the entry point for the application
	public static void main(String[] args) {
		MyFirstEvent frame = new MyFirstEvent();
		frame.setVisible(true);
	}
}