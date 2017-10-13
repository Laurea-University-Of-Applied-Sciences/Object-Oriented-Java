package studentgui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentGUI extends JFrame {
	// private static final long serialVersionUID = 1L; // You can use this line to remove the Eclipse warning "The serializable class..."
	
	// The following three variables need to be declared as Class variables (private) because they need to accessed from within the event handler methods
	private JTextField txtStudentName;
	private JLabel lblStudentInfo;
	private Student student;
	
	public StudentGUI() {
		
		setBounds(0,0,583,439); // Sets the size of the JFrames
		setLocationRelativeTo(null); // Positioning the JFrame (Window) at the center of the computer's screen
			
		// A menu (JMenu) "File" that has at least one menu item (JMenuItem) "Close" to close the application. You can create as many items as you wish and have time to implement.
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mnFile.add(mntmClose);

		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//When "Close" menu item is clicked, the application is closed. 
				System.exit(0);
			}
		});
		
		getContentPane().setLayout(null);
		
		//A drop down menu (JComboBox) to select the language of the student.
		JComboBox<String> cmbLanguage = new JComboBox<String>();
		cmbLanguage.setBounds(112, 31, 146, 26);
		getContentPane().add(cmbLanguage);
		cmbLanguage.addItem("Finnish");
		cmbLanguage.addItem("English");
		
		//A text box (JTextField) to enter the name of the student
		txtStudentName = new JTextField();
		txtStudentName.setBounds(112, 68, 146, 26);
		getContentPane().add(txtStudentName);
		txtStudentName.setColumns(10);
		
		
		// A label for language combo box
		JLabel lblLanguage = new JLabel("Language");
		lblLanguage.setBounds(34, 37, 69, 20);
		getContentPane().add(lblLanguage);
		
		// A label for name text box
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(34, 74, 69, 20);
		getContentPane().add(lblName);
		
		// A label to show the student’s name and language
		lblStudentInfo = new JLabel("");
		lblStudentInfo.setBounds(15, 167, 517, 34);
		getContentPane().add(lblStudentInfo);
		
		// A button (JButton) to create the student
		JButton btnCreateStudent = new JButton("Create Student");
		btnCreateStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 *  When Create student button is clicked
						-	a new private Student object is created
						-	student info is printed into the Student info label.
				 */
				student = new Student(txtStudentName.getText(), cmbLanguage.getSelectedItem().toString());
				lblStudentInfo.setText("Student " + student.getName() + " that speaks " + student.getLanguage() + " created.");
			}
		});
		btnCreateStudent.setBounds(122, 117, 136, 29);
		getContentPane().add(btnCreateStudent);
		
		// A button to make the student say hello
		JButton btnSayHello = new JButton("Say hello!");
		btnSayHello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// When "Say hello" button is clicked a message box (JOptionPane.showMessageDialog()) greets in their respective language.
				JOptionPane.showMessageDialog(rootPane, student.greet());
			}
		});
		btnSayHello.setBounds(15, 217, 115, 29);
		getContentPane().add(btnSayHello);
		
	}

	public static void main(String[] args) {
		JFrame frame = new StudentGUI();
		frame.setVisible(true);
	}
}
