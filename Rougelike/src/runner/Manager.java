package runner;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashSet;

import gui.Panel1;
import physical.Character;
import physical.Controls;
import physical.Map;
import physical.Monster;

public class Manager extends Thread {
	
	private Panel1 panel1;
	private boolean running;
	private Character character;
	private Map map;
	private Monster[][] monsterMap;

	public int stop = 0;
	public int stopClicked = 0;
	public int mouseX = 0;
	public int mouseY = 0;
	
	public Manager (Panel1 panel1, Map map) throws IOException {
		
		this.map = map;
		this.character = new Character();
		this.character.addMap(map);
		
		this.panel1 = panel1;
		this.panel1.addCharacter(character);
		
		this.running = true;
		
		this.monsterMap = this.map.getMonsterArray();
	}
	
	public void run() {
		while(running) {
			
			character.setVisibilitySquare();
			panel1.repaint();
			manageKeys();
			
			try {
				Thread.sleep(18);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void manageKeys() {
		HashSet<Integer> keys = Controls.getKeys();
		mouseX = (Controls.getX() - Map.TOP_LEFT_X) / Map.TILE_WIDTH;
		mouseY = (Controls.getY() - Map.TOP_LEFT_Y) / Map.TILE_WIDTH;
		
		panel1.setMouseX(mouseX);
		panel1.setMouseY(mouseY);
		
		boolean clicked = Controls.getClicked();
		
		if(!keys.contains(KeyEvent.VK_RIGHT) && !keys.contains(KeyEvent.VK_LEFT) && !keys.contains(KeyEvent.VK_UP) && !keys.contains(KeyEvent.VK_DOWN)
			&& !keys.contains(KeyEvent.VK_A) && !keys.contains(KeyEvent.VK_D) && !keys.contains(KeyEvent.VK_W) && !keys.contains(KeyEvent.VK_S)) {
			stop = 0;
		}
		if(stop == 0) {
		if(keys.contains(KeyEvent.VK_RIGHT) || keys.contains(KeyEvent.VK_D)) {
			character.moveCharacter(KeyEvent.VK_RIGHT);
			stop++;
			character.setVisibilitySquare();
		} else if(keys.contains(KeyEvent.VK_LEFT) || keys.contains(KeyEvent.VK_A)) {
			character.moveCharacter(KeyEvent.VK_LEFT);
			stop++;
			character.setVisibilitySquare();
		} else if(keys.contains(KeyEvent.VK_UP) || keys.contains(KeyEvent.VK_W)) {
			character.moveCharacter(KeyEvent.VK_UP);
			stop++;
			character.setVisibilitySquare();
		} else if(keys.contains(KeyEvent.VK_DOWN) || keys.contains(KeyEvent.VK_S)) {
			character.moveCharacter(KeyEvent.VK_DOWN);
			stop++;
			character.setVisibilitySquare();
		}}
		
		if(!clicked) {
			stopClicked = 0;
		}
		if(clicked && stopClicked == 0) {
			character.moveCharacterClick(mouseX, mouseY);
			stopClicked++;
		}
	
	}
	
	public Character getCharacter() {
		return character;
	}
}