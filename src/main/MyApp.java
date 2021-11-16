package main;

import java.awt.BorderLayout;

import views.MainFrame;
import views.MyMenuBar;
import views.MyStatusBar;

public class MyApp {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		
		// Meni bar
		MyMenuBar menuBar = new MyMenuBar();
	    mainFrame.setJMenuBar(menuBar);
	    
	    // Status bar
	    MyStatusBar statusBar = new MyStatusBar();
	    mainFrame.add(statusBar, BorderLayout.SOUTH);
	    
	    mainFrame.setVisible(true);
	}

}
