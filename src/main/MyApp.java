package main;

import views.MainFrame;
import views.MyMenuBar;

public class MyApp {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		
		// Meni bar
		MyMenuBar menuBar = new MyMenuBar();
	    mainFrame.setJMenuBar(menuBar);
	    
	    mainFrame.setVisible(true);
	}

}
