package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MyStatusBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4762649533520077076L;

	public MyStatusBar() {
		super();
		JLabel windowNameLabel = new JLabel("Studentska sluzba");
		windowNameLabel.setBorder(new EmptyBorder(4, 4, 4, 4));
		windowNameLabel.setFont(new Font("Serif", Font.BOLD, 16));
		// TODO Make it update continuous during runtime
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm  dd.MM.yyyy.");
		LocalDateTime now = LocalDateTime.now();
		JLabel dateLabel = new JLabel(dtf.format(now));
		dateLabel.setBorder(new EmptyBorder(4, 4, 4, 4));
		dateLabel.setFont(new Font("Serif", Font.BOLD, 16));
		
		this.setLayout(new BorderLayout());
		this.add(windowNameLabel, BorderLayout.WEST);
		this.add(dateLabel, BorderLayout.EAST);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		d.height=40;
		setMaximumSize(d);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	

	

}
	