package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

public class SubjectPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static SubjectPanel instance;
	
	private SubjectTable subjectTable;
	
	public static SubjectPanel getInstance()
	{
		if(instance==null)
			instance = new SubjectPanel();
		return instance;
	}
	
	private SubjectPanel() {
		subjectTable = new SubjectTable();
		
		JScrollPane scrollPane = new JScrollPane(subjectTable);
		this.add(scrollPane, BorderLayout.CENTER);
		
		this.updateView();
	}
	
	public void updateView() {
		AbstractTableModelSubjects model = (AbstractTableModelSubjects) subjectTable.getModel();
		model.fireTableDataChanged();
		validate();
	}
}
