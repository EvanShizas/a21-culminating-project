package alpha_versions;

/**
 * --a short description here--
 * 
 * modified     20220604
 * date         20220531
 * @filename    HaevinChess.java
 * @author      Alvin Chan, Hammad Hassan, Evan Shizas
 * @version     0.0.1
 * @see         A21 - Culminating Project
 */

/**	Patch Notes:
 * 	
 * 	Created the alpha interface. May be changed to where the 
 * 	buttons and menus are stored in separate Java classes, but for now 
 * 	this seems to be a good and efficient solution. (06/04/2022 -> Evan)
 * 	
 * 	
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.JLabel;
import java.awt.Font;
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
	private JButton play;
	private JButton instructions;
	private JButton exit;
	private JButton singlePlayer;
	private JButton multiPlayer;
	private JButton goBack;
	private JTextArea textArea;
	private JLabel title;
	private JLabel select;
	private JLabel settings;
	private JLabel version;
	private JLabel fileViewLbl;

	final String VERSION = "v0.0.1";
	
	ImageIcon winIcon = new ImageIcon("assets//images//window-icon.png");
	
	File file = new File("src//pre_alpha_test//Chess.java");
	
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

	public HaevinChess() {
		setResizable(false);
		setBackground(Color.WHITE);
		setTitle("A21 - Haevin Chess (" + VERSION + ")");
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

		version = new JLabel(VERSION + " - (alpha)");
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
	
	public void instructionsActionPerformed(java.awt.event.ActionEvent evt) {
		
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
		
	}
	
	public void multiPlayerActionPerformed(java.awt.event.ActionEvent evt) {
		
	}
}

/** Developer Notes:
 *	
 */