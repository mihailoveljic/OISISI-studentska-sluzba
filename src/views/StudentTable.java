package views;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import java.awt.Color;

public class StudentTable extends JTable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6741254119458863799L;

	private static StudentTable instance;

	
	private StudentTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudents());
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		
		if(isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		}else{
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	
	public static StudentTable getInstance()
	{
		if(instance == null)
			instance = new StudentTable();
		return instance;
	}
}
