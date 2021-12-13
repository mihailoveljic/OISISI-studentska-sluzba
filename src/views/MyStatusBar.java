package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


//https://www.sourcecodester.com/tutorials/java/5668/easy-way-implement-dynamic-clock-java-using-threads.html

public class MyStatusBar extends JPanel implements Runnable {

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
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss  dd.MM.yyyy.");
		//LocalDateTime now = LocalDateTime.now();
		//JLabel dateLabel = new JLabel(dtf.format(now));
		//dateLabel.setBorder(new EmptyBorder(4, 4, 4, 4));
		//dateLabel.setFont(new Font("Serif", Font.BOLD, 16));
		
		
		
		
		this.setLayout(new BorderLayout());
		this.add(windowNameLabel, BorderLayout.WEST);
		//this.add(dateLabel, BorderLayout.EAST);
		this.add(dateLabel, BorderLayout.EAST);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		d.height=40;
		setMaximumSize(d);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.start();
		
	}
	
	
	
	Thread timer=null;
	String dateToDisplay;	//string koji cemo da prikazemo u status baru
	
	int hr;
	Date d;
	JLabel dateLabel=new JLabel();
	int hour;
	int minute;
	int second;
	String amPm="AM"; 

	//dateLabel.setFont(new Font("Anklepants",Font.PLAIN,16)); 
	
	public void start() { 
		 if(timer == null) 
	    { 
	      timer = new Thread(this); 
	      timer.start(); 
	    } 
	} 
	
	
	
	
	public void stop() 
	{ 
	  timer = null; 
	} 
	
	@SuppressWarnings("deprecation")
	public String getFormatedDate(Date d) 
	{ 
	String formatedDate=" "; 
	 hour = d.getHours(); 
	 minute = d.getMinutes(); 
	 second = d.getSeconds(); 
	 amPm=(hour<12)?"AM":"PM"; 
	 hr=(hour>12)?hour-12:hour; 
		 
	formatedDate=formatedDate.concat(padElement(hr, '0')); 
	formatedDate=formatedDate.concat(":"); 
	formatedDate=formatedDate.concat(padElement(minute, '0')); 
	formatedDate=formatedDate.concat(":"); 
	formatedDate=formatedDate.concat(padElement(second, '0')); 
	formatedDate=formatedDate.concat(" "+ amPm); 
	return formatedDate;  
	} 
	 
	private String padElement(int expr, char padChar) 
	{ 
	  String result = ""; 
	  // I'm just padding 2 digit numbers 
	  if (expr < 10) result = result.concat(String.valueOf(padChar)); 
	  result = result.concat(String.valueOf(expr)); 
	  return(result); 
	} 
	 
	
	public void run() { 
		 // Sleep in the timer thread... 
		  while (timer != null) { 
		    try {Thread.sleep(10);} 
		catch (InterruptedException e){} 
		d=new  Date(); 
		dateToDisplay=getFormatedDate(d); 
		 dateLabel.setText(dateToDisplay); 
//		 dateLabel.setBackground(Color.GRAY); 
//			dateLabel.setForeground(Color.MAGENTA); 
//			dateLabel.setFont(new Font("Anklepants",Font.PLAIN,16));
		} 
		timer = null; 
		 
	} 

	

}
	