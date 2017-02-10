package physical;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Red extends Monster {
	
	public static int health = 10;
	public static int damageMin = 1;
	public static int damageMax = 4;
	public static String monsterName = "Red";
	
	public Red(int x, int y, BufferedImage img) {
		super(health, damageMin, damageMax, monsterName, x, y, img);
		
	}
}
