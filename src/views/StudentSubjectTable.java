package views;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class StudentSubjectTable extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8823694100864512615L;
	
	@SuppressWarnings("unused")
	private AbstractTableModelStudentSubject abstractTableModelStudentSubject = new AbstractTableModelStudentSubject();

	public StudentSubjectTable() {
		this.getTableHeader().setReorderingAllowed(false);
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudentSubject());
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
}
