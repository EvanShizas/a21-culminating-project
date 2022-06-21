package beta_versions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	
	final String VERSION = "v0.7.0 - (beta)";
	
	ImageIcon winIcon = new ImageIcon("assets//images//window-icon.png");
	ImageIcon background = new ImageIcon("assets//images//menu-background.jpg");
	ImageIcon instructionsImg = new ImageIcon("assets/images/instructions.png");


	public HaevinChessMainMenu() {
		setResizable(false);
		setBackground(Color.WHITE);
		setTitle("A21 - Haevin Chess [" + VERSION + "]");
		setIconImage(winIcon.getImage()); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 153, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		title = new JLabel("Haevin Chess");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(new Color(204, 51, 51));
		title.setFont(new Font("Tahoma", Font.BOLD, 45));
		title.setBackground(Color.WHITE);
		title.setBounds(0, 0, 588, 90);
		contentPane.add(title);

		play = new JButton("Play");
		play.setFont(new Font("Tahoma", Font.PLAIN, 20));
		play.setBounds(93, 206, 116, 72);
		contentPane.add(play);
		play.setBackground((new Color(101, 67, 33)));;
		play.setForeground(Color.WHITE);
		play.setFocusPainted(false);
		play.setFont(new Font("Tahoma", Font.BOLD, 16));
		play.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				playActionPerformed(evt);
			}
		});

		instructions = new JButton("Instructions");
		instructions.setFont(new Font("Tahoma", Font.PLAIN, 20));
		instructions.setBounds(93, 276, 356, 72);
		contentPane.add(instructions);
		instructions.setBackground((new Color(101, 67, 33)));;
		instructions.setForeground(Color.WHITE);
		instructions.setFocusPainted(false);
		instructions.setFont(new Font("Tahoma", Font.BOLD, 16));
		instructions.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				instructionsActionPerformed(evt);
			}
		});

		exit = new JButton("Exit");
		exit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		exit.setBounds(333, 346, 116, 72);
		contentPane.add(exit);
		exit.setBackground((new Color(101, 67, 33)));;
		exit.setForeground(Color.WHITE);
		exit.setFocusPainted(false);
		exit.setFont(new Font("Tahoma", Font.BOLD, 16));
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
	}
	
	public void exitActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}
	
	public void instructionsActionPerformed(java.awt.event.ActionEvent evt) {
		JOptionPane.showMessageDialog(null,"","Instructions",JOptionPane.INFORMATION_MESSAGE, instructionsImg);
	}
	
	public void playActionPerformed(java.awt.event.ActionEvent evt) {
		HaevinChessSelectionMenu frame = new HaevinChessSelectionMenu();
		frame.setVisible(true);
		setVisible(false);
	}
}