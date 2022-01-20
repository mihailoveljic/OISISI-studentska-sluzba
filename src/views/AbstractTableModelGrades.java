package views;


import java.util.List;

import javax.swing.table.AbstractTableModel;

import models.DbStudents;
import models.Grade;
import models.Student;

public class AbstractTableModelGrades  extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4656217212866529542L;
	Student s = DbStudents.getInstance().getRow(StudentTable.getInstance().getSelectedRow());
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(s.getGrades() != null) {
			return s.getGrades().size();
		}else {
			return 0;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
	
		List<Grade> grades = s.getGrades();
		Grade o = grades.get(rowIndex);
		
		switch(columnIndex)
		{
			case 0:
			{
				return o.getSubject().getId();
			}
			case 1:
			{
				return o.getSubject().getName();
			}
			case 2:
			{
				return Integer.toString(o.getSubject().getESPB());
			}
			case 3:
			{
				return o.getGrade();
			}
			case 4:
			{
				int day = o.getEvaluationDate().getDate();
				int month = o.getEvaluationDate().getMonth() + 1;
				int year = o.getEvaluationDate().getYear() + 1900;
				String date = Integer.toString(day) + "." + Integer.toString(month) + "." + Integer.toString(year) + ".";
				return date;
			}
			default:
				return null;
		
		}
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
				return "Ocena";
			}
			case 4:
			{
				return "Datum";
			}
			default:
				return null;
		
		}
	}
	public void updateStudent(int selectedRow) {
		s = DbStudents.getInstance().getRow(selectedRow);
	}
}
