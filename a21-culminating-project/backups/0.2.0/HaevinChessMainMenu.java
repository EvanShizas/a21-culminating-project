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

public class HaevinChessMainMenu extends JFrame {

	private JPanel contentPane;
	private JButton play;
	private JButton instructions;
	private JButton exit;
	private JLabel title;
	private JLabel version;
	private JLabel fileViewLbl;
	
	final String VERSION = "v0.2.0 - (beta)";
	
	ImageIcon winIcon = new ImageIcon("assets//images//window-icon.png");
	ImageIcon background = new ImageIcon("assets//images//menu-background.jpg");

	public HaevinChessMainMenu() {
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
		
		version = new JLabel(VERSION);
		version.setBackground(Color.WHITE);
		version.setFont(new Font("Tahoma", Font.ITALIC, 9));
		version.setBounds(10, 640, 84, 14);
		contentPane.add(version);

		fileViewLbl = new JLabel("HaevinChessMainMenu.java");
		fileViewLbl.setFont(new Font("Tahoma", Font.ITALIC, 9));
		fileViewLbl.setBackground(Color.WHITE);
		fileViewLbl.setHorizontalAlignment(SwingConstants.TRAILING);
		fileViewLbl.setBounds(454, 640, 124, 14);
		contentPane.add(fileViewLbl);
	}
	
	public void exitActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}
	
	public void instructionsActionPerformed(java.awt.event.ActionEvent evt) {

	}
	
	public void playActionPerformed(java.awt.event.ActionEvent evt) {
		HaevinChessSelectionMenu frame = new HaevinChessSelectionMenu();
		frame.setVisible(true);
		setVisible(false);
	}
}