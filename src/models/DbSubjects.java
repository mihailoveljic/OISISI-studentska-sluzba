package models;

import java.util.ArrayList;
import java.util.List;

import views.MainFrame;

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
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("subjectId"));
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("subjectName"));
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("espb"));
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("yearOfStudy"));
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("semester"));
	}
	
	private void initSubject() {
		this.subjects=new ArrayList<Subject>();
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
				return MainFrame.getInstance().getResourceBundle().getString("winter");
			} 
			else {
				return MainFrame.getInstance().getResourceBundle().getString("summer");
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

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public void reloadUI() {
		this.columns=new ArrayList<String>();
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("subjectId"));
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("subjectName"));
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("espb"));
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("yearOfStudy"));
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("semester"));
	}
}
