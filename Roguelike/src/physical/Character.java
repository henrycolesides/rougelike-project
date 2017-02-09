package physical;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Character {
	
	public int characterArrayX = 10;
	public int characterArrayY = 10;
	public int stop = 10;
	
	private BufferedImage idle;
	
	public Character() {
		
		loadAnimations();
	}
	
	public void moveCharacter(int direction) {
		
		switch(direction) {
		
		case KeyEvent.VK_LEFT:
			
		characterArrayX--;
		
		break;
		
		case KeyEvent.VK_RIGHT:
		
		characterArrayX++;
		
		break;
		
		case KeyEvent.VK_UP:
		
		characterArrayY--;
		
		break;
		
		case KeyEvent.VK_DOWN:
		
		characterArrayY++;
		
		break;
			
		default: break;
		
		}
	}
	
	public void loadAnimations() {
		
		try {
			
		idle = ImageIO.read(getClass().getResource("/character_idle/chicken_idle.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getCharacterFrame() {
		return idle;
	}
	
	public int getCharacterArrayX() {
		return characterArrayX;
	}
	
	public int getCharacterArrayY() {
		return characterArrayY;
	}

}
