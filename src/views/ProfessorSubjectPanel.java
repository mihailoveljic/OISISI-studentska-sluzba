package views;

import javax.swing.JPanel;

public class ProfessorSubjectPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public static ProfessorSubjectPanel instance;
	
	
	public static ProfessorSubjectPanel getInstance() {
		if(instance!=null)
		{
			return instance;
		} else 
			return instance = new ProfessorSubjectPanel();
	}
	
	
	
}
