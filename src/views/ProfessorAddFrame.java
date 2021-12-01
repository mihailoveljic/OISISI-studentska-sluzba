package views;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProfessorAddFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProfessorAddFrame() {
		super();
		
		Toolkit kit= Toolkit.getDefaultToolkit();
		Dimension d= kit.getScreenSize();
		int width= d.width;
		int height=d.height;
		setSize(width*1/4, height*1/2);
		setLocationRelativeTo(null);
		setTitle("Dodavanje profesora");
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		setIconImage(icon);
		
		JPanel contentPanel = new JPanel(new GridLayout(10, 2, 5, 5));
		contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		
		JLabel surnameLabel=new JLabel("Prezime*");
		JTextField surnameField = new JTextField();
		JLabel nameLabel=new JLabel("Ime*");
		JTextField nameField = new JTextField();
		JLabel birthDateLabel=new JLabel("Datum roðenja*");
		JTextField birthDateField = new JTextField();
		JLabel adressLabel=new JLabel("Adresa stanovanja*");
		JTextField adressField = new JTextField();
		JLabel emailLabel=new JLabel("E-mail adresa*");
		JTextField emailField = new JTextField();
		JLabel officeAdressLabel=new JLabel("Adresa kancelarije*");
		JTextField officeAdressLabelField = new JTextField();
		JLabel idNumberLabel=new JLabel("Broj licne karte*");
		JTextField idNumberField = new JTextField();
		JLabel titleLabel=new JLabel("Zvanje*");
		JTextField titleField = new JTextField();
		JLabel serviceYearsLabel=new JLabel("Godine radnog staza*");
		JTextField serviceYearsField = new JTextField();
		
		JButton confirmButton = new JButton("Potvrdi");
		JButton cancelButton = new JButton("Odustani");
		
		contentPanel.add(surnameLabel);
		contentPanel.add(surnameField);
		contentPanel.add(nameLabel);
		contentPanel.add(nameField);
		contentPanel.add(birthDateLabel);
		contentPanel.add(birthDateField);
		contentPanel.add(adressLabel);
		contentPanel.add(adressField);
		contentPanel.add(emailLabel);
		contentPanel.add(emailField);
		contentPanel.add(officeAdressLabel);
		contentPanel.add(officeAdressLabelField);
		contentPanel.add(idNumberLabel);
		contentPanel.add(idNumberField);
		contentPanel.add(titleLabel);
		contentPanel.add(titleField);
		contentPanel.add(serviceYearsLabel);
		contentPanel.add(serviceYearsField);
		contentPanel.add(confirmButton);
		contentPanel.add(cancelButton);
		
		this.getContentPane().add(contentPanel);
		this.setVisible(true);

		
		
		
	}
	
	

}
