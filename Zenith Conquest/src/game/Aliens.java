package game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Aliens extends Sprite {
	private Missle missle;
	private Image alien1 = new ImageIcon("images/AlienOne.png").getImage();
	private Image alien2 = new ImageIcon("images/AlienTwo.png").getImage();
	private Image alien3 = new ImageIcon("image/AlienThree.png").getImage();

	public Aliens(int x, int y) {
		startAlien(x,y);
	}
	
	public void startAlien(int x, int y) {
		this.x = x;
		this.y = y;
		
		missle = new Missle(x,y);
		setImage(alien1);
	}
	// add more aliens 
	
	public Missle getMissle() { 
		return missle;
	}
	
	public void spawn(int direction) {
		this.x += direction;
	}
	
	
}
