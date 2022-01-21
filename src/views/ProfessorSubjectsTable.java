package views;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import models.DbProfessors;

public class ProfessorSubjectsTable extends JTable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5492963277501410329L;
	AbstractTableModelProfessorSubjects abstractTableModelProfessorSubjects;
	
	public ProfessorSubjectsTable() {
		this.getTableHeader().setReorderingAllowed(false);
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		abstractTableModelProfessorSubjects = new AbstractTableModelProfessorSubjects();
		this.setModel(abstractTableModelProfessorSubjects);
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
		if(DbProfessors.getInstance().findProfessor(
				(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 0),
				(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 1),
				(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 3)			
				) != null)
			if(abstractTableModelProfessorSubjects != null)
				abstractTableModelProfessorSubjects.updateProfessor();
		return super.getModel();
	}
	
 
}
