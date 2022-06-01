DO NOT CREATE ANY JAVA FILES IN THE DEFAULT PACKAGE! ONLY FINAL VERSION WILL BE PLACED HERE!

To keep things organized, either create a new package for what is specifically being stored or place the Java file
in the corresponding package...

HaevinChess.java ---------------------------------------------------------------------------------------------

 * --a short description here--
 * 
 * modified     yyyymmdd
 * date         20220531
 * @filename    HaevinChess.java
 * @author      Alvin Chan, Hammad Hassan, Evan Shizas
 * @version     1.0.0
 * @see         A21 - Culminating Project
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