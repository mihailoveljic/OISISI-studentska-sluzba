package controllers;

import java.util.Date;

import javax.swing.JOptionPane;

import models.Adress;
import models.DbStudents;
import models.Student;
import models.StudentStatus;
import views.StudentInfoPanel;
import views.StudentPanel;
import views.StudentTable;


public class StudentController {
	
	int formattedEnrollmentYear;
	Date formattedDate;
	Adress formattedAdress;
	String formattedPhone;
	int formattedCurrentYearOfStudy;
	StudentStatus formattedStudentStatus;
	
	public void searchStudent(String text) {
		if(text.equals(""))
		{
			StudentTable.getInstance().clearFilter();
			StudentPanel.getInstance().updateView();
		}
		
		String words[] = text.trim().split("\\s+");
		
		if(words.length == 1) {
		String surname = words[0];
				StudentTable.getInstance().setFilter(surname, 2);
				StudentPanel.getInstance().updateView();
		}
		
		
		else if(words.length == 2) {
		String surname = words[0];
		String name = words[1];
			StudentTable.getInstance().set2Filter(surname, 2, name, 1);
			StudentPanel.getInstance().updateView();
		}
		
		else if(words.length == 3) {
			String surname = words[0];
			String name = words[1];
			String index = words[2];
				StudentTable.getInstance().set3Filter(surname, 2, name, 1, index, 0);
				StudentPanel.getInstance().updateView();
			}
		
		else {

			JOptionPane.showMessageDialog(null,
					"Unete vrednosti nisu dobre! Moguæe opcije su: <prezime>, <prezime ime>, <prezime ime indeks>.",
					"Upozorenje!", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
	
	public String addStudent(String surname, String name, String birthDate, String street, String number, String city, String country, String phone, String email, String index,
			String enrollmentYear, int currentYearOfStudy, int studentStatus) {
		
		
		String validationString = validateStudent(surname, name, birthDate, street, number, city, country, phone, email, index, enrollmentYear, currentYearOfStudy, studentStatus);
		for(Student s : DbStudents.getInstance().getStudents()) {
			if(s.getIndex().equals(index))
				return "Indeks studenta mora biti jedinstven!";
		}
		
		if(validationString != "OK")
			return validationString;
		
			
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
	
	public String editStudent(int rowSelectedIndex, String surname, String name, String birthDate, String street, String number, String city, String country, String phone, String email, String index,
			String enrollmentYear, int currentYearOfStudy, int studentStatus) {
		if (rowSelectedIndex < 0) {
			return "No row selected!";
		}
		// izmena modela
		Student student = DbStudents.getInstance().getRow(rowSelectedIndex);
		
		String validationString = validateStudent(surname, name, birthDate, street, number, city, country, phone, email, index, enrollmentYear, currentYearOfStudy, studentStatus);
		for(Student s : DbStudents.getInstance().getStudents()) {
			if(s.getIndex().equals(index))
				if(!s.getIndex().equals(StudentInfoPanel.getInstance().getOldIndex()))
					return "Indeks studenta mora biti jedinstven!";
		}
		
		if(validationString != "OK")
			return validationString;
		
		student.setSurname(surname);
		student.setName(name);
		student.setBirthDate(formattedDate);
		student.setAdress(formattedAdress);
		student.setPhone(formattedPhone);
		student.setEmail(email);
		student.setIndex(index);
		student.setEnrollmentYear(formattedEnrollmentYear);
		student.setCurrentYearOfStudy(formattedCurrentYearOfStudy);
		student.setStudentStatus(formattedStudentStatus);
		
		// azuriranje prikaza
		StudentPanel.getInstance().updateView();
		return "OK";
		}
	
	@SuppressWarnings("deprecation")
	private String validateStudent(String surname, String name, String birthDate, String street, String number, String city, String country, String phone, String email, String index,
			String enrollmentYear, int currentYearOfStudy, int studentStatus) {
				
				
		
				try {
				String parts[] = birthDate.split("[.]");
				if(parts.length >= 3) {
					formattedDate = new Date(Integer.parseInt(parts[2]), Integer.parseInt(parts[1]) - 1, Integer.parseInt(parts[0]));
				}else {
					return "Unesite datum u formatu: DD.MM.YYYY.";
				}
				}catch(Exception e){
					return "Unesite datum u formatu: DD.MM.YYYY.";
				}
				

					
				if(street.equals(""))
					return "Unesite ulicu!";
				if(number.equals(""))
					return "Unesite broj!";
				if(city.equals(""))
					return "Unesite grad!";
				if(country.equals(""))
					return "Unesite drzavu!";
				formattedAdress= new Adress(street, number, city, country);
				
				
//				formattedPhone = phone;
//				try {
//					formattedPhone = formattedPhone.replace(" ", "");
//					formattedPhone = formattedPhone.replace(".", "");
//					formattedPhone = formattedPhone.replace(",", "");
//					formattedPhone = formattedPhone.replace("(", "");
//					formattedPhone = formattedPhone.replace(")", "");
//					boolean isValid = formattedPhone.matches("^(\\+)(381)([0-9]){7,10}$");
//					if(!isValid) {
//						return "Unesite ispravan broj telefona sa pozivnim brojem +381";
//					}
//				}catch(Exception e){
//					return "Unesite ispravan broj telefona sa pozivnim brojem +381";
//				}
				
				if(phone.equals(""))
					return "Unesite broj telefona!";
				formattedPhone=phone;
				
				try {
					boolean isValid = email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
					if(!isValid) {
						return "Unesite ispravan email!";
					}
				}catch(Exception e) {
					return "Unesite ispravan email!";
				}
				
				
				try {
					formattedEnrollmentYear = Integer.parseInt(enrollmentYear);
				}catch(Exception e) {
					return "Godina upisa mora biti broj!";
				}
				
				formattedCurrentYearOfStudy = currentYearOfStudy + 1;
				
				
				
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
				
				return "OK";
	}
}
