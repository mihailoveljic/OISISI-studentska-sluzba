package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import models.DbStudents;
import models.DbSubjects;
import models.Grade;
import models.Student;
import models.Subject;

public class StudentAddSubjectDialog extends JDialog implements ActionListener{
	
	private static final long serialVersionUID = -7981006772785670384L;
	private JButton okButton;
	private JButton cancelButton;
	private String selectedSubject;
	@SuppressWarnings("rawtypes")
	private JList subjects;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public StudentAddSubjectDialog() {
		super();
		
		setTitle(MainFrame.getInstance().getResourceBundle().getString("addSubject"));
		setSize(400, 400);
		setLocationRelativeTo(this.getParent());
		setModal(true);
		setResizable(false);
		setAlwaysOnTop (true);
		
		JPanel commandsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		okButton = new JButton(MainFrame.getInstance().getResourceBundle().getString("confirm"));
		okButton.addActionListener(this);
		cancelButton = new JButton(MainFrame.getInstance().getResourceBundle().getString("cancel"));
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		commandsPanel.add(okButton);
		commandsPanel.add(cancelButton);
		
		DefaultListModel listModel;
		listModel = new DefaultListModel();
		boolean isContained = false;
		
		List<Subject> listSubjects = new ArrayList<Subject>();
		listSubjects = DbStudents.getInstance().findStudentByIndex((String) StudentTable.getInstance().getValueAt(StudentTable.getInstance().getSelectedRow(), 0)).getSubjects();
		List<Grade> listGrades = new ArrayList<Grade>();
		listGrades = DbStudents.getInstance().findStudentByIndex((String) StudentTable.getInstance().getValueAt(StudentTable.getInstance().getSelectedRow(), 0)).getGrades();
		
		for(Subject s : DbSubjects.getInstance().getSubjects()) {
			if(listSubjects.contains(s)) {
				isContained=true;
			}
			for(Grade g2 : listGrades) {
				if(g2.getSubject().getId()==s.getId())
				{
					isContained=true;
					break;
				}
			}
			
			if(!isContained) 
			{
				listModel.addElement(s.getId()+" "+s.getName());
			}
			isContained=false;
		}
		
		subjects = new JList(listModel);
	    subjects.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    JScrollPane scrollPane = new JScrollPane(subjects);
		
		add(scrollPane, BorderLayout.NORTH);
		add(commandsPanel, BorderLayout.SOUTH);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		selectedSubject = (String) subjects.getSelectedValue();
		if (selectedSubject == null) {
			JOptionPane.showMessageDialog(this, MainFrame.getInstance().getResourceBundle().getString("subjectNotChosen"), MainFrame.getInstance().getResourceBundle().getString("warning"),
					JOptionPane.ERROR_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(this, MainFrame.getInstance().getResourceBundle().getString("subjectAdded"));
			Student student = DbStudents.getInstance().findStudentByIndex((String) StudentTable.getInstance().getValueAt(StudentTable.getInstance().getSelectedRow(), 0));
			String parts[] = selectedSubject.split(" ");
			student.getSubjects().add(DbSubjects.getInstance().findSubjectById(parts[0]));
			if(DbSubjects.getInstance().findSubjectById(parts[0]).getListOfStudentsWhoFailed()==null) {
				DbSubjects.getInstance().findSubjectById(parts[0]).setListOfStudentsWhoFailed(new ArrayList<Student>());
				
			}
			DbSubjects.getInstance().findSubjectById(parts[0]).getListOfStudentsWhoFailed().add(student);
			StudentSubjectsPanel.getInstance().refresh();
			setVisible(false);
		}
		}
	}

