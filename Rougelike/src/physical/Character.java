package physical;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Character {
	
	public int characterArrayX = 10;
	public int characterArrayY = 10;
	
	public int characterHealth = 20;
	public int characterDamageMin = 4;
	public int characterDamageMax = 8;
	
	public int combatInitiated = 0;
	public int[][][] roomMap;
	public Monster[][] monsterMap;
	public Map map;
	
	private BufferedImage idle;
	
	public Character() {
		
		loadAnimations();

	}
	
	public void moveCharacter(int direction) {

		switch(direction) {
		
		case KeyEvent.VK_LEFT:
		
		if(monsterMap[characterArrayX - 1][characterArrayY] != null){
			combat(monsterMap[characterArrayX - 1][characterArrayY]);
		} else if (roomMap[characterArrayX - 1][characterArrayY][0] == 1) {
			characterArrayX--;
		}
		
		break;
		
		case KeyEvent.VK_RIGHT:
		
		if(monsterMap[characterArrayX + 1][characterArrayY] != null) {
			combat(monsterMap[characterArrayX + 1][characterArrayY]);
		} else if (roomMap[characterArrayX + 1][characterArrayY][0] == 1) {
			characterArrayX++;
		}
		
		break;
		
		case KeyEvent.VK_UP:
		
		if(monsterMap[characterArrayX][characterArrayY - 1] != null) {
			combat(monsterMap[characterArrayX][characterArrayY - 1]);
		} else if (roomMap[characterArrayX][characterArrayY - 1][0] == 1) {
			characterArrayY--;
		}
		
		break;
		
		case KeyEvent.VK_DOWN:
		
		if(monsterMap[characterArrayX][characterArrayY + 1] != null) {
			combat(monsterMap[characterArrayX][characterArrayY + 1]);
		} else if (roomMap[characterArrayX][characterArrayY + 1][0] == 1) {
			characterArrayY++;
		}
		
		break;
			
		default: break;
		
		}
	}
	
	public void setVisibilitySquare() {
		for(int i = -1; i <= 1; i++) {
			for(int j = -1; j <= 1; j++) {
				roomMap[characterArrayX + i][characterArrayY + j][1] = 1;
			}
		}
	}
	
	public void combat(Monster enemy) {
		enemy.setHealth(getDamageRoll());
		characterHealth -= enemy.getDamageRoll();
		
		if(enemy.getHealth() <= 0) {
			monsterMap[enemy.getMonsterArrayX()][enemy.getMonsterArrayY()] = null;
			map.setMonsterMap(monsterMap);
		}
	}
	
	public int getDamageRoll() {
		return (int)(Math.random() * (characterDamageMax - characterDamageMin + 1) + characterDamageMin);
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
	
	public void setCharacterArrayX(int x) {
		this.characterArrayX = x;
	}
	
	public void setCharacterArratY(int y) {
		this.characterArrayY = y;
	}
	
	public int getCombat() {
		return combatInitiated;
	}
	
	public void addMap(Map map) {
		this.map = map;
		roomMap = this.map.getMap();
		monsterMap = this.map.getMonsterArray();
		
		this.characterArrayX = map.characterArrayX;
		this.characterArrayY = map.characterArrayY;
	}

}
