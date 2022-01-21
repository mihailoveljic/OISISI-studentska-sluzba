package views;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

public class ProfessorEditFrame extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ProfessorEditFrame instance;
	
	JTabbedPane tabbedPane;
	static ProfessorSubjectPanel professorSubjectPanel;
	
	private ProfessorEditFrame() {
		super();
		
		this.setModal (true);
		this.setAlwaysOnTop (true);
		this.setModalityType (ModalityType.APPLICATION_MODAL);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		int width = d.width;
		int height = d.height;
		
		setSize(width*2/5, height*3/5);
		setLocationRelativeTo(MainFrame.getInstance());
		setTitle("Izmena profesora");
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		setIconImage(icon);
		
		
		tabbedPane = new JTabbedPane();
		tabbedPane.add(ProfessorInfoPanel.getInstance(), MainFrame.getInstance().getResourceBundle().getString("info"));
		professorSubjectPanel = new ProfessorSubjectPanel();
		tabbedPane.add(professorSubjectPanel, MainFrame.getInstance().getResourceBundle().getString("subjects"));
		this.add(tabbedPane);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		
		
		
	}

	public ProfessorSubjectPanel getProfessorSubjectPanel() {
		return professorSubjectPanel;
	}
	
	
	public  static ProfessorEditFrame getInstance() {
		if(instance!=null) {
			instance.setLocationRelativeTo(MainFrame.getInstance());
			return instance;
		} else
			return instance = new ProfessorEditFrame();
	}
	

}
