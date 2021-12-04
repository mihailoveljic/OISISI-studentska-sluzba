package views;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SubjectAddFrame extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4125736938637561082L;

	private static SubjectAddFrame instance;
	private SubjectAddFrame(){
		super();

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		int width = d.width;
		int height = d.height;

		// Pravljenje prozora
		setSize(width*1/4, height*2/4);
		setLocationRelativeTo(null);
		setTitle("Dodavanje predmeta");
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		setIconImage(icon);

		JPanel contentPanel = new JPanel(new GridLayout(7, 2, 5, 5));
		contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

		
		
		
		JLabel idLabel = new JLabel("Šifra*");
		JTextField idField = new JTextField();
		JLabel nameLabel = new JLabel("Naziv*");
		JTextField nameField = new JTextField();
		JLabel semesterLabel = new JLabel("Semestar*");
		JComboBox<String> semesterComboBox = new JComboBox<String>();
		semesterComboBox.addItem("Zimski");
		semesterComboBox.addItem("Letnji");
		JLabel currentYearOfStudyLabel = new JLabel("Godina studija*");
		JComboBox<String> currentYearOfStudyComboBox = new JComboBox<String>();
		currentYearOfStudyComboBox.addItem("I (Prva)");
		currentYearOfStudyComboBox.addItem("I (Druga)");
		currentYearOfStudyComboBox.addItem("I (Treæa)");
		currentYearOfStudyComboBox.addItem("I (Èetvrta)");		
		JLabel professorLabel = new JLabel("Profesor*");
		JComboBox<String> professorComboBox = new JComboBox<String>();
		// TODO Populate professorComboBox with professors
		JLabel espbLabel = new JLabel("ESPB*");
		JTextField espbField = new JTextField();
		JButton confirmButton = new JButton("Potvrdi");
		JButton cancelButton = new JButton("Odustani");
		
		contentPanel.add(idLabel);
		contentPanel.add(idField);
		contentPanel.add(nameLabel);
		contentPanel.add(nameField);
		contentPanel.add(semesterLabel);
		contentPanel.add(semesterComboBox);
		contentPanel.add(currentYearOfStudyLabel);
		contentPanel.add(currentYearOfStudyComboBox);
		contentPanel.add(professorLabel);
		contentPanel.add(professorComboBox);
		contentPanel.add(espbLabel);
		contentPanel.add(espbField);
		contentPanel.add(confirmButton);
		contentPanel.add(cancelButton);
	    this.getContentPane().add(contentPanel);
		setVisible(true);
	}
	
	public static SubjectAddFrame getInstance()
	{
		if(instance==null)
			instance=new SubjectAddFrame();
		return instance;
	}
}
