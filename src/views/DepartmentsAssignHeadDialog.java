package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import models.DbDepartments;
import models.DbProfessors;
import models.Professor;

public class DepartmentsAssignHeadDialog extends JDialog implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4117899405896014629L;
	
	
	private JButton okButton;
	private JButton cancelButton;
	private String selectedProfesor;
	@SuppressWarnings("rawtypes")
	private JList professorList;
	private Professor p;
	private DepartmentsPanel departmentsPanel;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DepartmentsAssignHeadDialog(DepartmentsPanel departmentsPanel){
		super();
		this.setModal (true);
		this.setAlwaysOnTop (true);
		this.setModalityType (ModalityType.APPLICATION_MODAL);

		this.departmentsPanel = departmentsPanel;
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		int width = d.width;
		int height = d.height;

		// Pravljenje prozora
		setSize(width*1/5, height*1/5);
		setLocationRelativeTo(SubjectEditFrame.getInstance());
		setTitle("Odaberi profesora");
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		setIconImage(icon);
		this.setResizable(false);
		
		
		
		
		JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		okButton = new JButton("Potvrdi");
		okButton.addActionListener(this);
		cancelButton = new JButton("Odustani");
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});

		commandPanel.add(okButton);
		commandPanel.add(cancelButton);
		
		DefaultListModel listModel;
		listModel = new DefaultListModel();
		List<Professor> professors =  DbDepartments.getInstance().getRow(this.departmentsPanel.getDepartmentsTable().getSelectedRow()).getProfessors();
		if(professors != null) {
			for(Professor p : professors) {
				
				listModel.addElement(p.getName() + " " + p.getSurname());
			}
		}
		professorList = new JList(listModel);
	    professorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    JScrollPane scrollPane = new JScrollPane(professorList);
		
		add(scrollPane, BorderLayout.CENTER);
		add(commandPanel, BorderLayout.SOUTH);
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		selectedProfesor = (String) professorList.getSelectedValue();
		if (selectedProfesor == null) {
			JOptionPane.showMessageDialog(this, "Profesor nije selektovan.", "Upozorenje!", JOptionPane.ERROR_MESSAGE);
		}
		else {
			String[] parts = selectedProfesor.split(" ");
			String name = parts[0];
			String surname = parts[1];
			for(Professor p : DbProfessors.getInstance().getProfessors()) {
				
				if(name.equals(p.getName()) && surname.equals(p.getSurname())) {
					DbDepartments.getInstance().getRow(departmentsPanel.getDepartmentsTable().getSelectedRow()).setHeadOfDepartment(p);
					departmentsPanel.refresh();
				}
			}
			
			JOptionPane.showMessageDialog(this, "Profesor uspešno izabran!");
			dispose();
		}
		
	}
	
	public Professor getProfessor() {
		return this.p;
	}
}
