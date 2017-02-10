package physical;

import java.awt.image.BufferedImage;

public class Monster {
	
	private int monsterHealth;
	private int monsterDamageMin;
	private int monsterDamageMax;
	private String monsterName;
	private int monsterArrayX;
	private int monsterArrayY;
	
	private BufferedImage monsterImage;
	
	public Monster(int health, int damageMin, int damageMax, String name, int x, int y, BufferedImage img) {
		this.monsterHealth = health;
		this.monsterDamageMin = damageMin;
		this.monsterDamageMax = damageMax;
		this.monsterName = name;
		
		this.monsterArrayX = x;
		this.monsterArrayY = y;
		
		this.monsterImage = img;
	}
	
	public int getDamageRoll() {
		return (int)(Math.random() * (monsterDamageMax - monsterDamageMin + 1) + monsterDamageMin);
	}
	
	public String getName() {
		return monsterName;
	}
	
	public int getHealth() {
		return monsterHealth;
	}
	
	public int getMonsterArrayX() {
		return monsterArrayX;
	}
	
	public int getMonsterArrayY() {
		return monsterArrayY;
	}
	
	public BufferedImage getMonsterFrame() {
		return monsterImage;
	}
	
	public void setMonsterFrame(BufferedImage tile) {
		this.monsterImage = tile;
	}
	
	public void setHealth(int damage) {
		this.monsterHealth -= damage;
	}
 }
