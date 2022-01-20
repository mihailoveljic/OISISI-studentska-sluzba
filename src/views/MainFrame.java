 package views;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

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
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
