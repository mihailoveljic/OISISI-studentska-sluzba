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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;


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
				helpTextArea = new JTextArea("\t\t\t NAČIN KORIŠĆENJA APLIKACIJE \n\n" + "TABELA STUDENATA\n"
						+ "1.Dodavanje studenta je moguće pomoću dugmeta u toolbar-u ili preko File -> New ukoliko je otvoren tab Studenti\n"
						+ "Validacija unosa:\n" + "Datum je u formatu - dd.mm.yyyy.\n"
						+ "Broj telefona može sadržati bilo koju cifru i znakove / i -.\n"
						+ "Indeks je u formatu XX(X)00(0)/0000 (prva dva velika slova, maksimalno 3) i mora biti jedinstven.\n"
						+ "Email – bilo_šta@bilo_šta.\n"
						+ "Sva polja u dialogu moraju biti popunjena da bi mogli da dodate studenta\n"
						+"2.Izmena studenta je moguća pomoću dugmeta u toolbar-u ili preko File->Edit\n"
						+"Validacija unosa je ista kao pri dodavanju studenta, dok se broj indeksa studenta"
						+ " ne može menjati.\n"
						+ "Sva polja u dialogu moraju biti popunjena da bi mogli da izmenite studenta\n"
						+"Takođe, u okviru dijaloga za izmenu studenta postoje tabovi sa položenim i "
						+ "nepoloženim ispitima.\n"
						+"Klikom na prvi otvara se lista položenih ispita sa ocenama za selektovanog studenta,"
						+ "kao i njegov prosek ocena i broj ESPB bodova. Postoji mogućnost \n poništavanja "
						+ "ocene kllikom na dugme i prelaska "
						+ "predmeta u listu nepoloženih. \n Klikom na drugi tab otvara se lista nepoloženih"
						+ " predmeta gde postoji mogućnost dodavanja"
						+ "novih predmeta koje student sluša, brisanje predmeta i upisivanje ocene ukoliko"
						+ " je student položio \ntaj predmet. Tada se otvara"
						+ "manji dijalog i upisuje se ocena i datum kada je položen ispit, a zatim se on "
						+ "prikazuje u listi položenih ispita.\n"
						+"3.Brisanje studenta je moguće pomoću dugmeta u toolbar-u ili preko File->Delete\n"
						+"4.Pretraga studenata je moguća u okviru toolbar-a upisivanjem traženog studenta u"
						+ " obliku <prezime>, "
						+ "<prezime ime> ili <prezime ime indeks> pri čemu se mogu uneti i delovi ovih reči"
						+ " kao i velika i mala slova.\n"
						+"5.Sortiranje studenata je moguće klikom na naziv kolone čiji elementi treba da se "
						+ "sortiraju. Nasumičnim klikovima se menja"
						+ "opadajuće i rastuće sortiranje.\n\n\n"
						
						+ "TABELA PREDMETA\n"
						+ "1.Dodavanje predmeta je moguće pomoću dugmeta u toolbar-u ili preko File -> New "
						+ "ukoliko je otvoren tab Predmeti\n"
						+ "Validacija unosa:\n" + "Šifra se sastoji od malih ili velikih slova i brojeva i "
								+ "mora biti jedinstvena.\n"
						+ "Naziv može sadržati bilo koja slova.\n"
						+ "ESPB bodovi se sastoje isključivo od brojeva.\n"
						+ "Klikom na dugme + moguće je dodati profesora na predmet ukoliko on nema profesora."
						+ " Tada se otvara lista svih predavača"
						+ "i mi možemo da izaberemo jednog profesora koji će konačno biti dodat na \npredmet"
						+ " klikom na dugme 'potvrdi'. Zatim se"
						+ "u listu predmeta koje taj profesor predaje, dodaje i trenutno selektovan predmet. "
						+ "Po istom principu radi uklanjanje profesora"
						+ "sa predmeta ukoliko je on postojao pre toga.\n"
						+ "Sva polja u dialogu moraju biti popunjena da bi mogli da dodate predmet.\n"
						+"2.Izmena predmeta je moguća pomoću dugmeta u toolbar-u ili preko File->Edit\n"
						+"Validacija unosa je ista kao pri dodavanju predmeta, dok se šifra predmeta ne može "
						+ "menjati.\n"
						+ "Sva polja u dialogu moraju biti popunjena da bi mogli da izmenite predmet\n"
						+"3.Brisanje predmeta je moguće pomoću dugmeta u toolbar-u ili preko File->Delete\n"
						+ "Ukoliko se neki predmet obriše iz baze predmeta, on je takođe uklonjen iz položenih/"
						+ "nepoloženih ispita studenta"
						+ ",kao i iz liste predmeta koje profesor predaje.\n"
						+"4.Pretraga predmeta je moguća u okviru toolbar-a upisivanjem traženog predmeta u "
						+ "obliku <naziv>.\n"
						+"5.Sortiranje predmeta je moguće klikom na naziv kolone čiji elementi treba da se sortiraju."
						+ " Nasumičnim klikovima se menja"
						+ "opadajuće i rastuće sortiranje.\n\n\n"
						
						
						+ "TABELA PROFESORA\n"
						+ "1.Dodavanja profesora na predmet moguće je pomoću dugmeta u toolbar-u ili preko File-> New\n"
						+ " ukoliko je otvoren tab Profesori"
						+ "Validacija unosa:\n"
						+"Broj lične karte ima 9 cifara i mora biti jedinstven.\n"
						+ "Datum u formatu dd.mm.yyyy.\n"
						+"2.Izmena profesora je moguća pomoću dugmeta u toolbar-u ili preko File->Edit\n"
						+"Validacija unosa je ista kao pri dodavanju profesora, dok se broj lične karte ne može"
						+ " menjati.\n"
						+ "Sva polja u dialogu moraju biti popunjena da bi mogli da izmenite studenta\n"
						+ "U okviru ovog dijaloga postoji tab Predmeti gde se nalazi spisak svih predmeta koje "
						+ "profesor predaje. Klikom na dugme 'dodaj predmet'"
						+ "moguće je dodati predmet profesoru i tada se i u bazi predmeta dodaje \nselektovani profesor."
						+ " Po istom principu može se ukloniti predmet"
						+ "sa profesora i u bazi predmeta ukloniti selektovani profesor."
						+ "Sva polja u dialogu moraju biti popunjena da bi mogli da dodate profesora\n"
						+"3.Brisanje profesora je moguće pomoću dugmeta u toolbar-u ili preko File->Delete\n"
						+ "Na taj način briše se i u bazi predmeta, odnosno predmeti koje je obrisani profesor "
						+ "predavao ostaju bez predavača.\n"
						+"4.Pretraga profesora je moguća u okviru toolbar-a upisivanjem traženog studenta u obliku <prezime>, "
						+ "<prezime ime> pri čemu se mogu uneti i delovi ovih reči kao i velika i mala slova.\n"
						+"5.Sortiranje profesora je moguće klikom na naziv kolone čiji elementi treba da se sortiraju. "
						+ "Nasumičnim klikovima se menja"
						+ "opadajuće i rastuće sortiranje.\n\n\n"
						
						+"MENI BAR\n"
						+ "U okviru meni bara klikom na File otvara se padajući meni koji sadrži New i Close."
						+ "Pomoću New se vrši dodavanje entiteta po principu otvorenog taba koji je gore naveden, "
						+ "dok se klikom na Close"
						+ "zatvara aplikacija što je moguće \nučiniti i klikom na X. Klikom na Edit u okviru meni bara"
						+ " otvara se padajući meni"
						+ "koji sadrži Edit i Delete. Pomoću Edit se otvara dijalog za izmenu entiteta, a klikom na "
						+ "Delete dijalog za brisanje"
						+ "entiteta. Ukoliko kliknete Help moći \nćete da izaberete \nAbout gde se dobijaju informacije o"
						+ " samoj aplikaciji i njenim autorima, dok"
						+ "se klikom na Help dobija detaljan opis korišćenja aplikacije.\n\n\n"
						
						+"STATUS BAR\n"
						+ "U status baru prikazano je trenutno vreme i datum.\n\n\n"
						+ "TOOLBAR\n"
						+ "tToolbar sadrži dugme za dodavanje, izmenu i brisanje entiteta,\n"
						+ " kao i polje za pretragu i dugme za pokretanje pretrage.\n\n\n"
						
						+ "Prečice:\n" + "ctrl + N – New Student/Profesor u zavisnosti od otvorenog taba\n" 
					 	+ "ctrl + H – Help\n"
						+ "ctrl + A - About App\n\n" 
					 	+"Mnemonici:\n"
						+"alt + F - File\n" 
					 	+"alt + E - Edit\n"
						+"alt + H - Help\n" + "", 20, 70);
				
				
				scrollPane = new JScrollPane(helpTextArea);
				JOptionPane.showMessageDialog(null, scrollPane);
				
			}
		});
		
		helpMenu.add(helpItem);
		helpMenu.addSeparator();
		
		
		aboutItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				aboutTextArea = new JTextArea("Java Aplikacija Studentska služba omogućava rad sa studentima, profesorima i predmetima.\\n\\n\"\r\n"
						+ "						+ \"Kratak opis korišćenja aplikacije:\\n\"\r\n"
						+ "						+ \"1.Tabela student ima mogućnost dodavanja, brisanja, izmene, prikaza predmeta koje sluša student i pretragu studenata.\\n\"\r\n"
						+ "						+ \"2.Tabela predmet ima mogućnost dodavanja, brisanja, izmene, pretrage predmeta, dodavanja studenta na predmet, brisanja studenta sa predmeta,\\n\"\r\n"
						+ "						+ \" dodavanja profesora na predmet, brisanja profesora sa predmeta, prikaza liste profesora i studenata na predmetu.\\n\"\r\n"
						+ "						+ \"3.Tabela profesor ima mogćnost dodavanja, brisanja, izmene profesora i prikaza predmeta na kojima predaje profesor.\\n\\n\"\r\n"
						+ "						+\"Student 1:\\n\"\r\n"
						+ "						+\"Anja Pešić, rođena 17.8.1999. u Novom Sadu, student Računarstva i automatike, indeks RA36-2018.\\n\"\r\n"
						+ "						+\"Student 2:\\n\"\r\n"
						+ "						+\"Tanja Cupać, rođena 24.1.2000. u Somboru, student Računarstva i automatike, indeks RA40-2018.\\n");
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
