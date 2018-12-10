package mp;

import javax.swing.*;

public class MainView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	protected int windowWidth = 500;
	protected int windowHeight = 500;
	
	public MainView(String name) {
		super(name);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(this.windowWidth, this.windowHeight);
	}
}
