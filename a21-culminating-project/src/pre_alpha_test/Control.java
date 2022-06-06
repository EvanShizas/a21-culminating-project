package pre_alpha_test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Control extends Chess implements ActionListener {
	Chess gui;
	final int BOARD_SIZE = gui.BOARD_SIZE;
	
	public void actionPerformed(ActionEvent e) {
		gui.map[0][0] = 2;
		gui.board[0][0].setIcon(gui.blackTile);
		gui.mapRead();
	}
}

