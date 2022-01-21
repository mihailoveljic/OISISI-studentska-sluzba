package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1314845205881394617L;
	private String surname;
	private String name;
	private Date birthDate;
	private Adress adress;
	private String phone;
	private String email;
	private String index;
	private int enrollmentYear;
	private int currentYearOfStudy;
	private StudentStatus studentStatus;
	private double averageGrade;
	private List<Grade> grades;
	private List<Subject> subjects;
	
	
	public Student(String surname, String name, Date birthDate, Adress adress, String phone, String email, String index,
			int enrollmentYear, int currentYearOfStudy, StudentStatus studentStatus) {
		super();
		this.surname = surname;
		this.name = name;
		this.birthDate = birthDate;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
		this.index = index;
		this.enrollmentYear = enrollmentYear;
		this.currentYearOfStudy = currentYearOfStudy;
		this.studentStatus = studentStatus;
		this.averageGrade = 0;
		this.grades = new ArrayList<Grade>();
		this.subjects = new ArrayList<Subject>();
	}

	public Student(String surname, String name, Date birthDate, Adress adress, String phone, String email, String index,
			int enrollmentYear, int currentYearOfStudy, StudentStatus studentStatus, double averageGrade,
			List<Grade> grades, List<Subject> subjects) {
		super();
		this.surname = surname;
		this.name = name;
		this.birthDate = birthDate;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
		this.index = index;
		this.enrollmentYear = enrollmentYear;
		this.currentYearOfStudy = currentYearOfStudy;
		this.studentStatus = studentStatus;
		this.averageGrade = averageGrade;
		this.grades = grades;
		this.subjects = subjects;
	}


	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public int getEnrollmentYear() {
		return enrollmentYear;
	}

	public void setEnrollmentYear(int enrollmentYear) {
		this.enrollmentYear = enrollmentYear;
	}

	public int getCurrentYearOfStudy() {
		return currentYearOfStudy;
	}

	public void setCurrentYearOfStudy(int currentYearOfStudy) {
		this.currentYearOfStudy = currentYearOfStudy;
	}

	public StudentStatus getStudentStatus() {
		return studentStatus;
	}

	public void setStudentStatus(StudentStatus studentStatus) {
		this.studentStatus = studentStatus;
	}

	public double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setExams(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public int getTotalESBP() {
		int sum = 0;
		if(grades != null) {
			for(Grade o : this.grades) {
				sum += o.getSubject().getESPB();
			}
		}
		return sum;
	}
	
	public void recalculateAvgGrade() {
		double total = 0;
		int count = 0;
		if(grades != null) {
			for(Grade g : grades) {
				total += g.getGrade();
				++count;
			}
			averageGrade = total / count;
			averageGrade = Math.round(averageGrade*100.0)/100.0;
		}
	}
	
}
