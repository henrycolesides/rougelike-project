package gui;

import javax.swing.JFrame;

public class Frame extends JFrame {
	
	private static final long serialVersionUID = 1L;
			
	public static final int FRAME_WIDTH = 1606;
	public static final int FRAME_HEIGHT = 926;
	
	public Frame(Panel1 panel1) {
		
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		this.setVisible(true);
		this.setResizable(false);
		
		this.setTitle("Roguelike");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(panel1);
		panel1.grabFocus();
		panel1.requestFocusInWindow();
		
	}
}
