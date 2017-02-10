package runner;

import java.io.IOException;

import gui.Frame;
import gui.Panel1;
import physical.Map;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		Map map = new Map();
		Panel1 panel1 = new Panel1(map);
		
		Manager manager = new Manager(panel1, map);
		manager.start();
		
		Frame frame = new Frame(panel1);
	}	
}
