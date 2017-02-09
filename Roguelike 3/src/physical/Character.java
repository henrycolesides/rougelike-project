package physical;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Character {
	
	public int characterArrayX = 10;
	public int characterArrayY = 10;
	public int stop = 10;
	public int[][] roomMap;
	private Map map;
	
	private BufferedImage idle;
	
	public Character() {
		
		loadAnimations();
		
		map = new Map();
		roomMap = map.getMap();
	}
	
	public void moveCharacter(int direction) {
		
		switch(direction) {
		
		case KeyEvent.VK_LEFT:
		
		if(roomMap[characterArrayX - 1][characterArrayY] == 1) {
			characterArrayX--;
		}
		
		break;
		
		case KeyEvent.VK_RIGHT:
		
		if(roomMap[characterArrayX + 1][characterArrayY] == 1) {
			characterArrayX++;
		}
		
		break;
		
		case KeyEvent.VK_UP:
		
		if(roomMap[characterArrayX][characterArrayY - 1] == 1) {
			characterArrayY--;
		}
		
		break;
		
		case KeyEvent.VK_DOWN:
		
		if(roomMap[characterArrayX][characterArrayY + 1] == 1) {
			characterArrayY++;
		}
		
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
