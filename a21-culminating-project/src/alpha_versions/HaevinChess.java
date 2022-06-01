package alpha_versions;

/**
 * --a short description here--
 * 
 * modified     20220531
 * date         20220531
 * @filename    HaevinChess.java
 * @author      Alvin Chan, Hammad Hassan, Evan Shizas
 * @version     0.0.1
 * @see         A21 - Culminating Project
 */

/**	Patch Notes:
 * 
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HaevinChess extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
}

/** Developer Notes:
*	
*/