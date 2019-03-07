package common;

//import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
//import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import common.search;
import common.sr;

import java.awt.Color;

public class mainpage {

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("");
		//frame.setSize(300, 150);
		frame.setBounds(200, 100, 1000, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(47, 47, 47));
		frame.getContentPane().add(panel_1);
		placeComponents(panel_1);
		
		JButton label = new JButton("");
		label.setBackground(new Color(0, 0, 0));
		label.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try {
						sr.main();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					search.main();
					
			}
		});
		Image images = new ImageIcon(mainpage.class.getResource("/gif7.gif")).getImage();
		label.setIcon(new ImageIcon(images));
		label.setOpaque(false);
		label.setContentAreaFilled(false);
		label.setBorderPainted(false);
		label.setBounds(350, 173, 275, 283);
		panel_1.add(label);
		
		JLabel lblSimulator = new JLabel("SORTING HAT");
		lblSimulator.setForeground(new Color(255, 255, 255));
		lblSimulator.setFont(new Font("Kristen ITC", Font.PLAIN, 47));
		lblSimulator.setBounds(325, 36, 525, 57);
		panel_1.add(lblSimulator);
		
		//JLabel label_1 = new JLabel("");
		/*JLabel label_1 = new JLabel("");
		Image images1 = new ImageIcon(Loginview.class.getResource("/111.jpg")).getImage();
		label_1.setIcon(new ImageIcon(images1));
		label_1.setBounds(0, 0, 985, 605);
		panel_1.add(label_1);*/

		frame.setVisible(true);

	}

	/**
	 * Create the application.
	 */
	
	/**
	 * Initialize the contents of the frame.
	 */

	private static void placeComponents(JPanel panel_1) {
		// TODO Auto-generated method stub
		panel_1.setLayout(null);
		
	}
}
