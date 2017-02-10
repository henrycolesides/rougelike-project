package physical;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Map {
	
	public int[][] tileMap;
	public BufferedImage[] terrain;
	
	public Monster[][] monsterMap;
	public BufferedImage[] monsters;
	
	public int characterArrayX = 0;
	public int characterArrayY = 0;
	
	public Map() {
		tileMap = new int[50][28];
		for(int i = 0; i < 50; i++) {
			for(int j = 0; j < 28; j++) {
				tileMap[i][j] = 0;
			}
		}
		monsterMap = new Monster[50][28];
		
		terrain = new BufferedImage[2];
		monsters = new BufferedImage[1];
		loadInformations();
		
		setupMap();
		setupMonsters();
	}
	
	public void setupMap() {
		for(int i = 0; i < 10; i++) {
			generateRectangularRoom();
		}
		setupCharacter();
	}
	
	public void generateRectangularRoom() {
		boolean flag1 = true;
		int height = 0, width = 0, x = 0, y = 0;
		while(flag1) {
			height = (int)(Math.random() * (8 - 2 + 1) + 2);
			width = (int)(Math.random() * (8 - 2 + 1) + 2);
			x = 0; 
			y = 0;
			boolean flag2 = true;
			while(flag2) {
				x = (int)(Math.random() * 50);
				if(x + width < 50 && x - width >= 0) {
					flag2 = false;
				}
			}
			boolean flag3 = true;
			while(flag3) {
				y = (int)(Math.random() * 28);
				if(y + height < 28 && y - height >= 0) {
					flag3 = false;
				}
			}
			int count = 0;
			for(int i = y; i < y + height; i++) {
				for(int j = x; j < x + width; j++) {
					if(tileMap[j][i] != 1) {
						count++;
					}
				}
			}
			if(count >= height * width) {
				flag1 = false;
			}
		}
		for(int i = y; i < y + height; i++) {
			for(int j = x; j < x + width; j++) {
				if(tileMap[j][i] != 1) {
					tileMap[j][i] = 1;
				}
			}
		}
	}
	
	public void setupMonsters() {
		int x = (int)(Math.random() * 50);
		int y = (int)(Math.random() * 28);
		/*Monster red1 = new Red(15, 10, monsters[0]);
		monsterMap[red1.getMonsterArrayX()][red1.getMonsterArrayY()] = red1;
		
		Monster red2 = new Red(10, 15, monsters[0]);
		monsterMap[red2.getMonsterArrayX()][red2.getMonsterArrayY()] = red2;*/
	}
	
	public void setupCharacter() {
		boolean flag = true;
		int x = 0;
		int y = 0;
		while(flag) {
			x = (int)(Math.random() * 50);
			y = (int)(Math.random() * 28);
			
			if(tileMap[x][y] == 1) {
				flag = false;
			}
		}
		this.characterArrayX = x;
		this.characterArrayY = y;
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
	
	public Monster[][] getMonsterArray() {
		return monsterMap;
	}
	
	public void setMonsterMap(Monster[][] monsterMap) {
		this.monsterMap = monsterMap;
	}
}
