package common;
import common.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import common.textDisplay;
import common.LuceneReadIndexFromFileExample;
//import common.sr;
//import common.LuceneWriteIndexFromFileExample;

public class soundex_gui {

	private JFrame frame;
	private JTextField textField;

	//private JTextField textField_3;
	
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					soundex_gui window = new soundex_gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public soundex_gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 102));
		frame.setBounds(100, 100, 1000, 650);
		frame.setLocation(200, 100);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label_1 = new JLabel("");
		Image images = new ImageIcon(mainpage.class.getResource("/112.jpg")).getImage();
		label_1.setIcon(new ImageIcon(images));
		label_1.setBounds(0, 0, 996, 612);
		frame.getContentPane().add(label_1);
		frame.getContentPane().setLayout(null);
		
		JButton btnStart = new JButton("Search\r\n");
		btnStart.setBounds(389, 298, 124, 34);
		btnStart.setBackground(new Color(240, 128, 128));
		btnStart.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnStart.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{	
	    		String t6=textField.getText();
	    		textField.setText("");
	    		String ans1 = null;
	    		int a=1;
				//LuceneReadIndexFromFileExample Obj1= new LuceneReadIndexFromFileExample();
				try {
					ParserTest.main(t6);
					LuceneWriteIndexFromFileExample.main(a);
					ans1 = LuceneReadIndexFromFileExample.main(t6,a);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				textDisplay.main(ans1);
			}
		});
		frame.getContentPane().add(btnStart);
		
		textField = new JTextField();
		textField.setBounds(305, 209, 284, 34);
		textField.setBackground(new Color(245, 222, 179));
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
	}

}
