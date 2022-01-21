package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controllers.ProfessorController;
import controllers.StudentController;
import controllers.SubjectController;

public class DeleteEntityListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame mainFrame = MainFrame.getInstance();
		
		JPanel panel = (JPanel) mainFrame.getContentPane();
		
		MainTabbedPane mainTabbedPane = (MainTabbedPane) panel.getComponent(2);
		
		switch(mainTabbedPane.getSelectedIndex()) {
		case 0:
			if(StudentTable.getInstance().getSelectedRow() != -1) {
				int userInput = JOptionPane.showOptionDialog(mainTabbedPane, MainFrame.getInstance().getResourceBundle().getString("sureToDeleteStudent"), MainFrame.getInstance().getResourceBundle().getString("deleteStudent"), JOptionPane.YES_NO_OPTION, 0, null, null, e);
				if(userInput == JOptionPane.YES_OPTION) {
					StudentController studentController = new StudentController();
					studentController.deleteStudent(StudentTable.getInstance().getSelectedRow());
				}
			}else {
				JOptionPane.showMessageDialog(null, MainFrame.getInstance().getResourceBundle().getString("studentNotChosen"));
			}
			break;
		case 1:
			if(ProfessorTable.getInstance().getSelectedRow() != -1) {
				int userInput = JOptionPane.showOptionDialog(mainTabbedPane, MainFrame.getInstance().getResourceBundle().getString("sureToDeleteProfessor"), MainFrame.getInstance().getResourceBundle().getString("professorDelete"), JOptionPane.YES_NO_OPTION, 0, null, null, e);
				if(userInput == JOptionPane.YES_OPTION) {
					ProfessorController professorController = new ProfessorController();
					professorController.deleteProfessor(ProfessorTable.getInstance().getSelectedRow());
				}
			}else {
				JOptionPane.showMessageDialog(null, MainFrame.getInstance().getResourceBundle().getString("professorNotChosen"));
			}
			break;
		case 2:
			//TODO Edit Subject
			if(SubjectTable.getInstance().getSelectedRow() != -1) {
				int userInput = JOptionPane.showOptionDialog(mainTabbedPane, MainFrame.getInstance().getResourceBundle().getString("sureToDeleteSubject"), MainFrame.getInstance().getResourceBundle().getString("subjectDelete"), JOptionPane.YES_NO_OPTION, 0, null, null, e);
				if(userInput == JOptionPane.YES_OPTION) {
					SubjectController subjectController = new SubjectController();
					subjectController.deleteSubject(SubjectTable.getInstance().getSelectedRow());
				}
			}else {
				JOptionPane.showMessageDialog(null, MainFrame.getInstance().getResourceBundle().getString("subjectNotChosen"));
			}
			break;
		default:
			System.out.println(MainFrame.getInstance().getResourceBundle().getString("error"));
			break;
		}	
	}

}
