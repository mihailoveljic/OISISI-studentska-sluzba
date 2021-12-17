package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.ProfessorController;
import models.DbProfessors;
import models.Professor;

public class ProfessorInfoPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static ProfessorInfoPanel instance;
	
	Professor p;
	private String surname;
	private String name;
	private String birthDate;
	private String adress;
	private String phone;
	private String email;
	private String officeAdress;
	private String idNumber;
	private String title;
	private String serviceYears;
	
	JLabel surnameLabel;
	JTextField surnameField;
	JLabel nameLabel;
	JTextField nameField;
	JLabel birthDateLabel;
	JTextField birthDateField;
	JLabel adressLabel;
	JTextField adressField;
	JLabel phoneLabel;
	JTextField phoneField;
	JLabel emailLabel;
	JTextField emailField;
	JLabel officeAdressLabel;
	JTextField officeAdressLabelField;
	JLabel idNumberLabel;
	JTextField idNumberField;
	JLabel titleLabel;
	JTextField titleField;
	JLabel serviceYearsLabel;
	JTextField serviceYearsField;
	
	@SuppressWarnings("deprecation")
	private ProfessorInfoPanel(int selectedRow) {
		super();
		
		this.setLayout(new GridLayout(11, 2, 5, 5));
		this.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		
		p=DbProfessors.getInstance().getRow(selectedRow);
		
		if(p!=null) {
			surname=p.getSurname();
			name=p.getName();
			birthDate=p.getBirthDate().getDate() + "." + p.getBirthDate().getMonth() + "." + p.getBirthDate().getYear();
			adress=p.getAdress().getStreet()+", " + p.getAdress().getNumber()+ ", " + p.getAdress().getCity()+ ", " + p.getAdress().getCountry();
			phone=p.getPhone();
			email=p.getEmail();
			officeAdress=p.getOfficeAdress().getStreet()+", " + p.getOfficeAdress().getNumber()+ ", " + p.getOfficeAdress().getCity()+ ", " + p.getOfficeAdress().getCountry();
			idNumber=Integer.toString(p.getIdNumber());
			title=p.getTitle();
			serviceYears=Integer.toString(p.getServiceYears());
		} else {
			surname="";
			name="";
			birthDate="";
			adress="";
			phone="";
			email="";
			officeAdress="";
			idNumber="";
			title="";
			serviceYears="";
		}
		
		 surnameLabel=new JLabel("Prezime*");
		 surnameField=new JTextField(surname);
		 nameLabel=new JLabel("Ime*");
		 nameField=new JTextField(name);
		 birthDateLabel=new JLabel("Datum rođenja");
		 birthDateField=new JTextField(birthDate);
		 adressLabel=new JLabel("Adresa*");
		 adressField=new JTextField(adress);
		 phoneLabel=new JLabel("Kontakt Telefon*");
		 phoneField=new JTextField(phone);
		 emailLabel=new JLabel("Email*");
		 emailField=new JTextField(email);
		 officeAdressLabel=new JLabel("Adresa kancelarije*");
		 officeAdressLabelField=new JTextField(officeAdress);
		 idNumberLabel=new JLabel("Broj licne karte*");
		 idNumberField=new JTextField(idNumber);
		 titleLabel=new JLabel("Zvanje*");
		 titleField=new JTextField(title);
		 serviceYearsLabel=new JLabel("Godine radnog staža*");
		 serviceYearsField=new JTextField(serviceYears);
		
	
	JButton confirmButton = new JButton("Potvrdi");
	confirmButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			ProfessorController professorController = new ProfessorController();
			
			String dataValid=professorController.editProfessor(ProfessorTable.getInstance().getSelectedRow(), surnameField.getText(),nameField.getText(), birthDateField.getText(), adressField.getText(), phoneField.getText(),
					emailField.getText(), officeAdressLabelField.getText(), idNumberField.getText(), titleField.getText(), serviceYearsField.getText());
			
			
			
			if(dataValid != "OK") {
				JOptionPane.showMessageDialog(null, dataValid);
				}else {
					ProfessorEditFrame.getInstance().dispose();
					
					surnameField.setText("");
					nameField.setText(""); 
					birthDateField.setText("");
					adressField.setText(""); 
					phoneField.setText("");
					emailField.setText("");
					officeAdressLabelField.setText(""); 
					idNumberField.setText("");
					titleField.setText("");
					serviceYearsField.setText("");
		
				}
			}
		
	});
	
	JButton cancelButton = new JButton("Odustani");
	cancelButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
				
				ProfessorAddFrame.getInstance().dispose();
				
				surnameField.setText("");
				nameField.setText(""); 
				birthDateField.setText("");
				adressField.setText(""); 
				phoneField.setText("");
				emailField.setText("");
				officeAdressLabelField.setText(""); 
				idNumberField.setText("");
				titleField.setText("");
				serviceYearsField.setText("");
			}	
		});
	
	this.add(surnameLabel);
	this.add(surnameField);
	this.add(nameLabel);
	this.add(nameField);
	this.add(birthDateLabel);
	this.add(birthDateField);
	this.add(adressLabel);
	this.add(adressField);
	this.add(phoneLabel);
	this.add(phoneField);
	this.add(emailLabel);
	this.add(emailField);
	this.add(officeAdressLabel);
	this.add(officeAdressLabelField);
	this.add(idNumberLabel);
	this.add(idNumberField);
	this.add(titleLabel);
	this.add(titleField);
	this.add(serviceYearsLabel);
	this.add(serviceYearsField);
	this.add(confirmButton);
	this.add(cancelButton);
	
	
	}
	
		@SuppressWarnings("deprecation")
		public void updateProfessorSelection(int selectedRow) {
			
			p=DbProfessors.getInstance().getRow(selectedRow);
			
			if(p!=null) {
				surname=p.getSurname();
				name=p.getName();
				birthDate=p.getBirthDate().getDate() + "." + p.getBirthDate().getMonth()+1 + "." + p.getBirthDate().getYear();
				adress=p.getAdress().getStreet()+", " + p.getAdress().getNumber()+ ", " + p.getAdress().getCity()+ ", " + p.getAdress().getCountry();
				phone=p.getPhone();
				email=p.getEmail();
				officeAdress=p.getOfficeAdress().getStreet()+", " + p.getOfficeAdress().getNumber()+ ", " + p.getOfficeAdress().getCity()+ ", " + p.getOfficeAdress().getCountry();
				idNumber=Integer.toString(p.getIdNumber());
				title=p.getTitle();
				serviceYears=Integer.toString(p.getServiceYears());
			} else {
				surname="";
				name="";
				birthDate="";
				adress="";
				phone="";
				email="";
				officeAdress="";
				idNumber="";
				title="";
				serviceYears="";
			}
			
			
			 surnameField.setText(surname);
			 nameField.setText(name);
			 birthDateField.setText(birthDate);
			 adressField.setText(adress);
			 phoneField.setText(phone);
			 emailField.setText(email);
			 officeAdressLabelField.setText(officeAdress);
			 idNumberField.setText(idNumber);
			 titleField.setText(title);
			 serviceYearsField.setText(serviceYears);
			
		}
	
	
		public static ProfessorInfoPanel getInstance()
		{
			if(instance == null)
				instance = new ProfessorInfoPanel(ProfessorTable.getInstance().getSelectedRow());
			return instance;
		}
}	

