package models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import views.MainFrame;

public class DbProfessors {
	
	private static DbProfessors instance = null;
	
	public static DbProfessors getInstance() {
		if(instance==null) {
			instance = new DbProfessors();
		}
		return instance;
	}
	
	private List<Professor> professors;
	private List<String>	columns;
	
	private DbProfessors() {
		initProfessors();
		
		this.columns=new ArrayList<String>();
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("name"));
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("surname"));
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("title"));
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("email"));
	}
	
	private void initProfessors() {
		this.professors= new ArrayList<Professor>();		
	}
	
	public List<Professor> getProfessors() {
		return professors;
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public String getColumnName(int index) {
		return this.columns.get(index);
	}
	
	public Professor getRow(int rowIndex) {
		if(rowIndex <= -1)
			return null;
		return this.professors.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Professor professor = this.professors.get(row);
		switch(column) {
		case 0:
			return professor.getName();
		case 1:
			return professor.getSurname();
		case 2:
			return professor.getTitle();
		case 3:
			return professor.getEmail();
			default:
				return null;
		}
	}
	
	public void addProfessor(String surname, String name, Date birthDate, Adress adress, String phone, String email,
			Adress officeAdress, int idNumber, String title, int serviceYears) {
		this.professors.add(new Professor(surname, name, birthDate, adress, phone, email, officeAdress, idNumber, title, serviceYears, null));
	}
	
	public void editProfessor(String surname, String name, Date birthDate, Adress adress, String phone, String email,
			Adress officeAdress, int idNumber, String title, int serviceYears) {
		for(Professor i: professors) {
			if(i.getIdNumber()==idNumber) {
				i.setSurname(surname);
				i.setName(name);
				i.setBirthDate(birthDate);
				i.setAdress(adress);
				i.setPhone(phone);
				i.setEmail(email);
				i.setOfficeAdress(officeAdress);
				i.setIdNumber(idNumber);
				i.setTitle(title);
				i.setServiceYears(serviceYears);
			}
		}
	}
	
	
	public void deleteProfessor(int idNumber) {
		for(Professor i : professors) {
			if(i.getIdNumber()==idNumber) {
				professors.remove(i);
				
				List<Subject> subjects = i.getSubjects();
				if(subjects!=null) {
					for(Subject s: subjects) {
						s.setProfessor(null);
					}
				}
				
				break;
			}
		}
	}
	
	public Professor findProfessor(String name, String surname, String email) {
		for(Professor p : professors) {
			if(p.getName().equals(name) && p.getSurname().equals(surname) && p.getEmail().equals(email))
				return p;
		}
		return null;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

}
