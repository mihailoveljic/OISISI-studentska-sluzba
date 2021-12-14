package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

public class StudentPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4362950133635844338L;
	public static StudentPanel instance;
	
	private StudentTable studentTable;
	
	public static StudentPanel getInstance()
	{
		if(instance==null)
			instance = new StudentPanel();
		return instance;
	}
	
	private StudentPanel() {
		studentTable = new StudentTable();
		
		JScrollPane scrollPane = new JScrollPane(studentTable);
		this.add(scrollPane, BorderLayout.CENTER);
		
		this.updateView();
	}
	
	public void updateView() {
		AbstractTableModelStudents model = (AbstractTableModelStudents) studentTable.getModel();
		model.fireTableDataChanged();
		validate();
	}
}
