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

		JPanel students_panel = new JPanel();
		JPanel professors_panel = new JPanel();
		JPanel subjects_panel = new JPanel();

		this.add("Studenti", students_panel);
		this.add("Profesori", professors_panel);
		this.add("Predmeti", subjects_panel);
		
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
