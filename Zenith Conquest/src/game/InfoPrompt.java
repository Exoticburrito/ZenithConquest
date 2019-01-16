package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InfoPrompt extends JFrame {
	ImageIcon infoBack = new ImageIcon("Zenith Conquest/images/infoScreenBack.jpg");
	ImageIcon infoBackHARD = new ImageIcon("Zenith Conquest/images/infoScreenBackHARD.jpg");
	
	JLabel backgroundHolder, uNamePrompt;
	JTextField txt1;
	
	public String USER_NAME;
	
	public InfoPrompt(String difficulty) {
		super("Zenith Conquest");
		setSize(550,550);
		
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		setIconImage(LaunchScreen.getTASKBAR_ICON());
		
		if (difficulty == "easy") {
			backgroundHolder = new JLabel(infoBack);
			setContentPane(backgroundHolder); 
		} else if (difficulty == "hard") {
			backgroundHolder = new JLabel(infoBackHARD);
			setContentPane(backgroundHolder); 
		}
		
		Handler hand = new Handler();
		
		
		txt1 = new JTextField(16);
			txt1.setBounds(50,100,100,25);
			txt1.addActionListener(hand);
		add(txt1);
		
		uNamePrompt = new JLabel("PLACEHOLDER_IMAGE");
		
		
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		InfoPrompt f = new InfoPrompt("easy");
	}
	
	
	public class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == txt1) {
				USER_NAME = txt1.getText();	
			}
		}
	}
}
