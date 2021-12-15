package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

public class ProfessorPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4362950133635844338L;
	public static ProfessorPanel instance;
	
	private ProfessorTable professorTable;
	
	public static ProfessorPanel getInstance()
	{
		if(instance==null)
			instance = new ProfessorPanel();
		return instance;
	}
	
	private ProfessorPanel() {
		professorTable = new ProfessorTable();
		
		JScrollPane scrollPane = new JScrollPane(professorTable);
		this.add(scrollPane, BorderLayout.CENTER);
		
		this.updateView();
	}
	
	public void updateView() {
		AbstractTableModelProfessors model = (AbstractTableModelProfessors) professorTable.getModel();
		model.fireTableDataChanged();
		validate();
	}
}

