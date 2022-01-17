package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import models.DbStudents;

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
		removeGrade = new JButton("Poništi ocenu");
		
		removeGrade.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Brisanje ocene
				
			}
		});
		commandPanel.add(removeGrade);
		add(commandPanel, BorderLayout.NORTH);
		
		JPanel labelsPanel = new JPanel(new BorderLayout());
		JPanel labelAvgOcenaPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel labelTotalESPBPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		DbStudents.getInstance().getRow(StudentTable.getInstance().getSelectedRow()).recalculateAvgGrade();
		avgGrade = DbStudents.getInstance().getRow(StudentTable.getInstance().getSelectedRow()).getAverageGrade();
		averageGradeLabel = new JLabel("Proseèna ocena: ");
        avgGradeField = new JTextField();
        avgGradeField.setEditable(false);
        avgGradeField.setText(Double.toString(avgGrade));
        labelAvgOcenaPanel.add(averageGradeLabel);
        labelAvgOcenaPanel.add(avgGradeField);
        
		espb =  DbStudents.getInstance().getRow(StudentTable.getInstance().getSelectedRow()).getTotalESBP();
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
		
		DbStudents.getInstance().getRow(StudentTable.getInstance().getSelectedRow()).recalculateAvgGrade();
		avgGrade = DbStudents.getInstance().getRow(StudentTable.getInstance().getSelectedRow()).getAverageGrade();
        avgGradeField.setText(Double.toString(avgGrade));
		espb =  DbStudents.getInstance().getRow(StudentTable.getInstance().getSelectedRow()).getTotalESBP();
        totalESPBField.setText(Integer.toString(espb));
	}
	
	public static StudentGradesPanel getInstance()
	{
		if(instance == null)
			instance = new StudentGradesPanel();
		return instance;
	}
}
