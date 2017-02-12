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

	public int stop = 0;
	
	public Manager (Panel1 panel1, Map map) throws IOException {
		
		this.map = map;
		this.character = new Character();
		this.character.addMap(map);
		
		this.panel1 = panel1;
		this.panel1.addCharacter(character);
		
		this.running = true;
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
		
		if(!keys.contains(KeyEvent.VK_RIGHT) && !keys.contains(KeyEvent.VK_LEFT) && !keys.contains(KeyEvent.VK_UP) && !keys.contains(KeyEvent.VK_DOWN)) {
			stop = 0;
		}
		if(stop == 0) {
		if(keys.contains(KeyEvent.VK_RIGHT)) {
			character.moveCharacter(KeyEvent.VK_RIGHT);
			stop++;
			character.setVisibilitySquare();
		} else if(keys.contains(KeyEvent.VK_LEFT)) {
			character.moveCharacter(KeyEvent.VK_LEFT);
			stop++;
			character.setVisibilitySquare();
		} else if(keys.contains(KeyEvent.VK_UP)) {
			character.moveCharacter(KeyEvent.VK_UP);
			stop++;
			character.setVisibilitySquare();
		} else if(keys.contains(KeyEvent.VK_DOWN)) {
			character.moveCharacter(KeyEvent.VK_DOWN);
			stop++;
			character.setVisibilitySquare();
		}}
	}
	
	public Character getCharacter() {
		return character;
	}
}