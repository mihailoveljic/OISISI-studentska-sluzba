package models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
		this.columns.add("IME");
		this.columns.add("PREZIME");
		this.columns.add("ZVANJE");
		this.columns.add("E-MAIL ADRESA");
	}
	
	@SuppressWarnings("deprecation")
	private void initProfessors() {
		this.professors= new ArrayList<Professor>();
		
		//TODO ucitavace se iz datoteke
		
		professors.add(new Professor("Imenko1", "Prezimenkovic1", new Date(1960, 11, 21), new Adress("Tolstojeva", "42", "mesto", "drzava"), "+38161247888", "sasasa@gmail.com", new Adress("sasa", "42", "grad", "drzava"), 1,
				"Doktor", 4));
		professors.add(new Professor("Imenko2", "Prezimenkovic2", new Date(1960, 11, 21), new Adress("Tolstojeva", "42", "mesto", "drzava"), "+38161247888", "sasasa@gmail.com", new Adress("sasa", "42", "grad", "drzava"), 2,
				"Doktor", 4));
		professors.add(new Professor("Imenko3", "Prezimenkovic3", new Date(1960, 11, 21), new Adress("Tolstojeva", "42", "mesto", "drzava"), "+38161247888", "sasasa@gmail.com", new Adress("sasa", "42", "grad", "drzava"), 3,
				"Doktor", 4));
		professors.add(new Professor("Imenko4", "Prezimenkovic4", new Date(1960, 11, 21), new Adress("Tolstojeva", "42", "mesto", "drzava"), "+38161247888", "sasasa@gmail.com", new Adress("sasa", "42", "grad", "drzava"), 4,
				"Doktor", 4));
		professors.add(new Professor("Imenko5", "Prezimenkovic5", new Date(1960, 11, 21), new Adress("Tolstojeva", "42", "mesto", "drzava"), "+38161247888", "sasasa@gmail.com", new Adress("sasa", "42", "grad", "drzava"), 5,
				"Doktor", 4));

		professors.get(0).getSubjects().add(new Subject("10", "Programski prevodioci",Semester.ZIMSKI, 1, 2));
		professors.get(0).getSubjects().add(new Subject("11", "Baze podataka",Semester.ZIMSKI, 2, 12));
		professors.get(0).getSubjects().add(new Subject("12", "Fizika",Semester.ZIMSKI, 3, 42));
		
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
	
	

}
