package jdbcExample;

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
//import java.util.List;
import java.util.ArrayList;

public class JdbcExample extends JFrame {
	final static int MAX_QTY = 6; // Constant value that defines the max amount of cars we can have in the application 

	// Private Class variables used in different methods in this Class 
	private CarQueries carQueries;
	private ArrayList<Car> allCars;
	private Car currentCar;
	
	static JTable tableCar; 
	static JButton btnAddCar; 
	
	public JdbcExample(){
		super("My Car Collection");

		carQueries = new CarQueries(); // Initializes a carQueries object to handle db operations in this session
		
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
			new Object[MAX_QTY][4],
			new String[] {"Plate Number", "Colour", "Model", "Model Year"}
		));
		tableCar.setBounds(10, 36, 240, 100);
		getContentPane().add(tableCar);
		
		btnAddCar = new JButton("Add Car");
		btnAddCar.setBounds(270, 36, 89, 23);
		getContentPane().add(btnAddCar);
		
		populateTable();
		
		MyEventHandler commandHandler = new MyEventHandler();
		btnAddCar.addActionListener(commandHandler);
	}

	private void populateTable()
	{		
		allCars = carQueries.getAllCars(); // Calling the CarQueries method that returns a list containing all cars from the database
		
		for (int row=0; row<allCars.size(); row++){ //allCars.size() returns the amount of items in the allCars list
			
			currentCar = allCars.get(row); // get a Car from the ArrayList allCars
			
			tableCar.setValueAt(currentCar.getPlateNr(), row, 0);  
			tableCar.setValueAt(currentCar.getColour(), row, 1);  
			tableCar.setValueAt(currentCar.getModel(), row, 2);
			tableCar.setValueAt(currentCar.getModelYear(), row, 3);
		}
	}

	private class MyEventHandler implements ActionListener
	{
		public void actionPerformed (ActionEvent myEvent)
		{
			if (myEvent.getSource() == btnAddCar){
				if (allCars.size() < MAX_QTY){ // If the current amount of cars in the database is smaller than MAX_QTY ...
					getNewCarFromUser();
					populateTable();
				}
				else{
					JOptionPane.showMessageDialog(null, "You can not add more cars in your collection", "Info", JOptionPane.INFORMATION_MESSAGE);
				}			
			}
		}
	}
	
	private void getNewCarFromUser(){
		JTextField plateNrField = new JTextField(10);
	    JTextField colourField = new JTextField(10);
	    JTextField modelField = new JTextField(10);
	    JTextField modelYearField = new JTextField(10);
 
	    JPanel myPanel = new JPanel();
	    
	    myPanel.add(new JLabel("Plate number:"));
	    myPanel.add(plateNrField);
	    
	    myPanel.add(new JLabel("Colour:"));
	    myPanel.add(colourField);

	    myPanel.add(new JLabel("Model:"));
	    myPanel.add(modelField);
	    
	    myPanel.add(new JLabel("Model Year:"));
	    myPanel.add(modelYearField);
	    
	    int result = JOptionPane.showConfirmDialog(null, myPanel, "Enter details of your new car", JOptionPane.OK_CANCEL_OPTION);
	    
	    if (result == JOptionPane.OK_OPTION) {	    	
	    	// Add here a call to the CarQueries method that inserts a new row into the database
	    	// To get the values from the dialog, use plateNrField.getText(), colourField.getText(), modelField.getText(), Integer.parseInt(modelYearField.getText())
	    }
	}
	
	public static void main(String[] args) {
		JdbcExample frame = new JdbcExample();
		frame.setVisible(true);
	}
}
