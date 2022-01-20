package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import models.DbStudents;
import models.Grade;
import models.Student;

public class StudentGradesPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7412489039644348070L;
	
	private static StudentGradesPanel instance;

	private GradesTable gradesTable;
	private JButton removeGrade;
	private JScrollPane scrollPane;
	private JLabel averageGradeLabel;
	private JLabel espbLabel;
	private int espb;
	private double avgGrade;
	private JTextField totalESPBField;
	private JTextField avgGradeField;
	
	public StudentGradesPanel() {
		super();
		setLayout(new BorderLayout());
		gradesTable = new GradesTable();
		scrollPane = new JScrollPane(gradesTable);
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		removeGrade = new JButton("PoniÅ¡ti ocenu");
		
		removeGrade.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Brisanje ocene
				
				int column = 0;
				int row = gradesTable.getSelectedRow();
				if(row!=-1) {

				String value = gradesTable.getModel().getValueAt(row, column).toString();
				Student student = DbStudents.getInstance().findStudentByIndex((String) StudentTable.getInstance().getValueAt(StudentTable.getInstance().getSelectedRow(), 0));
				List<Grade> grades = student.getGrades();
				for(Grade g: grades) {
					if(g.getSubject().getId()==value) {
						int userInput = JOptionPane.showOptionDialog(StudentGradesPanel.getInstance(), "Da li ste sigurni da ï¿½elite da ponistite ocenu?", "Ponistavanje ocene", JOptionPane.YES_NO_OPTION, 0, null, null, e);
						if(userInput == JOptionPane.YES_OPTION) {
							if(g.getSubject().getListOfStudentsWhoPassed()==null) {
									g.getSubject().setListOfStudentsWhoPassed(new ArrayList<Student>());
								}
						g.getSubject().getListOfStudentsWhoPassed().remove(student);
						student.getGrades().remove(g);
						student.getSubjects().add(g.getSubject());
						StudentGradesPanel.getInstance().refresh();
						StudentSubjectsPanel.getInstance().refresh();
						break;
						}
					}
				}
				}
				else {
					JOptionPane.showMessageDialog(StudentGradesPanel.getInstance(), "Niste selektovali ocenu!");
				}
			}
		});
		commandPanel.add(removeGrade);
		add(commandPanel, BorderLayout.NORTH);
		
		JPanel labelsPanel = new JPanel(new BorderLayout());
		JPanel labelAvgOcenaPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel labelTotalESPBPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		DbStudents.getInstance().findStudentByIndex((String) StudentTable.getInstance().getValueAt(StudentTable.getInstance().getSelectedRow(), 0)).recalculateAvgGrade();
		avgGrade = DbStudents.getInstance().findStudentByIndex((String) StudentTable.getInstance().getValueAt(StudentTable.getInstance().getSelectedRow(), 0)).getAverageGrade();
		averageGradeLabel = new JLabel("Proseèna ocena: ");
        avgGradeField = new JTextField();
        avgGradeField.setEditable(false);
        avgGradeField.setText(Double.toString(avgGrade));
        labelAvgOcenaPanel.add(averageGradeLabel);
        labelAvgOcenaPanel.add(avgGradeField);
        
		espb = DbStudents.getInstance().findStudentByIndex((String) StudentTable.getInstance().getValueAt(StudentTable.getInstance().getSelectedRow(), 0)).getTotalESBP();
		espbLabel = new JLabel("Ukupno ESPB: ");
        totalESPBField = new JTextField();
        totalESPBField.setEditable(false);
        totalESPBField.setText(Integer.toString(espb));
        labelTotalESPBPanel.add(espbLabel);
        labelTotalESPBPanel.add(totalESPBField);

		labelsPanel.add(labelAvgOcenaPanel, BorderLayout.NORTH);
		labelsPanel.add(labelTotalESPBPanel, BorderLayout.SOUTH);
		
		add(labelsPanel, BorderLayout.SOUTH);
		
	}
	
	public GradesTable getGradesTable() {
		return gradesTable;
	}

	public void setGradesTable(GradesTable table) {
		this.gradesTable = table;
	}
	
	public void refresh() {
		AbstractTableModelGrades abstractTableModelGrades = (AbstractTableModelGrades)gradesTable.getModel();
		abstractTableModelGrades.fireTableDataChanged();
		validate();
		
		DbStudents.getInstance().findStudentByIndex((String) StudentTable.getInstance().getValueAt(StudentTable.getInstance().getSelectedRow(), 0)).recalculateAvgGrade();
		avgGrade = DbStudents.getInstance().findStudentByIndex((String) StudentTable.getInstance().getValueAt(StudentTable.getInstance().getSelectedRow(), 0)).getAverageGrade();
        avgGradeField.setText(Double.toString(avgGrade));
		espb =  DbStudents.getInstance().findStudentByIndex((String) StudentTable.getInstance().getValueAt(StudentTable.getInstance().getSelectedRow(), 0)).getTotalESBP();
        totalESPBField.setText(Integer.toString(espb));
	}
	
	public static StudentGradesPanel getInstance()
	{
		if(instance == null)
			instance = new StudentGradesPanel();
		return instance;
	}
}
