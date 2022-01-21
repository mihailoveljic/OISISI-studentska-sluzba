package views;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ProfessorTable extends JTable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1482090380799770873L;
	
	private static ProfessorTable instance;
	
	private TableRowSorter<TableModel> sorter;
	
	private ProfessorTable() {
		this.getTableHeader().setReorderingAllowed(false);
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfessors());
		sorter = new TableRowSorter<TableModel>((AbstractTableModelProfessors)this.getModel());
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
	
	public static ProfessorTable getInstance()
	{
		if(instance == null)
			instance = new ProfessorTable();
		return instance;
	}
	
	public void clearFilter()
	{
		sorter.setRowFilter(RowFilter.regexFilter("", 0, 1, 2));
	}
	
	public void setFilter(String s, int i)
	{
		sorter.setRowFilter(RowFilter.regexFilter("(?i)" + s, i));
	}
	
	public void setFilters(String s1, int col1, String s2, int col2) {
		List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(2);
		filters.add(RowFilter.regexFilter("(?i)" + s1, col1));
		filters.add(RowFilter.regexFilter("(?i)" + s2, col2));
		RowFilter<Object,Object> rf = RowFilter.andFilter(filters);
		sorter.setRowFilter(rf);
		
	}

	public void reloadUI() {
		setModel(new AbstractTableModelProfessors());		
		sorter = new TableRowSorter<TableModel>((AbstractTableModelProfessors)this.getModel());
		this.setRowSorter(sorter);
	}

}
