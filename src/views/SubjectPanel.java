package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.GridLayout;

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
		this.setLayout(new GridLayout());
		this.setBorder(new EmptyBorder(30, 50, 30, 50));
		
		subjectTable = SubjectTable.getInstance();
		JScrollPane scrollPane = new JScrollPane(subjectTable);
		this.add(scrollPane, BorderLayout.CENTER);
		
		this.updateView();
	}
	
	public void updateView() {
		AbstractTableModelSubjects model = (AbstractTableModelSubjects) subjectTable.getModel();
		model.fireTableDataChanged();
		validate();
	}

	public void reloadUI() {
		instance.updateView();
	}
}
