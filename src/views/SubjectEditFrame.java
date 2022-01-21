package views;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
	
	String oldId = null;
	
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
		setTitle(MainFrame.getInstance().getResourceBundle().getString("editSubject"));
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		setIconImage(icon);

		JPanel contentPanel = new JPanel(new GridLayout(8, 2, 5, 5));
		contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

		s = DbSubjects.getInstance().findSubjectById((String)SubjectTable.getInstance().getValueAt(SubjectTable.getInstance().getSelectedRow(), 0));
		if(s != null) {
			oldId = s.getId();
			id = s.getId();
			name = s.getName();
		    yearOfStudy = s.getYearOfStudy();
			semester = s.getSemester();
		    ESPB = String.valueOf(s.getESPB());
		    professor = s.getProfessor();
		}else {
			oldId = null;
			id = "";
			name = "";
		    yearOfStudy = 0;
			semester = Semester.ZIMSKI;
		    ESPB = "";
		    professor = null;
		}
		
		JLabel idLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("subjectId") + "*");
		idField = new JTextField(id);
		JLabel nameLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("subjectName") + "*");
		nameField = new JTextField(name);
		JLabel currentYearOfStudyLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("yearOfStudy") + "*");
		currentYearOfStudyComboBox = new JComboBox<String>();
		currentYearOfStudyComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("firstYear"));
		currentYearOfStudyComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("secondYear"));
		currentYearOfStudyComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("thirdYear"));
		currentYearOfStudyComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("fourthYear"));
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
		JLabel semesterLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("semester") + "*");
		semesterComboBox = new JComboBox<String>();
		semesterComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("winter"));
		semesterComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("summer"));
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
		JLabel espbLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("espb") + "*");
		espbField = new JTextField(ESPB);
		JLabel professorLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("professor"));
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
		JButton confirmButton = new JButton(MainFrame.getInstance().getResourceBundle().getString("confirm"));
		ButtonModel confirmButtonModel = confirmButton.getModel();
		ButtonEnabler buttonEnabler = new ButtonEnabler(confirmButtonModel);
		buttonEnabler.addDocument(idField.getDocument());
		buttonEnabler.addDocument(nameField.getDocument());
		buttonEnabler.addDocument(espbField.getDocument());
		
		confirmButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SubjectController subjectController = new SubjectController();
				
				if(SubjectTable.getInstance().getSelectedRow()!=-1) {
				String dataValid = subjectController.editSubject(SubjectTable.getInstance().getSelectedRow(),
						idField.getText(), nameField.getText(), currentYearOfStudyComboBox.getSelectedIndex(),
						semesterComboBox.getSelectedIndex(),espbField.getText(), professor);
				
				if( dataValid != "OK") {
					JOptionPane.showMessageDialog(SubjectEditFrame.getInstance(), dataValid);
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
			}
			
		});
		
		JButton cancelButton = new JButton(MainFrame.getInstance().getResourceBundle().getString("cancel"));
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
		
	    setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				SubjectPanel.getInstance().updateView();
				dispose();
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void updateSubjectSelection() {
		s = DbSubjects.getInstance().findSubjectById((String)SubjectTable.getInstance().getValueAt(SubjectTable.getInstance().getSelectedRow(), 0));
		if(s != null) {
			oldId = s.getId();
			id = s.getId();
			name = s.getName();
		    yearOfStudy = s.getYearOfStudy();
			semester = s.getSemester();
		    ESPB = String.valueOf(s.getESPB());
		    professor = s.getProfessor();
		}else {
			oldId = null;
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
		
		updateProfessorSelection();
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

	public String getOldId() {
		return oldId;
	}

	public void setOldId(String oldId) {
		this.oldId = oldId;
	}
	
	public static void recreate() {
		if(instance != null)
			instance.dispose();
		instance = null;
	}
}