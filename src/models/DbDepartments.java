package models;

import java.util.ArrayList;
import java.util.List;



public class DbDepartments{
	
	private static DbDepartments instance = null;
	public static DbDepartments getInstance() {
		if(instance == null) {
			instance = new DbDepartments();
		}
		return instance;
	}

	private List<Department> departments;
	private List<String>	columns;
	
	private DbDepartments() {
		initDepartments();
		
		this.columns = new ArrayList<String>();
		this.columns.add("ID");
		this.columns.add("Naziv katedre");
		this.columns.add("Rukovodilac");
	}
	
	private void initDepartments() {
		this.departments= new ArrayList<Department>();
	}
	
	public List<Department> getDeparments() {
		return departments;
	}
	
	public int getColumnCount() {
		return 3;
	}
	
	public String getColumnName(int index) {
		return this.columns.get(index);
	}
	
	public Department getRow(int rowIndex) {
		if(rowIndex <= -1)
			return null;
		return this.departments.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Department department = this.departments.get(row);
		switch(column) {
		case 0:
			return String.valueOf(department.getID());
		case 1:
			return department.getName();
		case 2:
			return department.getHeadOfDepartment().getName() + " " + department.getHeadOfDepartment().getSurname();
			default:
				return null;
		}
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
	
	
	
}
