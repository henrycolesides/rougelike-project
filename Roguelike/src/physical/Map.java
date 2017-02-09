package physical;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Map {
	
	public int[][] map;
	public BufferedImage[] terrain;
	
	public Map() {
		map = new int[28][50];
		for(int i = 0; i < 28; i++) {
			for(int j = 0; j < 50; j++) {
				map[i][j] = 0;
			}
		}
		
		terrain = new BufferedImage[2];
		loadInformations();
		
		setMap();
	}
	
	public void setMap() {
		for(int i = 0; i < 10; i++) {
			map[10][10 + i] = 1;
			map[10 + i][10] = 1;
		}
	}
	
	public void loadInformations() {
		
		try {
			
			terrain[0] = ImageIO.read(getClass().getResource("/block_tiles/ter0.png"));
			terrain[1] = ImageIO.read(getClass().getResource("/block_tiles/ter1.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getTerrainTile(int tile) {
		return terrain[tile];
	}
	
	public int[][] getMap() {
		return map;
	}
}
