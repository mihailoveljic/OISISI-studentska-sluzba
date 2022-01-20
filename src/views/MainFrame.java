 package views;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import methods.WriterReader;
import models.DbSubjects;
import models.Subject;

public class MainFrame extends JFrame{
	
	
	private ResourceBundle resourceBundle;
	
	private static final long serialVersionUID = 4412289993443911914L;

		private static MainFrame instance;
		private MainFrame()
		{	
		super();
		
		Locale.setDefault(new Locale("sr", "RS"));
		resourceBundle = ResourceBundle.getBundle("main.languages.language", Locale.getDefault());
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		int width = d.width;
		int height = d.height;

		setSize(width*3/4, height*3/4);
		setLocationRelativeTo(null);
		setTitle(resourceBundle.getString("mainFrameTitle"));
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
				int userInput = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li želite da saèuvate izmene pre zatvaranja?",
						"Èuvanje izmena", JOptionPane.YES_NO_OPTION);
				if (userInput == JOptionPane.YES_OPTION) {
					WriterReader.getInstance().SaveData();
					}
				MainFrame.getInstance().dispose();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		setIconImage(icon);
		}
		
		public static MainFrame getInstance ()
		{
			if(instance==null)
				instance= new MainFrame();
			return instance;
		}
		
	}
