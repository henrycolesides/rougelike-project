package runner;

import java.io.IOException;

import gui.Frame;
import gui.Panel1;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Panel1 panel1 = new Panel1();
		
		Manager manager = new Manager(panel1);
		manager.start();
		
		Frame frame = new Frame(panel1);
	}	
}
