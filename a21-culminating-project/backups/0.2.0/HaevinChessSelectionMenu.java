package beta_versions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class HaevinChessSelectionMenu extends JFrame {

	private JPanel contentPane;
	private JButton singlePlayer;
	private JButton multiPlayer;
	private JButton goBack;
	private JTextArea textArea;
	private JLabel title;
	private JLabel select;
	private JLabel settings;
	private JLabel version;
	private JLabel fileViewLbl;

	final String VERSION = "v0.2.0 - (beta)";
	
	ImageIcon winIcon = new ImageIcon("assets//images//window-icon.png");
	ImageIcon background = new ImageIcon("assets//images//menu-background.jpg");

	public HaevinChessSelectionMenu() {
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
		
		version = new JLabel(VERSION);
		version.setBackground(Color.WHITE);
		version.setFont(new Font("Tahoma", Font.ITALIC, 9));
		version.setBounds(10, 640, 84, 14);
		contentPane.add(version);

		fileViewLbl = new JLabel("HaevinChessSelectionMenu.java");
		fileViewLbl.setFont(new Font("Tahoma", Font.ITALIC, 9));
		fileViewLbl.setBackground(Color.WHITE);
		fileViewLbl.setHorizontalAlignment(SwingConstants.TRAILING);
		fileViewLbl.setBounds(381, 640, 197, 14);
		contentPane.add(fileViewLbl);

		select = new JLabel("Select Game Mode:");
		select.setFont(new Font("Tahoma", Font.PLAIN, 20));
		select.setBackground(Color.WHITE);
		select.setBounds(10, 80, 428, 37);
		contentPane.add(select);

		settings = new JLabel("Settings:");
		settings.setFont(new Font("Tahoma", Font.PLAIN, 20));
		settings.setBackground(Color.WHITE);
		settings.setBounds(10, 252, 428, 37);
		contentPane.add(settings);

		singlePlayer = new JButton("Single Player");
		singlePlayer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		singlePlayer.setBounds(139, 128, 310, 51);
		contentPane.add(singlePlayer);
		singlePlayer.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				singlePlayerActionPerformed(evt);
			}
		});

		multiPlayer = new JButton("Multiplayer");
		multiPlayer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		multiPlayer.setBounds(139, 190, 310, 51);
		contentPane.add(multiPlayer);
		multiPlayer.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				multiPlayerActionPerformed(evt);
			}
		});

		textArea = new JTextArea();
		textArea.setBackground(Color.GRAY);
		textArea.setBounds(10, 300, 568, 329);
		contentPane.add(textArea);

		goBack = new JButton("<");
		goBack.setBounds(10, 10, 41, 23);
		contentPane.add(goBack);
		goBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				goBackActionPerformed(evt);
			}
		});
	}

	public void singlePlayerActionPerformed(java.awt.event.ActionEvent evt) {
		HaevinChess frame = new HaevinChess();
		frame.setVisible(true);
		setVisible(false);
	}
	
	public void multiPlayerActionPerformed(java.awt.event.ActionEvent evt) {
		HaevinChess frame = new HaevinChess();
		frame.setVisible(true);
		setVisible(false);
	}
	
	public void goBackActionPerformed(java.awt.event.ActionEvent evt) {
		HaevinChessMainMenu frame = new HaevinChessMainMenu();
		frame.setVisible(true);
		setVisible(false);
	}
}
