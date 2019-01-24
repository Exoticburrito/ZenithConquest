package game;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerShip extends Sprite implements DataHolder {
	private final int START_Y_POS = 500; // change if needed
	private final int START_X_POS = 250;
	private Image shipSprite;
	private int width;

	public PlayerShip(int shipNum) {
		startPlayer();
		if (shipNum == 1) {
			shipSprite = shipGalactacus.getImage();
		} else if (shipNum == 2) {
			shipSprite = shipUltron.getImage();
		} else if (shipNum == 3) {
			shipSprite = shipGamma.getImage();
		}
	}


	private void startPlayer() {
		width = 200;
		setImage(shipSprite);

		setX(START_X_POS);
		setY(START_Y_POS);
	}
	
	public void spawn() {
		x += dx;
		
		if (x<=2) {
			x = 2;
		}
		if (x >= GAME_WIDTH - 2 * width) { 
			x = GAME_WIDTH - 2 * width;
		}
	}
	
	public void keyPressed(KeyEvent e) { 
		if (e.getKeyCode() == KeyEvent.VK_LEFT) { 
			dx = -2;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) { 
			dx = 2;
		}
	}
	
	public void keyReleased(KeyEvent e) { 
		if (e.getKeyCode() == KeyEvent.VK_LEFT) { 
			dx = 0;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
	}
}
