package views;

import javax.swing.JPanel;

public class StudentGradesPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7412489039644348070L;
	
	private static StudentGradesPanel instance;

	
	private StudentGradesPanel() {
		
	}
	
	public static StudentGradesPanel getInstance()
	{
		if(instance == null)
			instance = new StudentGradesPanel();
		return instance;
	}
}
