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
	JRadioButton ship1Rad, ship2Rad, ship3Rad;
	
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
			txt1.setBounds(50,50,100,25);
			txt1.addActionListener(hand);
			txt1.setBackground(new Color(200, 191, 231));
		add(txt1);
		
		ship1Rad = new JRadioButton("Ship One: Galactacus");
			ship1Rad.setBounds(50, 184, 130, 25);			// setBounds(x,y, width,height)
			ship1Rad.setFont(new Font("Calibri", Font.ITALIC, 12));
			add(ship1Rad);
		ship2Rad = new JRadioButton("Ship Two: SS Qiaz Omur");
		
		ship3Rad = new JRadioButton("Ship Three: Gamma Odyssey");
		ButtonGroup shipRads = new ButtonGroup();
		
		
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
				System.out.println(USER_NAME);
			}
		}
	}
}
