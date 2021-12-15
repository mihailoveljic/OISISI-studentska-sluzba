package controllers;

import java.util.Date;

import models.Adress;
import models.DbStudents;
import models.Student;
import models.StudentStatus;
import views.StudentPanel;


public class StudentController {
	
	@SuppressWarnings("deprecation")
	public String addStudent(String surname, String name, String birthDate, String adress, String phone, String email, String index,
			String enrollmentYear, int currentYearOfStudy, int studentStatus) {
		
		
		// Validatition
		Date formattedDate;
		try {
		String parts[] = birthDate.split("[.]");
		if(parts.length >= 3) {
			formattedDate = new Date(Integer.parseInt(parts[2]), Integer.parseInt(parts[1]), Integer.parseInt(parts[0]));
		}else {
			return "Unesite datum u formatu: DD.MM.YYYY.";
		}
		}catch(Exception e){
			return "Unesite datum u formatu: DD.MM.YYYY.";
		}
		
		Adress formattedAdress;
		try {
		adress = adress.replace(" ", "");
		String parts[] = adress.split(",");
		if(parts.length == 4) {
			formattedAdress = new Adress(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3]);
		}else {
			return "Unesite adresu u formatu: ULICA, BROJ, MESTO, DRZAVA";
		}
		}catch(Exception e){
			return "Unesite adresu u formatu: ULICA, BROJ, MESTO, DRZAVA";
		}
		
		String formattedPhone = phone;
		try {
			formattedPhone = formattedPhone.replace(" ", "");
			formattedPhone = formattedPhone.replace(".", "");
			formattedPhone = formattedPhone.replace(",", "");
			formattedPhone = formattedPhone.replace("(", "");
			formattedPhone = formattedPhone.replace(")", "");
			boolean isValid = formattedPhone.matches("^(\\+)(3816)([0-9]){6,9}$");
			if(!isValid) {
				return "Unesite ispravan broj telefona sa pozivnim brojem +381";
			}
		}catch(Exception e){
			return "Unesite ispravan broj telefona sa pozivnim brojem +381";
		}
		
		try {
			boolean isValid = email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
			if(!isValid) {
				return "Unesite ispravan email!";
			}
		}catch(Exception e) {
			return "Unesite ispravan email!";
		}
		
		int formattedEnrollmentYear;
		try {
			formattedEnrollmentYear = Integer.parseInt(enrollmentYear);
		}catch(Exception e) {
			return "Godina upisa mora biti broj!";
		}
		
		int formattedCurrentYearOfStudy = currentYearOfStudy + 1;
		
		StudentStatus formattedStudentStatus;
		
		switch(studentStatus) {
		case 0:
			formattedStudentStatus = StudentStatus.B;
			break;
		case 1:
			formattedStudentStatus = StudentStatus.S;
			break;
		default:
			return "Nepostojeci odabir statusa studenta!";
		}
		
		// izmena modela
		DbStudents.getInstance().addStudent(surname, name, formattedDate, formattedAdress, formattedPhone, email,
				index, formattedEnrollmentYear, formattedCurrentYearOfStudy, formattedStudentStatus);
		// azuriranje prikaza
		StudentPanel.getInstance().updateView();
		return "OK";
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
