package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchScreen extends JFrame {
	
	ImageIcon titleScr = new ImageIcon("images/spacegif.gif");
	ImageIcon easyImg = new ImageIcon("images/easyButton.png");
	ImageIcon hardImg = new ImageIcon("images/hardButton.png");
	JLabel bckHold;
	JButton easyBtn, hardBtn;
	
	public LaunchScreen() {
		super("Zenith Conquest");
		setSize(550,550);
		
		setLocationRelativeTo(null);
		setResizable(false);
		bckHold = new JLabel(titleScr);
		setContentPane(bckHold);
		setLayout(new GridBagLayout());
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/Untitled.png"));
		GridBagConstraints gbc = new GridBagConstraints();
		
		Handler handler = new Handler();
		
		easyBtn = new JButton();
			easyBtn.addActionListener(handler);
			easyBtn.setIcon(easyImg);
			easyBtn.setBorder(BorderFactory.createEmptyBorder());
			easyBtn.setContentAreaFilled(false);
				gbc.gridy = 0;
			add(easyBtn,gbc);
		hardBtn = new JButton(hardImg);
			hardBtn.addActionListener(handler);
			hardBtn.setIcon(hardImg);
			hardBtn.setBorder(BorderFactory.createEmptyBorder());
			hardBtn.setContentAreaFilled(false);
				gbc.gridy = 1;
			add(hardBtn, gbc);

		setVisible(true);
	}
	
	public static void main(String[] args) {
		LaunchScreen frm = new LaunchScreen();
	}
	
	
	public class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == easyBtn) {
				InfoPrompt frm = new InfoPrompt("easy");
				dispose();
			} else if (e.getSource() == hardBtn) {
				InfoPrompt frm = new InfoPrompt("hard");
				dispose();
			}
			
		}
	}



}