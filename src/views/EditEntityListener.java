package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EditEntityListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame mainFrame = MainFrame.getInstance();
		
		JPanel panel = (JPanel) mainFrame.getContentPane();
		
		MainTabbedPane mainTabbedPane = (MainTabbedPane) panel.getComponent(2);
		
		switch(mainTabbedPane.getSelectedIndex()) {
		case 0:
			StudentEditFrame studentEditFrame;
			if(StudentTable.getInstance().getSelectedRow() != -1) {
				studentEditFrame = StudentEditFrame.getInstance();
				StudentInfoPanel.getInstance().updateStudentSelection(StudentTable.getInstance().getSelectedRow());
				studentEditFrame.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "Odaberi studenta prvo!");
			}
			break;
		case 1:
			ProfessorEditFrame professorEditFrame;
			if(ProfessorTable.getInstance().getSelectedRow() != -1) {
				professorEditFrame=ProfessorEditFrame.getInstance();
				ProfessorInfoPanel.getInstance().updateProfessorSelection(ProfessorTable.getInstance().getSelectedRow());
				professorEditFrame.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "Odaberi profesora prvo!");
			}
			break;
		case 2:
			SubjectEditFrame subjectEditFrame;
			if(SubjectTable.getInstance().getSelectedRow() != -1) {
				subjectEditFrame = SubjectEditFrame.getInstance();
				subjectEditFrame.updateSubjectSelection(SubjectTable.getInstance().getSelectedRow());
				subjectEditFrame.setVisible(true);
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
