package views;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import models.DbStudents;

public class GradesTable extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1116433226137967437L;
	AbstractTableModelGrades abstractTableModelGrades = new AbstractTableModelGrades();
	
	public GradesTable() {
		this.getTableHeader().setReorderingAllowed(false);
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(abstractTableModelGrades);
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}

	@Override
	public TableModel getModel() {
		if(DbStudents.getInstance().findStudentByIndex((String) StudentTable.getInstance().getValueAt(StudentTable.getInstance().getSelectedRow(), 0)) != null)
			if(abstractTableModelGrades != null)
				abstractTableModelGrades.updateStudent();
		return super.getModel();
	}
}
