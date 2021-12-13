package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import methods.ResizeIcon;

public class MyToolBar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5375224116363442663L;
	
	public MyToolBar()
	{
		super();
		
		int iconSize = 18;
		Icon addIcon = ResizeIcon.resizeIcon(new ImageIcon("images/addButton.png"),iconSize,iconSize);
		Icon editIcon = ResizeIcon.resizeIcon(new ImageIcon("images/editButton.png"),iconSize,iconSize);
		Icon deleteIcon = ResizeIcon.resizeIcon(new ImageIcon("images/deleteButton.png"),iconSize,iconSize);
		Icon searchIcon = ResizeIcon.resizeIcon(new ImageIcon("images/searchButton.png"),iconSize,iconSize);
		
		JButton addButton = new JButton(addIcon);
		JButton editButton = new JButton(editIcon);
		JButton deleteButton = new JButton(deleteIcon);
		JButton searchButton = new JButton(searchIcon);

		addButton.setToolTipText("Add entity");
		editButton.setToolTipText("Edit entity");
		deleteButton.setToolTipText("Delete entity");
		searchButton.setToolTipText("Search entity");
		
		JTextField searchBar = new JTextField(30);
		Dimension d = new Dimension(40, 30);
		searchBar.setMaximumSize(d);
		
		this.add(addButton);
		this.add(editButton);
		this.add(deleteButton);
		this.add(Box.createHorizontalGlue());
		this.add(searchBar);
		this.add(searchButton);
		this.setFloatable(false);
		this.setBorder(BorderFactory.createLineBorder(Color.black));	
	}
	

}
