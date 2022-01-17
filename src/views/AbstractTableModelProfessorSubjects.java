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
	private Professor p = DbProfessors.getInstance().getRow(ProfessorTable.getInstance().getSelectedRow());
	
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
				return "Šifra predmeta";
			}
			case 1:
			{
				return "Naziv predmeta";
			}
			case 2:
			{
				return "ESPB";
			}
			case 3:
			{
				return "Godina studija";
			}
			case 4:
			{
				return "Semestar";
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
				if(subject.getSemester() == Semester.LETNJI ) return "Letnji";
				else return "Zimski";
			}
			default:
				return null;
		
		}
	}
}
