package views;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JDialog;
import javax.swing.WindowConstants;

public class DepartmentsMainDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3230224877628169512L;

	public DepartmentsMainDialog() {
		super();
		this.setModal (true);
		this.setAlwaysOnTop (true);
		this.setModalityType (ModalityType.APPLICATION_MODAL);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		int width = d.width;
		int height = d.height;

		// Pravljenje prozora
		setSize(width*2/5, height*2/4);
		setLocationRelativeTo(MainFrame.getInstance());
		setTitle(MainFrame.getInstance().getResourceBundle().getString("studentEdit"));
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		setIconImage(icon);
		
		DepartmentsPanel deparmentsPanel = new DepartmentsPanel();
		
		this.add(deparmentsPanel);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
}
