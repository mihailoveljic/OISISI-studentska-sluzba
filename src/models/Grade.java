package models;

import java.io.Serializable;
import java.util.Date;

public class Grade implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6191935341274419017L;
	private Student student;
	private Subject subject;
	private int grade;
	private Date evaluationDate;
	
	public Grade(Student student, Subject subject, int grade, Date evaluationDate) {
		super();
		this.student = student;
		this.subject = subject;
		this.grade = grade;
		this.evaluationDate = evaluationDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		if(grade >= 6 && grade <= 10) {
			this.grade = grade;
		}else {
			//TODO Odraditi obradu greške
			System.out.println("Ocena mora biti u intervalu 6-10!");
		}
		
	}

	public Date getEvaluationDate() {
		return evaluationDate;
	}

	public void setEvaluationDate(Date evaluationDate) {
		this.evaluationDate = evaluationDate;
	}
	
	
}
