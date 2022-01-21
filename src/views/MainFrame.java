 package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import methods.WriterReader;
import models.DbDepartments;
import models.DbProfessors;
import models.DbStudents;
import models.DbSubjects;

public class MainFrame extends JFrame{
	
	
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	public void setResourceBundle(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
	}

	private ResourceBundle resourceBundle;
	
	private static final long serialVersionUID = 4412289993443911914L;

		private static MainFrame instance;
		private MainFrame()
		{	
		super();
		
		initGUI();
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		int width = d.width;
		int height = d.height;

		setSize(width*3/4, height*3/4);
		setLocationRelativeTo(null);
		setTitle(resourceBundle.getString("studentServices"));
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
				
				int userInput = JOptionPane.showConfirmDialog(MainFrame.getInstance(), resourceBundle.getString("saveChangesOnExit"),
						resourceBundle.getString("saveChangesOnExitTitle"), JOptionPane.YES_NO_OPTION);
				if (userInput == JOptionPane.YES_OPTION) {
					WriterReader.getInstance().SaveData();
					MainFrame.getInstance().dispose();
					System.exit(0);
					}
				else if(userInput==JOptionPane.NO_OPTION) {
					MainFrame.getInstance().dispose();
					System.exit(0);
				}
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				
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
		
		public void changeLanguage() {
			resourceBundle = ResourceBundle.getBundle("main.languages.language", Locale.getDefault());
			MainFrame.getInstance().reloadUI();
			MyStatusBar myStatusBar =  (MyStatusBar) instance.getContentPane().getComponent(0);
			myStatusBar.reloadUI();
			MyMenuBar menuBar = new MyMenuBar();
		    instance.setJMenuBar(menuBar);
		    MyToolBar myToolBar = (MyToolBar) instance.getContentPane().getComponent(1);
		    myToolBar.reloadUI();
		    instance.getContentPane().remove(2);
		    MainTabbedPane mainTabbedPane = new MainTabbedPane();
		    instance.add(mainTabbedPane, BorderLayout.CENTER);

		    DbStudents.getInstance().reloadUI();
		    DbProfessors.getInstance().reloadUI();
		    DbSubjects.getInstance().reloadUI();
		    DbDepartments.getInstance().reloadUI();
		    
		    StudentTable.getInstance().reloadUI();
		    ProfessorTable.getInstance().reloadUI();
		    SubjectTable.getInstance().reloadUI();
		    
		    StudentPanel.getInstance().reloadUI();
		    ProfessorPanel.getInstance().reloadUI();
		    SubjectPanel.getInstance().reloadUI();
		    
		    StudentAddFrame.recreate();
		    StudentInfoPanel.recreate();
		    StudentSubjectsPanel.recreate();
		    StudentGradesPanel.recreate();
		    StudentEditFrame.recreate();
		    
		    ProfessorAddFrame.recreate();
		    ProfessorInfoPanel.recreate();
		    ProfessorEditFrame.recreate();
		    
		    
		    SubjectAddFrame.recreate();
		    SubjectEditFrame.recreate();
		    
		    instance.update(getGraphics());
			}
		
		private void reloadUI() {
			setTitle(resourceBundle.getString("studentServices"));
			
			UIManager.put("OptionPane.yesButtonText", resourceBundle.getString("yes"));
			UIManager.put("OptionPane.noButtonText", resourceBundle.getString("no"));
			UIManager.put("OptionPane.okButtonText", resourceBundle.getString("ok"));
			UIManager.put("OptionPane.cancelButtonText", resourceBundle.getString("cancel"));
		}

		public void initGUI() {
			Locale.setDefault(new Locale("sr", "RS"));
			resourceBundle = ResourceBundle.getBundle("main.languages.language", Locale.getDefault());
			
			UIManager.put("OptionPane.yesButtonText", resourceBundle.getString("yes"));
			UIManager.put("OptionPane.noButtonText", resourceBundle.getString("no"));
			UIManager.put("OptionPane.okButtonText", resourceBundle.getString("ok"));
			UIManager.put("OptionPane.cancelButtonText", resourceBundle.getString("cancel"));
		}
	}
