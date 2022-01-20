package views;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import models.DbDepartments;
import models.Department;

public class AbstractTableModelDepartments extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8606553300743607961L;
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(DbDepartments.getInstance().getDeparments() != null) {
			return DbDepartments.getInstance().getDeparments().size();
		}else {
			return 0;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
	
		List<Department> departments = DbDepartments.getInstance().getDeparments();
		Department d = departments.get(rowIndex);
		
		switch(columnIndex)
		{
			case 0:
			{
				return d.getID();
			}
			case 1:
			{
				return d.getName();
			}
			case 2:
			{
				if(d.getHeadOfDepartment() != null)
					return d.getHeadOfDepartment().getName() + " " + d.getHeadOfDepartment().getSurname();
				else
					return "";
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
				return "Šifra katedre";
			}
			case 1:
			{
				return "Naziv katedre";
			}
			case 2:
			{
				return "Rukovodilac katedre";
			}
			default:
				return null;
		
		}
	}
}
