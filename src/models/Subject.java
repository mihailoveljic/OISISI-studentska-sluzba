package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Subject implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -79301667796385491L;
	private String id;
	private String name;
	private Semester semester;
    private int yearOfStudy;
    private Professor professor;
    private int ESPB;
    private List<Student> listOfStudentsWhoPassed;
    private List<Student> listOfStudentsWhoFailed;
	public Subject(String id, String name, Semester semester, int yearOfStudy, Professor professor, int eSPB,
			List<Student> listOfStudentsWhoPassed, List<Student> listOfStudentsWhoFailed) {
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
	
	
	
	public Subject(String id, String name, Semester semester, int yearOfStudy, int eSPB) {
		super();
		this.id = id;
		this.name = name;
		this.semester = semester;
		this.yearOfStudy = yearOfStudy;
		ESPB = eSPB;
		this.listOfStudentsWhoPassed = new ArrayList<Student>();
		this.listOfStudentsWhoFailed = new ArrayList<Student>();
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public List<Student> getListOfStudentsWhoPassed() {
		return listOfStudentsWhoPassed;
	}
	public void setListOfStudentsWhoPassed(List<Student> listOfStudentsWhoPassed) {
		this.listOfStudentsWhoPassed = listOfStudentsWhoPassed;
	}
	public List<Student> getListOfStudentsWhoFailed() {
		return listOfStudentsWhoFailed;
	}
	public void setListOfStudentsWhoFailed(List<Student> listOfStudentsWhoFailed) {
		this.listOfStudentsWhoFailed = listOfStudentsWhoFailed;
	}
    
	public void removeStudentFromListOfPassed(Student s) {
		this.listOfStudentsWhoPassed.remove(s);
	}
	
	public void removeStudentFromListOfFailed(Student s) {
		this.listOfStudentsWhoFailed.remove(s);
	}
	
    
}
