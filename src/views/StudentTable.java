package views;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import models.DbStudents;
import models.Student;

import java.awt.Color;

public class StudentTable extends JTable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6741254119458863799L;

	private static StudentTable instance;
	
	private TableRowSorter<TableModel> sorter;
	
	private StudentTable() {
		this.getTableHeader().setReorderingAllowed(false);
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudents());
		sorter = new TableRowSorter<TableModel>((AbstractTableModelStudents)this.getModel());
		this.setRowSorter(sorter);
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
	
	public void clearFilter()
	{
		sorter.setRowFilter(RowFilter.regexFilter("", 0, 1, 2));
	}
	
	public void setFilter(String s, int i)
	{
		sorter.setRowFilter(RowFilter.regexFilter("(?i)"+ s, i));
	}

	public void set2Filter(String s1, int col1, String s2, int col2) {
		List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(2);
		filters.add(RowFilter.regexFilter("(?i)"+ s1, col1));
		filters.add(RowFilter.regexFilter("(?i)"+ s2, col2));
		RowFilter<Object,Object> rf = RowFilter.andFilter(filters);
		sorter.setRowFilter(rf);
		
	}
	
	public void set3Filter(String s1, int col1, String s2, int col2, String s3, int col3) {
		List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(2);
		filters.add(RowFilter.regexFilter("(?i)"+s1, col1));
		filters.add(RowFilter.regexFilter("(?i)"+s2, col2));
		filters.add(RowFilter.regexFilter("(?i)"+s3, col3));
		RowFilter<Object,Object> rf = RowFilter.andFilter(filters);
		sorter.setRowFilter(rf);
		
	}
	
	
	public static StudentTable getInstance()
	{
		if(instance == null)
			instance = new StudentTable();
		return instance;
	}
	
	public Student selected() {
		return DbStudents.getInstance().getRow(StudentTable.getInstance().convertRowIndexToModel(StudentTable.getInstance().getSelectedRow()));
		
	}
}
