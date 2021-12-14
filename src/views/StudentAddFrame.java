package views;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controllers.StudentController;
import models.Adress;
import models.StudentStatus;

public class StudentAddFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6131600099102309111L;
	
	
	private static StudentAddFrame instance;
	private StudentAddFrame() {
		super();

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		int width = d.width;
		int height = d.height;

		// Pravljenje prozora
		setSize(width*1/4, height*2/4);
		setLocationRelativeTo(null);
		setTitle("Dodavanje studenta");
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		setIconImage(icon);

		JPanel contentPanel = new JPanel(new GridLayout(11, 2, 5, 5));
		contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

		JLabel nameLabel = new JLabel("Ime*");
		JTextField nameField = new JTextField();
		JLabel surnameLabel = new JLabel("Prezime*");
		JTextField surnameField = new JTextField();
		JLabel birthDateLabel = new JLabel("Datum roðenja*");
		JTextField birthDateField = new JTextField();
		JLabel adressLabel = new JLabel("Adresa stanovanja*");
		JTextField adressField = new JTextField();
		JLabel phoneLabel = new JLabel("Broj telefona*");
		JTextField phoneField = new JTextField();
		JLabel emailLabel = new JLabel("E-mail adresa*");
		JTextField emailField = new JTextField();
		JLabel indexLabel = new JLabel("Broj indeksa*");
		JTextField indexField = new JTextField();
		JLabel enrollmentYearLabel = new JLabel("Godina upisa*");
		JTextField enrollmentYearField = new JTextField();
		JLabel currentYearOfStudyLabel = new JLabel("Trenutna godina studija*");
		JComboBox<String> currentYearOfStudyComboBox = new JComboBox<String>();
		currentYearOfStudyComboBox.addItem("I (Prva)");
		currentYearOfStudyComboBox.addItem("II (Druga)");
		currentYearOfStudyComboBox.addItem("III (Treæa)");
		currentYearOfStudyComboBox.addItem("IV (Èetvrta)");
		JLabel studentStatusLabel = new JLabel("Naèin finansiranja*");
		JComboBox<String> studentStatusComboBox = new JComboBox<String>();
		studentStatusComboBox.addItem("Budzet");
		studentStatusComboBox.addItem("Samofinansiranje");

		JButton confirmButton = new JButton("Potvrdi");
		confirmButton.addActionListener(new ActionListener(){
	
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentController studentController = new StudentController();
				
				String[] parts = adressField.getText().split(",");
				//TODO validate adress input
				Adress adress = new Adress(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3]);
				
				int selectedCurrentYear = currentYearOfStudyComboBox.getSelectedIndex();
				int selectedStudentStatus = studentStatusComboBox.getSelectedIndex();
				StudentStatus studentStatus = null;
				switch(selectedStudentStatus) {
				case 0:
					studentStatus = StudentStatus.B;
					break;
				case 1:
					studentStatus = StudentStatus.S;
					break;
				default:
					break;
				}
				
				studentController.addStudent(surnameField.getText(), nameField.getText(),
						new Date(birthDateField.getText()), adress, phoneField.getText(),
						emailField.getText(), indexField.getText(), Integer.parseInt(enrollmentYearField.getText()),
						selectedCurrentYear +1, studentStatus);
				StudentAddFrame.getInstance().setVisible(false);
				
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
			
		});
		JButton cancelButton = new JButton("Odustani");
		
		contentPanel.add(nameLabel);
		contentPanel.add(nameField);
		contentPanel.add(surnameLabel);
		contentPanel.add(surnameField);
		contentPanel.add(birthDateLabel);
		contentPanel.add(birthDateField);
		contentPanel.add(adressLabel);
		contentPanel.add(adressField);
		contentPanel.add(phoneLabel);
		contentPanel.add(phoneField);
		contentPanel.add(emailLabel);
		contentPanel.add(emailField);
		contentPanel.add(indexLabel);
		contentPanel.add(indexField);
		contentPanel.add(enrollmentYearLabel);
		contentPanel.add(enrollmentYearField);
		contentPanel.add(currentYearOfStudyLabel);
		contentPanel.add(currentYearOfStudyComboBox);
		contentPanel.add(studentStatusLabel);
		contentPanel.add(studentStatusComboBox);
		contentPanel.add(confirmButton);
		contentPanel.add(cancelButton);
	    this.getContentPane().add(contentPanel);
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public static StudentAddFrame getInstance()
	{
		if(instance==null)
			instance=new StudentAddFrame();
		return instance;
	}

}
