package game;

import java.awt.*;
import javax.swing.*;

public class InfoPrompt extends JFrame {
	private ImageIcon infoBack = new ImageIcon("images/infoScreenBack.png");
	private ImageIcon infoBackHARD = new ImageIcon("images/infoScreenBackHARD.jpg");
	private JLabel backgroundHolder = new JLabel(infoBack);
	
	public InfoPrompt(String difficulty) {
		super("Zenith Conquest");
		setSize(550,550);
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(backgroundHolder);
		
		JButton btn = new JButton();
		add(btn);
		
		setVisible(true);
	}
	
}
