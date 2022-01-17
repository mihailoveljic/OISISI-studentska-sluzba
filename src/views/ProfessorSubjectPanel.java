package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import models.DbProfessors;
import models.DbSubjects;
import models.Professor;
import models.Subject;


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
				int row = subjectsTable.getSelectedRow();
				Professor p = DbProfessors.getInstance().getRow(ProfessorTable.getInstance().getSelectedRow());
				
				if (row >= 0 && row <= subjectsTable.getRowCount()) {
					int userInput = JOptionPane.showConfirmDialog(ProfessorSubjectPanel.getInstance(), "Da li ste sigurni da �elite da obri�ete predmet sa profesora?",
							"Brisanje predmeta", JOptionPane.YES_NO_OPTION);
					if (userInput == JOptionPane.YES_OPTION) {
						
						for(Subject s : DbSubjects.getInstance().getSubjects()) {
							if(p.getSubjects().get(row).equals(s)) {
								DbSubjects.getInstance().editSubject(s.getId(), s.getName(), s.getSemester(),
										s.getYearOfStudy(), null, s.getESPB());
							}
						}
						
						p.getSubjects().remove(row);
						refresh();			
						JOptionPane.showMessageDialog(ProfessorSubjectPanel.getInstance(), "Predmet je obrisan!");
					} else {
						JOptionPane.showMessageDialog(ProfessorSubjectPanel.getInstance(), "Predmet nije obrisan.");
					}
				} else {
					JOptionPane.showMessageDialog(ProfessorSubjectPanel.getInstance(), "Predmet nije selektovan.", "Upozorenje!",
							JOptionPane.ERROR_MESSAGE);
				}
				removeButton.setSelected(false);
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
