package common;
import java.awt.*;

import javax.swing.*;
 
public class textDisplay {
    
   private JFrame mainFrame;
   private JLabel headerLabel;
   //private JLabel statusLabel;
   private JPanel controlPanel;

   public textDisplay(){
      prepareGUI();
   }

   public static void main(String args){
	   textDisplay  swingControlDemo = new textDisplay();      
      swingControlDemo.showTextAreaDemo(args);
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Display");
      mainFrame.getContentPane().setBackground(Color.DARK_GRAY);
      mainFrame.setSize(400,400);
      //mainFrame.addWindowListener(new WindowAdapter() {
      //   public void windowClosing(WindowEvent windowEvent){
      //      System.exit(0);
      //   }        
      //});    
      headerLabel = new JLabel("", JLabel.CENTER);        
      headerLabel.setBounds(0, 1, 382, 117);
      headerLabel.setForeground(new Color(0, 255, 102));
      headerLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
      headerLabel.setBackground(new Color(238, 232, 170));
     // statusLabel = new JLabel("",JLabel.CENTER);    
     // statusLabel.setBackground(new Color(169, 169, 169));

     // statusLabel.setSize(350,100);

      controlPanel = new JPanel();
      controlPanel.setBounds(0, 99, 382, 169);
      controlPanel.setBackground(new Color(255, 204, 0));
      controlPanel.setLayout(new FlowLayout());
      mainFrame.getContentPane().setLayout(null);

      mainFrame.getContentPane().add(headerLabel);
      mainFrame.getContentPane().add(controlPanel);
    //  mainFrame.getContentPane().add(statusLabel);
      mainFrame.setLocation(200,100);
      mainFrame.setVisible(true);  
   }

   private void showTextAreaDemo(String T){
      headerLabel.setText("Output"); 

      final JTextArea commentTextArea = 
         new JTextArea(T,10,25);

      JScrollPane scrollPane = new JScrollPane(commentTextArea);    

      //JButton showButton = new JButton("Show");

     // showButton.addActionListener(new ActionListener() {
      //   public void actionPerformed(ActionEvent e) {     
       //     statusLabel.setText( commentTextArea.getText());        
         //}
      //}); 

      controlPanel.add(scrollPane);        
      //mainFrame.setVisible(true);  
   }
}