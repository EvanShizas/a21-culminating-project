package pre_alpha_test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Control implements ActionListener {
	Chess gui;
	
	final int BOARD_SIZE = gui.BOARD_SIZE;
	JButton[][] board = gui.board;
	ImageIcon highlightedBrownTile = new ImageIcon("assets/images/highlightedBrownTile.png");
	
	public void actionPerformed(ActionEvent e) {
		board[0][0].setIcon(highlightedBrownTile);
	}
	
}
