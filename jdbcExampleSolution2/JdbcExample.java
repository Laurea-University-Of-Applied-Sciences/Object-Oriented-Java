package jdbcExampleSolution2;

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
import java.util.ArrayList;

/*
 * This is an improved version of the jdbcExampleSolution. In this version we are creating a table that does not allow cell edition.
 * See method createCarTableModel() below
 */
public class JdbcExample extends JFrame {
	final static int MAX_QTY = 6; // Constant value that defines the max amount of cars we can have in the application 

	// Private Class variables used in different methods in this Class 
	private CarQueries carQueries;
	private ArrayList<Car> allCars;
	private Car currentCar;
	
	static JTable tableCar; 
	static JButton btnAddCar;
	static DefaultTableModel myCarTableModel;
	
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
		
		tableCar.setModel(createCarTableModel()); // Creating a custom TableModel with car data from the database and disabling cell edition
		
		tableCar.setBounds(10, 36, 240, 100);
		getContentPane().add(tableCar);
		
		btnAddCar = new JButton("Add Car");
		btnAddCar.setBounds(270, 36, 89, 23);
		getContentPane().add(btnAddCar);
		
		MyEventHandler commandHandler = new MyEventHandler();
		btnAddCar.addActionListener(commandHandler);
	}

	/*
	 * This method creates a customized TableModel that:
	 * 1) contains car data retrieved from the database (via the allCars ArrayList)
	 * 2) disables cell editing on the table
	 */
	private DefaultTableModel createCarTableModel()
	{
		allCars = carQueries.getAllCars();

		Object[][] data = new Object[allCars.size()][4];
		String[] columns = new String[] {"Plate Number", "Colour", "Model", "Model Year"};
		
		/*
		 * This for loop will populate the fixed array "data" with the rows found from the allCars ArrayList
		 * We need to do this because "data" is passed as an argument to the DefaultTableModel constructor method.
		 * We can nor pass an ArrayList as an argument to the DefaultTableModel constructor method
		 */
		for (int row=0; row<allCars.size(); row++){
			
			currentCar = allCars.get(row); // get a Car from the ArrayList allCars
			
			data[row][0] = currentCar.getPlateNr();  
			data[row][1] = currentCar.getColour();  
			data[row][2] = currentCar.getModel();  
			data[row][3] = currentCar.getModelYear();  
		}

		myCarTableModel = new DefaultTableModel(data, columns) // "data" contains the car data from the database
				{
					@Override
					public boolean isCellEditable(int row, int column)  // Disabling cell edition
					{
						return false;
					}
				};
		
		return myCarTableModel;
	}

	private class MyEventHandler implements ActionListener
	{
		public void actionPerformed (ActionEvent myEvent)
		{
			if (myEvent.getSource() == btnAddCar){
				if (allCars.size() < MAX_QTY){ // If the current amount of cars in the database is smaller than MAX_QTY ...
					getNewCarFromUser();
					tableCar.setModel(createCarTableModel()); // Assigning a new TableModel to our table containing up-to-date car data
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
	    	// modelYear should be passed as an integer to the addCar method. Integer.parseInt() is used to convert a String to integer 
	    	carQueries.addCar(plateNrField.getText(), colourField.getText(), modelField.getText(), Integer.parseInt(modelYearField.getText()));
	    }
	}
	
	public static void main(String[] args) {
		JdbcExample frame = new JdbcExample();
		frame.setVisible(true);
	}
}
