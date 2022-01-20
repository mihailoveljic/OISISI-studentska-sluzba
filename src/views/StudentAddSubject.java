package views;

import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.Color;
//import java.awt.Component;
import java.awt.Dimension;
//import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
//import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import models.DbStudents;
import models.Grade;
import models.Subject;
//import models.DbStudents;

public class StudentAddSubject extends JDialog implements ActionListener {

	private static final long serialVersionUID = -986281284875651792L;
	private JButton okButton;
	private JButton cancelButton;
	private JTextField idField;
	private JTextField nameField;
	private JTextField dateField;
	private JComboBox<Integer> gradeComboBox;
	private Subject s;
	
	
	public StudentAddSubject (MainFrame instance, String title, boolean b, Subject subject) {
		super();
		
		s = subject;
		
		setTitle("Unos ocene");
		setSize(350, 250);
		setLocationRelativeTo(StudentSubjectsPanel.getInstance());
		setResizable(false);
		setModal(true);
		this.setAlwaysOnTop(b);
		
		JPanel panCommands = new JPanel();
		okButton = new JButton("Potvrdi");
		okButton.setEnabled(false);
		okButton.addActionListener(this); 
		
		cancelButton = new JButton("Odustani");
        cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		panCommands.add(cancelButton);
		panCommands.add(okButton);
		
		Dimension dim = new Dimension(150, 30);
		JPanel panAddMark = new JPanel();

		JLabel labelSifra = new JLabel("�ifra*");
		labelSifra.setPreferredSize(dim);
		idField = new JTextField();
		idField.setPreferredSize(dim);
		
		JLabel labelNaziv = new JLabel("Naziv*");
		labelNaziv.setPreferredSize(dim);
		nameField = new JTextField();
		nameField.setPreferredSize(dim);
		
		JLabel labelOcena = new JLabel("Ocena*");
		labelOcena.setPreferredSize(dim);
	    Integer marks[] = { 6, 7, 8, 9, 10 };
		gradeComboBox = new JComboBox<Integer>(marks);
		gradeComboBox.setPreferredSize(dim);
		
		JLabel labelDatum = new JLabel("Datum*");
		labelDatum.setPreferredSize(dim);
		dateField = new JTextField();
		dateField.setPreferredSize(dim);
		dateField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (check()) {
					okButton.setEnabled(true);
				} else {
					okButton.setEnabled(false);
				}
			}
		});
		
		GridBagConstraints gbcIme = new GridBagConstraints();
		gbcIme.gridx = 0;
		gbcIme.gridy = 0;
		gbcIme.insets = new Insets(20, 20, 0, 0);
		panAddMark.add(labelNaziv, gbcIme);
		
		GridBagConstraints gbcTxtIme = new GridBagConstraints();
		gbcTxtIme.gridx = 1;
		gbcTxtIme.gridy = 0;
		gbcTxtIme.weightx = 200;
		gbcTxtIme.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtIme.insets = new Insets(20, 20, 0, 20);
		panAddMark.add(nameField, gbcTxtIme);

		GridBagConstraints gbcPrezime = new GridBagConstraints();
		gbcPrezime.gridx = 0;
		gbcPrezime.gridy = 1;
		gbcPrezime.insets = new Insets(20, 20, 0, 0);
		gbcPrezime.anchor = GridBagConstraints.LINE_START;
		panAddMark.add(labelSifra, gbcPrezime);
		
		GridBagConstraints gbcTxtPrezime = new GridBagConstraints();
		gbcTxtPrezime.gridx = 1;
		gbcTxtPrezime.gridy = 1;
		gbcTxtPrezime.weightx = 200;
		gbcTxtPrezime.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtPrezime.insets = new Insets(20, 20, 0, 20);
		panAddMark.add(idField, gbcTxtPrezime);

		GridBagConstraints gbcDatumRodjenja = new GridBagConstraints();
		gbcDatumRodjenja.gridx = 0;
		gbcDatumRodjenja.gridy = 2;
		gbcDatumRodjenja.insets = new Insets(20, 20, 0, 0);
		panAddMark.add(labelOcena, gbcDatumRodjenja);
		
		GridBagConstraints gbcTxtDatumRodjenja = new GridBagConstraints();
		gbcTxtDatumRodjenja.gridx = 1;
		gbcTxtDatumRodjenja.gridy = 2;
		gbcTxtDatumRodjenja.weightx = 200;
		gbcTxtDatumRodjenja.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtDatumRodjenja.insets = new Insets(20, 20, 0, 20);
		panAddMark.add(gradeComboBox, gbcTxtDatumRodjenja);

		GridBagConstraints gbcAdresaStanovanja = new GridBagConstraints();
		gbcAdresaStanovanja.gridx = 0;
		gbcAdresaStanovanja.gridy = 3;
		gbcAdresaStanovanja.insets = new Insets(20, 20, 0, 0);
		panAddMark.add(labelDatum, gbcAdresaStanovanja);
		
		GridBagConstraints gbcTxtAdresaStanovanja = new GridBagConstraints();
		gbcTxtAdresaStanovanja.gridx = 1;
		gbcTxtAdresaStanovanja.gridy = 3;
		gbcTxtAdresaStanovanja.weightx = 200;
		gbcTxtAdresaStanovanja.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtAdresaStanovanja.insets = new Insets(20, 20, 0, 20);
		panAddMark.add(dateField, gbcTxtAdresaStanovanja);

		
		add(panAddMark, BorderLayout.CENTER);
		add(panCommands, BorderLayout.SOUTH);
		
		set(subject);
		nameField.setEditable(false);
		idField.setEditable(false);
		
		
	}
	
	public void set(Subject s) {
		nameField.setText(s.getName());
		idField.setText(s.getId());
	}
	
	@SuppressWarnings("deprecation")
	public Date getDatum() {
		Date formattedDate=null;
		
		try {
			String parts[] = dateField.getText().toString().split("[.]");
			if(parts.length >= 3) {
				formattedDate = new Date(Integer.parseInt(parts[2]), Integer.parseInt(parts[1]) - 1, Integer.parseInt(parts[0]));
				dateField.setBorder(null);
			}else {
				dateField.setBorder(new LineBorder(Color.red,1));
				return null;
			}
			}catch(Exception e){
				dateField.setBorder(new LineBorder(Color.red,1));
				return null;
			}
		
		return formattedDate;
    }
	
	public boolean check() {
		Date text = getDatum();
		if(text!=null)
		{
		return true;
		} else return false;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Date datum = getDatum();
		int value = (int) gradeComboBox.getSelectedItem();
		DbStudents.getInstance().findStudentByIndex((String) StudentTable.getInstance().getValueAt(StudentTable.getInstance().getSelectedRow(), 0)).getSubjects().remove(s);
		Grade g = new Grade(DbStudents.getInstance().findStudentByIndex((String) StudentTable.getInstance().getValueAt(StudentTable.getInstance().getSelectedRow(), 0)),s,value,datum);
		
		DbStudents.getInstance().findStudentByIndex((String) StudentTable.getInstance().getValueAt(StudentTable.getInstance().getSelectedRow(), 0)).getGrades().add(g);
		DbStudents.getInstance().findStudentByIndex((String) StudentTable.getInstance().getValueAt(StudentTable.getInstance().getSelectedRow(), 0)).getSubjects().remove(g.getSubject());

		JOptionPane.showMessageDialog(StudentSubjectsPanel.getInstance().getStudentAddSubject(), "Upisana ocena");
		StudentGradesPanel.getInstance().refresh();
		StudentSubjectsPanel.getInstance().refresh();
		setVisible(false);
	}
}
