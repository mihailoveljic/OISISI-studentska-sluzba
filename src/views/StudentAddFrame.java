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

public class StudentAddFrame extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6131600099102309111L;
	
	
	private static StudentAddFrame instance;
	private StudentAddFrame() {
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
		setTitle(MainFrame.getInstance().getResourceBundle().getString("addStudent"));
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		setIconImage(icon);

		JPanel contentPanel = new JPanel(new GridLayout(14, 2, 5, 5));
		contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

		JLabel nameLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("name") + "*");
		JTextField nameField = new JTextField();
		JLabel surnameLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("surname") + "*");
		JTextField surnameField = new JTextField();
		JLabel birthDateLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("birthDate") + "* (dd.mm.yyyy.)");
		JTextField birthDateField = new JTextField();
		JLabel streetLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("streetLiving") + "*");
		JTextField streetField = new JTextField();
		JLabel numberLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("numberLiving") + "*");
		JTextField numberField = new JTextField();
		JLabel cityLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("cityLiving") + "*");
		JTextField cityField = new JTextField();
		JLabel countryLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("countryLiving") + "*");
		JTextField countryField = new JTextField();
		JLabel phoneLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("phone") + "*");
		JTextField phoneField = new JTextField();
		JLabel emailLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("email") + "*");
		JTextField emailField = new JTextField();
		JLabel indexLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("indexNumber") + "*");
		JTextField indexField = new JTextField();
		JLabel enrollmentYearLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("enrollmentYear") + "*");
		JTextField enrollmentYearField = new JTextField();
		JLabel currentYearOfStudyLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("currentYearOfStudy") + "*");
		JComboBox<String> currentYearOfStudyComboBox = new JComboBox<String>();
		currentYearOfStudyComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("firstYear"));
		currentYearOfStudyComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("secondYear"));
		currentYearOfStudyComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("thirdYear"));
		currentYearOfStudyComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("fourthYear"));
		JLabel studentStatusLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("finanseWay") + "*");
		JComboBox<String> studentStatusComboBox = new JComboBox<String>();
		studentStatusComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("budget"));
		studentStatusComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("selfFinansing"));

		JButton confirmButton = new JButton(MainFrame.getInstance().getResourceBundle().getString("confirm"));
		ButtonModel confirmButtonModel = confirmButton.getModel();
		ButtonEnabler buttonEnabler = new ButtonEnabler(confirmButtonModel);	
		buttonEnabler.addDocument(surnameField.getDocument());
		buttonEnabler.addDocument(nameField.getDocument());
		buttonEnabler.addDocument(birthDateField.getDocument());
		buttonEnabler.addDocument(streetField.getDocument());
		buttonEnabler.addDocument(numberField.getDocument());
		buttonEnabler.addDocument(cityField.getDocument());
		buttonEnabler.addDocument(countryField.getDocument());
		buttonEnabler.addDocument(phoneField.getDocument());
		buttonEnabler.addDocument(emailField.getDocument());
		buttonEnabler.addDocument(indexField.getDocument());
		buttonEnabler.addDocument(enrollmentYearField.getDocument());
		
		confirmButton.addActionListener(new ActionListener(){
	
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentController studentController = new StudentController();
				
				String dataValid = studentController.addStudent(surnameField.getText(), nameField.getText(),
						birthDateField.getText(), streetField.getText(), numberField.getText(), cityField.getText(), countryField.getText(), phoneField.getText(),
						emailField.getText(), indexField.getText(), enrollmentYearField.getText(),
						currentYearOfStudyComboBox.getSelectedIndex(), studentStatusComboBox.getSelectedIndex());
				
				if( dataValid != "OK") {
					JOptionPane.showMessageDialog(StudentAddFrame.getInstance(), dataValid);
				}else {
					StudentAddFrame.getInstance().dispose();
					
					surnameField.setText("");
					nameField.setText("");
					birthDateField.setText("");
					streetField.setText("");
					numberField.setText("");
					cityField.setText("");
					countryField.setText("");
					phoneField.setText("");
					emailField.setText("");
					indexField.setText("");
					enrollmentYearField.setText("");
					currentYearOfStudyComboBox.setSelectedIndex(0);
					studentStatusComboBox.setSelectedIndex(0);
				}
			}
			
		});
		JButton cancelButton = new JButton(MainFrame.getInstance().getResourceBundle().getString("cancel"));
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				surnameField.setText("");
				nameField.setText("");
				birthDateField.setText("");
				streetField.setText("");
				numberField.setText("");
				cityField.setText("");
				countryField.setText("");
				phoneField.setText("");
				emailField.setText("");
				indexField.setText("");
				enrollmentYearField.setText("");
				currentYearOfStudyComboBox.setSelectedIndex(0);
				studentStatusComboBox.setSelectedIndex(0);
				StudentAddFrame.getInstance().dispose();
			}
		});
		
		
		contentPanel.add(nameLabel);
		contentPanel.add(nameField);
		contentPanel.add(surnameLabel);
		contentPanel.add(surnameField);
		contentPanel.add(birthDateLabel);
		contentPanel.add(birthDateField);
		contentPanel.add(streetLabel);
		contentPanel.add(streetField);
		contentPanel.add(numberLabel);
		contentPanel.add(numberField);
		contentPanel.add(cityLabel);
		contentPanel.add(cityField);
		contentPanel.add(countryLabel);
		contentPanel.add(countryField);
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
		instance.setLocationRelativeTo(MainFrame.getInstance());
		return instance;
	}
	
	public static void recreate() {
		if(instance != null)
			instance.dispose();
		instance = null;
	}
}
