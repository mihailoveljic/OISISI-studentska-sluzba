package views;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


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
		sorter.setComparator(0, new Comparator<String>() {
			 
		    @Override
		    public int compare(String name1, String name2) {
		    	
		    	//RA 24/2019
		    	String parts1[] = name1.split("/");
		    	String parts2[] = name2.split("/");
		    	String parts3[] = name1.split(" ");
		    	String parts4[] = name2.split(" ");
		    	if(parts3[0].compareTo(parts4[0]) < 0) {
		    		return -1;
		    	}else if(parts3[0].compareTo(parts4[0]) > 0) {
		    		return 1;
		    	}
		    	
		    	int year1 = Integer.parseInt(parts1[1]);
		    	int year2 = Integer.parseInt(parts2[1]);
		    	if(year1 > year2) {
		    		return 1;
		    	}else if(year1 < year2) {
		    		return -1;
		    	}
		    	parts3 = name1.split(" ");
		    	parts4 = name2.split(" ");
		    	parts1 = parts3[1].split("/");
		    	parts2 = parts4[1].split("/");
		    	int number1 = Integer.parseInt(parts1[0]);
		    	int number2 = Integer.parseInt(parts2[0]);
		    	if(number1 > number2) {
		    		return 1;
		    	}else if(number1 < number2) {
		    		return -1;
		    	}
		    	return 0;
		    }
		});
		
		sorter.setComparator(3, new Comparator<String>() {
			 
		    @Override
		    public int compare(String name1, String name2) {
		    	
		    	
		    	int year1 = Integer.parseInt(name1);
		    	int year2 = Integer.parseInt(name2);
		    	if(year1 > year2) {
		    		return 1;
		    	}else if(year1 < year2) {
		    		return -1;
		    	}
		    	return 0;
		    }
		});
		
		sorter.setComparator(5, new Comparator<String>() {
			 
		    @Override
		    public int compare(String name1, String name2) {
		    	Double year1 = 0.0;
		    	Double year2 = 0.0;
		    	try {
			    	year1 = Double.parseDouble(name1);
		    	}catch(Exception e) {
		    		return -1;
		    	}
		    	try {
		    		year2 = Double.parseDouble(name2);
		    	}catch(Exception e) {
		    		return 1;
		    	}
		    	
		    	if(year1 > year2) {
		    		return 1;
		    	}else if(year1 < year2) {
		    		return -1;
		    	}
		    	return 0;
		    }
		});
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

	public void reloadUI() {
			setModel(new AbstractTableModelStudents());	
			
			sorter = new TableRowSorter<TableModel>((AbstractTableModelStudents)this.getModel());
			sorter.setComparator(0, new Comparator<String>() {
				 
			    @Override
			    public int compare(String name1, String name2) {
			    	
			    	//RA 24/2019
			    	String parts1[] = name1.split("/");
			    	String parts2[] = name2.split("/");
			    	String parts3[] = name1.split(" ");
			    	String parts4[] = name2.split(" ");
			    	if(parts3[0].compareTo(parts4[0]) < 0) {
			    		return -1;
			    	}else if(parts3[0].compareTo(parts4[0]) > 0) {
			    		return 1;
			    	}
			    	
			    	int year1 = Integer.parseInt(parts1[1]);
			    	int year2 = Integer.parseInt(parts2[1]);
			    	if(year1 > year2) {
			    		return 1;
			    	}else if(year1 < year2) {
			    		return -1;
			    	}
			    	parts3 = name1.split(" ");
			    	parts4 = name2.split(" ");
			    	parts1 = parts3[1].split("/");
			    	parts2 = parts4[1].split("/");
			    	int number1 = Integer.parseInt(parts1[0]);
			    	int number2 = Integer.parseInt(parts2[0]);
			    	if(number1 > number2) {
			    		return 1;
			    	}else if(number1 < number2) {
			    		return -1;
			    	}
			    	return 0;
			    }
			});
			
			sorter.setComparator(3, new Comparator<String>() {
				 
			    @Override
			    public int compare(String name1, String name2) {
			    	
			    	
			    	int year1 = Integer.parseInt(name1);
			    	int year2 = Integer.parseInt(name2);
			    	if(year1 > year2) {
			    		return 1;
			    	}else if(year1 < year2) {
			    		return -1;
			    	}
			    	return 0;
			    }
			});
			
			sorter.setComparator(5, new Comparator<String>() {
				 
			    @Override
			    public int compare(String name1, String name2) {
			    	Double year1 = 0.0;
			    	Double year2 = 0.0;
			    	try {
				    	year1 = Double.parseDouble(name1);
			    	}catch(Exception e) {
			    		return -1;
			    	}
			    	try {
			    		year2 = Double.parseDouble(name2);
			    	}catch(Exception e) {
			    		return 1;
			    	}
			    	
			    	if(year1 > year2) {
			    		return 1;
			    	}else if(year1 < year2) {
			    		return -1;
			    	}
			    	return 0;
			    }
			});
			this.setRowSorter(sorter);
	}
	
}
