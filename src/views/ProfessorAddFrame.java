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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controllers.ProfessorController;

public class ProfessorAddFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ProfessorAddFrame instance;
	private ProfessorAddFrame() {
		super();
		
		this.setModal (true);
		this.setAlwaysOnTop (true);
		this.setModalityType (ModalityType.APPLICATION_MODAL);
		
		Toolkit kit= Toolkit.getDefaultToolkit();
		Dimension d= kit.getScreenSize();
		int width= d.width;
		int height=d.height;
		setSize(width*1/4, height*3/4);
		setLocationRelativeTo(MainFrame.getInstance());
		setTitle(MainFrame.getInstance().getResourceBundle().getString("addProfessor"));
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		setIconImage(icon);
		
		JPanel contentPanel = new JPanel(new GridLayout(17, 2, 5, 5));
		contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		
		JLabel surnameLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("surname") + "*");
		JTextField surnameField = new JTextField();
		JLabel nameLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("name") + "*");
		JTextField nameField = new JTextField();
		JLabel birthDateLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("birthDate") + "* (dd.mm.yyyy.)");
		JTextField birthDateField = new JTextField();
		JLabel streetAdressLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("streetLiving") + "*");
		JTextField streetAdressField = new JTextField();
		JLabel numberAdressLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("numberLiving") + "*");
		JTextField numberAdressField = new JTextField();
		JLabel cityAdressLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("cityLiving") + "*");
		JTextField cityAdressField = new JTextField();
		JLabel countryAdressLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("countryLiving") + "*");
		JTextField countryAdressField = new JTextField();
		JLabel phoneLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("phone") + "*");
		JTextField phoneField = new JTextField();
		JLabel emailLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("email") + "*");
		JTextField emailField = new JTextField();
		JLabel streetOfficeAdressLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("streetOffice") + "*");
		JTextField streetOfficeAdressField = new JTextField();
		JLabel numberOfficeAdressLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("numberOffice") + "*");
		JTextField numberOfficeAdressField = new JTextField();
		JLabel cityOfficeAdressLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("cityOffice") + "*");
		JTextField cityOfficeAdressField = new JTextField();
		JLabel countryOfficeAdressLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("countryOffice") + "*");
		JTextField countryOfficeAdressField = new JTextField();
		JLabel idNumberLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("idNumber") + "*");
		JTextField idNumberField = new JTextField();
		JLabel titleLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("title") + "*");
		JTextField titleField = new JTextField();
		JLabel serviceYearsLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("yearsOfExperience") + "*");
		JTextField serviceYearsField = new JTextField();
		
		JButton confirmButton = new JButton(MainFrame.getInstance().getResourceBundle().getString("confirm"));
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
				
				String dataValid= professorController.addProfessor(surnameField.getText(),nameField.getText(), birthDateField.getText(),
						streetAdressField.getText(), numberAdressField.getText(), cityAdressField.getText(), countryAdressField.getText(),
						phoneField.getText(), emailField.getText(), streetOfficeAdressField.getText(), numberOfficeAdressField.getText(),
						cityOfficeAdressField.getText(), countryOfficeAdressField.getText(), idNumberField.getText(), 
						titleField.getText(), serviceYearsField.getText());
			
			if(dataValid != "OK") {
				JOptionPane.showMessageDialog(ProfessorAddFrame.getInstance(), dataValid);
				}else {
					ProfessorAddFrame.getInstance().dispose();
					
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
				
				ProfessorAddFrame.getInstance().dispose();
				
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
		
		contentPanel.add(surnameLabel);
		contentPanel.add(surnameField);
		contentPanel.add(nameLabel);
		contentPanel.add(nameField);
		contentPanel.add(birthDateLabel);
		contentPanel.add(birthDateField);
		contentPanel.add(streetAdressLabel);
		contentPanel.add(streetAdressField);
		contentPanel.add(numberAdressLabel);
		contentPanel.add(numberAdressField);
		contentPanel.add(cityAdressLabel);
		contentPanel.add(cityAdressField);
		contentPanel.add(countryAdressLabel);
		contentPanel.add(countryAdressField);
		contentPanel.add(phoneLabel);
		contentPanel.add(phoneField);
		contentPanel.add(emailLabel);
		contentPanel.add(emailField);
		contentPanel.add(streetOfficeAdressLabel);
		contentPanel.add(streetOfficeAdressField);
		contentPanel.add(numberOfficeAdressLabel);
		contentPanel.add(numberOfficeAdressField);
		contentPanel.add(cityOfficeAdressLabel);
		contentPanel.add(cityOfficeAdressField);
		contentPanel.add(countryOfficeAdressLabel);
		contentPanel.add(countryOfficeAdressField);
		contentPanel.add(idNumberLabel);
		contentPanel.add(idNumberField);
		contentPanel.add(titleLabel);
		contentPanel.add(titleField);
		contentPanel.add(serviceYearsLabel);
		contentPanel.add(serviceYearsField);
		contentPanel.add(confirmButton);
		contentPanel.add(cancelButton);
		
		this.getContentPane().add(contentPanel);

		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
	}
	
	public static ProfessorAddFrame getInstance()
	{
		if(instance==null)
			instance=new ProfessorAddFrame();
		instance.setLocationRelativeTo(MainFrame.getInstance());
		return instance;
	}
	
	public static void recreate() {
		if(instance != null)
			instance.dispose();
		instance = null;
	}

}
