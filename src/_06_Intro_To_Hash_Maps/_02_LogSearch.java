package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons.
	 * 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	
	HashMap<Integer, String> entries = new HashMap<Integer, String>();
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addBtn = new JButton();
	JButton searchBtn = new JButton();
	JButton viewBtn = new JButton();
	JButton removeBtn = new JButton();
	
	_02_LogSearch(){
		addBtn.setText("Add Entry");
		searchBtn.setText("Search By ID");
		viewBtn.setText("View List");
		removeBtn.setText("Remove Entry");
		addBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		viewBtn.addActionListener(this);
		removeBtn.addActionListener(this);
		panel.add(addBtn);
		panel.add(searchBtn);
		panel.add(viewBtn);
		panel.add(removeBtn);
		frame.add(panel);
		frame.setTitle("Name Database");
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new _02_LogSearch();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object pressedBtn = e.getSource();
		
		if(pressedBtn == addBtn) {
			int id = Integer.parseInt(JOptionPane.showInputDialog("Input an ID number."));
			String name = JOptionPane.showInputDialog("Input a name to assign to this ID number.");
			entries.put(id, name);
			JOptionPane.showMessageDialog(null, "The name and ID has been logged.");
		}
		else if(pressedBtn == searchBtn) {
			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter and ID number to search for."));
			
			if(entries.containsKey(id)) {
				JOptionPane.showMessageDialog(null, "The name associated with ID: " + id + " is " + entries.get(id) + ".");
			} else {
				JOptionPane.showMessageDialog(null, "The entered ID number does not exist.");
			}
		}
		else if(pressedBtn == viewBtn) {
			String entireList = "";
			
			for(int key : entries.keySet()) {
				entireList += ("ID: " + key + "   Name: " + entries.get(key) + "\n");
			}
			
			JOptionPane.showMessageDialog(null, "List of All Entries: \n" + entireList);
		}
		else if(pressedBtn == removeBtn) {
			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID number to remove."));
			
			if(entries.containsKey(id)) {
				entries.remove(id);
				JOptionPane.showMessageDialog(null, "The ID: " + id + " and the name associated with it has been removed.");
			} else {
				JOptionPane.showMessageDialog(null, "The entered ID number does not exist.");
			}
		}
	}
	
}
