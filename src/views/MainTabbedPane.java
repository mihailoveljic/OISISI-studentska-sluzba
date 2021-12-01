package views;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

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
		
		
	}

	
}
