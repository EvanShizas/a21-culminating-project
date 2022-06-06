package pre_alpha_test;

import java.awt.BorderLayout;
import java.awt.Color;
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
	ImageIcon whiteKing = new ImageIcon("assets/images/white-king.png");
	ImageIcon whiteQueen = new ImageIcon("assets/images/white-queen.png");
	ImageIcon whiteRook = new ImageIcon("assets/images/white-rook.png");
	ImageIcon whiteKnight = new ImageIcon("assets/images/white-knight.png");
	ImageIcon whiteBishop = new ImageIcon("assets/images/white-bishop.png");
	ImageIcon whitePawn = new ImageIcon("assets/images/white-pawn.png");
	ImageIcon blackKing = new ImageIcon("assets/images/black-king.png");
	ImageIcon blackQueen = new ImageIcon("assets/images/black-queen.png");
	ImageIcon blackRook = new ImageIcon("assets/images/black-rook.png");
	ImageIcon blackKnight = new ImageIcon("assets/images/black-knight.png");
	ImageIcon blackBishop = new ImageIcon("assets/images/black-bishop.png");
	ImageIcon blackPawn = new ImageIcon("assets/images/black-pawn.png");
	final int BOARD_SIZE = 8;
	String[][] map = new String[BOARD_SIZE][BOARD_SIZE];
	JButton[][] board = new JButton[BOARD_SIZE][BOARD_SIZE];
	int tileNum = 0;
	final Color BROWN = new Color(185, 122, 87);
	final Color WHITE = new Color(255, 255, 255);
	
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
				map[row][col] = "  ";
				
				board[row][col].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
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
					board[row][col].setBackground(BROWN);
				} else if (tileNum % 2 == 1) {
					board[row][col].setBackground(WHITE);
				} 
			}
			
			tileNum++;
		}

		for (int col = 0; col < BOARD_SIZE; col++) {
			map[6][col] = "wP";
			map[1][col] = "bP";
		}
		map[7][0] = "wR";
		map[7][1] = "wN";
		map[7][2] = "wB";
		map[7][3] = "wQ";
		map[7][4] = "wK";
		map[7][5] = "wB";
		map[7][6] = "wN";
		map[7][7] = "wR";
		map[0][0] = "bR";
		map[0][1] = "bN";
		map[0][2] = "bB";
		map[0][3] = "bQ";
		map[0][4] = "bK";
		map[0][5] = "bB";
		map[0][6] = "bN";
		map[0][7] = "bR";
		mapRead();
		
		getContentPane().add(panel);
		setVisible(true);
	}
	
	public void mapRead() {
		ImageIcon icon = new ImageIcon();
		
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				switch (map[row][col]) {
				case "wK":
					icon = whiteKing;
					break;
				case "wQ":
					icon = whiteQueen;
					break;
				case "wR":
					icon = whiteRook;
					break;
				case "wN":
					icon = whiteKnight;
					break;
				case "wB":
					icon = whiteBishop;
					break;
				case "wP":
					icon = whitePawn;
					break;
				case "bK":
					icon = blackKing;
					break;
				case "bQ":
					icon = blackQueen;
					break;
				case "bR":
					icon = blackRook;
					break;
				case "bN":
					icon = blackKnight;
					break;
				case "bB":
					icon = blackBishop;
					break;
				case "bP":
					icon = blackPawn;
					break;
				}
				board[row][col].setIcon(icon);
				System.out.print(map[row][col]);
			}
			System.out.println();
		}
		System.out.println();
	}

}
