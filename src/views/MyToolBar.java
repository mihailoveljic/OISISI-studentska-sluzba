package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controllers.ProfessorController;
import controllers.StudentController;
import controllers.SubjectController;
import methods.ResizeIcon;

public class MyToolBar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5375224116363442663L;
	
	JTextField searchBar;
	
	JButton addButton;
	JButton editButton;
	JButton deleteButton;
	JButton searchButton;
	
	public MyToolBar()
	{
		super();
		
		int iconSize = 18;
		Icon addIcon = ResizeIcon.resizeIcon(new ImageIcon("images" + File.separator + "addButton.png"),iconSize,iconSize);
		Icon editIcon = ResizeIcon.resizeIcon(new ImageIcon("images" + File.separator + "editButton.png"),iconSize,iconSize);
		Icon deleteIcon = ResizeIcon.resizeIcon(new ImageIcon("images" + File.separator + "deleteButton.png"),iconSize,iconSize);
		Icon searchIcon = ResizeIcon.resizeIcon(new ImageIcon("images" + File.separator + "searchButton.png"),iconSize,iconSize);
		
		addButton = new JButton(addIcon);
		editButton = new JButton(editIcon);
		deleteButton = new JButton(deleteIcon);
		searchButton = new JButton(searchIcon);

		addButton.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("add"));
		editButton.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("edit"));
		deleteButton.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("delete"));
		searchButton.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("search"));
		
		searchBar = new JTextField(30);
		Dimension d = new Dimension(40, 30);
		searchBar.setMaximumSize(d);
		
		addButton.addActionListener(new AddEntityListener());
		editButton.addActionListener(new EditEntityListener());
		deleteButton.addActionListener(new DeleteEntityListener());
		searchBar.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
			
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					MainFrame mainFrame = MainFrame.getInstance();
					
					JPanel panel = (JPanel) mainFrame.getContentPane();
					
					MainTabbedPane mainTabbedPane = (MainTabbedPane) panel.getComponent(2);
					
					switch(mainTabbedPane.getSelectedIndex()) {
						case 0:
						{
							String s = searchBar.getText();
							StudentController studentController = new StudentController();
							studentController.searchStudent(s);
							searchButton.setSelected(false);
							break;
						}
						case 1:
						{
						}
						case 2:
						{	
			
						}
					}
			    }
			}
		});
		
		searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame mainFrame = MainFrame.getInstance();
				
				JPanel panel = (JPanel) mainFrame.getContentPane();
				
				MainTabbedPane mainTabbedPane = (MainTabbedPane) panel.getComponent(2);
				
				switch(mainTabbedPane.getSelectedIndex()) {
					case 0:
					{
						String s = searchBar.getText();
						StudentController studentController = new StudentController();
						studentController.searchStudent(s);
						searchButton.setSelected(false);
						break;
					}
					case 1:
					{
						String s = searchBar.getText();
						ProfessorController professorController = new ProfessorController();
						professorController.searchProfesor(s);
						searchButton.setSelected(false);
						break;
					}
					case 2:
					{	
						String s = searchBar.getText();
						SubjectController subjectController = new SubjectController();
						subjectController.searchSubject(s);
						searchButton.setSelected(false);
						break;
					}
				}
			}
		});
		
		this.add(addButton);
		this.add(editButton);
		this.add(deleteButton);
		this.add(Box.createHorizontalGlue());
		this.add(searchBar);
		this.add(searchButton);
		this.setFloatable(false);
		this.setBorder(BorderFactory.createLineBorder(Color.black));	
	}
	
	public void reloadUI() {
		addButton.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("add"));
		editButton.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("edit"));
		deleteButton.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("delete"));
		searchButton.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("search"));
	}


}
