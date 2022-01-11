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
				int userInput = JOptionPane.showOptionDialog(mainTabbedPane, "Da li ste sigurni da želite da obrišete studenta?", "Brisanje studenta", JOptionPane.YES_NO_OPTION, 0, null, null, e);
				if(userInput == JOptionPane.YES_OPTION) {
					StudentController studentController = new StudentController();
					studentController.deleteStudent(StudentTable.getInstance().getSelectedRow());
				}
			}else {
				JOptionPane.showMessageDialog(null, "Odaberi studenta prvo!");
			}
			break;
		case 1:
			if(ProfessorTable.getInstance().getSelectedRow() != -1) {
				int userInput = JOptionPane.showOptionDialog(mainTabbedPane, "Da li ste sigurni da želite da obrišete profesora?", "Brisanje profesora", JOptionPane.YES_NO_OPTION, 0, null, null, e);
				if(userInput == JOptionPane.YES_OPTION) {
					ProfessorController professorController = new ProfessorController();
					professorController.deleteProfessor(ProfessorTable.getInstance().getSelectedRow());
				}
			}else {
				JOptionPane.showMessageDialog(null, "Odaberi profesora prvo!");
			}
			break;
		case 2:
			//TODO Edit Subject
			if(SubjectTable.getInstance().getSelectedRow() != -1) {
				int userInput = JOptionPane.showOptionDialog(mainTabbedPane, "Da li ste sigurni da želite da obrišete predmet?", "Brisanje predmeta", JOptionPane.YES_NO_OPTION, 0, null, null, e);
				if(userInput == JOptionPane.YES_OPTION) {
					SubjectController subjectController = new SubjectController();
					subjectController.deleteSubject(SubjectTable.getInstance().getSelectedRow());
				}
			}else {
				JOptionPane.showMessageDialog(null, "Odaberi predmet prvo!");
			}
			break;
		default:
			System.out.println("ERROR");
			break;
		}	
	}

}
