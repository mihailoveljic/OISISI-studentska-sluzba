package models;

import java.util.ArrayList;
import java.util.List;

public class DbSubjects {
	
	private static DbSubjects instance = null;
	
	public static DbSubjects getInstance() {
		if(instance == null) {
			instance = new DbSubjects();
		}
		return instance;
	}
	
	private List<Subject> subjects;
	private List<String> columns;
	
	private DbSubjects() {
		initSubject();
		
		this.columns=new ArrayList<String>();
		this.columns.add("SIFRA PREDMETA");
		this.columns.add("NAZIV PREDMETA");
		this.columns.add("BROJ ESPB BODOVA");
		this.columns.add("GODINA NA KOJOJ SE PREDMET IZVODI");
		this.columns.add("SEMESTAR U KOME SE PREDMET IZVODI");
	}
	
	private void initSubject() {
		this.subjects=new ArrayList<Subject>();
		
		//TODO iz datoteke 
		
		subjects.add(new Subject("1", "MATEMATICKA ANALIZA 1",Semester.ZIMSKI, 1, 1000));
		subjects.add(new Subject("2", "MATEMATICKA ANALIZA 1",Semester.ZIMSKI, 1, 1000));
		subjects.add(new Subject("3", "MATEMATICKA ANALIZA 1",Semester.ZIMSKI, 1, 1000));
		subjects.add(new Subject("4", "MATEMATICKA ANALIZA 1",Semester.ZIMSKI, 1, 1000));
		subjects.add(new Subject("5", "MATEMATICKA ANALIZA 1",Semester.ZIMSKI, 1, 1000));

	}
	
	
	public List<Subject> getSubjects() {
		return subjects;
	}
	
	public int getColumnCount() {
		return 5;
	}
	
	
	public String getColumnName(int index) {
		return this.columns.get(index);
	}
	
	public String getValueAt(int row, int column) {
		Subject subjects = this.subjects.get(row);
		switch(column) {
		case 0:
			return subjects.getId();
		case 1:
			return subjects.getName();
		case 2:
			return Integer.toString(subjects.getESPB());
		case 3:
			return Integer.toString(subjects.getYearOfStudy());
		case 4:
			if(subjects.getSemester() == Semester.ZIMSKI) {
				return "ZIMSKI";
			} 
			else {
				return "LETNJI";
			}
			default:
					return null;
		}
	}
	
	
	public void addSubject(String id, String name, Semester semester, 
			int yearOfStudy, Professor professor, int ESPB) {
		
		this.subjects.add(new Subject(id, name, semester, yearOfStudy, professor, ESPB, null, null));
	}
	
	public void editSubject(String id, String name, Semester semester, 
			int yearOfStudy, Professor professor, int ESPB) {
		for(Subject i : subjects) {
			if(i.getId()==id) {
				i.setName(name);
				i.setSemester(semester);
				i.setYearOfStudy(yearOfStudy);
				i.setProfessor(professor);
				i.setESPB(ESPB);
			}
		}
	}
	
	public void deleteSubject(String id) {
		for (Subject i : subjects) {
			if(i.getId()==id) {
				subjects.remove(i);
				break;
			}
		}
	}
	
	public Subject getRow(int rowIndex) {
		if(rowIndex <= -1)
			return null;
		return this.subjects.get(rowIndex);
	}
	
	public Subject findSubjectById(String id) {
		for(Subject s: subjects) {
			if(s.getId().equals(id))
				return s;
		}
		return null;
	}
}
