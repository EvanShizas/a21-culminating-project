package pre_alpha_test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Control {
	Chess gui;
	final int BOARD_SIZE = gui.BOARD_SIZE;
	int[][] map = gui.map;
	
	public void adjust() {
		map[0][0] = 2;
		gui.mapRead(map);
	}
}

