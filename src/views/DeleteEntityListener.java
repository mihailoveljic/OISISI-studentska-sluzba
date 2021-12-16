package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controllers.StudentController;

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
				JOptionPane.showMessageDialog(null, "Odaberi studenta studenta prvo!");
			}
			break;
		case 1:
			//TODO Edit Professor
			break;
		case 2:
			//TODO Edit Subject
			break;
		default:
			System.out.println("ERROR");
			break;
		}	
	}

}
