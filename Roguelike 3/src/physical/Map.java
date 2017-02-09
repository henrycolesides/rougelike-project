package physical;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Map {
	
	public int[][] tileMap;
	public BufferedImage[] terrain;
	
	public int[][] monsterMap;
	public BufferedImage[] monsters;
	
	public Map() {
		tileMap = new int[28][50];
		for(int i = 0; i < 28; i++) {
			for(int j = 0; j < 50; j++) {
				tileMap[i][j] = 0;
			}
		}
		monsterMap = new int[28][50];
		
		terrain = new BufferedImage[2];
		monsters = new BufferedImage[1];
		loadInformations();
		
		setMap();
		setMonsterMap();
	}
	
	public void setMap() {
		for(int i = 0; i < 10; i++) {
			tileMap[10][10 + i] = 1;
			tileMap[10 + i][10] = 1;
		}
	}
	
	public void setMonsterMap() {
		Monster red = new Red();
		monsterMap[red.getMonsterArrayX()][red.getMonsterArrayY()] = 1;
	}
	
	public void loadInformations() {
		
		try {
			
			terrain[0] = ImageIO.read(getClass().getResource("/block_tiles/ter0.png"));
			terrain[1] = ImageIO.read(getClass().getResource("/block_tiles/ter1.png"));
			
			monsters[0] = ImageIO.read(getClass().getResource("/monster_sprites/red.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getTerrainTile(int tileNumber) {
		return terrain[tileNumber];
	}
	
	public int[][] getMap() {
		return tileMap;
	}
	
	public BufferedImage getMonsterSprites(int monsterNumber) {
		return monsters[monsterNumber];
	}
	
	public int[][] getMonsterArray() {
		return monsterMap;
	}
}
