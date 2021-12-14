package controllers;

import java.util.Date;

import models.Adress;
import models.DbStudents;
import models.Student;
import models.StudentStatus;
import views.StudentPanel;


public class StudentController {
	
	public void addStudent(String surname, String name, Date birthDate, Adress adress, String phone, String email, String index,
			int enrollmentYear, int currentYearOfStudy, StudentStatus studentStatus) {
		// izmena modela
		DbStudents.getInstance().addStudent(surname, name, birthDate, adress, phone, email,
				index, enrollmentYear, currentYearOfStudy, studentStatus);
		// azuriranje prikaza
		StudentPanel.getInstance().updateView();
	}
	
    public void deleteStudent(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	// izmena modela
    	Student student = DbStudents.getInstance().getRow(rowSelectedIndex);
		DbStudents.getInstance().deleteStudent(student.getIndex());
		// azuriranje prikaza
		StudentPanel.getInstance().updateView();
		}
	
	public void editStudent(int rowSelectedIndex, String surname, String name, Date birthDate, Adress adress, String phone, String email, String index,
			int enrollmentYear, int currentYearOfStudy, StudentStatus studentStatus, double averageGrade) {
		if (rowSelectedIndex < 0) {
			return;
		}
		// izmena modela
		Student student = DbStudents.getInstance().getRow(rowSelectedIndex);
		// TODO: izmena dodatnih polja modela tabele
		DbStudents.getInstance().editStudent(surname, name, birthDate, adress, phone, email, index, enrollmentYear,
				currentYearOfStudy, studentStatus, averageGrade);
		// azuriranje prikaza
		StudentPanel.getInstance().updateView();
		}
	
	
	
}
