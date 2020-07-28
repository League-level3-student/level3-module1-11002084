package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton playButton = new JButton();
	JButton stopButton = new JButton();
	
	int selectedSongIndex = -1;
	Random rand = new Random();
	
	ArrayList<Song> songList = new ArrayList<Song>();
	
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
				songList.add(new Song("Rick Roll.mp3"));
				songList.add(new Song("Megalovania.mp3"));
				songList.add(new Song("All Star.mp3"));
				songList.add(new Song("Despacito.mp3"));
		
				playButton.setText("Surprise me!");
				playButton.addActionListener(this);
				stopButton.setText("Stop Music");
				stopButton.addActionListener(this);
				panel.add(playButton);
				panel.add(stopButton);
				frame.add(panel);
				frame.setTitle("Surprise Music Player");
				frame.pack();
				frame.setVisible(true);
				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == playButton) {
			if(selectedSongIndex != -1) {
				songList.get(selectedSongIndex).stop();
			}
			
			selectedSongIndex = rand.nextInt(songList.size());
			songList.get(selectedSongIndex).play();
		}
		else if(e.getSource() == stopButton) {
			if(selectedSongIndex != -1) {
				songList.get(selectedSongIndex).stop();
			}
		}
	}
}