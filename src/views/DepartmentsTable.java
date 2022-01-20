package views;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class DepartmentsTable extends JTable{
/**
	 * 
	 */
	private static final long serialVersionUID = 3450641995669586376L;
	AbstractTableModelDepartments abstractTableModelDepartments = new AbstractTableModelDepartments();
	
	public DepartmentsTable() {
		this.getTableHeader().setReorderingAllowed(false);
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(abstractTableModelDepartments);
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
