package views;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
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
	
	int oldIdNumber = 0;
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
		
		p = DbProfessors.getInstance().findProfessor(
				(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 0),
				(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 1),
				(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 3)			
				);
		
		if(p!=null) {
			
			int month = p.getBirthDate().getMonth() + 1;
			
			surname = p.getSurname();
			name = p.getName();
			birthDate = p.getBirthDate().getDate() + "." + month + "." + p.getBirthDate().getYear() + ".";
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
			oldIdNumber = p.getIdNumber();
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
			oldIdNumber = 0;
			title = "";
			serviceYears = "";
		}
		
		 surnameLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("surname") + "*");
		 surnameField = new JTextField(surname);
		 nameLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("name") + "*");
		 nameField = new JTextField(name);
		 birthDateLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("birthDate") + "* (dd.mm.yyyy.)");
		 birthDateField = new JTextField(birthDate);
		 streetAdressLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("streetLiving") + "*");
		 streetAdressField = new JTextField(streetAdress);
		 numberAdressLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("numberLiving") + "*");
		 numberAdressField = new JTextField(numberAdress);
		 cityAdressLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("cityLiving") + "*");
		 cityAdressField = new JTextField(cityAdress);
		 countryAdressLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("countryLiving") + "*");
		 countryAdressField = new JTextField(countryAdress);
		 phoneLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("phone") + "*");
		 phoneField = new JTextField(phone);
		 emailLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("email") + "*");
		 emailField = new JTextField(email);
		 streetOfficeAdressLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("streetOffice") + "*");
		 streetOfficeAdressField = new JTextField(streetOfficeAdress);
		 numberOfficeAdressLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("numberOffice") + "*");
		 numberOfficeAdressField = new JTextField(numberOfficeAdress);
		 cityOfficeAdressLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("cityOffice") + "*");
		 cityOfficeAdressField = new JTextField(cityOfficeAdress);
		 countryOfficeAdressLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("countryOffice") + "*");
		 countryOfficeAdressField = new JTextField(countryOfficeAdress);
		 idNumberLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("idNumber") + "*");
		 idNumberField = new JTextField(idNumber);
		 titleLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("title") + "*");
		 titleField = new JTextField(title);
		 serviceYearsLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("yearsOfExperience") + "*");
		 serviceYearsField = new JTextField(serviceYears);
		
	
		 JButton confirmButton = new JButton(MainFrame.getInstance().getResourceBundle().getString("confirm"));
		confirmButton.setEnabled(false);
		ButtonModel confirmButtonModel = confirmButton.getModel();
		ButtonEnabler buttonEnabler = new ButtonEnabler(confirmButtonModel);
		buttonEnabler.addDocument(surnameField.getDocument());
		buttonEnabler.addDocument(nameField.getDocument());
		buttonEnabler.addDocument(birthDateField.getDocument());
		buttonEnabler.addDocument(streetAdressField.getDocument());
		buttonEnabler.addDocument(numberAdressField.getDocument());
		buttonEnabler.addDocument(cityAdressField.getDocument());
		buttonEnabler.addDocument(countryAdressField.getDocument());
		buttonEnabler.addDocument(phoneField.getDocument());
		buttonEnabler.addDocument(emailField.getDocument());
		buttonEnabler.addDocument(streetOfficeAdressField.getDocument());
		buttonEnabler.addDocument(numberOfficeAdressField.getDocument());
		buttonEnabler.addDocument(cityOfficeAdressField.getDocument());
		buttonEnabler.addDocument(countryOfficeAdressField.getDocument());
		buttonEnabler.addDocument(idNumberField.getDocument());
		buttonEnabler.addDocument(titleField.getDocument());
		buttonEnabler.addDocument(serviceYearsField.getDocument());

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
				JOptionPane.showMessageDialog(ProfessorInfoPanel.getInstance(), dataValid);
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
	
	JButton cancelButton = new JButton(MainFrame.getInstance().getResourceBundle().getString("cancel"));
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
			
			p = DbProfessors.getInstance().findProfessor(
					(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 0),
					(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 1),
					(String)ProfessorTable.getInstance().getValueAt(ProfessorTable.getInstance().getSelectedRow(), 3)			
					);
			
			if(p != null) {

				int month = p.getBirthDate().getMonth() + 1;
				
				surname = p.getSurname();
				name = p.getName();
				birthDate = p.getBirthDate().getDate() + "." + month + "." + p.getBirthDate().getYear() + ".";
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
				oldIdNumber = p.getIdNumber();
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
				oldIdNumber = 0;
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

		public int getOldIdNumber() {
			return oldIdNumber;
		}

		public void setOldIdNumber(int oldIdNumber) {
			this.oldIdNumber = oldIdNumber;
		}


}	

