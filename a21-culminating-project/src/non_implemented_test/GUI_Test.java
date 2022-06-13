package non_implemented_test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class GUI_Test extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Test frame = new GUI_Test();
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
	public GUI_Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1483, 762);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(8, 8));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
		panel_2.setLayout(new GridLayout(0, 8, 0, 0));
		
		JButton btnNewButton1 = new JButton("New button");
		panel_2.add(btnNewButton1);
		
		JButton btnNewButton1_1 = new JButton("New button");
		panel_2.add(btnNewButton1_1);
		
		JButton btnNewButton1_2 = new JButton("New button");
		panel_2.add(btnNewButton1_2);
		
		JButton btnNewButton1_23 = new JButton("New button");
		panel_2.add(btnNewButton1_23);
		
		JButton btnNewButton1_3 = new JButton("New button");
		panel_2.add(btnNewButton1_3);
		
		JButton btnNewButton1_4 = new JButton("New button");
		panel_2.add(btnNewButton1_4);
		
		JButton btnNewButton1_5 = new JButton("New button");
		panel_2.add(btnNewButton1_5);
		
		JButton btnNewButton1_6 = new JButton("New button");
		panel_2.add(btnNewButton1_6);
		
		JButton btnNewButton1_7 = new JButton("New button");
		panel_2.add(btnNewButton1_7);
		
		JButton btnNewButton2 = new JButton("New button");
		panel_3.add(btnNewButton2);
		
		JButton btnNewButton3 = new JButton("New button");
		btnNewButton3.setBackground(Color.RED);
		panel_4.add(btnNewButton3);
		
		JButton btnNewButton4 = new JButton("New button");
		panel.add(btnNewButton4);
	}
}
