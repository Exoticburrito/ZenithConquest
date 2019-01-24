package game;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GameStart extends JPanel implements DataHolder, Runnable {
	
	private Dimension BoardSize = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	private static ArrayList<Aliens> aliens = new ArrayList<Aliens>();
	private PlayerShip player;
	private PlayerShot shot;
	
	private final int ALIEN_START_POSX = 100;
	private final int ALIEN_START_POSY = 5;
	private int direction = -1;
	private int kills = 0;
	private String message = "Game Over";

	private boolean gameRunning = true;
	private Image shipExplode = new ImageIcon("images/Explosion.png").getImage();
	
	private Thread spawner;
	
	public GameStart(int shipNum) {
		addKeyListener(new KeyEar());
		setFocusable(true);
		setBackground(Color.black);
		setDoubleBuffered(true);
		player = new PlayerShip(shipNum);
		
		runGame();
		
	}

    @Override
    public void addNotify() {

        super.addNotify();
        runGame();
    }
	public void runGame() {
		
		for(int i = 0; i <4; i++) { 
			for(int ii = 0; ii < 6; ii ++) { 
				Aliens alien = new Aliens(ALIEN_START_POSX + 18 * ii, ALIEN_START_POSY + 18 * i);
				aliens.add(alien);
			}
			
			shot = new PlayerShot();
			if (spawner == null || !gameRunning) {
				spawner = new Thread(this);
				spawner.start();
			}
		}
		int x = 0;
		for(Aliens a : aliens) { 
			x ++;
			System.out.println(x);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}

//	}
//	
//	public void drawAlien(Graphics g) { 
//		
//		for (Aliens alien: aliens) { 
//			if(alien.isVisible()) { 
//				g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
//			}
//			
//			if (alien.isDying()) {
//				alien.spriteDeath();				// kills alien, makes them disappear
//			}
//		}
//	}
//	
//	public void drawPlayer(Graphics g) {
//		if (player.isVisible()) { 
//			g.drawImage(player.getImage(), player.getX(), player.getY(), this);
//		}
//		
//		if(player.isDying()) {
//			player.spriteDeath();
//			gameRunning = false;
//		}
//	}
//	
//	public void drawShot(Graphics g) { 
//		if (shot.isVisible()) { 
//			g.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);
//		}
//	}
//	
//	public void drawMissle(Graphics g) {
//		for(Aliens a : aliens) {
//			Missle m = a.getMissle();
//			
//			if(!m.isDestroyed()) { 
//				g.drawImage(m.getImage(),m.getX(), m.getY(), this);
//			}
//		}
//	}
//	
//	@Override
//	public void paintComponent(Graphics g) { 
//		super.paintComponent(g);
//		
//		g.setColor(Color.black);
//		g.fillRect(0, 0, BoardSize.width, BoardSize.height);
//		g.setColor(Color.green);
//		
//		if (gameRunning) {
//			g.drawLine(0, GROUND, (int) BoardSize.getWidth(), GROUND);
//			drawAlien(g);
//			drawPlayer(g);
//			drawShot(g);
//			drawMissle(g);
//		}
//		
//		Toolkit.getDefaultToolkit().sync();
//		g.dispose();
//	}
//	
//	public void gameOver() { 							//////////////////////////////////////////
//		Graphics g = this.getGraphics();
//		
//		g.setColor(Color.black);
//		g.fillRect(0, 0, (int)BoardSize.getWidth(), (int)BoardSize.getHeight());
//		
//		g.setColor(new Color(0,32,48));
//		g.fillRect(50, (int)BoardSize.getHeight()/ 2 - 30, (int)BoardSize.getWidth()- 100, 50);
//	    g.setColor(Color.white);
//	    g.drawRect(50, (int)BoardSize.getHeight() / 2 - 30, (int)BoardSize.getWidth() - 100, 50);
//	    
//	    Font small = new Font("Helvetica", Font.BOLD, 14);
//        FontMetrics metr = this.getFontMetrics(small);
//
//        g.setColor(Color.white);
//        g.setFont(small);
//        g.drawString(message, ((int)BoardSize.getWidth() - metr.stringWidth(message)) / 2,
//                (int)BoardSize.getWidth() / 2);
//	}
//	
//	public void animationCycle() { 
//		if(kills == 10) { 
//			gameRunning = false;
//			JOptionPane.showMessageDialog(null, "You won!");
//		} 
//		
//		player.spawn();
//		
//		if(shot.isVisible()) { 
//			int shotX = shot.getX();
//			int shotY = shot.getY();
//			for (Aliens alien: aliens) { 
//				int alienX = alien.getX();
//				int alienY = alien.getY();
//				
//					if (alien.isVisible() && shot.isVisible()) { 
//						if (shotX >= (alienX) 
//								&& shotX <= (alienX + ALIEN_WIDTH)
//								&& shotY >= (alienY)
//								&& shotY <= (alienY = ALIEN_HEIGHT)
//								) {
//							alien.setImage(alienExplode);
//							alien.kill(true);
//							kills++;
//							shot.spriteDeath();
//						}	
//					}
//				}
//			int y = shot.getY();
//			y -= 4;
//			
//			if(y < 0) { 
//				shot.spriteDeath();
//			} else { 
//				shot.setY(y);
//			}
//		}
//		
//		for (Aliens alien: aliens) { 
//			int x = alien.getX();
//			
//			if(x >= BoardSize.getWidth() - BORDER_RIGHT && x != -1) {
//				
//				direction = -1;
//				Iterator<Aliens> aliensIt = aliens.iterator();
//				
//				while(aliensIt.hasNext()) { 
//					Aliens a = (Aliens) aliensIt.next();
//					a.setY(a.getY() + GO_DOWN);
//				}
//			}
//			
//			if (x <= BORDER_LEFT && direction != 1) { 
//				direction = 1;
//				
//				Iterator<Aliens> aliensIt2 = aliens.iterator();
//				
//				while(aliensIt2.hasNext()) {
//					Aliens a = (Aliens) aliensIt2.next();
//					a.setY(a.getY() + GO_DOWN);
//				}	
//			}
//		}
//		
//		Iterator<Aliens> it = aliens.iterator();
//		
//		while(it.hasNext()) { 
//			Aliens alien = (Aliens) it.next();
//			
//			if (alien.isVisible()) {
//				int y = alien.getY();
//					if (y > GROUND - ALIEN_HEIGHT) { 
//						gameRunning = false;
//						JOptionPane.showMessageDialog(null, "INVASION! YOU LOSE");
//					}
//				alien.spawn(direction);
//			}
//		}
//		
//		Random rnd = new Random();
//		
//		for (Aliens alien: aliens) { 
//			int shot = rnd.nextInt(15);
//			Missle m = alien.getMissle();
//			
//			if(shot == CHANCE_FOR_SHOT && alien.isVisible() && m.isDestroyed()) { 
//				m.setDestroyed(false);
//				m.setX(alien.getX());
//				m.setY(alien.getY());
//			}
//			
//			int missleX = m.getX();
//			int missleY = m.getY();
//			int playerX = player.getX();
//			int playerY = player.getY();
//			
//			if(player.isVisible() && !m.isDestroyed()) {
//				if (missleX >= playerX 
//						&& missleX <= (playerX + PLAYER_WIDTH)
//						&& missleY >= playerY
//						&& missleY <= (playerY = PLAYER_HEIGHT)) {
//					player.setImage(shipExplode);
//					player.kill(true);
//					m.setDestroyed(true);
//				}
//			}
//			
//			if(!m.isDestroyed()) { 
//				m.setY(m.getY() + 1);
//				
//				if(m.getY() >= GROUND - MISSLE_HEIGHT) {
//					m.setDestroyed(true);
//				}
//			}		
//		}
//	}
//		
//	public void run() { 
//		long preTime, deltaTime, sleep;
//		
//		preTime = System.currentTimeMillis();
//		
//		while(gameRunning) {
//			repaint();
//			animationCycle();
//			
//			deltaTime = System.currentTimeMillis() - preTime;
//			sleep = DELAY - deltaTime;
//			
//			if (sleep < 0) { 
//				sleep = 2;
//			}
//			
//			try {
//				Thread.sleep(sleep);
//			} catch (InterruptedException e) { 
//				System.out.println("interrupted");
//			}
//			
//			preTime = System.currentTimeMillis();
//		}
//		
//		gameOver();
//	}
//
//	
//private class KeyEar extends KeyAdapter { 
//	@Override
//	public void keyPressed(KeyEvent e) {
//		player.keyPressed(e);
//		
//		int x = player.getX();
//		int y = player.getY();
//		
//		int key = e.getKeyCode();
//		
//		if(key == KeyEvent.VK_SPACE) {
//			if (gameRunning) {
//				if (!shot.isVisible()) { 
//					shot = new PlayerShot(x,y);
//				}
//			}
//		}
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) {
//		player.keyReleased(e);
//		}
//	}
//}

