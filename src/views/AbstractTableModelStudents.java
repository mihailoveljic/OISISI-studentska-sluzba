package views;

import javax.swing.table.AbstractTableModel;

import models.DbStudents;

public class AbstractTableModelStudents extends AbstractTableModel {

	private static final long serialVersionUID = 2710362894062472488L;

	
	
	public AbstractTableModelStudents() {
		super();
	}

	@Override
	public int getRowCount() {
		return DbStudents.getInstance().getstudents().size();
	}

	@Override
	public int getColumnCount() {
		return DbStudents.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return DbStudents.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex < 5)
			return DbStudents.getInstance().getValueAt(rowIndex, columnIndex);
		return null;
	}
	
}
