package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class AddEntityListener implements ActionListener{


	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame mainFrame = MainFrame.getInstance();
		
		JPanel panel = (JPanel) mainFrame.getContentPane();
		
		MainTabbedPane mainTabbedPane = (MainTabbedPane) panel.getComponent(2);
		
		switch(mainTabbedPane.getSelectedIndex()) {
		case 0:
			StudentAddFrame studentAddFrame = StudentAddFrame.getInstance();
			studentAddFrame.setVisible(true);
			break;
		case 1:
			ProfessorAddFrame professorAddFrame = ProfessorAddFrame.getInstance();
			professorAddFrame.setVisible(true);
			break;
		case 2:
			SubjectAddFrame subjectAddFrame = SubjectAddFrame.getInstance();
			subjectAddFrame.setVisible(true);
			break;
		default:
			System.out.println("ERROR");
			break;
		}
		
	}
}
