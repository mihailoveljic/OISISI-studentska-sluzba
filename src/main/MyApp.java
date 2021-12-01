package main;

import java.awt.BorderLayout;

import views.MainFrame;
import views.MainTabbedPane;
import views.MyMenuBar;
import views.MyStatusBar;
import views.MyToolBar;
import views.SubjectAddFrame;

public class MyApp {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		
		// Meni bar
		MyMenuBar menuBar = new MyMenuBar();
	    mainFrame.setJMenuBar(menuBar);
	    
	    // Status bar
	    MyStatusBar statusBar = new MyStatusBar();
	    mainFrame.add(statusBar, BorderLayout.SOUTH);
	    
	    //Tool bar
	    MyToolBar toolBar= new MyToolBar();
	    mainFrame.add(toolBar,BorderLayout.PAGE_START);
	   
	    //Main Panel
	    MainTabbedPane mainTabbedPane = new MainTabbedPane();
	    mainFrame.add(mainTabbedPane, BorderLayout.CENTER);

	    
	    
	    
	    mainFrame.setVisible(true);
	}

}
