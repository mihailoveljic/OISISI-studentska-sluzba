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

		this.add("Studenti", studentPanel);
		this.add("Profesori", professorPanel);
		this.add("Predmeti", subjectPanel);
		
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
				label.setText("Studentska služba - Studenti");
				break;
			case 1:
				label.setText("Studentska služba - Profesori");
				break;
			case 2:
				label.setText("Studentska služba - Predmeti");
				break;
			default:
				label.setText("Studentska služba");
				break;
				
				
		}
		
	}
	
}
