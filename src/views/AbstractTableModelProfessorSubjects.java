package views;

import java.util.List;

import javax.swing.table.AbstractTableModel;


import models.DbProfessors;
import models.Professor;
import models.Semester;
import models.Subject;

public class AbstractTableModelProfessorSubjects extends AbstractTableModel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 721332372551834518L;
	private Professor p = DbProfessors.getInstance().findProfessor(
			(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 0),
			(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 1),
			(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 3)			
			);
	
	@Override
	public int getRowCount() {
		if(p.getSubjects() != null) {
			return p.getSubjects().size();
		}
		return 0;
	}
	
	@Override
	public String getColumnName(int column) {
		switch(column)
		{
			case 0:
			{
				return MainFrame.getInstance().getResourceBundle().getString("subjectId");
			}
			case 1:
			{
				return MainFrame.getInstance().getResourceBundle().getString("subjectName");
			}
			case 2:
			{
				return MainFrame.getInstance().getResourceBundle().getString("espb");
			}
			case 3:
			{
				return MainFrame.getInstance().getResourceBundle().getString("yearOfStudy");
			}
			case 4:
			{
				return MainFrame.getInstance().getResourceBundle().getString("semester");
			}
			default:
				return null;
		
		}
	}
	
	
	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		List<Subject> subjects = p.getSubjects();
		Subject subject = subjects.get(rowIndex);
		switch(columnIndex)
		{
			case 0:
			{
				return subject.getId();
			}
			case 1:
			{
				return subject.getName();
			}
			case 2:
			{
				return Integer.toString(subject.getESPB());
			}
			case 3:
			{
				return Integer.toString(subject.getYearOfStudy());
			}
			case 4:
			{
				if(subject.getSemester() == Semester.LETNJI ) return MainFrame.getInstance().getResourceBundle().getString("summer");
				else return MainFrame.getInstance().getResourceBundle().getString("winter");
			}
			default:
				return null;
		
		}
	}
	
	public void updateProfessor() {
		p = DbProfessors.getInstance().findProfessor(
				(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 0),
				(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 1),
				(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 3)			
				);
	}
}
