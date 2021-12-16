package views;

import javax.swing.table.AbstractTableModel;

import models.DbSubjects;

public class AbstractTableModelSubjects extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbstractTableModelSubjects() {
		super();
	}

	@Override
	public int getRowCount() {
		return DbSubjects.getInstance().getSubjects().size();
	}

	@Override
	public int getColumnCount() {
		return DbSubjects.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return DbSubjects.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return DbSubjects.getInstance().getValueAt(rowIndex, columnIndex);
	}
}
