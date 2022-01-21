package models;

import java.util.ArrayList;
import java.util.List;

import views.MainFrame;



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
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("departmentId"));
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("departmentName"));
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("departmentHead"));
	}
	
	private void initDepartments() {
		this.departments= new ArrayList<Department>();


//		Professor p1 = DbProfessors.getInstance().findProfessor("Nikola", "Mirkovic", "nikola.mirkovic@mailinator.com");
//		Professor p2 = DbProfessors.getInstance().findProfessor("Ilija", "Petkovic", "ilija.petkovic@mailinator.com");
//		Professor p3 = DbProfessors.getInstance().findProfessor("Mitar", "Petrovic", "mitar.petrovic@mailinator.com");
//		Professor p4 = DbProfessors.getInstance().findProfessor("Branislav", "Mihajlovic", "branislav.mihajlovic@mailinator.com");
//		Professor p5 = DbProfessors.getInstance().findProfessor("Bogdan", "Rekaviæ", "bogdan.rekavic@mailinator.com");
//		Professor p6 = DbProfessors.getInstance().findProfessor("Branislav", "Lukovic", "branislav.lukovic@mailinator.com");
//		
//		List<Professor> ps1 = new ArrayList<>();
//		List<Professor> ps2 = new ArrayList<>();
//		List<Professor> ps3 = new ArrayList<>();
//		List<Professor> ps4 = new ArrayList<>();
//		List<Professor> ps5 = new ArrayList<>();
//		List<Professor> ps6 = new ArrayList<>();
//		
//		ps1.add(DbProfessors.getInstance().getProfessors().get(0));
//		ps1.add(DbProfessors.getInstance().getProfessors().get(1));
//		ps1.add(DbProfessors.getInstance().getProfessors().get(18));
//		
//
//		ps2.add(DbProfessors.getInstance().getProfessors().get(2));
//		ps2.add(DbProfessors.getInstance().getProfessors().get(7));
//		ps2.add(DbProfessors.getInstance().getProfessors().get(13));
//		
//
//		ps3.add(DbProfessors.getInstance().getProfessors().get(3));
//		ps3.add(DbProfessors.getInstance().getProfessors().get(8));
//		ps3.add(DbProfessors.getInstance().getProfessors().get(14));
//		
//
//		ps4.add(DbProfessors.getInstance().getProfessors().get(6));
//		ps4.add(DbProfessors.getInstance().getProfessors().get(9));
//		ps4.add(DbProfessors.getInstance().getProfessors().get(15));
//		
//
//		ps5.add(DbProfessors.getInstance().getProfessors().get(4));
//		ps5.add(DbProfessors.getInstance().getProfessors().get(10));
//		ps5.add(DbProfessors.getInstance().getProfessors().get(12));
//		ps5.add(DbProfessors.getInstance().getProfessors().get(16));
//		
//
//		ps6.add(DbProfessors.getInstance().getProfessors().get(5));
//		ps5.add(DbProfessors.getInstance().getProfessors().get(11));
//		ps5.add(DbProfessors.getInstance().getProfessors().get(17));
//		
//		departments.add(new Department("e42", "Katedra za matematiku", p1, ps1));
//		departments.add(new Department("e43", "Katedra za fiziku", p2, ps2));
//		departments.add(new Department("e44", "Katedra za elektrotehniku", p3, ps3));
//		departments.add(new Department("e45", "Katedra za primenjene raèunarske nauke", p4, ps4));
//		departments.add(new Department("e46", "Katedra za informatiku", p5, ps5));
//		departments.add(new Department("e47", "Katedra za automatiku", p6, ps6));
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
	
	public void reloadUI() {
		this.columns = new ArrayList<String>();
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("departmentId"));
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("departmentName"));
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("departmentHead"));
	}
	
	
}
