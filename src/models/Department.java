package models;

import java.util.Set;

public class Department {
	private int ID;
	private String name;
	private Professor headOfDepartment;
	private Set<Professor> professors;
	
	public Department(int iD, String name, Professor headOfDepartment, Set<Professor> professors) {
		super();
		ID = iD;
		this.name = name;
		this.headOfDepartment = headOfDepartment;
		this.professors = professors;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Professor getHeadOfDepartment() {
		return headOfDepartment;
	}

	public void setHeadOfDepartment(Professor headOfDepartment) {
		this.headOfDepartment = headOfDepartment;
	}

	public Set<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(Set<Professor> professors) {
		this.professors = professors;
	}
	
	
}
