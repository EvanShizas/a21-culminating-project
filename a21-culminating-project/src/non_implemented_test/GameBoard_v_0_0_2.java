package non_implemented_test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;

public class GameBoard_v_0_0_2 extends JFrame {

	private JPanel contentPane;
	private JPanel centrePanel;
	
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
	JButton[][] chessBoard = new JButton[BOARD_SIZE][BOARD_SIZE];
	int tileNum = 0;
	int name = 0;
	
	final Color BROWN = new Color(185, 122, 87);
	final Color WHITE = new Color(255, 255, 255);
	
	Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int)size.getWidth();
	int height = (int)size.getHeight();
	double change = (double)((width-height)/2);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameBoard_v_0_0_2 frame = new GameBoard_v_0_0_2();
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
	public GameBoard_v_0_0_2() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1472, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		JPanel westPanel = new JPanel();
		westPanel.setBorder(new EmptyBorder(5, (int) change, 5, 5));
		contentPane.add(westPanel, BorderLayout.WEST);
		
		JPanel southPanel = new JPanel();
		contentPane.add(southPanel, BorderLayout.SOUTH);
		
		JButton stats = new JButton("Stats");
		southPanel.add(stats);
		
		JButton instructions = new JButton("Instructions");
		southPanel.add(instructions);
		
		JButton pause = new JButton("                  Pause                  ");
		southPanel.add(pause);
		
		JButton restart = new JButton("Restart");
		southPanel.add(restart);
		
		JButton quit = new JButton("Quit");
		southPanel.add(quit);
		
		JPanel eastPanel = new JPanel();
		eastPanel.setBorder(new EmptyBorder(5, (int) change, 5, 5));
		contentPane.add(eastPanel, BorderLayout.EAST);
		
		centrePanel = new JPanel();
		contentPane.add(centrePanel, BorderLayout.CENTER);
		centrePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		centrePanel.setLayout(new GridLayout(0, 8, 0, 0));
	
		JLabel title = new JLabel("Haevin Chess");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.BLUE);
		title.setFont(new Font("Tahoma", Font.BOLD, 45));
		title.setBackground(Color.WHITE);
		title.setBounds(0, 0, 588, 90);
		northPanel.add(title);
		
		boardGridInit();
		
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				chessBoard[row][col] = new JButton();
				
				chessBoard[row][col].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for (int row = 0; row < BOARD_SIZE; row++) {
							for (int col = 0; col < BOARD_SIZE; col++) {
								if (e.getSource() == chessBoard[row][col]) {
									
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
	}

	public void boardGridInit() {
		
	}
}
