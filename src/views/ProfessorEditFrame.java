package views;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

public class ProfessorEditFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ProfessorEditFrame instance;
	
	private ProfessorEditFrame() {
		super();
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		int width = d.width;
		int height = d.height;
		
		setSize(width*1/4, height*3/4);
		setLocationRelativeTo(MainFrame.getInstance());
		setTitle("Izmena profesora");
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		setIconImage(icon);
		
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.add(ProfessorInfoPanel.getInstance(), "Informacije");
		tabbedPane.add(ProfessorSubjectPanel.getInstance(), "Predmeti");
		this.add(tabbedPane);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		
		
		
	}
	
	public  static ProfessorEditFrame getInstance() {
		if(instance!=null) {
			instance.setLocationRelativeTo(MainFrame.getInstance());
			return instance;
		} else
			return instance = new ProfessorEditFrame();
	}
	

}
