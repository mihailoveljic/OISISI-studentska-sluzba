package views;

import methods.ResizeIcon;
import methods.WriterReader;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;


public class MyMenuBar extends JMenuBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1635843134686347858L;

	public MyMenuBar() {
		super();
		
		// Glavni meni
		JMenu fileMenu = new JMenu(MainFrame.getInstance().getResourceBundle().getString("file"));
		fileMenu.setMnemonic(KeyEvent.VK_F);
		JMenu editMenu = new JMenu(MainFrame.getInstance().getResourceBundle().getString("edit"));
		editMenu.setMnemonic(KeyEvent.VK_E);
		JMenu helpMenu = new JMenu(MainFrame.getInstance().getResourceBundle().getString("help"));
		helpMenu.setMnemonic(KeyEvent.VK_H);
		JMenu languageMenu = new JMenu(MainFrame.getInstance().getResourceBundle().getString("language"));
		
		// Ikonice
		Icon addIcon = ResizeIcon.resizeIcon(new ImageIcon("images" + File.separator + "addButton.png"), 14, 14);
		Icon editIcon = ResizeIcon.resizeIcon(new ImageIcon("images" + File.separator + "editButton.png"), 14, 14);
		Icon deleteIcon = ResizeIcon.resizeIcon(new ImageIcon("images" + File.separator + "deleteButton.png"), 14, 14);
		Icon closeIcon = ResizeIcon.resizeIcon(new ImageIcon("images" + File.separator + "closeButton.png"), 14, 14);
		Icon saveIcon = ResizeIcon.resizeIcon(new ImageIcon("images" + File.separator + "saveButton.png"), 14, 14);
		Icon openIcon = ResizeIcon.resizeIcon(new ImageIcon("images" + File.separator + "openButton.png"), 14, 14);
		Icon helpIcon = ResizeIcon.resizeIcon(new ImageIcon("images" + File.separator + "helpButton.png"), 14, 14);
		Icon aboutIcon = ResizeIcon.resizeIcon(new ImageIcon("images" + File.separator + "aboutButton.png"), 14, 14);
		Icon studentIcon = ResizeIcon.resizeIcon(new ImageIcon("images" + File.separator + "studentIcon.png"), 14, 14);
		Icon professorIcon = ResizeIcon.resizeIcon(new ImageIcon("images" + File.separator + "professorIcon.png"), 14, 14);
		Icon subjectIcon = ResizeIcon.resizeIcon(new ImageIcon("images" + File.separator + "subjectIcon.png"), 14, 14);
		Icon departmentIcon = ResizeIcon.resizeIcon(new ImageIcon("images" + File.separator + "departmentIcon.png"), 14, 14);
		Icon rsFlagIcon = ResizeIcon.resizeIcon(new ImageIcon("images" + File.separator + "rsFlag.png"), 14, 14);
		Icon usFlagIcon = ResizeIcon.resizeIcon(new ImageIcon("images" + File.separator + "usFlag.png"), 14, 14);
		
		
		// File meni
		JMenuItem newItem = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("new"), addIcon);
		newItem.setMnemonic(KeyEvent.VK_N);
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		JMenuItem saveItem = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("save"), saveIcon);
		saveItem.setMnemonic(KeyEvent.VK_S);
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		JMenu openMenu = new JMenu(MainFrame.getInstance().getResourceBundle().getString("open"));
		openMenu.setIcon(openIcon);
		openMenu.setMnemonic(KeyEvent.VK_O);
		
		JMenuItem students = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("students"), studentIcon);
		students.setMnemonic(KeyEvent.VK_S);
		students.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.SHIFT_MASK));
		students.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((MainTabbedPane) MainFrame.getInstance().getContentPane().getComponent(2)).setSelectedIndex(0);
				
			}
		});
		JMenuItem subjects = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("subjects"), subjectIcon);
		subjects.setMnemonic(KeyEvent.VK_P);
		subjects.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.SHIFT_MASK));
		subjects.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((MainTabbedPane) MainFrame.getInstance().getContentPane().getComponent(2)).setSelectedIndex(2);
				
			}
		});
		JMenuItem professors = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("professors"), professorIcon);
		professors.setMnemonic(KeyEvent.VK_F);
		professors.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.SHIFT_MASK));
		professors.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((MainTabbedPane) MainFrame.getInstance().getContentPane().getComponent(2)).setSelectedIndex(1);
				
			}
		});
		JMenuItem departments = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("departments"), departmentIcon);
		departments.setMnemonic(KeyEvent.VK_K);
		departments.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.SHIFT_MASK));
		departments.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DepartmentsMainDialog departmentsMainDialog = new DepartmentsMainDialog();
				departmentsMainDialog.setVisible(true);
			}
		});
		openMenu.add(students);
		openMenu.add(subjects);
		openMenu.add(professors);
		openMenu.add(departments);
		
		JMenuItem closeItem = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("close"), closeIcon);
		closeItem.setMnemonic(KeyEvent.VK_C);
		closeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		closeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int userInput = JOptionPane.showConfirmDialog(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("saveChangesOnExit"),
						 MainFrame.getInstance().getResourceBundle().getString("saveChangesOnExitTitle"), JOptionPane.YES_NO_OPTION);
				if (userInput == JOptionPane.YES_OPTION) {
					WriterReader.getInstance().SaveData();
					MainFrame.getInstance().dispose();
					}
				else if(userInput==JOptionPane.NO_OPTION) {
					MainFrame.getInstance().dispose();
					System.exit(0);
				}
			}
		});
		
		newItem.addActionListener(new AddEntityListener());
		
		
		saveItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WriterReader.getInstance().SaveData();	
			}
		});
		
		
		fileMenu.add(newItem);
		fileMenu.addSeparator();
		fileMenu.add(saveItem);
		fileMenu.addSeparator();
		fileMenu.add(openMenu);
		fileMenu.add(closeItem);
		
		// Edit meni
		JMenuItem editItem = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("edit"), editIcon);
		editItem.setMnemonic(KeyEvent.VK_E);
		editItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		JMenuItem deleteItem = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("delete"), deleteIcon);
		deleteItem.setMnemonic(KeyEvent.VK_D);
		deleteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		editItem.addActionListener(new EditEntityListener());
		deleteItem.addActionListener(new DeleteEntityListener());
		editMenu.add(editItem);
		editMenu.addSeparator();
		editMenu.add(deleteItem);
		
		// Help meni
		JMenuItem helpItem = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("help"), helpIcon);
		helpItem.setMnemonic(KeyEvent.VK_H);
		helpItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		JMenuItem aboutItem = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("about"), aboutIcon);
		aboutItem.setMnemonic(KeyEvent.VK_A);
		aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		helpMenu.add(helpItem);
		helpMenu.addSeparator();
		helpMenu.add(aboutItem);

		// Language meni
		JCheckBoxMenuItem languageSerbianItem = new JCheckBoxMenuItem(MainFrame.getInstance().getResourceBundle().getString("serbian"), rsFlagIcon);
		JCheckBoxMenuItem languageEnglishItem = new JCheckBoxMenuItem(MainFrame.getInstance().getResourceBundle().getString("english"), usFlagIcon);
		
		languageSerbianItem.setSelected(true);
		
		languageEnglishItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("en", "US"));
				MainFrame.getInstance().changeLanguage();
				languageSerbianItem.setSelected(false);
			}
		});
		
		languageSerbianItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("sr", "RS"));
				MainFrame.getInstance().changeLanguage();
				languageEnglishItem.setSelected(false);
			}
		});

		languageMenu.add(languageSerbianItem);
		languageMenu.add(languageEnglishItem);
		
		// Dodavanje na meni bar
		this.add(fileMenu);
		this.add(editMenu);
		this.add(helpMenu);
		this.add(languageMenu);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
