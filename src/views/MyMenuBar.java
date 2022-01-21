package views;

import methods.ResizeIcon;
import methods.WriterReader;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;


public class MyMenuBar extends JMenuBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1635843134686347858L;
	
	JScrollPane scrollPane;
	JTextArea helpTextArea;
	JTextArea aboutTextArea;

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
		
		helpItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				helpTextArea = new JTextArea("				UPUTSTVO ZA KOIRŠĆENJE APLIKACIJE\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "*TABELA STUDENATA\r\n"
						+ "I)\r\n"
						+ "Dodavanje studenta se vrši pomoću dugmeta u toolbar-u, takođe je moguće i preko: File -> New pod uslovom da je tab studenti otvoren.\r\n"
						+ "Provera ispravnosti unetih podataka:\r\n"
						+ "	-Ispravan format datuma: dan.mesec.godina.\r\n"
						+ "	-broj telefona nema ograničenje\r\n"
						+ "	-Ispravan format indeksa: (X)X (YY)Y/XXXX - npr. RA 31/2019.\r\n"
						+ "	-Indeks mora biti jedinstven\r\n"
						+ "	-Email mora sadržati \"@\".\r\n"
						+ "	-Sva polja moraju biti popunjena da bi dodavanje bilo moguće.\r\n"
						+ "II)\r\n"
						+ "Izmena studenta se vrši pomoću dugmeta  u toolbar-u, takođe je moguće i preko: File -> Edit -> Edit pod uslovom da je tab studenti otvoren.\r\n"
						+ "Student prethodno mora biti selektovan u tabeli kako bi izmena bila moguća.\r\n"
						+ "Provera ispravnosti unetih podataka je ista kao za unos novog studenta, polje za broj indeksa se ne može menjati.\r\n"
						+ "U okviru dijaloga za izmenu studenata, nalaze se tri taba, jedan sa informacija, drugi sa ispitima koje je student položio, i treći sa ispitima koje student nije položio.\r\n"
						+ "Prilikom otvaranja dijaloga za izmenu studenta otvara se prvi tab u okviru kog se vrši izmena.\r\n"
						+ "Prelaskom na drugi tab, imamo informacije o predmetima koje je student položio(Broj ESPB bodova koliko predmet nosi, ocena, datum polaganja...).\r\n"
						+ "U okviru ovog taba postoji mogućnost poništavanja ocene. Ako se ocena poništi, predmet se prebacuje u listu nepoloženih predmeta za zadatog studenta.\r\n"
						+ "Prelaskom na treći tab, imamo informacije o predmetima koje student nije položio(Broj ESPB bodova koliko predmet nosi, godina studija na kojoj se predmet izvodi, semestar u kom se predmet izvodi...).\r\n"
						+ "U okviru ovog taba postoji mogućnost dodavanja nove ocene, brisanje ocene, i postoji opcija \"polaganje\" koja nam omogućava da prebacimo ocenu iz liste nepoloženih u listu položenih ukoliko je student položio predmet.\r\n"
						+ "III)\r\n"
						+ "Brisanje studenta se vrši pomoću dugmeta u toolbar-u, takođe je moguće i preko: File -> Edit -> Delete pod uslovom da je tab studenti otvoren.\r\n"
						+ "Student kog želite da uklonite iz tabele takođe mora biti prethodno selektovan.\r\n"
						+ "\r\n"
						+ "*TABELA PROFESORA\r\n"
						+ "I)\r\n"
						+ "Dodavanje profesora se vrši pomoću dugmeta u toolbar-u, takođe je moguće i preko: File -> New pod uslovom da je tab profesori otvoren.\r\n"
						+ "Provera ispravnosti unetih podataka:\r\n"
						+ "	-Ispravan format datuma: dan.mesec.godina.\r\n"
						+ "	-broj telefona nema ograničenje\r\n"
						+ "	-Email mora sadržati \"@\".\r\n"
						+ "	-Broj lične karte mora biti jedinstven\r\n"
						+ "	-Ostala polja nemaju specijalnih ograničenja\r\n"
						+ "	-Sva polja moraju biti popunjena da bi dodavanje bilo moguće.\r\n"
						+ "II)\r\n"
						+ "Izmena profesora se vrši pomoću dugmeta  u toolbar-u, takođe je moguće i preko: File -> Edit -> Edit pod uslovom da je tab profesori otvoren.\r\n"
						+ "Profesor prethodno mora biti selektovan u tabeli kako bi izmena bila moguća.\r\n"
						+ "Provera ispravnosti unetih podataka je ista kao za unos novog profesora, polje za broj lične karte se ne može menjati.\r\n"
						+ "U okviru dijaloga za izmenu profesora, nalaze se dva taba, jedan sa informacija, drugi sa predmetima koje profesor predaje.\r\n"
						+ "Prilikom otvaranja dijaloga za izmenu profesora otvara se prvi tab u okviru kog se vrši izmena.\r\n"
						+ "Prelaskom na drugi tab, imamo informacije o predmetima koje profesor predaje(Broj ESPB bodova koliko predmet nosi, godina studija na kojoj se predmet izvodi, semestar u kom se predmet izvodi...).\r\n"
						+ "U okviru ovog taba možemo profesoru da dodamo novi predmet ili da uklonimo postojeći.\r\n"
						+ "III)\r\n"
						+ "Brisanje profesora se vrši pomoću dugmeta u toolbar-u, takođe je moguće i preko: File -> Edit -> Delete pod uslovom da je tab profesori otvoren.\r\n"
						+ "Profesor kog želite da uklonite iz tabele takođe mora biti prethodno selektovan.\r\n"
						+ "\r\n"
						+ "*TABELA PREDMET\r\n"
						+ "I)\r\n"
						+ "Dodavanje predmeta se vrši pomoću dugmeta u toolbar-u, takođe je moguće i preko: File -> New pod uslovom da je tab predmeti otvoren.\r\n"
						+ "Provera ispravnosti unetih podataka:\r\n"
						+ "	-Šifra predmeta mora biti u formatu: string+int - npr. p1.\r\n"
						+ "	-Ostala polja nemaju specijalnih ograničenja\r\n"
						+ "Prilikom dodavanja predmeta, imamo opciju da predmetu \"dodamo\" profesora(svakom predmetu dodaćemo koji profesor ga predaje), a profesor može ostati i nepopunjen(u slučaju da niko trenutno ne predaje predmet).\r\n"
						+ "II)\r\n"
						+ "Izmena predmeta se vrši pomoću dugmeta  u toolbar-u, takođe je moguće i preko: File -> Edit -> Edit pod uslovom da je tab predmeti otvoren.\r\n"
						+ "Predmet prethodno mora biti selektovan u tabeli kako bi izmena bila moguća.\r\n"
						+ "Dijalog za izmenu predmeta je potpuno isti kao dijalog za dodavanje predmeta samo je popunjen sa akutelnim podacima iz tabele za označeni predmet.\r\n"
						+ "III)\r\n"
						+ "Brisanje predmeta se vrši pomoću dugmeta u toolbar-u, takođe je moguće i preko: File -> Edit -> Delete pod uslovom da je tab predmeti otvoren.\r\n"
						+ "Predmet kog želite da uklonite iz tabele takođe mora biti prethodno selektovan.\r\n"
						+ "\r\n"
						+ "*TABELA KATEDRE\r\n"
						+ "Tabeli katedre pristupamo pomoći FILE -> OPEN -> KATEDRE ili preko mnemonika CTRL + K.\r\n"
						+ "U ovoj tabeli imamo informacije o rukovodiocima katedri. Moguće je postaviti nove rukovodioce. Lista katedri se ne može menjati.\r\n"
						+ "\r\n"
						+ "*SORTIRANJE\r\n"
						+ "Sortiranje je moguće izvršiti na osnovu bilo koje kolone. Klikom na naziv odgovarajuće kolone, tabela se sortira po toj koloni.\r\n"
						+ "\r\n"
						+ "*PRETRAGA\r\n"
						+ "Prilikom pretrage, pretražuje se tabela odgovarajućeg otvorenog taba.\r\n"
						+ "U koliko je otvoren tab:\r\n"
						+ "1)Studenti\r\n"
						+ "Pretraga se vrši u formatu: \"prezime[,ime,broj_indeksa]\"!\r\n"
						+ "2)Profesori\r\n"
						+ "Pretraga se vrši u formatu: \"prezime[\" \"ime]\"!\r\n"
						+ "3)Predmeti\r\n"
						+ "Pretraga se vrši u formatu: \"naziv[,sifra]\"!\r\n"
						+ "gde [] označavaju opciono navođenje.\r\n"
						+ "\r\n"
						+ "*LOKALIZACIJA(JEZIK)\r\n"
						+ "U okviru Meni bara odabirom opcije \"JEZIK\" možemo odabrati ponuđene jezike.\r\n"
						+ "Podržava se srpski i engleski jezik.\r\n"
						+ "\r\n"
						+ "*PREČICE\r\n"
						+ "CTRL + N - otvara novi prozor za dodavanje novog(studenta, predmeta, profesora) u zavisnosti koji je tab otvoren.\r\n"
						+ "CTRL + S - sačuvava izmene\r\n"
						+ "CTRL + C - zatvaranje programa\r\n"
						+ "CTRL + E - otvara novi prozor za izmenu (studenta, predmeta, profesora) u zavisnosti koji je tab otvoren.\r\n"
						+ "CTRL + D - brisanje (studenta, predmeta, profesora) u zavisnoti koji je tab otvoren.\r\n"
						+ "CTRL + H - otvaranje ovog prozora(HELP).\r\n"
						+ "CTRL + A - otvaranje \"about\" prozora.\r\n"
						+ "CTRL + K - otvaranje tabela katedri.", 20, 70);
				
				helpTextArea.setEditable(false);
				helpTextArea.setBorder(BorderFactory.createEmptyBorder(10,20,10,10));
				scrollPane = new JScrollPane(helpTextArea);
				JFrame jFrame = new JFrame();
				Toolkit kit = Toolkit.getDefaultToolkit();
				Dimension d = kit.getScreenSize();
				int width = d.width;
				int height = d.height;

				jFrame.setSize(width*2/3, height*2/3);
				jFrame.setLocationRelativeTo(null);
				jFrame.setTitle(MainFrame.getInstance().getResourceBundle().getString("help"));
				jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				jFrame.add(scrollPane);
				jFrame.setVisible(true);
				
				
			}
		});
		
		helpMenu.add(helpItem);
		helpMenu.addSeparator();
		
		
		aboutItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				aboutTextArea = new JTextArea("\t O APLIKACIJI\n"
						+ "Aplikacija koja simulira rad studentske službe.\n"
						+ "Za više informacija pogledati prozor 'HELP'.\n\n\n"
						+ "Verzija: 1.0\n\n\n"
						+ "Autori:\n"
						+ "   Miloš Zeljko RA 24/2019\n"
						+ "   Mihailo Veljić RA 31/2019");
				scrollPane = new JScrollPane(aboutTextArea);
				JOptionPane.showMessageDialog(null, scrollPane);
				
			}
		});
		
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
