package beta_versions;

/**
 * Haevin Chess. A game of Chess with a twist!
 * 
 * modified     20220614
 * date         20220531
 * @filename    HaevinChess.java
 * @author      Alvin Chan
 * @author      Hammad Hassan
 * @author      Evan Shizas
 * @version     0.1.0
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

public class HaevinChess extends JFrame {

	private JPanel contentPane;
	private JPanel centrePanel;
	private JPanel northPanel;
	private JPanel southPanel;
	private JPanel eastPanel;
	private JPanel westPanel;
	private JButton play;
	private JButton instructions;
	private JButton exit;
	private JButton singlePlayer;
	private JButton multiPlayer;
	private JButton goBack;
	private JButton stats;
	private JButton pause;
	private JButton restart;
	private JButton quit;
	private JTextArea textArea;
	private JLabel title;
	private JLabel select;
	private JLabel settings;
	private JLabel version;
	private JLabel fileViewLbl;

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	final String VERSION = "v0.1.0 - (beta)";
	final int BOARD_SIZE = 8, WIDTH = (int)screenSize.getWidth(), HEIGHT = (int)screenSize.getHeight();
	final Color BROWN = new Color(185, 122, 87), WHITE = new Color(255, 255, 255);

	int tileNum = 0, name = 0, posX, posY, pieceStoreX = 0, pieceStoreY = 0;
	double change = (double)((WIDTH-HEIGHT)/2);
	boolean checkMate = false, kingCheck = false, castling = false, secondClick = false, secondPlayer = false;

	String pieceStore = "", charTurnContain = "";

	ImageIcon winIcon = new ImageIcon("assets//images//window-icon.png");
	ImageIcon background = new ImageIcon("assets//images//menu-background.jpg");
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
	ImageIcon whiteKingSelect = new ImageIcon("assets/images/white-king-select.png");
	ImageIcon whiteQueenSelect = new ImageIcon("assets/images/white-queen-select.png");
	ImageIcon whiteRookSelect = new ImageIcon("assets/images/white-rook-select.png");
	ImageIcon whiteKnightSelect = new ImageIcon("assets/images/white-knight-select.png");
	ImageIcon whiteBishopSelect = new ImageIcon("assets/images/white-bishop-select.png");
	ImageIcon whitePawnSelect = new ImageIcon("assets/images/white-pawn-select.png");
	ImageIcon blackKingSelect = new ImageIcon("assets/images/black-king-select.png");
	ImageIcon blackQueenSelect = new ImageIcon("assets/images/black-queen-select.png");
	ImageIcon blackRookSelect = new ImageIcon("assets/images/black-rook-select.png");
	ImageIcon blackKnightSelect = new ImageIcon("assets/images/black-knight-select.png");
	ImageIcon blackBishopSelect = new ImageIcon("assets/images/black-bishop-select.png");
	ImageIcon blackPawnSelect = new ImageIcon("assets/images/black-pawn-select.png");
	ImageIcon emptySelect = new ImageIcon("assets/images/empty-select.png");
	ImageIcon placeholder = new ImageIcon();

	String[][] chessBoardMap = new String[BOARD_SIZE][BOARD_SIZE];
	JButton[][] chessBoard = new JButton[BOARD_SIZE][BOARD_SIZE];

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HaevinChess frame = new HaevinChess();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HaevinChess() { // Constructors
		setResizable(false);
		setBackground(Color.WHITE);
		setTitle("A21 - Haevin Chess [" + VERSION + "]");
		setIconImage(winIcon.getImage()); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		title = new JLabel("Haevin Chess");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.BLUE);
		title.setFont(new Font("Tahoma", Font.BOLD, 45));
		title.setBackground(Color.WHITE);
		title.setBounds(0, 0, 588, 90);
		contentPane.add(title);

		play = new JButton("Play");
		play.setFont(new Font("Tahoma", Font.PLAIN, 20));
		play.setBounds(169, 173, 250, 72);
		contentPane.add(play);
		play.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				playActionPerformed(evt);
			}
		});

		instructions = new JButton("Instructions");
		instructions.setFont(new Font("Tahoma", Font.PLAIN, 20));
		instructions.setBounds(169, 256, 250, 72);
		contentPane.add(instructions);
		instructions.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				instructionsActionPerformed(evt);
			}
		});

		exit = new JButton("Exit");
		exit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		exit.setBounds(169, 339, 250, 72);
		contentPane.add(exit);
		exit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitActionPerformed(evt);
			}
		});

		stats = new JButton("Stats");
		stats.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				statsActionPerformed(evt);
			}
		});

		pause = new JButton("                  Pause                  ");
		pause.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				pauseActionPerformed(evt);
			}
		});

		restart = new JButton("Restart");
		restart.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				restartActionPerformed(evt);
			}
		});

		quit = new JButton("Quit");
		quit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				quitActionPerformed(evt);
			}
		});

		version = new JLabel(VERSION);
		version.setBackground(Color.WHITE);
		version.setFont(new Font("Tahoma", Font.ITALIC, 9));
		version.setBounds(10, 640, 84, 14);
		contentPane.add(version);

		fileViewLbl = new JLabel("HaevinChess.java");
		fileViewLbl.setFont(new Font("Tahoma", Font.ITALIC, 9));
		fileViewLbl.setBackground(Color.WHITE);
		fileViewLbl.setHorizontalAlignment(SwingConstants.TRAILING);
		fileViewLbl.setBounds(476, 640, 102, 14);
		contentPane.add(fileViewLbl);

		select = new JLabel("Select Game Mode:");
		select.setFont(new Font("Tahoma", Font.PLAIN, 20));
		select.setBackground(Color.WHITE);
		select.setBounds(10, 80, 428, 37);

		settings = new JLabel("Settings:");
		settings.setFont(new Font("Tahoma", Font.PLAIN, 20));
		settings.setBackground(Color.WHITE);
		settings.setBounds(10, 252, 428, 37);

		singlePlayer = new JButton("Single Player");
		singlePlayer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		singlePlayer.setBounds(139, 128, 310, 51);
		singlePlayer.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				singlePlayerActionPerformed(evt);
			}
		});

		multiPlayer = new JButton("Multiplayer");
		multiPlayer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		multiPlayer.setBounds(139, 190, 310, 51);
		multiPlayer.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				multiPlayerActionPerformed(evt);
			}
		});

		textArea = new JTextArea();
		textArea.setBackground(Color.GRAY);
		textArea.setBounds(10, 300, 568, 329);

		goBack = new JButton("<");
		goBack.setBounds(10, 10, 41, 23);
		goBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				goBackActionPerformed(evt);
			}
		});
	}

	public void exitActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

	public void pauseActionPerformed(java.awt.event.ActionEvent evt) {

	}

	public void instructionsActionPerformed(java.awt.event.ActionEvent evt) {

	}

	public void statsActionPerformed(java.awt.event.ActionEvent evt) {

	}

	public void restartActionPerformed(java.awt.event.ActionEvent evt) {

	}

	public void quitActionPerformed(java.awt.event.ActionEvent evt) {

	}

	public void playActionPerformed(java.awt.event.ActionEvent evt) {
		contentPane.add(select);
		contentPane.add(settings);
		contentPane.add(singlePlayer);
		contentPane.add(multiPlayer);
		contentPane.add(textArea);
		contentPane.add(goBack);

		contentPane.remove(play);
		contentPane.remove(instructions);
		contentPane.remove(exit);

		repaint();
	}

	public void goBackActionPerformed(java.awt.event.ActionEvent evt) {		
		contentPane.add(play);
		contentPane.add(instructions);
		contentPane.add(exit);

		contentPane.remove(select);
		contentPane.remove(settings);
		contentPane.remove(singlePlayer);
		contentPane.remove(multiPlayer);
		contentPane.remove(textArea);
		contentPane.remove(goBack);

		repaint();
	}

	public void singlePlayerActionPerformed(java.awt.event.ActionEvent evt) {
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizes screen.

		contentPane.remove(select);
		contentPane.remove(settings);
		contentPane.remove(singlePlayer);
		contentPane.remove(multiPlayer);
		contentPane.remove(textArea);
		contentPane.remove(goBack);
		contentPane.remove(version);
		contentPane.remove(fileViewLbl);

		gameBoardInit();
	}

	public void multiPlayerActionPerformed(java.awt.event.ActionEvent evt) {
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizes screen.

		contentPane.remove(select);
		contentPane.remove(settings);
		contentPane.remove(singlePlayer);
		contentPane.remove(multiPlayer);
		contentPane.remove(textArea);
		contentPane.remove(goBack);
		contentPane.remove(version);
		contentPane.remove(fileViewLbl);

		gameBoardInit();
	}

	public void gameBoardInit() { // Game Board Initializer. Contains board ActionListener!
		setBounds(10, 10, 1475, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane.setLayout(new BorderLayout(0, 0));

		northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);

		southPanel = new JPanel();
		contentPane.add(southPanel, BorderLayout.SOUTH);

		eastPanel = new JPanel();
		eastPanel.setBorder(new EmptyBorder(5, (int) change, 5, 5));
		contentPane.add(eastPanel, BorderLayout.EAST);

		westPanel = new JPanel();
		westPanel.setBorder(new EmptyBorder(5, (int) change, 5, 5));
		contentPane.add(westPanel, BorderLayout.WEST);

		centrePanel = new JPanel();
		contentPane.add(centrePanel, BorderLayout.CENTER);
		centrePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		centrePanel.setLayout(new GridLayout(0, 8, 0, 0));

		instructions = new JButton("Instructions");

		northPanel.add(title);		
		southPanel.add(stats);
		southPanel.add(instructions);
		southPanel.add(pause);
		southPanel.add(restart);
		southPanel.add(quit);

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

	public void boardImageLoad() {
		ImageIcon icon = new ImageIcon();

		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				switch (chessBoardMap[row][col]) {
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
				case "wKs":
					icon = whiteKingSelect;
					break;
				case "wQs":
					icon = whiteQueenSelect;
					break;
				case "wRs":
					icon = whiteRookSelect;
					break;
				case "wNs":
					icon = whiteKnightSelect;
					break;
				case "wBs":
					icon = whiteBishopSelect;
					break;
				case "wPs":
					icon = whitePawnSelect;
					break;
				case "bKs":
					icon = blackKingSelect;
					break;
				case "bQs":
					icon = blackQueenSelect;
					break;
				case "bRs":
					icon = blackRookSelect;
					break;
				case "bNs":
					icon = blackKnightSelect;
					break;
				case "bBs":
					icon = blackBishopSelect;
					break;
				case "bPs":
					icon = blackPawnSelect;
					break;
				case "eEs":
					icon = emptySelect;
					break;
				case "eEsR":
					icon = emptySelect;
					break;
				default:
					icon = null;
				}

				chessBoard[row][col].setIcon(icon);
			}
		}
	}

	public void gameAction() { // When board button is pressed...
		if (!secondPlayer && !kingCheck) { // First player
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

		else if (!kingCheck) { // Second player
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

		else { // If king is in check
			if (!secondPlayer) {
				switch (chessBoardMap[posX][posY]) {
				case "bK":
					kingRuleSet();
					break;
				}
			}

			else {
				switch (chessBoardMap[posX][posY]) {
				case "wK":
					kingRuleSet();
					break;
				}
			}
		}

		if (secondClick) { // Done when a piece is already selected and is to be moved...
			chessBoardMap[posX][posY] = pieceStore;

			if (castling) { // Castling-specific rule...
				if (posY < 5) {
					if (!secondPlayer) {
						chessBoardMap[pieceStoreX][pieceStoreY - 1] = "wR";
						chessBoardMap[BOARD_SIZE - 1][0] = "eE";
					}

					else { 
						chessBoardMap[pieceStoreX][pieceStoreY - 1] = "bR";
						chessBoardMap[0][0] = "eE";
					}
				}

				else {
					if (!secondPlayer) {
						chessBoardMap[pieceStoreX][pieceStoreY + 1] = "wR";
						chessBoardMap[BOARD_SIZE - 1][BOARD_SIZE - 1] = "eE";
					}

					else { 
						chessBoardMap[pieceStoreX][pieceStoreY + 1] = "bR";
						chessBoardMap[0][BOARD_SIZE - 1] = "eE";
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
			checkGameScanner();
		}

		boardImageLoad();
	}

	public void checkKingScanner() { // Checks if king(s) are in check, and what spots are danger/check spots...
		// TODO -> remove selected spots that will put the king in check by changing the chessBoardMap[][] values.
	}

	public void checkGameScanner() {
		// TODO -> have entire board scanned to see if a move has placed the king in check...
		// force kingCheck to be true, forcing the only thing to be moved being the king...
	}

	public void pawnRuleSet() {
		if (!secondClick)
			selectReset();

		if (chessBoardMap[posX][posY].equals("wP")) {
			if (posX == 6) {
				if (chessBoardMap[posX - 2][posY].equals("eE") && chessBoardMap[posX - 1][posY].equals("eE")) {
					chessBoardMap[posX - 2][posY] += "s";
				}
			}

			if (posX != 0) {
				if (chessBoardMap[posX - 1][posY].equals("eE")) {
					chessBoardMap[posX - 1][posY] += "s";
				}

				if (posY != BOARD_SIZE - 1) {
					if (!chessBoardMap[posX - 1][posY + 1].equals("eE") && !chessBoardMap[posX - 1][posY + 1].contains(charTurnContain)) {
						chessBoardMap[posX - 1][posY + 1] += "s";
					}
				}

				if (posY != 0) {
					if (!chessBoardMap[posX - 1][posY - 1].equals("eE") && !chessBoardMap[posX - 1][posY - 1].contains(charTurnContain)) {
						chessBoardMap[posX - 1][posY - 1] += "s";
					}
				}
			}
		}

		else {
			if (posX == 1) {
				if (chessBoardMap[posX + 2][posY].equals("eE") && chessBoardMap[posX + 1][posY].equals("eE")) {
					chessBoardMap[posX + 2][posY] += "s";
				}
			}

			if (posX != BOARD_SIZE - 1) {
				if (chessBoardMap[posX + 1][posY].equals("eE")) {
					chessBoardMap[posX + 1][posY] += "s";
				}

				if (posY != BOARD_SIZE - 1) {
					if (!chessBoardMap[posX + 1][posY + 1].equals("eE") && !chessBoardMap[posX + 1][posY + 1].contains(charTurnContain)) {
						chessBoardMap[posX + 1][posY + 1] += "s";
					}
				}

				if (posY != 0) {
					if (!chessBoardMap[posX + 1][posY - 1].equals("eE") && !chessBoardMap[posX + 1][posY - 1].contains(charTurnContain)) {
						chessBoardMap[posX + 1][posY - 1] += "s";
					}
				}
			}
		}

		pieceStoreX = posX;
		pieceStoreY = posY;
		pieceStore = chessBoardMap[posX][posY];
	}

	public void rookRuleSet() {
		if (!secondClick)
			selectReset();

		for (int i = posX + 1; i < BOARD_SIZE; i++) {
			if (chessBoardMap[i][posY].equals("eE")) {
				chessBoardMap[i][posY] += "s";
			}

			else if (!chessBoardMap[i][posY].equals("eE") && !chessBoardMap[i][posY].contains(charTurnContain)) {
				chessBoardMap[i][posY] += "s";
				break;
			}

			else {
				break;
			}
		}

		for (int i = posX - 1; i > -1; i--) {
			if (chessBoardMap[i][posY].equals("eE")) {
				chessBoardMap[i][posY] += "s";
			}

			else if (!chessBoardMap[i][posY].equals("eE") && !chessBoardMap[i][posY].contains(charTurnContain)) {
				chessBoardMap[i][posY] += "s";
				break;
			}

			else {
				break;
			}
		}

		for (int i = posY + 1; i < BOARD_SIZE; i++) {
			if (chessBoardMap[posX][i].equals("eE")) {
				chessBoardMap[posX][i] += "s";
			}

			else if (!chessBoardMap[posX][i].equals("eE") && !chessBoardMap[posX][i].contains(charTurnContain)) {
				chessBoardMap[posX][i] += "s";
				break;
			}

			else {
				break;
			}
		}

		for (int i = posY - 1; i > -1; i--) {
			if (chessBoardMap[posX][i].equals("eE")) {
				chessBoardMap[posX][i] += "s";
			}

			else if (!chessBoardMap[posX][i].equals("eE") && !chessBoardMap[posX][i].contains(charTurnContain)) {
				chessBoardMap[posX][i] += "s";
				break;
			}

			else {
				break;
			}
		}

		pieceStoreX = posX;
		pieceStoreY = posY;
		pieceStore = chessBoardMap[posX][posY];
	}

	public void knightRuleSet() {
		if (!secondClick)
			selectReset();

		try {
			if (chessBoardMap[posX + 2][posY + 1].equals("eE") || !chessBoardMap[posX + 2][posY + 1].contains(charTurnContain)) {
				chessBoardMap[posX + 2][posY + 1] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX + 2][posY - 1].equals("eE") || !chessBoardMap[posX + 2][posY - 1].contains(charTurnContain)) {
				chessBoardMap[posX + 2][posY - 1] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX - 2][posY + 1].equals("eE") || !chessBoardMap[posX - 2][posY + 1].contains(charTurnContain)) {
				chessBoardMap[posX - 2][posY + 1] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX - 2][posY - 1].equals("eE") || !chessBoardMap[posX - 2][posY - 1].contains(charTurnContain)) {
				chessBoardMap[posX - 2][posY - 1] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX + 1][posY + 2].equals("eE") || !chessBoardMap[posX + 1][posY + 2].contains(charTurnContain)) {
				chessBoardMap[posX + 1][posY + 2] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX + 1][posY - 2].equals("eE") || !chessBoardMap[posX + 1][posY - 2].contains(charTurnContain)) {
				chessBoardMap[posX + 1][posY - 2] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX - 1][posY + 2].equals("eE") || !chessBoardMap[posX - 1][posY + 2].contains(charTurnContain)) {
				chessBoardMap[posX - 1][posY + 2] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX - 1][posY - 2].equals("eE") || !chessBoardMap[posX - 1][posY - 2].contains(charTurnContain)) {
				chessBoardMap[posX - 1][posY - 2] += "s";
			}
		} catch (Exception e) {}

		pieceStoreX = posX;
		pieceStoreY = posY;
		pieceStore = chessBoardMap[posX][posY];
	}

	public void bishopRuleSet() {
		int j = 0;

		if (!secondClick)
			selectReset();

		try {
			j = posY + 1;

			for (int i = posX + 1; i < BOARD_SIZE; i++) {
				if (chessBoardMap[i][j].equals("eE")) {
					chessBoardMap[i][j] += "s";
				}

				else if (!chessBoardMap[i][j].equals("eE") && !chessBoardMap[i][j].contains(charTurnContain)) {
					chessBoardMap[i][j] += "s";
					break;
				}

				else {
					break;
				}

				j++;
			}
		} catch (Exception e) {}

		try {
			j = posY - 1;

			for (int i = posX - 1; i > -1; i--) {
				if (chessBoardMap[i][j].equals("eE")) {
					chessBoardMap[i][j] += "s";
				}

				else if (!chessBoardMap[i][j].equals("eE") && !chessBoardMap[i][j].contains(charTurnContain)) {
					chessBoardMap[i][j] += "s";
					break;
				}

				else {
					break;
				}

				j--;
			}
		} catch (Exception e) {}

		try {
			j = posY + 1;

			for (int i = posX - 1; i > -1; i--) {
				if (chessBoardMap[i][j].equals("eE")) {
					chessBoardMap[i][j] += "s";
				}

				else if (!chessBoardMap[i][j].equals("eE") && !chessBoardMap[i][j].contains(charTurnContain)) {
					chessBoardMap[i][j] += "s";
					break;
				}

				else {
					break;
				}

				j++;
			}
		} catch (Exception e) {}

		try {
			j = posY - 1;

			for (int i = posX + 1; i < BOARD_SIZE; i++) {
				if (chessBoardMap[i][j].equals("eE")) {
					chessBoardMap[i][j] += "s";
				}

				else if (!chessBoardMap[i][j].equals("eE") && !chessBoardMap[i][j].contains(charTurnContain)) {
					chessBoardMap[i][j] += "s";
					break;
				}

				else {
					break;
				}

				j--;
			}
		} catch (Exception e) {}


		pieceStoreX = posX;
		pieceStoreY = posY;
		pieceStore = chessBoardMap[posX][posY];
	}

	public void queenRuleSet() {
		int j = 0;

		if (!secondClick)
			selectReset();

		try {
			j = posY + 1;

			for (int i = posX + 1; i < BOARD_SIZE; i++) {
				if (chessBoardMap[i][j].equals("eE")) {
					chessBoardMap[i][j] += "s";
				}

				else if (!chessBoardMap[i][j].equals("eE") && !chessBoardMap[i][j].contains(charTurnContain)) {
					chessBoardMap[i][j] += "s";
					break;
				}

				else {
					break;
				}

				j++;
			}
		} catch (Exception e) {}

		try {
			j = posY - 1;

			for (int i = posX - 1; i > -1; i--) {
				if (chessBoardMap[i][j].equals("eE")) {
					chessBoardMap[i][j] += "s";
				}

				else if (!chessBoardMap[i][j].equals("eE") && !chessBoardMap[i][j].contains(charTurnContain)) {
					chessBoardMap[i][j] += "s";
					break;
				}

				else {
					break;
				}

				j--;
			}
		} catch (Exception e) {}

		try {
			j = posY + 1;

			for (int i = posX - 1; i > -1; i--) {
				if (chessBoardMap[i][j].equals("eE")) {
					chessBoardMap[i][j] += "s";
				}

				else if (!chessBoardMap[i][j].equals("eE") && !chessBoardMap[i][j].contains(charTurnContain)) {
					chessBoardMap[i][j] += "s";
					break;
				}

				else {
					break;
				}

				j++;
			}
		} catch (Exception e) {}

		try {
			j = posY - 1;

			for (int i = posX + 1; i < BOARD_SIZE; i++) {
				if (chessBoardMap[i][j].equals("eE")) {
					chessBoardMap[i][j] += "s";
				}

				else if (!chessBoardMap[i][j].equals("eE") && !chessBoardMap[i][j].contains(charTurnContain)) {
					chessBoardMap[i][j] += "s";
					break;
				}

				else {
					break;
				}

				j--;
			}
		} catch (Exception e) {}

		for (int i = posX + 1; i < BOARD_SIZE; i++) {
			if (chessBoardMap[i][posY].equals("eE")) {
				chessBoardMap[i][posY] += "s";
			}

			else if (!chessBoardMap[i][posY].equals("eE") && !chessBoardMap[i][posY].contains(charTurnContain)) {
				chessBoardMap[i][posY] += "s";
				break;
			}

			else {
				break;
			}
		}

		for (int i = posX - 1; i > -1; i--) {
			if (chessBoardMap[i][posY].equals("eE")) {
				chessBoardMap[i][posY] += "s";
			}

			else if (!chessBoardMap[i][posY].equals("eE") && !chessBoardMap[i][posY].contains(charTurnContain)) {
				chessBoardMap[i][posY] += "s";
				break;
			}

			else {
				break;
			}
		}

		for (int i = posY + 1; i < BOARD_SIZE; i++) {
			if (chessBoardMap[posX][i].equals("eE")) {
				chessBoardMap[posX][i] += "s";
			}

			else if (!chessBoardMap[posX][i].equals("eE") && !chessBoardMap[posX][i].contains(charTurnContain)) {
				chessBoardMap[posX][i] += "s";
				break;
			}

			else {
				break;
			}
		}

		for (int i = posY - 1; i > -1; i--) {
			if (chessBoardMap[posX][i].equals("eE")) {
				chessBoardMap[posX][i] += "s";
			}

			else if (!chessBoardMap[posX][i].equals("eE") && !chessBoardMap[posX][i].contains(charTurnContain)) {
				chessBoardMap[posX][i] += "s";
				break;
			}

			else {
				break;
			}
		}

		pieceStoreX = posX;
		pieceStoreY = posY;
		pieceStore = chessBoardMap[posX][posY];
	}

	public void kingRuleSet() { 
		if (!secondClick)
			selectReset();

		try {
			if (chessBoardMap[posX + 1][posY].equals("eE") || !chessBoardMap[posX + 1][posY].contains(charTurnContain) && !chessBoardMap[posX + 1][posY].contains("K")) {
				chessBoardMap[posX + 1][posY] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX - 1][posY].equals("eE") || !chessBoardMap[posX - 1][posY].contains(charTurnContain) && !chessBoardMap[posX - 1][posY].contains("K")) {
				chessBoardMap[posX - 1][posY] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX][posY + 1].equals("eE") || !chessBoardMap[posX][posY + 1].contains(charTurnContain) && !chessBoardMap[posX][posY + 1].contains("K")) {
				chessBoardMap[posX][posY + 1] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX][posY - 1].equals("eE") || !chessBoardMap[posX][posY - 1].contains(charTurnContain) && !chessBoardMap[posX][posY - 1].contains("K")) {
				chessBoardMap[posX][posY - 1] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX + 1][posY + 1].equals("eE") || !chessBoardMap[posX + 1][posY + 1].contains(charTurnContain) && !chessBoardMap[posX + 1][posY + 1].contains("K")) {
				chessBoardMap[posX + 1][posY + 1] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX - 1][posY + 1].equals("eE") || !chessBoardMap[posX - 1][posY + 1].contains(charTurnContain) && !chessBoardMap[posX - 1][posY + 1].contains("K")) {
				chessBoardMap[posX - 1][posY + 1] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX + 1][posY - 1].equals("eE") || !chessBoardMap[posX + 1][posY - 1].contains(charTurnContain) && !chessBoardMap[posX + 1][posY - 1].contains("K")) {
				chessBoardMap[posX + 1][posY - 1] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX - 1][posY - 1].equals("eE") || !chessBoardMap[posX - 1][posY - 1].contains(charTurnContain) && !chessBoardMap[posX - 1][posY - 1].contains("K")) {
				chessBoardMap[posX - 1][posY - 1] += "s";
			}
		} catch (Exception e) {}

		if (chessBoardMap[posX][posY].equals("wK")) {
			if (chessBoardMap[BOARD_SIZE - 1][0].equals("wR") && chessBoardMap[BOARD_SIZE - 1][1].equals("eE") && chessBoardMap[BOARD_SIZE - 1][2].equals("eE") && chessBoardMap[BOARD_SIZE - 1][3].equals("eEs") 
					&& chessBoardMap[BOARD_SIZE - 1][4].equals("wK")) {
				chessBoardMap[BOARD_SIZE - 1][2] += "sR";
			}

			else if (chessBoardMap[BOARD_SIZE - 1][BOARD_SIZE - 1].equals("wR") && chessBoardMap[BOARD_SIZE - 1][BOARD_SIZE - 2].equals("eE") && chessBoardMap[BOARD_SIZE - 1][BOARD_SIZE - 3].equals("eEs") 
					&& chessBoardMap[BOARD_SIZE - 1][4].equals("wK")) {
				chessBoardMap[BOARD_SIZE - 1][6] += "sR";
			}
		}

		else {
			if (chessBoardMap[0][0].equals("bR") && chessBoardMap[0][1].equals("eE") && chessBoardMap[0][2].equals("eE") && chessBoardMap[0][3].equals("eEs") 
					&& chessBoardMap[0][4].equals("bK")) {
				chessBoardMap[0][2] += "sR";
			}

			else if (chessBoardMap[0][0].equals("bR") && chessBoardMap[0][BOARD_SIZE - 2].equals("eE") && chessBoardMap[0][BOARD_SIZE - 3].equals("eEs") 
					&& chessBoardMap[0][4].equals("bK")) {
				chessBoardMap[0][6] += "sR";
			}
		}

		pieceStoreX = posX;
		pieceStoreY = posY;
		pieceStore = chessBoardMap[posX][posY];

		checkKingScanner();
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

	/** Developer Notes:
	 * 	
	 */
}