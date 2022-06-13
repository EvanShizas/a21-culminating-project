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
	
	ImageIcon placeholder = new ImageIcon("assets/images/transparent-tile.png");
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
	int name = 0;
	
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
		setExtendedState(JFrame.MAXIMIZED_BOTH);
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
				
				board[row][col].setText(Integer.toString(name));
				map[row][col] = "eE";
				
				board[row][col].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int pos = Integer.parseInt(e.getActionCommand());
						// uses index based on 0-7 for array
						int posRow = pos / 8;
						int posCol = pos % 8;
						
						System.out.println("Row of button: " + posRow);
						System.out.println("Col of button: " + posCol);
						
						// piece movement can go here using x,y position of clicked button
						moveChecker(posRow, posCol);
						
						mapRead();
					}
				});
				panel.add(board[row][col]);
				
				name++;
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

		// setting the pieces on the board
		for (int col = 0; col < BOARD_SIZE; col++) {
			map[6][col] = "wP";
			map[1][col] = "bP";
		}
		map[2][5] = "wR";
		map[7][1] = "wN";
		map[4][3] = "wB";
		map[7][3] = "wQ";
		map[7][4] = "wK";
		map[3][1] = "wB";
		//map[7][6] = "wN";
		map[3][3] = "wR";
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
				default:
					icon = placeholder;
				}
				board[row][col].setIcon(icon);
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	boolean checkRook = false;
	boolean blocked = false;
	boolean downCheck = false;
	boolean upCheck = false;
	public void moveChecker(int posRow, int posCol) {
		switch (map[posRow][posCol]) {
		case "wR": case "bR":
			// todo: if clicked again then deselect rook
			
			// rook down check
			for (int i = posRow+1; i < BOARD_SIZE; i++) {
				if (map[i][posCol] != "eE" || downCheck != false) {
					board[i][posCol].setEnabled(false);
					downCheck = true;
				}	 
			}
			
			// rook up check (caveman check)
			/*for (int i = posRow-1; i < (BOARD_SIZE-posRow); i--) {
				if (map[i][posCol] != "eE" || upCheck != false) {
					board[i][posCol].setEnabled(false);
					upCheck = true;
				}
				if (i <= 0) {
					break;
				}
			}*/
			
			// rook up check
			for (int i = 0; i < posRow; i++) {
				if (map[i][posCol] != "eE" || upCheck != false) {
					board[i][posCol].setEnabled(false);
					upCheck = true;
				}
			}
			
			// todo: add horizontal rook checks

			// todo: add legal moves to a list and disable others
			
			break;
		case "wB": case "bB":
			
			break;
		case "wN": case "bN":
			
			break;
		case "wQ": case "bQ":
			
			break;
		case "wP": case "bP":
			
			break;
		case "wK": case "bK":
			
			break;
		}
	}

}