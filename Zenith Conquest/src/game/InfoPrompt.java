package game;

import java.awt.*;
import javax.swing.*;

public class InfoPrompt extends JFrame {
	private ImageIcon infoBack = new ImageIcon("Zenith Conqeust/images/infoScreenBack.png");
	private ImageIcon infoBackHARD = new ImageIcon("Zenith Conquest/images/infoScreenBackHARD.jpg");
	
	private JLabel backgroundHolder;
	
	public InfoPrompt(String difficulty) {
		super("Zenith Conquest");
		setSize(550,550);
		
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new GridBagLayout());
		setIconImage(LaunchScreen.getTASKBAR_ICON());
		
		if (difficulty == "easy") {
			backgroundHolder = new JLabel(infoBack);
			setContentPane(backgroundHolder); 
		} else if (difficulty == "hard") {
			backgroundHolder = new JLabel(infoBackHARD);
			setContentPane(backgroundHolder); 
		}
		                                                                             
		
		
		setVisible(true);
	}
	
}
