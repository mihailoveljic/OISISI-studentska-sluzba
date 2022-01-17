package views;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controllers.StudentController;
import controllers.SubjectController;
import models.DbSubjects;
import models.Professor;
import models.Semester;
import models.Subject;

public class SubjectEditFrame extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6561684240490567882L;
	private static SubjectEditFrame instance;
	
	Subject s;
	String id;
	String name;
    int yearOfStudy;
	Semester semester;
    String ESPB;
    Professor professor;
	
	JTextField idField;
	JTextField nameField;
	JComboBox<String> currentYearOfStudyComboBox;
	JComboBox<String> semesterComboBox;
	JTextField espbField;
	JTextField professorTextField;
	
	JButton addProfessorButton;
	JButton removeProfessorButton;
    
	private SubjectEditFrame(int selectedRow){
		super();

		this.setModal (true);
		this.setAlwaysOnTop (true);
		this.setModalityType (ModalityType.APPLICATION_MODAL);

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		int width = d.width;
		int height = d.height;

		// Pravljenje prozora
		setSize(width*1/4, height*2/4);
		setLocationRelativeTo(MainFrame.getInstance());
		setTitle("Dodavanje predmeta");
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		setIconImage(icon);

		JPanel contentPanel = new JPanel(new GridLayout(8, 2, 5, 5));
		contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

		s = DbSubjects.getInstance().getRow(selectedRow);
		if(s != null) {
			id = s.getId();
			name = s.getName();
		    yearOfStudy = s.getYearOfStudy();
			semester = s.getSemester();
		    ESPB = String.valueOf(s.getESPB());
		    professor = s.getProfessor();
		}else {
			id = "";
			name = "";
		    yearOfStudy = 0;
			semester = Semester.ZIMSKI;
		    ESPB = "";
		    professor = null;
		}
		
		JLabel idLabel = new JLabel("Šifra*");
		idField = new JTextField(id);
		JLabel nameLabel = new JLabel("Naziv*");
		nameField = new JTextField(name);
		JLabel currentYearOfStudyLabel = new JLabel("Godina studija*");
		currentYearOfStudyComboBox = new JComboBox<String>();
		currentYearOfStudyComboBox.addItem("I (Prva)");
		currentYearOfStudyComboBox.addItem("II (Druga)");
		currentYearOfStudyComboBox.addItem("III (Tre�a)");
		currentYearOfStudyComboBox.addItem("IV (�etvrta)");
		switch(yearOfStudy) {
		case 1:
			currentYearOfStudyComboBox.setSelectedIndex(0);
			break;
		case 2:
			currentYearOfStudyComboBox.setSelectedIndex(1);
			break;
		case 3:
			currentYearOfStudyComboBox.setSelectedIndex(2);
			break;
		case 4:
			currentYearOfStudyComboBox.setSelectedIndex(3);
			break;
		default:
			break;
		}
		JLabel semesterLabel = new JLabel("Semestar*");
		semesterComboBox = new JComboBox<String>();
		semesterComboBox.addItem("Zimski");
		semesterComboBox.addItem("Letnji");
		switch(semester) {
		case ZIMSKI:
			currentYearOfStudyComboBox.setSelectedIndex(0);
			break;
		case LETNJI:
			currentYearOfStudyComboBox.setSelectedIndex(1);
			break;
		default:
			break;
		}
		JLabel espbLabel = new JLabel("ESPB*");
		espbField = new JTextField(ESPB);
		JLabel professorLabel = new JLabel("Profesor*");
		if(professor == null) {
			professorTextField = new JTextField("");
		}else {
			professorTextField = new JTextField(professor.getName() + " " + professor.getSurname());
		}
		professorTextField.setEditable(false);
		
		
		addProfessorButton = new JButton("+");
		addProfessorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SubjectEditChooseProfessor subjectEditChooseProfessor = new SubjectEditChooseProfessor();
				subjectEditChooseProfessor.setVisible(true);
			}
		});
		removeProfessorButton = new JButton("-");
		
		removeProfessorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int userInput = JOptionPane.showOptionDialog(SubjectEditFrame.getInstance(), "Da li ste sigurni da želite da uklonite trenutnog profesora?",
						"Uklanjanje profesora", JOptionPane.YES_NO_OPTION, 0, null, null, e);
				if(userInput == JOptionPane.YES_OPTION) {
					professor = null;
					SubjectEditFrame.getInstance().updateProfessorSelection();
				}
			}
		});
		if(professorTextField.getText().equals("")) {
			addProfessorButton.setEnabled(true);
			removeProfessorButton.setEnabled(false);
		}else {
			addProfessorButton.setEnabled(false);
			removeProfessorButton.setEnabled(true);
		}
		JButton confirmButton = new JButton("Potvrdi");
		ButtonModel confirmButtonModel = confirmButton.getModel();
		ButtonEnabler buttonEnabler = new ButtonEnabler(confirmButtonModel);
		buttonEnabler.addDocument(idField.getDocument());
		buttonEnabler.addDocument(nameField.getDocument());
		buttonEnabler.addDocument(espbField.getDocument());
		
		confirmButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SubjectController subjectController = new SubjectController();
				
				String dataValid = subjectController.editSubject(SubjectTable.getInstance().getSelectedRow(),
						idField.getText(), nameField.getText(), currentYearOfStudyComboBox.getSelectedIndex(),
						semesterComboBox.getSelectedIndex(),espbField.getText(), professor);
				
				if( dataValid != "OK") {
					JOptionPane.showMessageDialog(null, dataValid);
				}else {					
					idField.setText("");
					nameField.setText("");
					currentYearOfStudyComboBox.setSelectedIndex(0);
					semesterComboBox.setSelectedIndex(0);
					espbField.setText("");
					professorTextField.setText("");
					SubjectEditFrame.getInstance().dispose();
				}
			}
			
		});
		
		JButton cancelButton = new JButton("Odustani");
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				idField.setText("");
				nameField.setText("");
				currentYearOfStudyComboBox.setSelectedIndex(0);
				semesterComboBox.setSelectedIndex(0);
				espbField.setText("");
				professorTextField.setText("");
				SubjectEditFrame.getInstance().dispose();
			}
		});
		
		contentPanel.add(idLabel);
		contentPanel.add(idField);
		contentPanel.add(nameLabel);
		contentPanel.add(nameField);
		contentPanel.add(currentYearOfStudyLabel);
		contentPanel.add(currentYearOfStudyComboBox);
		contentPanel.add(semesterLabel);
		contentPanel.add(semesterComboBox);
		contentPanel.add(espbLabel);
		contentPanel.add(espbField);
		contentPanel.add(professorLabel);
		contentPanel.add(professorTextField);
		contentPanel.add(addProfessorButton);
		contentPanel.add(removeProfessorButton);
		contentPanel.add(confirmButton);
		contentPanel.add(cancelButton);
	    this.getContentPane().add(contentPanel);
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public void updateSubjectSelection(int selectedRow) {
		s = DbSubjects.getInstance().getRow(selectedRow);
		if(s != null) {
			id = s.getId();
			name = s.getName();
		    yearOfStudy = s.getYearOfStudy();
			semester = s.getSemester();
		    ESPB = String.valueOf(s.getESPB());
		    professor = s.getProfessor();
		}else {
			id = "";
			name = "";
		    yearOfStudy = 0;
			semester = Semester.ZIMSKI;
		    ESPB = "";
		    professor = null;
		}
		
		idField.setText(id);
		nameField.setText(name);
		switch(yearOfStudy) {
		case 1:
			currentYearOfStudyComboBox.setSelectedIndex(0);
			break;
		case 2:
			currentYearOfStudyComboBox.setSelectedIndex(1);
			break;
		case 3:
			currentYearOfStudyComboBox.setSelectedIndex(2);
			break;
		case 4:
			currentYearOfStudyComboBox.setSelectedIndex(3);
			break;
		default:
			break;
		}
		switch(semester) {
		case ZIMSKI:
			currentYearOfStudyComboBox.setSelectedIndex(0);
			break;
		case LETNJI:
			currentYearOfStudyComboBox.setSelectedIndex(1);
			break;
		default:
			break;
		}
		espbField.setText(ESPB);
		if(professor == null) {
			professorTextField.setText("");
		}else {
			professorTextField.setText(professor.getName() + " " + professor.getSurname());
		}
		professorTextField.setEditable(false);
		
	}
	
	public static SubjectEditFrame getInstance()
	{
		if(instance==null)
			instance = new SubjectEditFrame(SubjectTable.getInstance().getSelectedRow());
		instance.setLocationRelativeTo(MainFrame.getInstance());
		return instance;
	}

	public void updateProfessorSelection() {
		if(professor != null) {
			professorTextField.setText(professor.getName() + " " + professor.getSurname());
		}else {
			professorTextField.setText("");
		}
		if(professorTextField.getText().equals("")) {
			addProfessorButton.setEnabled(true);
			removeProfessorButton.setEnabled(false);
		}else {
			addProfessorButton.setEnabled(false);
			removeProfessorButton.setEnabled(true);
		}
		
	}
}