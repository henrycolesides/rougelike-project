package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import physical.Map;
import physical.Monster;
import physical.Character;
import physical.Controls;

public class Panel1 extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public Map map;
	int[][][] roomMap;
	Monster[][] monsterMap;
	
	int mouseX = 0;
	int mouseY = 0;
	
	private Character character;
	private Controls controls;
	
	public Panel1(Map map) {
		
		this.setRequestFocusEnabled(true);
		this.setSize(Frame.FRAME_WIDTH, Frame.FRAME_HEIGHT);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		
		this.map = map;
		
		roomMap = this.map.getMap();
		monsterMap = this.map.getMonsterArray();
		
		controls = new Controls();
		this.addKeyListener(controls);
		this.addMouseListener(controls);
		this.addMouseMotionListener(controls);
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		paintUI(g2);
		/*for(int i = 0; i < 28; i++) {
			g2.setColor(Color.DARK_GRAY);
			g2.drawLine(0, i * 32, 1600, i * 32);
		}
		for(int j = 0; j < 50; j++) {
			g2.setColor(Color.DARK_GRAY);
			g2.drawLine(j * 32, 0, j*32, 900);
		}*/ 
		
		for(int c = 0; c < Map.NUM_COLS; c++) {
			for(int r = 0; r < Map.NUM_ROWS; r++) {
				if(roomMap[c][r][1] == 1 ) {
					if(roomMap[c][r][0] == 1) {
						g2.drawImage(map.getTerrainTile(0), (c * Map.TILE_WIDTH) + Map.TOP_LEFT_X, (r * Map.TILE_WIDTH) + Map.TOP_LEFT_Y, this);
					} else if (roomMap[c][r][0] == 2) {
						g2.drawImage(map.getTerrainTile(1), (c * Map.TILE_WIDTH) + Map.TOP_LEFT_X, (r * Map.TILE_WIDTH) + Map.TOP_LEFT_Y, this);
					}
					if(monsterMap[c][r] != null) {
						g2.drawImage(monsterMap[c][r].getMonsterFrame(), (c * Map.TILE_WIDTH) + Map.TOP_LEFT_X, (r * Map.TILE_WIDTH) + Map.TOP_LEFT_Y, this);
					}
				}
			}
		}
		
		
		g2.drawImage(character.getCharacterFrame(), (character.getCharacterArrayX() * Map.TILE_WIDTH) + Map.TOP_LEFT_X, (character.getCharacterArrayY() * Map.TILE_WIDTH) + Map.TOP_LEFT_Y, this);
	}
	
	public void paintUI(Graphics2D g2) {
		
		g2.setColor(Color.BLACK);
		g2.drawRect(0, 0, Frame.FRAME_WIDTH, Map.TOP_LEFT_Y - 2);
		g2.fillRect(0, 0, Frame.FRAME_WIDTH, Map.TOP_LEFT_Y - 2);
		
		g2.setColor(Color.WHITE);
		g2.setFont(new Font("MonospacedPlain", Font.PLAIN, 20));
		
		//painting character stats
		String characterHealth = Integer.toString(character.getCharacterHealth());
		g2.drawString("HEALTH: " + characterHealth, 5, 20);
		
		String characterDamageMin = Integer.toString(character.getCharacterDamageRange()[0]);
		String characterDamageMax = Integer.toString(character.getCharacterDamageRange()[1]);
		g2.drawString("ATTACK: " + characterDamageMin + "-" + characterDamageMax, 5, 40);
		
		//painting monster stats
		int monsterHealth = 0;
		int[] monsterDamageRange = new int[2];
		
		if(mouseX >= 0 && mouseX < Map.NUM_COLS && mouseY >= 0 && mouseY < Map.NUM_ROWS) {
			if(monsterMap[mouseX][mouseY] != null && roomMap[mouseX][mouseY][1] == 1) {
				monsterHealth = monsterMap[mouseX][mouseY].getHealth();
				monsterDamageRange = monsterMap[mouseX][mouseY].getMonsterDamageRange();
				String monsterHealthString = Integer.toString(monsterHealth);
				g2.drawString("HEALTH: " + monsterHealth, 1475, 20);
				g2.drawString("ATTACK: " + monsterDamageRange[0] + "-" + monsterDamageRange[1], 1475, 40);
			}
		}	
	}
	
	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}
	
	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}
	
	public void addCharacter(Character character) {
		this.character = character;
	}
}
