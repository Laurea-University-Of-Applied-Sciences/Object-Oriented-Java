package painting;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Painting {
	public static void main(String[] args) {
		JFrame myFrame = new JFrame("Painting");
	
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.getContentPane().setLayout(null); 
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 334, 21);
		myFrame.getContentPane().add(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmAbout = new JMenuItem("Exit");
		
		// Event handler for the "Exit" menu
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); // Terminate the application
			}
		});
		
		mnMenu.add(mntmAbout);
	
		JPanel paintingPanel = new JPanel();
		paintingPanel.setBounds(121, 35, 101, 98);
		myFrame.getContentPane().add(paintingPanel);
		
		JLabel lblSelectColor = new JLabel("Select color:");
		lblSelectColor.setBounds(10, 35, 133, 14);
		myFrame.getContentPane().add(lblSelectColor);
		
		JComboBox color = new JComboBox();
		color.setModel(new DefaultComboBoxModel(new String[] {"Red", "Green", "Blue"}));
		color.setBounds(10, 60, 89, 20);
		myFrame.getContentPane().add(color);
		
		JButton btnNewButton = new JButton("Paint!");

		// Event handler for the "Paint!" button
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (color.getSelectedItem().equals("Red")) {
					paintingPanel.setBackground(Color.RED);
				}
				else if (color.getSelectedItem().equals("Green")) {
					paintingPanel.setBackground(Color.GREEN);					
				}
				else if (color.getSelectedItem().equals("Blue")) {
					paintingPanel.setBackground(Color.BLUE);
				}
				else {
					paintingPanel.setBackground(Color.GRAY);					
				}						
			}
		});

		btnNewButton.setBounds(10, 110, 89, 23);
		myFrame.getContentPane().add(btnNewButton);
	
		myFrame.setBounds(0,0,249,183);
		myFrame.setLocationRelativeTo(null);  
		myFrame.setVisible(true);
	}
}
