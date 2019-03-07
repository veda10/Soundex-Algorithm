package common;


import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionListener;


public class search {

	JFrame frame;
	JButton j,k;
	JLabel l;
	JFrame f3,f2;
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search window = new search();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public search() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		/*UIManager.put("InternalFrame.activeTitleBackground", new ColorUIResource(Color.red ));
		UIManager.put("InternalFrame.activeTitleForeground", new ColorUIResource(Color.red));
		UIManager.put("InternalFrame.titleFont", new Font("Dialog", Font.PLAIN, 11));*/
		frame.getContentPane().setIgnoreRepaint(true);
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setForeground(new Color(205, 92, 92));
		frame.getContentPane().setFont(new Font("Tahoma", Font.ITALIC, 11));
		frame.setBounds(200, 100, 1000, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		btnStop.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				PageFaultGUI OBJ2=new PageFaultGUI();
//				OBJ2.main();
//			}
//		});
		frame.getContentPane().setLayout(null);
		
		JLabel lblSRILEKHA = new JLabel("JAHNAVI\r\n                                    VEDA  \r\n                                    MONICA \r\n                                     \r\nSRILEKHA ");
		lblSRILEKHA.setBounds(10, 477, 962, 135);
		lblSRILEKHA.setFont(new Font("MV Boli", Font.PLAIN, 12));
		lblSRILEKHA.setBackground(new Color(255, 99, 71));
		lblSRILEKHA.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(lblSRILEKHA);
		
		
		
		JButton btnClick = new JButton("Search with soundex");
		btnClick.setBounds(365, 218, 217, 37);
		btnClick.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnClick.setForeground(Color.BLACK);
		btnClick.setBackground(new Color(255, 255, 255));
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				soundex_gui.main();				
			}
		});
		frame.getContentPane().add(btnClick);
		
		JLabel lblNewLabel = new JLabel("SORTING HAT");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(382, 0, 200, 100);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		Font labelFont = lblNewLabel.getFont();
		String labelText = lblNewLabel.getText();
		int stringWidth = lblNewLabel.getFontMetrics(labelFont).stringWidth(labelText);
		int componentWidth = lblNewLabel.getWidth();
		double widthRatio = (double)componentWidth / (double)stringWidth;
		int newFontSize = (int)(labelFont.getSize() * widthRatio);
		int componentHeight = lblNewLabel.getHeight();
		int fontSizeToUse = Math.min(newFontSize, componentHeight);
		lblNewLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
		
		JButton btnDiskScheduling = new JButton("Search without soundex");
		btnDiskScheduling.setBounds(365, 304, 217, 37);
		btnDiskScheduling.setForeground(new Color(0, 0, 0));
		btnDiskScheduling.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnDiskScheduling.setBackground(new Color(255, 255, 255));
		btnDiskScheduling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				no_soundex.main();
			}
		});
		frame.getContentPane().add(btnDiskScheduling);
		
		JButton btnA = new JButton("a");
		btnA.setBounds(10, 165, -1, 23);
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				
			}
		});
		btnA.setBackground(new Color(210, 105, 30));
		btnA.setForeground(new Color(210, 105, 30));
		frame.getContentPane().add(btnA);
		
		JLabel label_1 = new JLabel("");
		Image images = new ImageIcon(mainpage.class.getResource("/112.jpg")).getImage();
		label_1.setIcon(new ImageIcon(images));
		label_1.setBounds(-22, -69, 1006, 681);
		frame.getContentPane().add(label_1);
		
		/*JButton btnBankersAlgorithm = new JButton("Banker's Algorithm");
		btnBankersAlgorithm.setForeground(new Color(255, 255, 255));
		btnBankersAlgorithm.setBounds(382, 461, 200, 37);
		frame.getContentPane().add(btnBankersAlgorithm);*/
		
		
		
	}
}
