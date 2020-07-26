package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	
	ArrayList<String> guestNames = new ArrayList<String>();
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addButton = new JButton();
	JButton viewButton = new JButton();
	
	public static void main(String[] args) {
		new _02_GuestBook().setup();
	}
	
	void setup() {
		addButton.setText("Add Name");
		viewButton.setText("Display Names");
		addButton.addActionListener(this);
		viewButton.addActionListener(this);
		
		panel.add(addButton);
		panel.add(viewButton);
		frame.add(panel);
		frame.setTitle("Guest Book");
		frame.pack();
		frame.setVisible(true);
	}
	
	void addName() {
		guestNames.add(JOptionPane.showInputDialog("Input name to add to guest list."));
	}
	
	void displayNames() {
		String displayText = "";
		
		for(int i=0; i<guestNames.size(); i++) {
			displayText += ("Guest #" + (i+1) + ": " + guestNames.get(i) + "\n"); 
		}
		
		JOptionPane.showMessageDialog(null, displayText);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == addButton) {
			addName();
		}
		else if(e.getSource() == viewButton) {
			displayNames();
		}
	}
}
