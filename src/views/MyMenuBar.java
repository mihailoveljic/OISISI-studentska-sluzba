package views;

import methods.ResizeIcon;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


public class MyMenuBar extends JMenuBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1635843134686347858L;

	public MyMenuBar() {
		super();
		
		// Glavni meni
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		JMenu editMenu = new JMenu("Edit");
		editMenu.setMnemonic(KeyEvent.VK_E);
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		
		// Ikonice
		Icon addIcon = ResizeIcon.resizeIcon(new ImageIcon("images/addButton.png"), 14, 14);
		Icon editIcon = ResizeIcon.resizeIcon(new ImageIcon("images/editButton.png"), 14, 14);
		Icon deleteIcon = ResizeIcon.resizeIcon(new ImageIcon("images/deleteButton.png"), 14, 14);
		Icon closeIcon = ResizeIcon.resizeIcon(new ImageIcon("images/closeButton.png"), 14, 14);
		Icon saveIcon = ResizeIcon.resizeIcon(new ImageIcon("images/saveButton.png"), 14, 14);
		Icon openIcon = ResizeIcon.resizeIcon(new ImageIcon("images/openButton.png"), 14, 14);
		Icon helpIcon = ResizeIcon.resizeIcon(new ImageIcon("images/helpButton.png"), 14, 14);
		Icon aboutIcon = ResizeIcon.resizeIcon(new ImageIcon("images/aboutButton.png"), 14, 14);
		Icon studentIcon = ResizeIcon.resizeIcon(new ImageIcon("images/studentIcon.png"), 14, 14);
		Icon professorIcon = ResizeIcon.resizeIcon(new ImageIcon("images/professorIcon.png"), 14, 14);
		Icon subjectIcon = ResizeIcon.resizeIcon(new ImageIcon("images/subjectIcon.png"), 14, 14);
		Icon departmentIcon = ResizeIcon.resizeIcon(new ImageIcon("images/departmentIcon.png"), 14, 14);
		
		
		// File meni
		JMenuItem newItem = new JMenuItem("New", addIcon);
		newItem.setMnemonic(KeyEvent.VK_N);
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		JMenuItem saveItem = new JMenuItem("Save", saveIcon);
		saveItem.setMnemonic(KeyEvent.VK_S);
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		JMenu openMenu = new JMenu("Open");
		openMenu.setIcon(openIcon);
		openMenu.setMnemonic(KeyEvent.VK_O);
		
		JMenuItem students = new JMenuItem("Studenti", studentIcon);
		students.setMnemonic(KeyEvent.VK_S);
		students.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.SHIFT_MASK));
		JMenuItem subjects = new JMenuItem("Predmeti", subjectIcon);
		subjects.setMnemonic(KeyEvent.VK_P);
		subjects.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.SHIFT_MASK));
		JMenuItem professors = new JMenuItem("Profesori", professorIcon);
		professors.setMnemonic(KeyEvent.VK_F);
		professors.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.SHIFT_MASK));
		JMenuItem departments = new JMenuItem("Katedre", departmentIcon);
		departments.setMnemonic(KeyEvent.VK_K);
		departments.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.SHIFT_MASK));
		openMenu.add(students);
		openMenu.add(subjects);
		openMenu.add(professors);
		openMenu.add(departments);
		
		JMenuItem closeItem = new JMenuItem("Close", closeIcon);
		closeItem.setMnemonic(KeyEvent.VK_C);
		closeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		newItem.addActionListener(new AddEntityListener());
		
		
		fileMenu.add(newItem);
		fileMenu.addSeparator();
		fileMenu.add(saveItem);
		fileMenu.addSeparator();
		fileMenu.add(openMenu);
		fileMenu.add(closeItem);
		
		// Edit meni
		JMenuItem editItem = new JMenuItem("Edit", editIcon);
		editItem.setMnemonic(KeyEvent.VK_E);
		editItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		JMenuItem deleteItem = new JMenuItem("Delete", deleteIcon);
		deleteItem.setMnemonic(KeyEvent.VK_D);
		deleteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		editItem.addActionListener(new EditEntityListener());
		deleteItem.addActionListener(new DeleteEntityListener());
		editMenu.add(editItem);
		editMenu.addSeparator();
		editMenu.add(deleteItem);
		
		// Help meni
		JMenuItem helpItem = new JMenuItem("Help", helpIcon);
		helpItem.setMnemonic(KeyEvent.VK_H);
		helpItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		JMenuItem aboutItem = new JMenuItem("About", aboutIcon);
		aboutItem.setMnemonic(KeyEvent.VK_A);
		aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		helpMenu.add(helpItem);
		helpMenu.addSeparator();
		helpMenu.add(aboutItem);

		// Dodavanje na meni bar
		this.add(fileMenu);
		this.add(editMenu);
		this.add(helpMenu);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
