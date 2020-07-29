package _03_IntroToStacks;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	
	Stack<Character> deletedChars = new Stack<Character>();
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel text = new JLabel();
	
	_02_TextUndoRedo(){
		panel.add(text);
		frame.addKeyListener(this);
		frame.add(panel);
		frame.setTitle("Simple Text Editor");
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new _02_TextUndoRedo();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode() == 8) {
			String currentText = text.getText();
			if(currentText.length() != 0) {
				deletedChars.push(currentText.charAt(currentText.length()-1));
				text.setText(currentText.substring(0, currentText.length() - 1));
			}
		} 
		else if(e.getKeyCode() == 17)
		{
			if(deletedChars.size() != 0) {
				text.setText(text.getText() + deletedChars.pop());
			}
		} else {
			if(e.getKeyCode() != 16) {
				text.setText(text.getText() + e.getKeyChar());
				deletedChars.clear();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
