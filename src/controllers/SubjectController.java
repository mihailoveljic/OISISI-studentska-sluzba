package controllers;

import models.DbSubjects;
import models.Professor;
import models.Semester;
import models.Subject;
import views.SubjectEditFrame;
import views.SubjectPanel;

public class SubjectController {
	
	
	Semester formattedSemester;
	int formattedEspb;
	
	public String addSubject(String id, String name, int currentYearOfStudy, int semester,
			String espb, Professor p) {
		
		String validationString = validateSubject(id, name, currentYearOfStudy,
				semester, espb, p);
		for(Subject s : DbSubjects.getInstance().getSubjects()) {
			if(s.getId().equals(id))
				return "ID predmeta mora biti jedinstven!";
		}
		
		if(validationString != "OK")
			return validationString;
		
		DbSubjects.getInstance().addSubject(id, name, formattedSemester,
				currentYearOfStudy + 1, p, formattedEspb);
		SubjectPanel.getInstance().updateView();
		
		return "OK";
	}
	
	public String editSubject(int rowSelectedIndex, String id, String name,
			int currentYearOfStudy, int semester, String espb, Professor p) {
		if (rowSelectedIndex < 0) {
			return "No row selected!";
		}
		// izmena modela
		Subject subject = DbSubjects.getInstance().getRow(rowSelectedIndex);
		
		String validationString = validateSubject(id, name, currentYearOfStudy,
				semester, espb, p);
		
		for(Subject s : DbSubjects.getInstance().getSubjects()) {
			if(s.getId().equals(id))
				if(s.getId() != SubjectEditFrame.getInstance().getOldId())
					return "ID predmeta mora biti jedinstven!";
		}
		
		if(validationString != "OK")
			return validationString;
		
		subject.setId(id);
		subject.setName(name);
		subject.setYearOfStudy(currentYearOfStudy + 1);
		subject.setSemester(formattedSemester);
		subject.setESPB(formattedEspb);
		if(subject.getProfessor() != null) {
			subject.getProfessor().getSubjects().remove(subject);
		}
		subject.setProfessor(p);
		p.getSubjects().add(subject);
	
		
		SubjectPanel.getInstance().updateView();
		
		return "OK";
	}
	
	public void deleteSubject(int selectedRow) {
		if(selectedRow<0) {
			return;
		} else {
			Subject s = DbSubjects.getInstance().getRow(selectedRow);
			DbSubjects.getInstance().deleteSubject(s.getId());
			SubjectPanel.getInstance().updateView();
		}
	}
	
	public String validateSubject(String id, String name, int currentYearOfStudy, int semester,
			String espb, Professor p) {
		
		
		try {
			formattedEspb = Integer.parseInt(espb);
		} catch(Exception e) {
			return "ESPB mora biti broj!";
		}
		
		switch(semester) {
		case 0:
			formattedSemester = Semester.LETNJI;
			break;
		case 1:
			formattedSemester = Semester.ZIMSKI;
			break;
		default:
			return "Nepostojeci odabir semestra!";
		}
		return "OK";
	}
}
