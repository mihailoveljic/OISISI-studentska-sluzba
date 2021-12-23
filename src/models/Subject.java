package models;

import java.util.Set;

public class Subject {

	
	private int id;
	private String name;
	private Semester semester;
    private int yearOfStudy;
    private Professor professor;
    private int ESPB;
    private Set<Student> listOfStudentsWhoPassed;
    private Set<Student> listOfStudentsWhoFailed;
	public Subject(int id, String name, Semester semester, int yearOfStudy, Professor professor, int eSPB,
			Set<Student> listOfStudentsWhoPassed, Set<Student> listOfStudentsWhoFailed) {
		super();
		this.id = id;
		this.name = name;
		this.semester = semester;
		this.yearOfStudy = yearOfStudy;
		this.professor = professor;
		ESPB = eSPB;
		this.listOfStudentsWhoPassed = listOfStudentsWhoPassed;
		this.listOfStudentsWhoFailed = listOfStudentsWhoFailed;
	}
	
	
	
	public Subject(int id, String name, Semester semester, int yearOfStudy, int eSPB) {
		super();
		this.id = id;
		this.name = name;
		this.semester = semester;
		this.yearOfStudy = yearOfStudy;
		ESPB = eSPB;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	public int getYearOfStudy() {
		return yearOfStudy;
	}
	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public int getESPB() {
		return ESPB;
	}
	public void setESPB(int eSPB) {
		ESPB = eSPB;
	}
	public Set<Student> getListOfStudentsWhoPassed() {
		return listOfStudentsWhoPassed;
	}
	public void setListOfStudentsWhoPassed(Set<Student> listOfStudentsWhoPassed) {
		this.listOfStudentsWhoPassed = listOfStudentsWhoPassed;
	}
	public Set<Student> getListOfStudentsWhoFailed() {
		return listOfStudentsWhoFailed;
	}
	public void setListOfStudentsWhoFailed(Set<Student> listOfStudentsWhoFailed) {
		this.listOfStudentsWhoFailed = listOfStudentsWhoFailed;
	}
    
	public void removeStudentFromListOfPassed(Student s) {
		this.listOfStudentsWhoPassed.remove(s);
	}
	
	public void removeStudentFromListOfFailed(Student s) {
		this.listOfStudentsWhoFailed.remove(s);
	}
	
    
}
