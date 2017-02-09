package runner;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashSet;

import gui.Panel1;
import physical.Character;
import physical.Controls;

public class Manager extends Thread {
	
	private Panel1 panel1;
	private boolean running;
	private Character character;

	public int stop = 0;
	public int combatInitiated = 0;
	
	public Manager (Panel1 panel1) throws IOException {
		
		this.character = new Character();
		this.panel1 = panel1;
		this.panel1.addCharacter(character);
		
		this.running = true;
	}
	
	public void run() {
		while(running) {
			
			panel1.repaint();
			if(combatInitiated == 1) {
				
			}
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
		} else if(keys.contains(KeyEvent.VK_LEFT)) {
			character.moveCharacter(KeyEvent.VK_LEFT);
			stop++;
		} else if(keys.contains(KeyEvent.VK_UP)) {
			character.moveCharacter(KeyEvent.VK_UP);
			stop++;
		} else if(keys.contains(KeyEvent.VK_DOWN)) {
			character.moveCharacter(KeyEvent.VK_DOWN);
			stop++;
		}}}
	
	public Character getCharacter() {
		return character;
	}
	
	public void setCombat(int combatNumber) {
		this.combatInitiated = combatNumber;
	}
	
}