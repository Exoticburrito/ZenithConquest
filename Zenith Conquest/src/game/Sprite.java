package game;

import java.awt.Image;

public class Sprite {
	private boolean isVisible;
	private Image image;
	private Image sprite;
	protected int x;
	protected int y;
	protected boolean isDying;
	protected int dx;
	
	public Sprite() {
		isVisible = true;
	}
	public void spriteDeath() {
		isVisible = false;
	}
	public boolean isVisible() {
		return isVisible;
	}
	public void appear(boolean isVisible) {
		this.isVisible = isVisible;
	}
	public void setImage(Image givenSprite) { 
		sprite = givenSprite;
	}
	public Image getImage() { 
		return image;
	}
	public void setX(int x) { 
		this.x = x;
	}
	public int getX() {
		return x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() { 
		return y;
	}
	public void kill(boolean isDying) {
		this.isDying = isDying;
	}
	public boolean isDying() { 
		return isDying;
	}
}
