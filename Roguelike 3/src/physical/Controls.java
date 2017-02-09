package physical;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

public class Controls implements KeyListener{
	
	public static HashSet<Integer> keys;
	public Character character = new Character();
	public static int stop = 0;
	
	public static HashSet<Integer> getKeys(){
		return keys;
	}
	
	public Controls(){
		keys = new HashSet<Integer>();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(keys.contains(e.getKeyCode())) {
		} else {
			keys.add(e.getKeyCode());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys.remove(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
}
