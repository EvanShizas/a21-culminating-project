package beta_versions;

/**
 * Haevin Chess. A game of Chess with a twist!
 * 
 * modified     20220620
 * date         20220531
 * @filename    HaevinChess.java
 * @author      Alvin Chan
 * @author      Hammad Hassan
 * @author      Evan Shizas
 * @version     0.7.0
 * @see         A21 - Culminating Project
 */

/**	Patch Notes:
 * 	
 * 	Created the alpha interface. May be changed to where the 
 * 	buttons and menus are stored in separate Java classes, but for now 
 * 	this seems to be a good and efficient solution. (06/04/2022 -> Evan)
 * 	
 * 	Implented 90% of the pre_alpha_test work done by Alvin and Hammad. The program
 * 	now loads the game board, images, as well as some other behaviour. Piece controls and 
 * 	movements are to be added. (06/12/2022 -> Evan)
 * 
 * 	Got all piece movements and behaviours complete. Only the king will need some tuning to prevent the 
 * 	piece from getting into check when using it. A checkGame() method will need to be created as well. (06/13/2022 -> Evan)
 * 
 * 	Got all piece movements and behaviours complete. A checkKingScanner() and checkGameScanner() methods will need to be created as well. (06/14/2022 -> Evan)
 * 
 * 	Broke down the entire game into multiple class files. Each one contains a different aspect of the game and its properties. Not fully finalized but will be the new way
 * 	in which we will manage variables and other things in the game to prevent the main class file (this one!!) from being too large and hard to manage. (06/18/2022 -> Evan)
 * 
 * 	Added restart functionality to the game. (06/18/2022 -> Evan)
 * 
 * 	Tuned up the properties files for all the pieces to prevent errors. (06/19/2022 -> Evan)
 * 
 * 	Got king check and checkmate system fully working. (06/20/2022 -> Evan & Alvin)
 * 
 * 	Applied program theme (06/20/2022 -> Evan & Hammad)
 */

/** Developer Notes:
 * 	
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HaevinChess extends JFrame {

	private JPanel contentPane;
	private JPanel centrePanel;
	private JPanel northPanel;
	private JPanel southPanel;
	private JPanel eastPanel;
	private JPanel westPanel;
	private JButton instructions;
	private JButton stats;
	private JButton pause;
	private JButton restart;
	private JButton quit;
	private JLabel title;

	PawnProperties pawnProperties = new PawnProperties();
	RookProperties rookProperties = new RookProperties();
	KnightProperties knightProperties = new KnightProperties();
	BishopProperties bishopProperties = new BishopProperties();
	QueenProperties queenProperties = new QueenProperties();
	KingProperties kingProperties = new KingProperties();

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	ActionEvent f;

	final String VERSION = "v0.7.0 - (beta)";
	final int BOARD_SIZE = 8, WIDTH = (int)screenSize.getWidth(), HEIGHT = (int)screenSize.getHeight();
	final Color BROWN = new Color(185, 122, 87), WHITE = new Color(255, 255, 255);

	int tileNum = 0, name = 0, posX, posY, pieceStoreX = 0, pieceStoreY = 0;
	double winChange = (double)((WIDTH-HEIGHT)/2);
	boolean castling = false, castlingDoneP1 = false, castlingDoneP2 = false, secondClick = false, secondPlayer = false, whiteKingExists = false, blackKingExists = false, stalemate = false;

	String pieceStore = "", charTurnContain = "";

	ImageIcon winIcon = new ImageIcon("assets/images/window-icon.png");
	ImageIcon background = new ImageIcon("assets/images/menu-background.jpg");
	ImageIcon whiteKing = new ImageIcon("assets/images/white-king.png");
	ImageIcon blackKing = new ImageIcon("assets/images/black-king.png");
	ImageIcon instructionsImg = new ImageIcon("assets/images/instructions.png");

	String[][] chessBoardMap = new String[BOARD_SIZE][BOARD_SIZE];
	JButton[][] chessBoard = new JButton[BOARD_SIZE][BOARD_SIZE];

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HaevinChessMainMenu frame = new HaevinChessMainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HaevinChess() { // Constructors
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setBackground(Color.WHITE);
		setTitle("A21 - Haevin Chess [" + VERSION + "]");
		setIconImage(winIcon.getImage()); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1475, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 153, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		northPanel = new JPanel();
		northPanel.setBackground(new Color(204, 153, 102));
		contentPane.add(northPanel, BorderLayout.NORTH);

		southPanel = new JPanel();
		southPanel.setBackground(new Color(204, 153, 102));
		contentPane.add(southPanel, BorderLayout.SOUTH);

		eastPanel = new JPanel();
		eastPanel.setBackground(new Color(204, 153, 102));
		eastPanel.setBorder(new EmptyBorder(5, (int) winChange, 5, 5));
		contentPane.add(eastPanel, BorderLayout.EAST);

		westPanel = new JPanel();
		westPanel.setBackground(new Color(204, 153, 102));
		westPanel.setBorder(new EmptyBorder(5, (int) winChange, 5, 5));
		contentPane.add(westPanel, BorderLayout.WEST);

		centrePanel = new JPanel();
		centrePanel.setBackground(new Color(204, 153, 102));
		contentPane.add(centrePanel, BorderLayout.CENTER);
		centrePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		centrePanel.setLayout(new GridLayout(0, 8, 0, 0));

		title = new JLabel("Haevin Chess");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(new Color(204, 51, 51));
		title.setFont(new Font("Tahoma", Font.BOLD, 45));
		title.setBackground(Color.WHITE);
		title.setBounds(0, 0, 588, 90);

		stats = new JButton("Stats");
		stats.setBackground((new Color(101, 67, 33)));;
		stats.setForeground(Color.WHITE);
		stats.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				statsActionPerformed(evt);
			}
		});

		instructions = new JButton("Instructions");
		instructions.setBackground((new Color(101, 67, 33)));;
		instructions.setForeground(Color.WHITE);
		instructions.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				instructionsActionPerformed(evt);
			}
		});

		pause = new JButton("                  Pause                  ");
		pause.setBackground((new Color(101, 67, 33)));;
		pause.setForeground(Color.WHITE);
		pause.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				pauseActionPerformed(evt);
			}
		});

		restart = new JButton("Restart");
		restart.setBackground((new Color(101, 67, 33)));;
		restart.setForeground(Color.WHITE);
		restart.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				restartActionPerformed(evt);
			}
		});

		quit = new JButton("Quit");
		quit.setBackground((new Color(101, 67, 33)));;
		quit.setForeground(Color.WHITE);
		quit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				quitActionPerformed(evt);
			}
		});

		northPanel.add(title);		
		southPanel.add(stats);
		southPanel.add(instructions);
		southPanel.add(pause);
		southPanel.add(restart);
		southPanel.add(quit);

		// Game board constructors and ActionListener below! Formerly part of gameBoardInit() method.
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				chessBoard[row][col] = new JButton();

				chessBoard[row][col].addActionListener(new ActionListener() { // Board ActionListener...
					public void actionPerformed(ActionEvent e) {
						for (int row = 0; row < BOARD_SIZE; row++) {
							for (int col = 0; col < BOARD_SIZE; col++) {
								if (e.getSource() == chessBoard[row][col]) {
									posX = row;
									posY = col;

									if (!secondClick && chessBoardMap[row][col].contains("sR")) {
										secondClick = true;
										castling = true;
									}

									else if (!secondClick && chessBoardMap[row][col].contains("s")) {
										secondClick = true;
									}

									else {
										secondClick = false;
									}

									gameAction();

									debugConsole();
								}
							}
						}
					}
				});

				centrePanel.add(chessBoard[row][col]);
			}
		}

		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {				
				tileNum++;

				if (tileNum % 2 == 0) {
					chessBoard[row][col].setBackground(BROWN);
				} 

				else if (tileNum % 2 == 1) {
					chessBoard[row][col].setBackground(WHITE);
				}
			}

			tileNum++;
		}

		// Piece placement loop...
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (i == 0) {
					if (j == 0 || j == 7)
						chessBoardMap[i][j] = "bR";

					else if (j == 1 || j == 6)
						chessBoardMap[i][j] = "bN";

					else if (j == 2 || j == 5)
						chessBoardMap[i][j] = "bB";

					else if (j == 3)
						chessBoardMap[i][j] = "bQ";

					else if (j == 4)
						chessBoardMap[i][j] = "bK";
				}

				else if (i == 1) {
					chessBoardMap[i][j] = "bP";
				}

				else if (i == 6) {
					chessBoardMap[i][j] = "wP";
				}

				else if (i == 7) {
					if (j == 0 || j == 7)
						chessBoardMap[i][j] = "wR";

					else if (j == 1 || j == 6)
						chessBoardMap[i][j] = "wN";

					else if (j == 2 || j == 5)
						chessBoardMap[i][j] = "wB";

					else if (j == 3)
						chessBoardMap[i][j] = "wQ";

					else if (j == 4)
						chessBoardMap[i][j] = "wK";
				}

				else {
					chessBoardMap[i][j] = "eE";
				}
			}
		}

		boardImageLoad();
	}

	public void pauseActionPerformed(java.awt.event.ActionEvent evt) {
		JOptionPane.showMessageDialog(null,"Game Paused!\n\nPress (OK) to RESUME.\n\n","PAUSE",JOptionPane.INFORMATION_MESSAGE, winIcon);
	}

	public void instructionsActionPerformed(java.awt.event.ActionEvent evt) {
		JOptionPane.showMessageDialog(null,"","Instructions",JOptionPane.INFORMATION_MESSAGE, instructionsImg);
	}

	public void statsActionPerformed(java.awt.event.ActionEvent evt) {
		JOptionPane.showMessageDialog(null,"<html><font color = blue size = 16>Chess Game Stats</font></html>\n\n","Game Stats",JOptionPane.INFORMATION_MESSAGE);
	}

	public void restartActionPerformed(java.awt.event.ActionEvent evt) {
		int confirmOption = JOptionPane.showConfirmDialog (null, "Wish to start a new game?\n\n[Yes] --> New Game...\n[No] --> Continue Game...","NEW GAME...", JOptionPane.YES_NO_OPTION);

		if (confirmOption == JOptionPane.YES_OPTION) {
			int confirmResetOption = JOptionPane.showConfirmDialog (null, "Wish to reset all progress and scores?\n\nWARNING: THIS ACTION CANNOT BE UNDONE!","RESET WARNING", JOptionPane.YES_NO_OPTION);

			if (confirmResetOption == JOptionPane.YES_OPTION) {
				// TODO wipe save stats text file...
			}

			HaevinChess frame = new HaevinChess();
			frame.setVisible(true);
			setVisible(false);
		}
	}

	public void quitActionPerformed(java.awt.event.ActionEvent evt) {
		int confirmOption = JOptionPane.showConfirmDialog (null, "Wish to quit the game?\n\n[Yes] --> Main Menu...\n[No] --> Continue Game...","QUIT GAME...", JOptionPane.YES_NO_OPTION);

		if (confirmOption == JOptionPane.YES_OPTION) {
			int confirmResetOption = JOptionPane.showConfirmDialog (null, "Wish to reset all progress and scores?\n\nWARNING: THIS ACTION CANNOT BE UNDONE!","RESET WARNING", JOptionPane.YES_NO_OPTION);

			if (confirmResetOption == JOptionPane.YES_OPTION) {
				// TODO wipe save stats text file...
			}

			HaevinChessMainMenu frame = new HaevinChessMainMenu();
			frame.setVisible(true);
			setVisible(false);
		}
	}

	public void boardImageLoad() {
		ImageIcon icon = new ImageIcon();
		IconSelect iconSelect = new IconSelect();

		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {				
				icon = iconSelect.load(icon, chessBoardMap, row, col);
				chessBoard[row][col].setIcon(icon);
			}
		}
	}

	public void gameAction() { // When board button is pressed...
		whiteKingExists = false;
		blackKingExists = false;
		stalemate = true;

		ruleSetSelect();
		pawnProperties.promotion(chessBoardMap, BOARD_SIZE);

		if (secondClick) { // Done when a piece is already selected and is to be moved...
			chessBoardMap[posX][posY] = pieceStore;

			if (castling) { // Castling-specific rule...
				if (posY < 5) {
					if (!secondPlayer && !castlingDoneP1) {
						chessBoardMap[pieceStoreX][pieceStoreY - 1] = "wR";
						chessBoardMap[BOARD_SIZE - 1][0] = "eE";
						castlingDoneP1 = true;
					}

					else if (!castlingDoneP2) { 
						chessBoardMap[pieceStoreX][pieceStoreY - 1] = "bR";
						chessBoardMap[0][0] = "eE";
						castlingDoneP2 = true;
					}
				}

				else {
					if (!secondPlayer && !castlingDoneP1) {
						chessBoardMap[pieceStoreX][pieceStoreY + 1] = "wR";
						chessBoardMap[BOARD_SIZE - 1][BOARD_SIZE - 1] = "eE";
						castlingDoneP1 = true;
					}

					else if (!castlingDoneP2) { 
						chessBoardMap[pieceStoreX][pieceStoreY + 1] = "bR";
						chessBoardMap[0][BOARD_SIZE - 1] = "eE";
						castlingDoneP2 = true;
					}
				}

				castling = false;
			}

			// Makes empty spot where piece used to be...
			chessBoardMap[pieceStoreX][pieceStoreY] = "eE";

			if (secondPlayer) {
				charTurnContain = "w";
				secondPlayer = false;
			}

			else { 
				charTurnContain = "b";
				secondPlayer = true;
			}

			selectReset();
		}

		pawnProperties.promotion(chessBoardMap, BOARD_SIZE);

		boardImageLoad();

		// King checker...
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (chessBoardMap[i][j].contains("bK")) {
					blackKingExists = true;
				} 

				else if (chessBoardMap[i][j].contains("wK")) {
					whiteKingExists = true;
				}
			}
		}

		// Stalemate checker...
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (chessBoardMap[i][j].contains("P") || chessBoardMap[i][j].contains("R") || chessBoardMap[i][j].contains("N") || chessBoardMap[i][j].contains("B") || chessBoardMap[i][j].contains("Q")) {
					stalemate = false;
					break;
				}
			}
		}

		if (!blackKingExists) {
			JOptionPane.showMessageDialog(null,"Game Over!\n\nWhite Wins!","Game Information",JOptionPane.INFORMATION_MESSAGE, whiteKing);
			restartActionPerformed(f);
		} 

		else if (!whiteKingExists) {
			JOptionPane.showMessageDialog(null,"Game Over!\n\nBlack Wins!","Game Information",JOptionPane.INFORMATION_MESSAGE, blackKing);
			restartActionPerformed(f);
		}

		if (stalemate) {
			JOptionPane.showMessageDialog(null,"Game Over!\n\nNeither player wins...","Game Information",JOptionPane.INFORMATION_MESSAGE, winIcon);
			restartActionPerformed(f);
		}
	}

	public void ruleSetSelect() {
		if (!secondPlayer) { // First player
			switch (chessBoardMap[posX][posY]) {
			case "wK":
				kingRuleSet();
				break;
			case "wQ":
				queenRuleSet();
				break;
			case "wR":
				rookRuleSet();
				break;
			case "wN":
				knightRuleSet();
				break;
			case "wB":
				bishopRuleSet();
				break;
			case "wP":
				pawnRuleSet();
				break;
			}
		}

		else { // Second player
			switch (chessBoardMap[posX][posY]) {
			case "bK":
				kingRuleSet();
				break;
			case "bQ":
				queenRuleSet();
				break;
			case "bR":
				rookRuleSet();
				break;
			case "bN":
				knightRuleSet();
				break;
			case "bB":
				bishopRuleSet();
				break;
			case "bP":
				pawnRuleSet();
				break;
			}
		}
	}

	public void pawnRuleSet() {
		if (!secondClick)
			selectReset();

		pawnProperties.ruleSet(chessBoardMap, charTurnContain, posX, posY, BOARD_SIZE);

		pieceStoreX = posX;
		pieceStoreY = posY;
		pieceStore = chessBoardMap[posX][posY];
	}

	public void rookRuleSet() {
		if (!secondClick)
			selectReset();

		rookProperties.ruleSet(chessBoardMap, charTurnContain, posX, posY, BOARD_SIZE);

		pieceStoreX = posX;
		pieceStoreY = posY;
		pieceStore = chessBoardMap[posX][posY];
	}

	public void knightRuleSet() {
		if (!secondClick)
			selectReset();

		knightProperties.ruleSet(chessBoardMap, charTurnContain, posX, posY, BOARD_SIZE);

		pieceStoreX = posX;
		pieceStoreY = posY;
		pieceStore = chessBoardMap[posX][posY];
	}

	public void bishopRuleSet() {
		if (!secondClick)
			selectReset();

		bishopProperties.ruleSet(chessBoardMap, charTurnContain, posX, posY, BOARD_SIZE);

		pieceStoreX = posX;
		pieceStoreY = posY;
		pieceStore = chessBoardMap[posX][posY];
	}

	public void queenRuleSet() {
		if (!secondClick)
			selectReset();

		queenProperties.ruleSet(chessBoardMap, charTurnContain, posX, posY, BOARD_SIZE);

		pieceStoreX = posX;
		pieceStoreY = posY;
		pieceStore = chessBoardMap[posX][posY];
	}

	public void kingRuleSet() { 
		if (!secondClick)
			selectReset();

		kingProperties.ruleSet(chessBoardMap, charTurnContain, posX, posY, BOARD_SIZE, castlingDoneP1, castlingDoneP2);

		pieceStoreX = posX;
		pieceStoreY = posY;
		pieceStore = chessBoardMap[posX][posY];
	}

	public void selectReset() { // Resets any highlighted spots which were available to be selected from for specific piece chosen...
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (chessBoardMap[i][j].contains("sR")) {
					chessBoardMap[i][j] = chessBoardMap[i][j].replaceAll("sR", "");
				}

				if (chessBoardMap[i][j].contains("s")) {
					chessBoardMap[i][j] = chessBoardMap[i][j].replaceAll("s", "");
				}
			}
		}

		boardImageLoad();
	}

	public void debugConsole() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				System.out.print(chessBoardMap[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println();
	}
}