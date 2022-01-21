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

	
	private ProfessorSubjectsTable subjectsTable;
	private JButton addButton;
	private JButton removeButton;
	private JScrollPane scrollPane;
	
	public ProfessorSubjectPanel() {
		super();
		
		
		setLayout(new BorderLayout());
		setOpaque(false);
		subjectsTable = new ProfessorSubjectsTable();
		scrollPane = new JScrollPane(subjectsTable);
		add(scrollPane, BorderLayout.CENTER);
		JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		addButton = new JButton(MainFrame.getInstance().getResourceBundle().getString("addSubject"));
		removeButton = new JButton(MainFrame.getInstance().getResourceBundle().getString("removeSubject"));
		commandPanel.add(addButton);
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProfessorSubjectAddFrame professorSubjectAddFrame = new ProfessorSubjectAddFrame();
				professorSubjectAddFrame.setVisible(true);
				refresh();
				professorSubjectAddFrame.setVisible(false);
				addButton.setSelected(false);
			}
		});
		commandPanel.add(removeButton);
		removeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int row = subjectsTable.getSelectedRow();
				Professor p = DbProfessors.getInstance().findProfessor(
						(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 0),
						(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 1),
						(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 3)			
						);
				
				if (row >= 0 && row <= subjectsTable.getRowCount()) {
					int userInput = JOptionPane.showConfirmDialog(ProfessorEditFrame.getInstance().getProfessorSubjectPanel(), MainFrame.getInstance().getResourceBundle().getString("sureToDeleteSubjectFromProfessor"),
							MainFrame.getInstance().getResourceBundle().getString("deleteSubject"), JOptionPane.YES_NO_OPTION);
					if (userInput == JOptionPane.YES_OPTION) {
						
						for(Subject s : DbSubjects.getInstance().getSubjects()) {
							if(p.getSubjects().get(row).equals(s)) {
								DbSubjects.getInstance().editSubject(s.getId(), s.getName(), s.getSemester(),
										s.getYearOfStudy(), null, s.getESPB());
							}
						}
						
						p.getSubjects().remove(row);
						refresh();			
						JOptionPane.showMessageDialog(ProfessorEditFrame.getInstance().getProfessorSubjectPanel(), MainFrame.getInstance().getResourceBundle().getString("subjectDeleted"));
					} else {
						JOptionPane.showMessageDialog(ProfessorEditFrame.getInstance().getProfessorSubjectPanel(), MainFrame.getInstance().getResourceBundle().getString("subjectNotDeleted"));
					}
				} else {
					JOptionPane.showMessageDialog(ProfessorEditFrame.getInstance().getProfessorSubjectPanel(), MainFrame.getInstance().getResourceBundle().getString("subjectNotChosen"), MainFrame.getInstance().getResourceBundle().getString("warning"),
							JOptionPane.WARNING_MESSAGE);
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
		
	
}
