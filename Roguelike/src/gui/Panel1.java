package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import physical.Map;
import physical.Character;
import physical.Controls;

public class Panel1 extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public Map map;
	int[][] roomMap;
	
	private Character character;
	private Controls controls;
	
	public Panel1() {
		
		this.setRequestFocusEnabled(true);
		this.setSize(Frame.FRAME_WIDTH, Frame.FRAME_HEIGHT);
		this.setLayout(null);
		this.setBackground(Color.CYAN);
	
		map = new Map();
		roomMap = map.getMap();
		
		controls = new Controls();
		this.addKeyListener(controls);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		for(int i = 0; i < 28; i++) {
			g2.setColor(Color.white);
			g2.drawLine(0, i * 32, 1600, i * 32);
		}
		for(int j = 0; j < 50; j++) {
			g2.setColor(Color.white);
			g2.drawLine(j * 32, 0, j*32, 900);
		}
		
		for(int r = 0; r < 28; r++) {
			for(int c = 0; c < 50; c++) {
				if(roomMap[r][c] == 1 ){
					g2.drawImage(map.getTerrainTile(0), r * 32, c * 32, this);
				}
			}
		}
		
		g2.drawImage(character.getCharacterFrame(), character.getCharacterArrayX() * 32, character.getCharacterArrayY() * 32, this);
	}
	
	public void addCharacter(Character character) {
		this.character = character;
	}
}
