package pre_alpha_test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Chess extends JFrame {

	private JPanel contentPane;
	
	JPanel panel = new JPanel();
	Control control;
	ImageIcon blackTile = new ImageIcon("assets/images/black-tile.png");
	ImageIcon brownTile = new ImageIcon("assets/images/brown-tile.png");
	ImageIcon whiteTile = new ImageIcon("assets/images/white-tile.png");
	final int BOARD_SIZE = 8;
	int[][] map = new int[BOARD_SIZE][BOARD_SIZE];
	JButton[][] board = new JButton[BOARD_SIZE][BOARD_SIZE];
	int tileNum = 0;
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chess frame = new Chess();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Chess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		FlowLayout layout = new FlowLayout();
		getContentPane().setLayout(layout);
		
		GridLayout layout1 = new GridLayout(BOARD_SIZE, BOARD_SIZE);
		panel.setLayout(layout1);
		
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				board[row][col] = new JButton((row+1) + " " + (col+1));
				board[row][col].setMargin(new Insets(0,0,0,0));
				
				board[row][col].setText("");
				map[row][col] = 0;
				
				board[row][col].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						map[0][0] = 2;
						board[0][0].setIcon(blackTile);
						mapRead();
					}
				});
				panel.add(board[row][col]);
			}
		}
		
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				tileNum++;
				
				if (tileNum % 2 == 0) {
					map[row][col] = 0;
				} else if (tileNum % 2 == 1) {
					map[row][col] = 1;
				} else {
					map[row][col] = 2;
				}
				
				mapRead();
			}
			
			tileNum++;
		}
		
		getContentPane().add(panel);
		setVisible(true);
	}
	
	public void mapRead() {
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				switch (map[row][col]) {
				case 0:
					board[row][col].setIcon(brownTile);
					break;
				case 1:
					board[row][col].setIcon(whiteTile);
					break;
				case 2:
					board[row][col].setIcon(blackTile);
					break;
				}
			}
		}
	}

}
