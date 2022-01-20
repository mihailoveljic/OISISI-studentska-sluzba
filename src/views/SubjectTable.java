package views;

import java.awt.Color;
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

public class SubjectTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static SubjectTable instance;
	
	private TableRowSorter<TableModel> sorter;
	
	private SubjectTable() {
		this.getTableHeader().setReorderingAllowed(false);
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelSubjects());
		sorter = new TableRowSorter<TableModel>((AbstractTableModelSubjects)this.getModel());
		sorter.setComparator(2, new Comparator<String>() {
			 
		    @Override
		    public int compare(String bodovi1, String bodovi2) {
		    	
		    	
		    	int espb1 = Integer.parseInt(bodovi1);
		    	int espb2 = Integer.parseInt(bodovi2);
		    	if(espb1 > espb2) {
		    		return 1;
		    	}else if(espb1 < espb2) {
		    		return -1;
		    	}
		    	return 0;
		    }
		});
		sorter.setComparator(3, new Comparator<String>() {
			 
		    @Override
		    public int compare(String godina1, String godina2) {
		    	
		    	
		    	int year1 = Integer.parseInt(godina1);
		    	int year2 = Integer.parseInt(godina2);
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
		}else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	public static SubjectTable getInstance()
	{
		if(instance == null)
			instance = new SubjectTable();
		return instance;
	}

	public void clearFilter()
	{
		sorter.setRowFilter(RowFilter.regexFilter("", 0, 1, 2));
	}
	
	public void setFilter(String s, int i)
	{
		sorter.setRowFilter(RowFilter.regexFilter("(?i)" +s  , i));
	}
	
	public void set2Filter(String s1, int i1, String s2, int i2)
	{
		List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(2);
		filters.add(RowFilter.regexFilter("(?i)"+ s1, i1));
		filters.add(RowFilter.regexFilter("(?i)"+ s2, i2));
		RowFilter<Object,Object> rf = RowFilter.andFilter(filters);
		sorter.setRowFilter(rf);
	}
}
