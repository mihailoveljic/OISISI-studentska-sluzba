package models;

import java.util.Date;

public class Grade {
	private Student student;
	private Exam exam;
	private int grade;
	private Date evaluationDate;
	
	public Grade(Student student, Exam exam, int grade, Date evaluationDate) {
		super();
		this.student = student;
		this.exam = exam;
		this.grade = grade;
		this.evaluationDate = evaluationDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
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
