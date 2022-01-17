package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class ProfessorSubjectPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public static ProfessorSubjectPanel instance;
	
	private ProfessorSubjectsTable subjectsTable;
	private JButton addButton;
	private JButton removeButton;
	private JScrollPane scrollPane;
	
	private ProfessorSubjectPanel() {
		super();
		setLayout(new BorderLayout());
		setOpaque(false);
		subjectsTable = new ProfessorSubjectsTable();
		scrollPane = new JScrollPane(subjectsTable);
		add(scrollPane, BorderLayout.CENTER);
		JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		addButton = new JButton("Dodaj predmet");
		removeButton = new JButton("Ukloni predmet");
		commandPanel.add(addButton);
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO dodaj predmet profesoru 
			}
		});
		commandPanel.add(removeButton);
		removeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO obrisi predmet profesoru
			}
			
		});
		add(commandPanel, BorderLayout.NORTH);		
	
	}
	
	public ProfessorSubjectsTable getSubjectsTable() {
		return subjectsTable;
	}

	public void setSubjectsTable(ProfessorSubjectsTable subjectsTable) {
		this.subjectsTable = subjectsTable;
	}
	
	
	public void refresh() {
		AbstractTableModelProfessorSubjects abstractTableModelProfessorSubjects = (AbstractTableModelProfessorSubjects)subjectsTable.getModel();
		abstractTableModelProfessorSubjects.fireTableDataChanged();
		validate();
	}
	
	public static ProfessorSubjectPanel getInstance() {
		if(instance!=null)
		{
			return instance;
		} else 
			return instance = new ProfessorSubjectPanel();
	}
	
	
	
}
