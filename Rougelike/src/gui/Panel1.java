package gui;

import java.awt.Color;
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
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		/*for(int i = 0; i < 28; i++) {
			g2.setColor(Color.DARK_GRAY);
			g2.drawLine(0, i * 32, 1600, i * 32);
		}
		for(int j = 0; j < 50; j++) {
			g2.setColor(Color.DARK_GRAY);
			g2.drawLine(j * 32, 0, j*32, 900);
		}*/ 
		
		for(int c = 0; c < 50; c++) {
			for(int r = 0; r < 28; r++) {
				if(roomMap[c][r][1] == 1 ) {
					if(roomMap[c][r][0] == 1) {
						g2.drawImage(map.getTerrainTile(0), c * 32, r * 32, this);
					} else if (roomMap[c][r][0] == 2) {
						g2.drawImage(map.getTerrainTile(1), c * 32, r * 32, this);
					}
					if(monsterMap[c][r] != null) {
						g2.drawImage(monsterMap[c][r].getMonsterFrame(), c * 32, r * 32, this);
					}
				}
			}
		}
		
		
		g2.drawImage(character.getCharacterFrame(), character.getCharacterArrayX() * 32, character.getCharacterArrayY() * 32, this);
	}
	
	public void addCharacter(Character character) {
		this.character = character;
	}
}
