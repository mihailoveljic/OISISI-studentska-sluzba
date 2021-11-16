package views;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4412289993443911914L;

	public MainFrame() {
		super();

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		int width = d.width;
		int height = d.height;

		// Pravljenje prozora
		setSize(width*3/4, height*3/4);
		setLocationRelativeTo(null);
		setTitle("Studentska služba");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		setIconImage(icon);
		}
	}
