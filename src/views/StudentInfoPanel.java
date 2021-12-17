package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.StudentController;
import models.DbStudents;
import models.Student;
import models.StudentStatus;

public class StudentInfoPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4000816222354440731L;
	
	private static StudentInfoPanel instance;

	Student s;
	String name;
	String surname;
	String birthDate;
	String adress;
	String phone;
	String email;
	String index;
	String enrollmentYear;
	int currentYearOfStudy;
	StudentStatus studentStatus;
	
	JLabel nameLabel;
	JTextField nameField;
	JLabel surnameLabel;
	JTextField surnameField;
	JLabel birthDateLabel;
	JTextField birthDateField;
	JLabel adressLabel;
	JTextField adressField;
	JLabel phoneLabel;
	JTextField phoneField;
	JLabel emailLabel;
	JTextField emailField;
	JLabel indexLabel;
	JTextField indexField;
	JLabel enrollmentYearLabel;
	JTextField enrollmentYearField;
	JLabel currentYearOfStudyLabel;
	JComboBox<String> currentYearOfStudyComboBox;
	JLabel studentStatusLabel;
	JComboBox<String> studentStatusComboBox;
	
	@SuppressWarnings("deprecation")
	private StudentInfoPanel(int selectedRow) {
		super();
		
		this.setLayout(new GridLayout(11, 2, 5, 5));
		this.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

		s = DbStudents.getInstance().getRow(selectedRow);
		
		if(s != null) {
			name = s.getName();
			surname = s.getSurname();
			birthDate = s.getBirthDate().getDate() + "." + s.getBirthDate().getMonth()+1 + "." + s.getBirthDate().getYear();
			adress = s.getAdress().getStreet() + ", " + s.getAdress().getNumber() + ", " + s.getAdress().getCity() + ", " + s.getAdress().getCountry();
			phone = s.getPhone();
			email = s.getEmail();
			index = s.getIndex();
			enrollmentYear = String.valueOf(s.getEnrollmentYear());
			currentYearOfStudy = s.getCurrentYearOfStudy();
			studentStatus = s.getStudentStatus();
		}else {
			name = "";
			surname = "";
			birthDate = "";
			adress = "";
			phone = "";
			email = "";
			index = "";
			enrollmentYear = "";
			currentYearOfStudy = 0;
			studentStatus = StudentStatus.B;
		}
		
		nameLabel = new JLabel("Ime*");
		nameField = new JTextField(name);
		surnameLabel = new JLabel("Prezime*");
		surnameField = new JTextField(surname);
		birthDateLabel = new JLabel("Datum roðenja*");
		birthDateField = new JTextField(birthDate);
		adressLabel = new JLabel("Adresa stanovanja*");
		adressField = new JTextField(adress);
		phoneLabel = new JLabel("Broj telefona*");
		phoneField = new JTextField(phone);
		emailLabel = new JLabel("E-mail adresa*");
		emailField = new JTextField(email);
		indexLabel = new JLabel("Broj indeksa*");
		indexField = new JTextField(index);
		enrollmentYearLabel = new JLabel("Godina upisa*");
		enrollmentYearField = new JTextField(enrollmentYear);
		currentYearOfStudyLabel = new JLabel("Trenutna godina studija*");
		currentYearOfStudyComboBox = new JComboBox<String>();
		currentYearOfStudyComboBox.addItem("I (Prva)");
		currentYearOfStudyComboBox.addItem("II (Druga)");
		currentYearOfStudyComboBox.addItem("III (Treæa)");
		currentYearOfStudyComboBox.addItem("IV (Èetvrta)");
		
		switch(currentYearOfStudy) {
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
		JLabel studentStatusLabel = new JLabel("Naèin finansiranja*");
		studentStatusComboBox = new JComboBox<String>();
		studentStatusComboBox.addItem("Budzet");
		studentStatusComboBox.addItem("Samofinansiranje");
		switch(studentStatus) {
		case B:
			studentStatusComboBox.setSelectedIndex(0);
			break;
		case S:
			studentStatusComboBox.setSelectedIndex(1);
			break;
		default:
			break;
		}
		
		JButton confirmButton = new JButton("Potvrdi");
		confirmButton.addActionListener(new ActionListener(){
	
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentController studentController = new StudentController();
				
				String dataValid = studentController.editStudent(StudentTable.getInstance().getSelectedRow(), surnameField.getText(), nameField.getText(),
						birthDateField.getText(), adressField.getText(), phoneField.getText(),
						emailField.getText(), indexField.getText(), enrollmentYearField.getText(),
						currentYearOfStudyComboBox.getSelectedIndex(), studentStatusComboBox.getSelectedIndex());
				
				if( dataValid != "OK") {
					JOptionPane.showMessageDialog(null, dataValid);
				}else {
					StudentEditFrame.getInstance().dispose();
					
					surnameField.setText("");
					nameField.setText("");
					birthDateField.setText("");
					adressField.setText("");
					phoneField.setText("");
					emailField.setText("");
					indexField.setText("");
					enrollmentYearField.setText("");
					currentYearOfStudyComboBox.setSelectedIndex(0);
					studentStatusComboBox.setSelectedIndex(0);
				}
			}
			
		});
		JButton cancelButton = new JButton("Odustani");
		
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				surnameField.setText("");
				nameField.setText("");
				birthDateField.setText("");
				adressField.setText("");
				phoneField.setText("");
				emailField.setText("");
				indexField.setText("");
				enrollmentYearField.setText("");
				currentYearOfStudyComboBox.setSelectedIndex(0);
				studentStatusComboBox.setSelectedIndex(0);
				StudentEditFrame.getInstance().dispose();
			}
		});
		
		
		this.add(nameLabel);
		this.add(nameField);
		this.add(surnameLabel);
		this.add(surnameField);
		this.add(birthDateLabel);
		this.add(birthDateField);
		this.add(adressLabel);
		this.add(adressField);
		this.add(phoneLabel);
		this.add(phoneField);
		this.add(emailLabel);
		this.add(emailField);
		this.add(indexLabel);
		this.add(indexField);
		this.add(enrollmentYearLabel);
		this.add(enrollmentYearField);
		this.add(currentYearOfStudyLabel);
		this.add(currentYearOfStudyComboBox);
		this.add(studentStatusLabel);
		this.add(studentStatusComboBox);
		this.add(confirmButton);
		this.add(cancelButton);
		
		
	}
	
	
	@SuppressWarnings("deprecation")
	public void updateStudentSelection(int selectedRow) {
		s = DbStudents.getInstance().getRow(selectedRow);
		if(s != null) {
			name = s.getName();
			surname = s.getSurname();
			birthDate = s.getBirthDate().getDate() + "." + s.getBirthDate().getMonth() + "." + s.getBirthDate().getYear();
			adress = s.getAdress().getStreet() + ", " + s.getAdress().getNumber() + ", " + s.getAdress().getCity() + ", " + s.getAdress().getCountry();
			phone = s.getPhone();
			email = s.getEmail();
			index = s.getIndex();
			enrollmentYear = String.valueOf(s.getEnrollmentYear());
			currentYearOfStudy = s.getCurrentYearOfStudy();
			studentStatus = s.getStudentStatus();
		}else {
			name = "";
			surname = "";
			birthDate = "";
			adress = "";
			phone = "";
			email = "";
			index = "";
			enrollmentYear = "";
			currentYearOfStudy = 0;
			studentStatus = StudentStatus.B;
		}
		
		nameField.setText(name);
		surnameField.setText(surname);
		birthDateField.setText(birthDate);
		adressField.setText(adress);
		phoneField.setText(phone);
		emailField.setText(email);
		indexField.setText(index);
		enrollmentYearField.setText(enrollmentYear);
		
		switch(currentYearOfStudy) {
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
		switch(studentStatus) {
		case B:
			studentStatusComboBox.setSelectedIndex(0);
			break;
		case S:
			studentStatusComboBox.setSelectedIndex(1);
			break;
		default:
			break;
		}
	}
	
	public static StudentInfoPanel getInstance()
	{
		if(instance == null)
			instance = new StudentInfoPanel(StudentTable.getInstance().getSelectedRow());
		return instance;
	}
}
