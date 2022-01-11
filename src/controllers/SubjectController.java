package controllers;

import models.DbSubjects;
import models.Subject;
import views.SubjectPanel;

public class SubjectController {
	
	
	int IdSubject;
	String nameSubject;
	
	public void deleteSubject(int selectedRow) {
		if(selectedRow<0) {
			return;
		} else {
			Subject s = DbSubjects.getInstance().getRow(selectedRow);
			DbSubjects.getInstance().deleteSubject(s.getId());
			SubjectPanel.getInstance().updateView();
		}
}
}
