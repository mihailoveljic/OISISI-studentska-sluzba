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
	private String streetAdress;
	private String numberAdress;
	private String cityAdress;
	private String countryAdress;
	private String phone;
	private String email;
	private String streetOfficeAdress;
	private String numberOfficeAdress;
	private String cityOfficeAdress;
	private String countryOfficeAdress;
	private String idNumber;
	private String title;
	private String serviceYears;
	
	JLabel surnameLabel;
	JTextField surnameField;
	JLabel nameLabel;
	JTextField nameField;
	JLabel birthDateLabel;
	JTextField birthDateField;
	JLabel streetAdressLabel;
	JTextField streetAdressField;
	JLabel numberAdressLabel;
	JTextField numberAdressField;
	JLabel cityAdressLabel;
	JTextField cityAdressField;
	JLabel countryAdressLabel;
	JTextField countryAdressField;
	JLabel phoneLabel;
	JTextField phoneField;
	JLabel emailLabel;
	JTextField emailField;
	JLabel streetOfficeAdressLabel;
	JTextField streetOfficeAdressField;
	JLabel numberOfficeAdressLabel;
	JTextField numberOfficeAdressField;
	JLabel cityOfficeAdressLabel;
	JTextField cityOfficeAdressField;
	JLabel countryOfficeAdressLabel;
	JTextField countryOfficeAdressField;
	JLabel idNumberLabel;
	JTextField idNumberField;
	JLabel titleLabel;
	JTextField titleField;
	JLabel serviceYearsLabel;
	JTextField serviceYearsField;
	
	@SuppressWarnings("deprecation")
	private ProfessorInfoPanel(int selectedRow) {
		super();
		
		this.setLayout(new GridLayout(17, 2, 5, 5));
		this.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		
		p = DbProfessors.getInstance().getRow(selectedRow);
		
		if(p!=null) {
			surname = p.getSurname();
			name = p.getName();
			birthDate = p.getBirthDate().getDate() + "." + p.getBirthDate().getMonth() + "." + p.getBirthDate().getYear();
			streetAdress = p.getAdress().getStreet();
			numberAdress = p.getAdress().getNumber();
			cityAdress = p.getAdress().getCity();
			countryAdress = p.getAdress().getCountry();
			phone = p.getPhone();
			email = p.getEmail();
			streetOfficeAdress = p.getOfficeAdress().getStreet();
			numberOfficeAdress = p.getOfficeAdress().getNumber();
			cityOfficeAdress = p.getOfficeAdress().getCity();
			countryOfficeAdress = p.getOfficeAdress().getCountry();
			idNumber = Integer.toString(p.getIdNumber());
			title = p.getTitle();
			serviceYears = Integer.toString(p.getServiceYears());
		} else {
			surname = "";
			name = "";
			birthDate = "";
			streetAdress = "";
			numberAdress = "";
			cityAdress = "";
			countryAdress = "";
			phone = "";
			email = "";
			streetAdress = "";
			numberAdress = "";
			cityAdress = "";
			countryAdress = "";
			idNumber = "";
			title = "";
			serviceYears = "";
		}
		
		 surnameLabel = new JLabel("Prezime*");
		 surnameField = new JTextField(surname);
		 nameLabel = new JLabel("Ime*");
		 nameField = new JTextField(name);
		 birthDateLabel = new JLabel("Datum roðenja");
		 birthDateField = new JTextField(birthDate);
		 streetAdressLabel = new JLabel("Ulica stanovanja*");
		 streetAdressField = new JTextField(streetAdress);
		 numberAdressLabel = new JLabel("Broj stanovanja*");
		 numberAdressField = new JTextField(numberAdress);
		 cityAdressLabel = new JLabel("Grad stanovanja*");
		 cityAdressField = new JTextField(cityAdress);
		 countryAdressLabel = new JLabel("Država stanovanja*");
		 countryAdressField = new JTextField(countryAdress);
		 phoneLabel = new JLabel("Kontakt Telefon*");
		 phoneField = new JTextField(phone);
		 emailLabel = new JLabel("Email*");
		 emailField = new JTextField(email);
		 streetOfficeAdressLabel = new JLabel("Ulica kancelarije*");
		 streetOfficeAdressField = new JTextField(streetOfficeAdress);
		 numberOfficeAdressLabel = new JLabel("Broj kancelarije*");
		 numberOfficeAdressField = new JTextField(numberOfficeAdress);
		 cityOfficeAdressLabel = new JLabel("Grad kancelarije*");
		 cityOfficeAdressField = new JTextField(cityOfficeAdress);
		 countryOfficeAdressLabel = new JLabel("Država kancelarije*");
		 countryOfficeAdressField = new JTextField(countryOfficeAdress);
		 idNumberLabel = new JLabel("Broj licne karte*");
		 idNumberField = new JTextField(idNumber);
		 titleLabel = new JLabel("Zvanje*");
		 titleField = new JTextField(title);
		 serviceYearsLabel = new JLabel("Godine radnog staža*");
		 serviceYearsField = new JTextField(serviceYears);
		
	
	JButton confirmButton = new JButton("Potvrdi");
	confirmButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			ProfessorController professorController = new ProfessorController();
			
			String dataValid=professorController.editProfessor(ProfessorTable.getInstance().getSelectedRow(), surnameField.getText(),
					nameField.getText(), birthDateField.getText(), streetAdressField.getText(), numberAdressField.getText(),
					cityAdressField.getText(), countryAdressField.getText(), phoneField.getText(), emailField.getText(),
					streetOfficeAdressField.getText(), numberOfficeAdressField.getText(), cityOfficeAdressField.getText(),
					countryOfficeAdressField.getText(), idNumberField.getText(), titleField.getText(), serviceYearsField.getText());
			
			
			
			if(dataValid != "OK") {
				JOptionPane.showMessageDialog(null, dataValid);
				}else {
					ProfessorEditFrame.getInstance().dispose();
					
					surnameField.setText("");
					nameField.setText(""); 
					birthDateField.setText("");
					streetAdressField.setText(""); 
					numberAdressField.setText(""); 
					cityAdressField.setText(""); 
					countryAdressField.setText(""); 
					phoneField.setText("");
					emailField.setText("");
					streetOfficeAdressField.setText(""); 
					numberOfficeAdressField.setText(""); 
					cityOfficeAdressField.setText(""); 
					countryOfficeAdressField.setText(""); 
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
				
				ProfessorEditFrame.getInstance().dispose();
				
				surnameField.setText("");
				nameField.setText(""); 
				birthDateField.setText("");
				streetAdressField.setText(""); 
				numberAdressField.setText(""); 
				cityAdressField.setText(""); 
				countryAdressField.setText(""); 
				phoneField.setText("");
				emailField.setText("");
				streetOfficeAdressField.setText(""); 
				numberOfficeAdressField.setText(""); 
				cityOfficeAdressField.setText(""); 
				countryOfficeAdressField.setText(""); 
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
	this.add(streetAdressLabel);
	this.add(streetAdressField);
	this.add(numberAdressLabel);
	this.add(numberAdressField);
	this.add(cityAdressLabel);
	this.add(cityAdressField);
	this.add(countryAdressLabel);
	this.add(countryAdressField);
	this.add(phoneLabel);
	this.add(phoneField);
	this.add(emailLabel);
	this.add(emailField);
	this.add(streetOfficeAdressLabel);
	this.add(streetOfficeAdressField);
	this.add(numberOfficeAdressLabel);
	this.add(numberOfficeAdressField);
	this.add(cityOfficeAdressLabel);
	this.add(cityOfficeAdressField);
	this.add(countryOfficeAdressLabel);
	this.add(countryOfficeAdressField);
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
			
			p = DbProfessors.getInstance().getRow(selectedRow);
			
			if(p != null) {
				surname = p.getSurname();
				name = p.getName();
				birthDate = p.getBirthDate().getDate() + "." + p.getBirthDate().getMonth()+1 + "." + p.getBirthDate().getYear();
				streetAdress = p.getAdress().getStreet();
				numberAdress = p.getAdress().getNumber();
				cityAdress = p.getAdress().getCity();
				countryAdress = p.getAdress().getCountry();
				phone = p.getPhone();
				email = p.getEmail();
				streetOfficeAdress = p.getOfficeAdress().getStreet();
				numberOfficeAdress = p.getOfficeAdress().getNumber();
				cityOfficeAdress = p.getOfficeAdress().getCity();
				countryOfficeAdress = p.getOfficeAdress().getCountry();
				idNumber = Integer.toString(p.getIdNumber());
				title = p.getTitle();
				serviceYears = Integer.toString(p.getServiceYears());
			} else {
				surname = "";
				name = "";
				birthDate = "";
				streetAdress = "";
				numberAdress = "";
				cityAdress = "";
				countryAdress = "";
				phone = "";
				email = "";
				streetOfficeAdress = "";
				numberOfficeAdress = "";
				cityOfficeAdress = "";
				countryOfficeAdress = "";
				idNumber = "";
				title = "";
				serviceYears = "";
			}
			
			
			surnameField.setText(surname);
			nameField.setText(name); 
			birthDateField.setText(birthDate);
			streetAdressField.setText(streetAdress); 
			numberAdressField.setText(numberAdress); 
			cityAdressField.setText(cityAdress); 
			countryAdressField.setText(countryAdress); 
			phoneField.setText(phone);
			emailField.setText(email);
			streetOfficeAdressField.setText(streetOfficeAdress); 
			numberOfficeAdressField.setText(numberOfficeAdress); 
			cityOfficeAdressField.setText(cityOfficeAdress); 
			countryOfficeAdressField.setText(countryOfficeAdress); 
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

