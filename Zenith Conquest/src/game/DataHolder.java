package game;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

public interface DataHolder {
	public final int GAME_WIDTH = 550;
	public final int GAME_HEIGHT = 550;
	public static final int GROUND = 200;
	public static final int BORDER_RIGHT = 15;				//tinker
	public static final int BORDER_LEFT = 1;
	public static final int GO_DOWN = 15;
	public static final int CHANCE_FOR_SHOT = 5;
	public static final int DELAY = 17;
	public static final int PLAYER_WIDTH = 15;				// size of sprite downscaled
	public static final int PLAYER_HEIGHT = 10;
	public static final int ALIEN_WIDTH = 12;
	public static final int ALIEN_HEIGHT = 12;
	public static final int MISSLE_HEIGHT = 5;
	
	
	// launch screen images
	Image TASKBAR_ICON = new ImageIcon("Zenith Conquest/images/TASKBARICON.png").getImage();		
	
	ImageIcon titleScr = new ImageIcon("Zenith Conquest/images/spacegif.gif");
	ImageIcon easyImg = new ImageIcon("Zenith Conquest/images/easyButton.png");
	ImageIcon hardImg = new ImageIcon("Zenith Conquest/images/hardButton.png");

	// info prompt images & fonts
	public ImageIcon infoBack = new ImageIcon("Zenith Conquest/images/infoScreenBack.png");
	public ImageIcon infoBackHARD = new ImageIcon("Zenith Conquest/images/infoScreenBackHARD.jpg");				// remember to fix images at school, add "Zenith Conquest/" to file path
	
	public ImageIcon namePrompt = new ImageIcon("Zenith Conquest/images/namePrompt.png");
	public ImageIcon shipPrompt = new ImageIcon("Zenith Conquest/images/shipPrompt.png");
	
	public ImageIcon shipGalactacus = new ImageIcon("Zenith Conquest/images/Galactacus.png");
	public ImageIcon shipUltron = new ImageIcon("Zenith Conquest/images/OmegaUltron.png");
	public ImageIcon shipGamma = new ImageIcon("Zenith Conquest/images/GammaOdyssey.png");
	
	Font CALIBRI = new Font("Calibri", Font.ITALIC, 16);
	Font VCR_OSD = new Font("VCR OSD MONO", Font.PLAIN, 24);
	
	// for game itself 
	public Image alienExplode = new ImageIcon("ZenithConquest/images/AlienExplode.gif").getImage();
	
}
