package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
	
}
