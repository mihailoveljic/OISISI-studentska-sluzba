package controllers;

import javax.swing.JOptionPane;
import java.util.ArrayList;

import models.DbSubjects;
import models.Professor;
import models.Semester;
import models.Subject;
import views.MainFrame;
import views.SubjectEditFrame;
import views.SubjectPanel;
import views.SubjectTable;

public class SubjectController {
	
	
	Semester formattedSemester;
	int formattedEspb;
	
	public String addSubject(String id, String name, int currentYearOfStudy, int semester,
			String espb, Professor p) {
		
		String validationString = validateSubject(id, name, currentYearOfStudy,
				semester, espb, p);
		for(Subject s : DbSubjects.getInstance().getSubjects()) {
			if(s.getId().equals(id))
				return MainFrame.getInstance().getResourceBundle().getString("idSubjectUnique");
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
			return "NO ROW SELECTED!";
		}
		// izmena modela
		Subject subject = DbSubjects.getInstance().findSubjectById((String)SubjectTable.getInstance().getValueAt(SubjectTable.getInstance().getSelectedRow(), 0));
		
		String validationString = validateSubject(id, name, currentYearOfStudy,
				semester, espb, p);
		
		for(Subject s : DbSubjects.getInstance().getSubjects()) {
			if(s.getId().equals(id))
				if(s.getId() != SubjectEditFrame.getInstance().getOldId())
					return MainFrame.getInstance().getResourceBundle().getString("idSubjectUnique");
		}
		
		if(validationString != "OK")
			return validationString;
		
		subject.setId(id);
		subject.setName(name);
		subject.setYearOfStudy(currentYearOfStudy + 1);
		subject.setSemester(formattedSemester);
		subject.setESPB(formattedEspb);
		if(subject.getProfessor() != null) {
			if(subject.getProfessor().getSubjects()!=null)
			subject.getProfessor().getSubjects().remove(subject);
		}
		if(p != null) {
			subject.setProfessor(p);
			if(p.getSubjects()==null)
			{
				p.setSubjects(new ArrayList<Subject>());
			}
			p.getSubjects().add(subject);
		}
		
	
		
		SubjectPanel.getInstance().updateView();
		
		return "OK";
	}
	
	public void deleteSubject(int selectedRow) {
		if(selectedRow<0) {
			return;
		} else {
			Subject s = DbSubjects.getInstance().findSubjectById((String)SubjectTable.getInstance().getValueAt(SubjectTable.getInstance().getSelectedRow(), 0));
			DbSubjects.getInstance().deleteSubject(s.getId());
			SubjectPanel.getInstance().updateView();
		}
	}
	
	public String validateSubject(String id, String name, int currentYearOfStudy, int semester,
			String espb, Professor p) {
		
		
		try {
			formattedEspb = Integer.parseInt(espb);
		} catch(Exception e) {
			return MainFrame.getInstance().getResourceBundle().getString("espbFormat");
		}
		
		switch(semester) {
		case 0:
			formattedSemester = Semester.ZIMSKI;
			break;
		case 1:
			formattedSemester = Semester.LETNJI;
			break;
		default:
			return MainFrame.getInstance().getResourceBundle().getString("semesterChooseIncorrect");
		}
		return "OK";
	}
	public void searchSubject(String text) {
		if(text.equals(""))
		{
			SubjectTable.getInstance().clearFilter();
			SubjectPanel.getInstance().updateView();
		}
		else {
			String parts[] = text.split(",");
			if(parts.length == 1) {
			SubjectTable.getInstance().setFilter(text.trim(), 1);
			SubjectPanel.getInstance().updateView();
			} else if(parts.length == 2){
				SubjectTable.getInstance().set2Filter(parts[0], 1, parts[1], 0);
				SubjectPanel.getInstance().updateView();
			}else {

				JOptionPane.showMessageDialog(MainFrame.getInstance(),
						MainFrame.getInstance().getResourceBundle().getString("searchSubjects"),
						MainFrame.getInstance().getResourceBundle().getString("warning"), JOptionPane.ERROR_MESSAGE);
				return;
			}
	}
}
}
