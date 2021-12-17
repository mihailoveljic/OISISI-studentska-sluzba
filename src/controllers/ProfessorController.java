package controllers;

import java.sql.Date;

import models.Adress;
import models.DbProfessors;
import models.Professor;
import views.ProfessorPanel;

public class ProfessorController {
	
	Date formattedBirthDate;
	Adress formattedAdress;
	String formattedPhone;
	String formattedEmail;
	Adress formattedOfficeAdress;
	int formattedIdNumber;
	int formattedServiceYears;

	public String addProfessor(String surname, String name, String birthDate, String adress, String phone, String email,
			String officeAdress, String idNumber, String title, String serviceYears) {
		
		String validationString = validateProfessor(surname, name, birthDate, adress, phone, email,
			 officeAdress, idNumber, title, serviceYears);
		if(validationString != "OK")
			return validationString;
		
		
		DbProfessors.getInstance().addProfessor (surname, name, formattedBirthDate, formattedAdress, formattedPhone, formattedEmail,
				formattedOfficeAdress, formattedIdNumber, title, formattedServiceYears);
		
		ProfessorPanel.getInstance().updateView();
		return "OK";
	}

	@SuppressWarnings("deprecation")
	private String validateProfessor(String surname, String name, String birthDate, String adress, String phone,
			String email, String officeAdress, String idNumber, String title, String serviceYears) {
		
		try {
			String parts[] = birthDate.split("[.]");
			if(parts.length >= 3) {
				formattedBirthDate = new Date(Integer.parseInt(parts[2]), Integer.parseInt(parts[1]), Integer.parseInt(parts[0]));
			}else {
				return "Unesite datum u formatu: DD.MM.YYYY.";
			}
			}catch(Exception e){
				return "Unesite datum u formatu: DD.MM.YYYY.";
			}
		
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
		
		formattedPhone = phone;
		try {
			formattedPhone = formattedPhone.replace(" ", "");
			formattedPhone = formattedPhone.replace(".", "");
			formattedPhone = formattedPhone.replace(",", "");
			formattedPhone = formattedPhone.replace("(", "");
			formattedPhone = formattedPhone.replace(")", "");
			boolean isValid = formattedPhone.matches("^(\\+)(381)([0-9]){7,10}$");
			if(!isValid) {
				return "Unesite ispravan broj telefona sa pozivnim brojem +381";
			}
		}catch(Exception e){
			return "Unesite ispravan broj telefona sa pozivnim brojem +381";
		}
		
		formattedEmail=email;
		try {
			boolean isValid = formattedEmail.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
			if(!isValid) {
				return "Unesite ispravan email!";
			}
		}catch(Exception e) {
			return "Unesite ispravan email!";
		}
	
		try {
			officeAdress = officeAdress.replace(" ", "");
			String parts[] = officeAdress.split(",");
			if(parts.length == 4) {
				formattedOfficeAdress = new Adress(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3]);
			}else {
				return "Unesite adresu u formatu: ULICA, BROJ, MESTO, DRZAVA";
			}
			}catch(Exception e){
				return "Unesite adresu u formatu: ULICA, BROJ, MESTO, DRZAVA";
			}
		
		
		try {
			formattedIdNumber=Integer.parseInt(idNumber);
		} catch(Exception e) {
				return "Neispravan broj lične karte!";	
		}
		
		try {
			formattedServiceYears=Integer.parseInt(serviceYears);
		} catch(Exception e) {
				return "Neispravan unet radni staž!";	
		}
		
		
		return "OK";
	}
	
	public String editProfessor(int rowSelectedIndex, String surname, String name, String birthDate, String adress, String phone, String email,
			String officeAdress, String idNumber, String title, String serviceYears) {
		if(rowSelectedIndex<0) {
			return "NO ROW SELECTED!";
		}
		
		Professor profesor = DbProfessors.getInstance().getRow(rowSelectedIndex);
		
		String validationString = validateProfessor(surname,name,birthDate, adress, phone, email,
				 officeAdress, idNumber, title,serviceYears);
		if(validationString!="OK")
			return validationString;
		
		profesor.setSurname(surname);
		profesor.setName(name);
		profesor.setBirthDate(formattedBirthDate);
		profesor.setAdress(formattedAdress);
		profesor.setPhone(phone);
		profesor.setEmail(email);
		profesor.setOfficeAdress(formattedOfficeAdress);
		profesor.setIdNumber(Integer.parseInt(idNumber));
		profesor.setTitle(title);
		profesor.setServiceYears(Integer.parseInt(serviceYears));
		
		ProfessorPanel.getInstance().updateView();
		
		return "OK";
	}
	
	public void deleteProfessor(int selectedRow) {
			if(selectedRow<0) {
				return;
			} else {
				Professor p = DbProfessors.getInstance().getRow(selectedRow);
				DbProfessors.getInstance().deleteProfessor(p.getIdNumber());
				ProfessorPanel.getInstance().updateView();
			}
	}
	
}
