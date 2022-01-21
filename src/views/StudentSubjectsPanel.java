package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import models.DbStudents;
import models.DbSubjects;
import models.Student;
import models.Subject;

public class StudentSubjectsPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7743348763378268567L;
	
	private static StudentSubjectsPanel instance;

	private StudentSubjectTable studentSubjectTable;
	private JButton addGrade;
	private JButton deleteGrade;
	private JButton entryGrade;
	private JScrollPane scrollPane;
	StudentEntrySubject studentAddSubject;
	
	public StudentSubjectsPanel() {
		super();
		setLayout(new BorderLayout());
		studentSubjectTable = new StudentSubjectTable();
		scrollPane = new JScrollPane(studentSubjectTable);
		add(scrollPane, BorderLayout.CENTER);
		JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		addGrade = new JButton ("Dodaj");
		
		addGrade.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentAddSubjectDialog studentAddSubjectDialog = new StudentAddSubjectDialog();
				studentAddSubjectDialog.setLocationRelativeTo(StudentEditFrame.getInstance());
				studentAddSubjectDialog.setVisible(true);
				
			}
		});
		commandPanel.add(addGrade);
		add(commandPanel, BorderLayout.NORTH);
		
	
		deleteGrade = new JButton (MainFrame.getInstance().getResourceBundle().getString("delete"));
	
		deleteGrade.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(studentSubjectTable.getSelectedRow()!=-1)
			{
			Student s = DbStudents.getInstance().findStudentByIndex((String) StudentTable.getInstance().getValueAt(StudentTable.getInstance().getSelectedRow(), 0));
			if(s!=null)
			{
				int userInput = JOptionPane.showOptionDialog(StudentSubjectsPanel.getInstance(), MainFrame.getInstance().getResourceBundle().getString("sureToDeleteSubject"), MainFrame.getInstance().getResourceBundle().getString("subjectDelete"), JOptionPane.YES_NO_OPTION, 0, null, null, e);
				if(userInput == JOptionPane.YES_OPTION) {
					s.getSubjects().remove(studentSubjectTable.getSelectedRow());
					StudentSubjectsPanel.getInstance().refresh();
				}
			}
			}
			else {
				JOptionPane.showMessageDialog(StudentSubjectsPanel.getInstance(), "Niste selektovali predmet!", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
			}
		}
	});
	commandPanel.add(deleteGrade);
	add(commandPanel, BorderLayout.NORTH);
	
	entryGrade = new JButton (MainFrame.getInstance().getResourceBundle().getString("passing"));
	
	entryGrade.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Subject subject=null;
			int row = studentSubjectTable.getSelectedRow();
			if (row >= 0 &&  row < studentSubjectTable.getRowCount())
			{
			String index = (String) studentSubjectTable.getValueAt(row, 0);
			List<Subject> listSubjects = new ArrayList<Subject>();
			listSubjects = DbSubjects.getInstance().getSubjects();
			for(Subject s: listSubjects)
			{
				if(s.getId()==index)
				{
					subject=s;
				}
			}
			studentAddSubject = new StudentEntrySubject(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("gradeEntry"), true, subject);
			studentAddSubject.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(StudentSubjectsPanel.getInstance(), MainFrame.getInstance().getResourceBundle().getString("subjectNotChosen"), MainFrame.getInstance().getResourceBundle().getString("warning"), JOptionPane.WARNING_MESSAGE);
			}
		}
	});
	commandPanel.add(entryGrade);
	add(commandPanel, BorderLayout.NORTH);
}
	
	public static StudentSubjectsPanel getInstance()
	{
		if(instance == null)
			instance = new StudentSubjectsPanel();
		return instance;
	}

	public StudentSubjectTable getGradesTable() {
		return studentSubjectTable;
	}

	public void setGradesTable(StudentSubjectTable studentSubjectTable) {
		this.studentSubjectTable = studentSubjectTable;
	}

	public JButton getAddGrade() {
		return addGrade;
	}

	public void setAddGrade(JButton addGrade) {
		this.addGrade = addGrade;
	}

	public JButton getDeleteGrade() {
		return deleteGrade;
	}

	public void setDeleteGrade(JButton deleteGrade) {
		this.deleteGrade = deleteGrade;
	}

	public JButton getEntryGrade() {
		return entryGrade;
	}

	public void setEntryGrade(JButton entryGrade) {
		this.entryGrade = entryGrade;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setInstance(StudentSubjectsPanel instance) {
		StudentSubjectsPanel.instance = instance;
	}

	public StudentEntrySubject getStudentAddSubject() {
		return studentAddSubject;
	}

	public void setStudentAddSubject(StudentEntrySubject studentAddSubject) {
		this.studentAddSubject = studentAddSubject;
	}
	
	public void refresh() {
		AbstractTableModelStudentSubject abstractTableModelStudentSubject = (AbstractTableModelStudentSubject)studentSubjectTable.getModel();
		abstractTableModelStudentSubject.fireTableDataChanged();
		validate();
		
	}
}
