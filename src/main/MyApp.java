package main;

import java.awt.BorderLayout;

import methods.WriterReader;
import views.MainFrame;
import views.MainTabbedPane;
import views.MyMenuBar;
import views.MyStatusBar;
import views.MyToolBar;


public class MyApp {

	
	
	public static void main(String[] args) {
		
		try {
			WriterReader.getInstance().LoadData();
		}catch(Exception e) {
			
		}
		
		MainFrame mainFrame = MainFrame.getInstance();
		
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
	    

		WriterReader.getInstance().SaveData();
	}

}
