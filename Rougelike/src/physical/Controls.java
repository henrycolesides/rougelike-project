package physical;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashSet;

public class Controls implements KeyListener, MouseListener, MouseMotionListener{
	
	public static HashSet<Integer> keys;
	public static int x;
	public static int y;
	public static boolean clicked = false;
	public Character character = new Character();
	public static int stop = 0;
	
	public static HashSet<Integer> getKeys(){
		return keys;
	}
	
	public static int getX() {
		return x;
	}
	
	public static int getY() {
		return y;
	}
	
	public static boolean getClicked() {
		return clicked;
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

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		clicked = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		clicked = false;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
	
}
