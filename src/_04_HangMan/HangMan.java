package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	Stack<String> wordStack = new Stack<String>();
	ArrayList<Character> usedChars = new ArrayList<Character>();
	int numWords;
	String chosenWord;
	int numLives;
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel marking = new JLabel();
	JLabel lives = new JLabel();
	JLabel usedLetters = new JLabel();
	
	HangMan(){
		selectWords();
		setupUI();
	}
	
	//MAIN METHOD IS HERE
	public static void main(String[] args) {
		new HangMan();
	}
	
	void selectWords() {
		numWords = Integer.parseInt(JOptionPane.showInputDialog("Enter an integer between 1 and " + Utilities.getTotalWordsInFile("dictionary.txt") + " to choose how many words you want for this game."));
		
		for(int i=0; i<numWords; i++) {
			String randWord = Utilities.readRandomLineFromFile("dictionary.txt");
			
			if(wordStack.contains(randWord)) {
				i--;
			} else {
				wordStack.push(randWord);
			}
		}
	}
	
	void setupUI() {
		setupJLabels();
		panel.add(lives);
		panel.add(usedLetters);
		panel.add(marking);
		panel.add(label);
		frame.add(panel);
		frame.addKeyListener(this);
		frame.pack();
		frame.setVisible(true);
	}
	
	void setupJLabels() {
		if(wordStack.size() > 0) {
			numLives = 10;
			lives.setText("(Lives: " + numLives + ")");
			
			usedLetters.setText("Used Characters: ");
			
			marking.setText("Word: ");
			
			chosenWord = wordStack.pop();
			
			label.setText("");
			for(int i=0; i<chosenWord.length(); i++) {
				label.setText(label.getText() + "*");
			}
			frame.pack();
		} else {
			JOptionPane.showMessageDialog(null, "You Win! You solved all the words!");
			confirmNewGame();
		}
	}
	
	void confirmNewGame() {
		int confirm = JOptionPane.showConfirmDialog(null, "Would you like to play again?");
		
		if(confirm == 0) {
			JOptionPane.showMessageDialog(null, "Starting new game...");
			frame.setEnabled(false);
			frame.setVisible(false);
			new HangMan();
		}
		else if(confirm == 1) {
			System.exit(0);
		}
		else {
			System.exit(0);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		CharSequence check = "*";
		boolean foundMatchingLetter = false;
		
		// TODO Auto-generated method stub
		if(!usedChars.contains(e.getKeyChar())) {
			usedChars.add(e.getKeyChar());
			usedLetters.setText(usedLetters.getText() + e.getKeyChar() + ", ");
			
			for(int i=0; i<chosenWord.length(); i++) {
				if(e.getKeyChar() == chosenWord.charAt(i)) {
					label.setText(label.getText().substring(0, i) + e.getKeyChar() + label.getText().substring(i+1));
					foundMatchingLetter = true;
				
					if(!label.getText().contains(check)) {
						frame.pack();
						JOptionPane.showMessageDialog(null, "You solved the word ''" + chosenWord + "''! Click OK to continue.");
						usedChars.clear();
						setupJLabels();
					}
				}
			}
		
			if(!foundMatchingLetter) {
				numLives--;
				lives.setText("(Lives: " + numLives + ")");
			
				if(numLives == 0) {
					JOptionPane.showMessageDialog(null, "Aw shoot, you ran out of lives. Game over :(");
					confirmNewGame();
				}
			}
			
			frame.pack();
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
