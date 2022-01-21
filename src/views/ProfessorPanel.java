package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.GridLayout;

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
		this.setLayout(new GridLayout());
		this.setBorder(new EmptyBorder(30, 50, 30, 50));
		professorTable = ProfessorTable.getInstance();
		JScrollPane scrollPane = new JScrollPane(professorTable);
		this.add(scrollPane, BorderLayout.CENTER);
		
		this.updateView();
	}
	
	public void updateView() {
		AbstractTableModelProfessors model = (AbstractTableModelProfessors) professorTable.getModel();
		model.fireTableDataChanged();
		validate();
	}

	public void reloadUI() {
		instance.updateView();
	}
}

