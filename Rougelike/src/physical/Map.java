package physical;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Map {
	
	public int[][][] tileMap;
	public BufferedImage[] terrain;
	
	public Monster[][] monsterMap;
	public BufferedImage[] monsters;
	
	public static final int NUM_COLS = 50;
	public static final int NUM_ROWS = 27;
	public static final int TILE_WIDTH = 32;
	public static final int TOP_LEFT_X = 0;
	public static final int TOP_LEFT_Y = 100;
	
	public int characterArrayX = 0;
	public int characterArrayY = 0;
	
	public Map() {
		tileMap = new int[NUM_COLS][NUM_ROWS][2];
		for(int i = 0; i < NUM_COLS; i++) {
			for(int j = 0; j < NUM_ROWS; j++) {
				tileMap[i][j][0] = 0;
			}
		}
		monsterMap = new Monster[NUM_COLS][NUM_ROWS];
		
		terrain = new BufferedImage[2];
		monsters = new BufferedImage[1];
		loadInformations();
		
		setupMap();
		for(int j = 0; j < NUM_COLS; j++) {
			setupMonsters();
		}
	}
	
	public void setupMap() {
		for(int k = 0; k < 8; k++) {
			generateRectangularRoom();
		}
		setupCharacter();
		for(int i = 0; i < 40; i++) {
			generateHorizontalHallway();
			generateVerticalHallway();
		}
		for(int j = 0; j < NUM_COLS; j++) {
			for(int l = 0; l < NUM_ROWS; l++) {
				tileMap[j][0][0] = 2;
				tileMap[0][l][0] = 2;
				tileMap[j][NUM_ROWS - 1][0] = 2;
				tileMap[NUM_COLS - 1][l][0] = 2;
				if(tileMap[j][l][0] != 1) {
					tileMap[j][l][0] = 2;
				}
			}
		}
	}
	
	public void generateRectangularRoom() {
		boolean flag1 = true;
		int height = 0, width = 0, x = 0, y = 0;
		while(flag1) {
			height = (int)(Math.random() * (8 - 4 + 1) + 4);
			width = (int)(Math.random() * (8 - 4 + 1) + 4);
			x = 0; 
			y = 0;
			boolean flag2 = true;
			while(flag2) {
				x = (int)(Math.random() * NUM_COLS);
				y = (int)(Math.random() * NUM_ROWS);
				if(x + width < NUM_COLS && x - width >= 0 && y + height < NUM_ROWS && y - height >= 0) {
					flag2 = false;
				}
			}
			int count = 0;
			for(int i = y; i < y + height; i++) {
				for(int j = x; j < x + width; j++) {
					if(tileMap[j][i][0] != 1) {
						count++;
					}
				}
			}
			if(count >= (height) * (width)) {
				flag1 = false;
			}
		}
		for(int i = y; i < y + height; i++) {
			for(int j = x; j < x + width; j++) {
				if(tileMap[j][i][0] != 1) {
					tileMap[j][i][0] = 1;
				}
			}
		}
	}
	
	public void generateVerticalHallway() {
		boolean flag1 = true;
		int x = 0, y = 0;
		String direction = "";
		while(flag1) {
			x = (int)(Math.random() * NUM_COLS);
			y = (int)(Math.random() * NUM_ROWS);
			if(tileMap[x][y][0] == 1) {
				if(y + 1 < NUM_ROWS && y - 1 >= 0 && x + 1 < NUM_COLS && x - 1 >= 0) {
					if(tileMap[x][y - 1][0] == 0 && tileMap[x - 1][y - 1][0] == 0 && tileMap[x + 1][y - 1][0] ==  0) {
						flag1 = false;
						direction = "up";
					} else if (tileMap[x][y + 1][0] == 0 && tileMap[x - 1][y + 1][0] == 0 && tileMap[x + 1][y + 1][0] ==  0) {
						flag1 = false;
						direction = "down";
					}
				}
			}
		}
		boolean flag2 = true;
		int count = 1;
		if(direction == "up") {
			while(flag2) {
				if(y - count >= 0) {
					if(tileMap[x][y - count][0] == 0) {
						tileMap[x][y - count][0] = 1;
						count++;
					} else {
						flag2 = false;
					}
				} else {
					flag2 = false;
				}
			}
		} else if (direction == "down") {
			while(flag2) {
				if(y + count < NUM_ROWS) {
					if(tileMap[x][y + count][0] == 0) {
						tileMap[x][y + count][0] = 1;
						count++;
					} else {
						flag2 = false;
					}
				} else {
					flag2 = false;
				}
			}
		}
	}
	
	public void generateHorizontalHallway() {
		boolean flag1 = true;
		int x = 0, y = 0;
		String direction = "";
		while(flag1) {
			x = (int)(Math.random() * NUM_COLS);
			y = (int)(Math.random() * NUM_ROWS);
			if(tileMap[x][y][0] == 1) {
				if(x + 1 < NUM_COLS && x - 1 >= 0 && y + 1 < NUM_ROWS && y - 1 >= 0) {
					if(tileMap[x - 1][y][0] == 0 && tileMap[x - 1][y - 1][0] == 0 && tileMap[x - 1][y + 1][0] ==  0) {
						flag1 = false;
						direction = "left";
					} else if (tileMap[x + 1][y][0] == 0 && tileMap[x + 1][y - 1][0] == 0 && tileMap[x + 1][y + 1][0] ==  0) {
						flag1 = false;
						direction = "right";
					}
				}
			}
		}
		boolean flag = true;
		int count = 1;
		if(direction == "left") {
			while(flag) {
				if(x - count >= 0) {
					if(tileMap[x - count][y][0] == 0) {
						tileMap[x - count][y][0] = 1;
						count++;
					} else {
						flag = false;
					}
				} else {
					flag = false;
				}
			}
		} else if (direction == "right") {
			while(flag) {
				if(x + count < NUM_COLS) {
					if(tileMap[x + count][y][0] == 0) {
						tileMap[x + count][y][0] = 1;
						count++;
					} else {
						flag = false;
					}
				} else {
					flag = false;
				}
			}
		}
	}
	
	public void setupMonsters() {
		boolean flag1 = true;
		int x = 0, y = 0;
		while(flag1) {
			x = (int)(Math.random() * NUM_COLS);
			y = (int)(Math.random() * NUM_ROWS);
			if(tileMap[x][y][0] == 1 && x != this.characterArrayX && y != this.characterArrayY) {
				flag1 = false;
			}
		}
		monsterMap[x][y] = new Red(x, y, monsters[0]);
	}
	
	public void setupCharacter() {
		boolean flag = true;
		int x = 0;
		int y = 0;
		int count = 0;
		while(flag) {
			x = (int)(Math.random() * NUM_COLS);
			y = (int)(Math.random() * NUM_ROWS);
			
			if(tileMap[x][y][0] == 1) {
				flag = false;
			}
		}
		this.characterArrayX = x;
		this.characterArrayY = y;
	}
	
	public void loadInformations() {
		
		try {
			
			terrain[0] = ImageIO.read(getClass().getResource("/block_tiles/ter0.png"));
			terrain[1] = ImageIO.read(getClass().getResource("/block_tiles/ter2.png"));
			
			monsters[0] = ImageIO.read(getClass().getResource("/monster_sprites/red.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getTerrainTile(int tileNumber) {
		return terrain[tileNumber];
	}
	
	public int[][][] getMap() {
		return tileMap;
	}
	
	public Monster[][] getMonsterArray() {
		return monsterMap;
	}
	
	public void setMonsterMap(Monster[][] monsterMap) {
		this.monsterMap = monsterMap;
	}
}
