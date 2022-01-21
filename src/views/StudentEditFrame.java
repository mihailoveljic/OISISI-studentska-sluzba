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



public class StudentEditFrame extends JDialog{

		
		/**
		 * 
		 */
	private static final long serialVersionUID = -919912894941283074L;
	private static StudentEditFrame instance;
	
	private StudentEditFrame() {
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
		setTitle(MainFrame.getInstance().getResourceBundle().getString("editStudent"));
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		setIconImage(icon);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		StudentInfoPanel studentInfoPanel = StudentInfoPanel.getInstance();
		StudentGradesPanel studentGradesPanel = StudentGradesPanel.getInstance();
		StudentSubjectsPanel studentSubjectsPanel = StudentSubjectsPanel.getInstance();
		

		tabbedPane.add(studentInfoPanel, MainFrame.getInstance().getResourceBundle().getString("info"));
		tabbedPane.add(studentGradesPanel, MainFrame.getInstance().getResourceBundle().getString("passed"));
		tabbedPane.add(studentSubjectsPanel, MainFrame.getInstance().getResourceBundle().getString("notPassed"));
		
		this.add(tabbedPane);
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
				StudentPanel.getInstance().updateView();
				StudentEditFrame.getInstance().dispose();
				
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
	}
	
	public static StudentEditFrame getInstance()
	{
		if(instance == null)
			instance = new StudentEditFrame();
		instance.setLocationRelativeTo(MainFrame.getInstance());
		return instance;
	}
	public static void recreate() {
		if(instance != null)
			instance.dispose();
		instance = null;
	}
}
