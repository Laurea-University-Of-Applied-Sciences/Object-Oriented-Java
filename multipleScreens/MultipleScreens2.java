// This file shows a possible solution for the hands-on exercise given in the contact session

package multipleScreens;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class MultipleScreens2 extends JFrame {

	final static int MAX_QTY = 6; // Code changed here 
	static int dbItems = 0;
	
	static SimpleCar2[] myDB = new SimpleCar2[MAX_QTY]; // Code changed here
	
	static JTable tableCar; 
	static JButton btnAddCar; 
	
	public MultipleScreens2(){
		super("My Car Collection");

		initiateCarCollection();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null); 
		setBounds(0,0,436,331); 
		setLocationRelativeTo(null); 

		JLabel lblTheseAreMy = new JLabel("These are my cars:");
		lblTheseAreMy.setBounds(10, 11, 187, 14);
		getContentPane().add(lblTheseAreMy);
		
		tableCar = new JTable();
		tableCar.setRowSelectionAllowed(false);
		tableCar.setModel(new DefaultTableModel(
			new Object[MAX_QTY][4],  // Code changed here
			new String[] {"Plate Number", "Colour", "Model", "Model Year"} // Code changed here
		));
		tableCar.setBounds(10, 36, 240, 100); // Code changed here
		getContentPane().add(tableCar);
		
		btnAddCar = new JButton("Add Car");
		btnAddCar.setBounds(270, 36, 89, 23); // Code changed here
		getContentPane().add(btnAddCar);
		
		populateTable();
		
		MyEventHandler commandHandler = new MyEventHandler();
		btnAddCar.addActionListener(commandHandler);
	}

	private static void populateTable(){
		for (int row=0; row<dbItems; row++){
			tableCar.setValueAt(myDB[row].plateNr, row, 0);  
			tableCar.setValueAt(myDB[row].colour, row, 1);  
			tableCar.setValueAt(myDB[row].model, row, 2);
			tableCar.setValueAt(myDB[row].modelYear, row, 3); // Code added here
		}
	}
	
	private static void initiateCarCollection(){
		myDB[0] = new SimpleCar2("HGF-234", "Green", "Toyota", "1991"); // Code changed here
		myDB[1] = new SimpleCar2("YSL-409", "Black", "Renault", "1974"); // Code changed here
		dbItems = 2;
	}

	private class MyEventHandler implements ActionListener
	{
		public void actionPerformed (ActionEvent myEvent) // Code changes in this method
		{
			if (myEvent.getSource() == btnAddCar){
				if (dbItems < MAX_QTY){
					getNewCarFromUser();
					populateTable();
				}
				else{
					JOptionPane.showMessageDialog(null, "You can not add more cars in your collection", "Info", JOptionPane.INFORMATION_MESSAGE);
				}
					
			}
		}
	}
	
	private static void getNewCarFromUser(){
		JTextField plateNrField = new JTextField(10);
	    JTextField colourField = new JTextField(10);
	    JTextField modelField = new JTextField(10);
	    JTextField modelYearField = new JTextField(10); // Code added here
 
	    JPanel myPanel = new JPanel();
	    
	    myPanel.add(new JLabel("Plate number:"));
	    myPanel.add(plateNrField);
	    
	    myPanel.add(new JLabel("Colour:"));
	    myPanel.add(colourField);

	    myPanel.add(new JLabel("Model:"));
	    myPanel.add(modelField);
	    
	    myPanel.add(new JLabel("Model Year:")); // Code added here
	    myPanel.add(modelYearField); // Code added here
	    
	    int result = JOptionPane.showConfirmDialog(null, myPanel, "Enter details of your new car", JOptionPane.OK_CANCEL_OPTION);
	    
	    if (result == JOptionPane.OK_OPTION) {
	    	myDB[dbItems] = new SimpleCar2(plateNrField.getText(), colourField.getText(), modelField.getText(), modelYearField.getText()); // Code changed here  	
	    	++dbItems;
	    }
	}
	
	public static void main(String[] args) {
		MultipleScreens2 frame = new MultipleScreens2();
		frame.setVisible(true);
	}
}
