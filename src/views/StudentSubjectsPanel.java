package views;

import javax.swing.JPanel;

public class StudentSubjectsPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7743348763378268567L;
	
	private static StudentSubjectsPanel instance;

	
	private StudentSubjectsPanel() {
		
	}
	
	public static StudentSubjectsPanel getInstance()
	{
		if(instance == null)
			instance = new StudentSubjectsPanel();
		return instance;
	}
}
