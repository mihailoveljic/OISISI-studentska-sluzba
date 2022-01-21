package views;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainTabbedPane extends JTabbedPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5351564682657896302L;
	

	public MainTabbedPane() {
		super();

		StudentPanel studentPanel = StudentPanel.getInstance();
		ProfessorPanel professorPanel = ProfessorPanel.getInstance();

		//JPanel subjects_panel = new JPanel();
		
		//studentPanel.setPreferredSize(getSize());

		//this.add("Studenti", studentPanel);
		//this.add("Profesori", professorPanel);
		//this.add("Predmeti", subjects_panel);

		SubjectPanel subjectPanel = SubjectPanel.getInstance();

		this.add(MainFrame.getInstance().getResourceBundle().getString("students"), studentPanel);
		this.add(MainFrame.getInstance().getResourceBundle().getString("professors"), professorPanel);
		this.add(MainFrame.getInstance().getResourceBundle().getString("subjects"), subjectPanel);
		
		this.addChangeListener(new TabChangeListener(this));
	}
	
}


class TabChangeListener implements ChangeListener{

	private MainTabbedPane tabbedPane;
	
	public TabChangeListener(MainTabbedPane tabbedPane) {
		super();
		this.tabbedPane = tabbedPane;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
		MainFrame mainFrame = MainFrame.getInstance();
		
		JPanel panel = (JPanel) mainFrame.getContentPane();
		
		MyStatusBar statusBar = (MyStatusBar) panel.getComponent(0);
		
		int selectedIndex = tabbedPane.getSelectedIndex();
		JLabel label = (JLabel) statusBar.getComponent(0);
		
		switch(selectedIndex) {
			case 0:
				label.setText(MainFrame.getInstance().getResourceBundle().getString("studentServicesStudents"));
				break;
			case 1:
				label.setText(MainFrame.getInstance().getResourceBundle().getString("studentServicesProfessors"));
				break;
			case 2:
				label.setText(MainFrame.getInstance().getResourceBundle().getString("studentServicesSubjects"));
				break;
			default:
				label.setText(MainFrame.getInstance().getResourceBundle().getString("studentServices"));
				break;
				
				
		}
		
	}
	
}
