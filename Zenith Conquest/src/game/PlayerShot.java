package game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class PlayerShot extends Sprite {
	private Image shotSprite = new ImageIcon("images/ShotSprite.png").getImage();
	private final int H_SPACE = 6; // change according to size of shot
	private final int V_SPACE = 1;
	
	public PlayerShot() {
		// TODO Auto-generated constructor stub
	}

	public PlayerShot(int x, int y) {
		startShot(x, y);
	}

	private void startShot(int x, int y) {
		setImage(shotSprite);
		setX(x + H_SPACE);
		setY(y - V_SPACE);
	}

}
