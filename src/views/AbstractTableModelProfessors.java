package views;

import javax.swing.table.AbstractTableModel;

import models.DbProfessors;

public class AbstractTableModelProfessors extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbstractTableModelProfessors() {
		super();
	}

	@Override
	public int getRowCount() {
		return DbProfessors.getInstance().getProfessors().size();
	}

	@Override
	public int getColumnCount() {
		return DbProfessors.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return DbProfessors.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return DbProfessors.getInstance().getValueAt(rowIndex, columnIndex);
	}
}
