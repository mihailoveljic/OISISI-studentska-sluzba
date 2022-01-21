package controllers;

import java.sql.Date;

import javax.swing.JOptionPane;

import models.Adress;
import models.DbProfessors;
import models.Professor;
import views.MainFrame;
import views.ProfessorInfoPanel;
import views.ProfessorPanel;
import views.ProfessorTable;

public class ProfessorController {
	
	Date formattedBirthDate;
	Adress formattedAdress;
	String formattedPhone;
	String formattedEmail;
	Adress formattedOfficeAdress;
	int formattedIdNumber;
	int formattedServiceYears;

	public String addProfessor(String surname, String name, String birthDate, String streetAdress, 
			String numberAdress, String cityAdress, String countryAdress, String phone, String email, String streetOfficeAdress,
			String numberOfficeAdress, String cityOfficeAdress, String countryOfficeAdress, String idNumber, String title, String serviceYears) {
		
		String validationString = validateProfessor(surname, name, birthDate, streetAdress, numberAdress, cityAdress, countryAdress, 
				phone, email, streetOfficeAdress, numberOfficeAdress, cityOfficeAdress, countryOfficeAdress, idNumber, title, serviceYears);
		
		for(Professor p : DbProfessors.getInstance().getProfessors()) {
			if(p.getIdNumber() == formattedIdNumber)
				return MainFrame.getInstance().getResourceBundle().getString("idUnique");
		}
		
		if(validationString != "OK")
			return validationString;
		
		
		DbProfessors.getInstance().addProfessor (surname, name, formattedBirthDate, formattedAdress, formattedPhone, formattedEmail,
				formattedOfficeAdress, formattedIdNumber, title, formattedServiceYears);
		
		ProfessorPanel.getInstance().updateView();
		return "OK";
	}

	@SuppressWarnings("deprecation")
	private String validateProfessor(String surname, String name, String birthDate, String streetAdress, String numberAdress,
			String cityAdress, String countryAdress, String phone, String email, String streetOfficeAdress, String numberOfficeAdress,
			String cityOfficeAdress, String countryOfficeAdress, String idNumber, String title, String serviceYears) {
		
	
		
		
		try {
			String parts[] = birthDate.split("[.]");
			if(parts.length >= 3) {
				formattedBirthDate = new Date(Integer.parseInt(parts[2]), Integer.parseInt(parts[1]) - 1, Integer.parseInt(parts[0]));
			}else {
				return MainFrame.getInstance().getResourceBundle().getString("dateFormat");
			}
			}catch(Exception e){
				return MainFrame.getInstance().getResourceBundle().getString("dateFormat");
			}
		
			if(streetAdress == null)
				return MainFrame.getInstance().getResourceBundle().getString("enterStreet");
			if(numberAdress == null)
				return MainFrame.getInstance().getResourceBundle().getString("enterNumber");
			if(cityAdress == null)
				return MainFrame.getInstance().getResourceBundle().getString("enterCity");
			if(countryAdress == null)
				return MainFrame.getInstance().getResourceBundle().getString("enterCountry");
			
			formattedAdress = new Adress(streetAdress, numberAdress, cityAdress, countryAdress);
			
//		formattedPhone = phone;
//		try {
//			formattedPhone = formattedPhone.replace(" ", "");
//			formattedPhone = formattedPhone.replace(".", "");
//			formattedPhone = formattedPhone.replace(",", "");
//			formattedPhone = formattedPhone.replace("(", "");
//			formattedPhone = formattedPhone.replace(")", "");
//			boolean isValid = formattedPhone.matches("^(\\+)(381)([0-9]){7,10}$");
//			if(!isValid) {
//				return "Unesite ispravan broj telefona sa pozivnim brojem +381";
//			}
//		}catch(Exception e){
//			return "Unesite ispravan broj telefona sa pozivnim brojem +381";
//		}
		
			
		if(phone.equals(""))
			return MainFrame.getInstance().getResourceBundle().getString("enterPhone");
		formattedPhone = phone;
			
		formattedEmail=email;
		try {
			boolean isValid = formattedEmail.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
			if(!isValid) {
				return MainFrame.getInstance().getResourceBundle().getString("enterEmail");
			}
		}catch(Exception e) {
			return MainFrame.getInstance().getResourceBundle().getString("enterEmail");
		}
	
		if(streetOfficeAdress.equals(""))
			return MainFrame.getInstance().getResourceBundle().getString("enterStreetOffice");
		if(numberOfficeAdress.equals(""))
			return MainFrame.getInstance().getResourceBundle().getString("enterNumberOffice");
		if(cityOfficeAdress.equals(""))
			return MainFrame.getInstance().getResourceBundle().getString("enterCityOffice");
		if(countryOfficeAdress.equals(""))
			return MainFrame.getInstance().getResourceBundle().getString("enterCountryOffice");
		
		formattedOfficeAdress = new Adress(streetAdress, numberAdress, cityAdress, countryAdress);
		
		
		try {
			formattedIdNumber=Integer.parseInt(idNumber);
		} catch(Exception e) {
				return MainFrame.getInstance().getResourceBundle().getString("idIncorrect");	
		}
		

		
		
		try {
			formattedServiceYears=Integer.parseInt(serviceYears);
		} catch(Exception e) {
				return MainFrame.getInstance().getResourceBundle().getString("workYearsIncorrect");	
		}
		
		
		return "OK";
	}
	
	public String editProfessor(int rowSelectedIndex, String surname, String name, String birthDate, String streetAdress, 
			String numberAdress, String cityAdress, String countryAdress, String phone, String email, String streetOfficeAdress,
			String numberOfficeAdress, String cityOfficeAdress, String countryOfficeAdress, String idNumber, String title, String serviceYears) {
		
		if(rowSelectedIndex<0) {
			return "NO ROW SELECTED!";
		}
		
		Professor profesor = DbProfessors.getInstance().findProfessor(
				(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 0),
				(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 1),
				(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 3)			
				);
		
		String validationString = validateProfessor(surname,name,birthDate, streetAdress, numberAdress, cityAdress, countryAdress, phone, email,
				 streetOfficeAdress, numberOfficeAdress, cityOfficeAdress, countryOfficeAdress, idNumber, title,serviceYears);
		
		for(Professor p : DbProfessors.getInstance().getProfessors()) {
			if(p.getIdNumber() == formattedIdNumber)
				if(p.getIdNumber() != ProfessorInfoPanel.getInstance().getOldIdNumber())
					return MainFrame.getInstance().getResourceBundle().getString("idUnique");
		}
		
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
				Professor p = DbProfessors.getInstance().findProfessor(
						(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 0),
						(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 1),
						(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 3)			
						);
				DbProfessors.getInstance().deleteProfessor(p.getIdNumber());
				ProfessorPanel.getInstance().updateView();
			}
	}
	public void searchProfesor(String text) {
		if(text.equals(""))
		{
			ProfessorTable.getInstance().clearFilter();
			ProfessorPanel.getInstance().updateView();;
		}
		
		String words[] = text.trim().split("\\s+");
		
		if(words.length == 1) {
		String prezime = words[0];
				ProfessorTable.getInstance().setFilter(prezime, 1);
				ProfessorPanel.getInstance().updateView();;
		}
		
		
		else if(words.length == 2) {
		String prezime = words[0];
		String ime = words[1];
			ProfessorTable.getInstance().setFilters(prezime, 1, ime, 0);
			ProfessorPanel.getInstance().updateView();
		}
		
		else {
			JOptionPane.showMessageDialog(MainFrame.getInstance(),
					MainFrame.getInstance().getResourceBundle().getString("searchProfessor"),
					MainFrame.getInstance().getResourceBundle().getString("warning"), JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
	
}
