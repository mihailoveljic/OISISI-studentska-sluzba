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

import models.DbSubjects;
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
	StudentAddSubject studentAddSubject;
	
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
				
			}
		});
		commandPanel.add(addGrade);
		add(commandPanel, BorderLayout.NORTH);
		
	
		deleteGrade = new JButton ("Obriši");
	
		deleteGrade.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	commandPanel.add(deleteGrade);
	add(commandPanel, BorderLayout.NORTH);
	
	entryGrade = new JButton ("Polaganje");
	
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
			studentAddSubject = new StudentAddSubject(MainFrame.getInstance(), "Unos ocene", true, subject);
			studentAddSubject.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(StudentSubjectsPanel.getInstance(), "Predmet nije selektovan.", "Upozorenje!",
						JOptionPane.ERROR_MESSAGE);
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

	public StudentAddSubject getStudentAddSubject() {
		return studentAddSubject;
	}

	public void setStudentAddSubject(StudentAddSubject studentAddSubject) {
		this.studentAddSubject = studentAddSubject;
	}
	
	public void refresh() {
		AbstractTableModelStudentSubject abstractTableModelStudentSubject = (AbstractTableModelStudentSubject)studentSubjectTable.getModel();
		abstractTableModelStudentSubject.fireTableDataChanged();
		validate();
		
	}
}
