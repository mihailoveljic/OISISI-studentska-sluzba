package views;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
		setTitle(MainFrame.getInstance().getResourceBundle().getString("editProfessor"));
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		setIconImage(icon);
		
		
		tabbedPane = new JTabbedPane();
		tabbedPane.add(ProfessorInfoPanel.getInstance(), MainFrame.getInstance().getResourceBundle().getString("info"));
		professorSubjectPanel = new ProfessorSubjectPanel();
		tabbedPane.add(professorSubjectPanel, MainFrame.getInstance().getResourceBundle().getString("subjects"));
		this.add(tabbedPane);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				ProfessorPanel.getInstance().updateView();
				dispose();
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				
			}
		});
		
		
		
		
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
	public static void recreate() {
		if(instance != null)
			instance.dispose();
		instance = null;
	}

}
