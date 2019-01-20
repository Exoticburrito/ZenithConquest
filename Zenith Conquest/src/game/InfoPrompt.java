
package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InfoPrompt extends JFrame implements ActionListener {
	ImageIcon infoBack = new ImageIcon("images/infoScreenBack.jpg");
	ImageIcon infoBackHARD = new ImageIcon("images/infoScreenBackHARD.jpg");				// remember to fix images at school, add "Zenith Conquest/" to file path
	
	ImageIcon namePrompt = new ImageIcon("images/namePrompt.png");
	ImageIcon shipPrompt = new ImageIcon("images/shipPrompt.png");
	
	ImageIcon shipGalactacus = new ImageIcon("images/ree.png");
	ImageIcon shipUltron = new ImageIcon("images/OmegaUltron.png");
	ImageIcon shipGammaOdyssey = new ImageIcon("images/GammaOdyssey.png");
	
	Font CALIBRI = new Font("Calibri", Font.ITALIC, 16);
	JLabel backgroundHolder, uNamePrompt, shipPromptHolder, shipHolder;
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
		
		
		uNamePrompt = new JLabel(namePrompt);
			uNamePrompt.setBounds(12,25,425,25);
			add(uNamePrompt);
		txt1 = new JTextField(16);
			txt1.setBounds(50,60,300,25);
			txt1.addActionListener(this);
			txt1.setBackground(new Color(200, 191, 231));
		add(txt1);
		
		shipPromptHolder = new JLabel(shipPrompt);
			shipPromptHolder.setBounds(12, 160, 425, 25);
			add(shipPromptHolder);
		
		ButtonGroup shipRads = new ButtonGroup();
		
		
		ship1Rad = new JRadioButton("Ship One: Galactacus");
			ship1Rad.setBounds(50, 190, 175, 25);										// setBounds(x,y, width,height)
			ship1Rad.setFont(CALIBRI);
			ship1Rad.addActionListener(this);
			shipRads.add(ship1Rad);
			add(ship1Rad);
		ship2Rad = new JRadioButton("Ship Two: Omega Ultron");
			ship2Rad.setBounds(50, 275, 190, 25);
			ship2Rad.setFont(CALIBRI);
			ship2Rad.addActionListener(this);
			shipRads.add(ship2Rad);
			add(ship2Rad);
		ship3Rad = new JRadioButton("Ship Three: Gamma Odyssey");
			ship3Rad.setBounds(50, 360, 230, 25);
			ship3Rad.setFont(CALIBRI);
			ship3Rad.addActionListener(this);
			shipRads.add(ship3Rad);
			add(ship3Rad);
		shipHolder = new JLabel(shipGalactacus);
			shipHolder.setBounds(300, 300, 200, 200);
			add(shipHolder);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		InfoPrompt f = new InfoPrompt("easy");
	}
	
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == txt1) {
			USER_NAME = txt1.getText();	
			System.out.println(USER_NAME);
		}
		if (e.getSource() == ship1Rad) {
			shipHolder = new JLabel(shipGalactacus);
				shipHolder.setBounds(300, 300, 200, 200);
			add(shipHolder);
		}
	}

	
}

