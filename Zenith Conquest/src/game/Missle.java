package game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Missle extends Sprite {
	private Image missleSprite = new ImageIcon("images/MissleSprite.png").getImage();
	private boolean isDestroyed;
	
	public Missle(int x, int y) {
		startMissle(x, y);
	}

	private void startMissle(int x, int y) {
		setDestroyed(true);
		this.x = x;
		this.y = y;
		setImage(missleSprite);
		
	}
	
	public void setDestroyed(boolean isDestroyed) { 
		this.isDestroyed = isDestroyed;
	}
	
	public boolean isDestroyed() { 
		return isDestroyed;
	}
}
