				UPUTSTVO ZA KORIŠĆENJE APLIKACIJE


# TABELA STUDENATA  

I)  

Dodavanje studenta se vrši pomoću dugmeta u toolbar-u, takođe je moguće i preko: File -> New pod uslovom da je tab studenti otvoren.   
Provera ispravnosti unetih podataka:   
	- Ispravan format datuma: dan.mesec.godina.   
	- broj telefona nema ograničenje    
	- Ispravan format indeksa: (X)X (YY)Y/XXXX - npr. RA 31/2019.   
	- Indeks mora biti jedinstven   
	- Email mora sadržati "@".   
	- Sva polja moraju biti popunjena da bi dodavanje bilo moguće.   

II)  

Izmena studenta se vrši pomoću dugmeta  u toolbar-u, takođe je moguće i preko: File -> Edit -> Edit pod uslovom da je tab studenti otvoren.   
Student prethodno mora biti selektovan u tabeli kako bi izmena bila moguća.   
Provera ispravnosti unetih podataka je ista kao za unos novog studenta, polje za broj indeksa se ne može menjati.   
U okviru dijaloga za izmenu studenata, nalaze se tri taba, jedan sa informacija, drugi sa ispitima koje je student položio, i treći sa ispitima koje student nije položio.  
Prilikom otvaranja dijaloga za izmenu studenta otvara se prvi tab u okviru kog se vrši izmena.   
Prelaskom na drugi tab, imamo informacije o predmetima koje je student položio(Broj ESPB bodova koliko predmet nosi, ocena, datum polaganja...).   
U okviru ovog taba postoji mogućnost poništavanja ocene. Ako se ocena poništi, predmet se prebacuje u listu nepoloženih predmeta za zadatog studenta.   
Prelaskom na treći tab, imamo informacije o predmetima koje student nije položio(Broj ESPB bodova koliko predmet nosi, godina studija na kojoj se predmet izvodi, semestar u kom se predmet izvodi...).   
U okviru ovog taba postoji mogućnost dodavanja nove ocene, brisanje ocene, i postoji opcija "polaganje" koja nam omogućava da prebacimo ocenu iz liste nepoloženih u listu položenih ukoliko je student položio predmet.  

III)  

Brisanje studenta se vrši pomoću dugmeta u toolbar-u, takođe je moguće i preko: File -> Edit -> Delete pod uslovom da je tab studenti otvoren.   
Student kog želite da uklonite iz tabele takođe mora biti prethodno selektovan.   

# TABELA PROFESORA  

 I)  

Dodavanje profesora se vrši pomoću dugmeta u toolbar-u, takođe je moguće i preko: File -> New pod uslovom da je tab profesori otvoren.   
Provera ispravnosti unetih podataka:  
	- Ispravan format datuma: dan.mesec.godina.  
	- broj telefona nema ograničenje  
	- Email mora sadržati "@".  
	- Broj lične karte mora biti jedinstven  
	- Ostala polja nemaju specijalnih ograničenja  
	- Sva polja moraju biti popunjena da bi dodavanje bilo moguće.  

II)

Izmena profesora se vrši pomoću dugmeta  u toolbar-u, takođe je moguće i preko: File -> Edit -> Edit pod uslovom da je tab profesori otvoren.  
Profesor prethodno mora biti selektovan u tabeli kako bi izmena bila moguća.  
Provera ispravnosti unetih podataka je ista kao za unos novog profesora, polje za broj lične karte se ne može menjati.  
U okviru dijaloga za izmenu profesora, nalaze se dva taba, jedan sa informacija, drugi sa predmetima koje profesor predaje.  
Prilikom otvaranja dijaloga za izmenu profesora otvara se prvi tab u okviru kog se vrši izmena.  
Prelaskom na drugi tab, imamo informacije o predmetima koje profesor predaje(Broj ESPB bodova koliko predmet nosi, godina studija na kojoj se predmet izvodi, semestar u kom se predmet izvodi...).  
U okviru ovog taba možemo profesoru da dodamo novi predmet ili da uklonimo postojeći.  

III)  

Brisanje profesora se vrši pomoću dugmeta u toolbar-u, takođe je moguće i preko: File -> Edit -> Delete pod uslovom da je tab profesori otvoren.  
Profesor kog želite da uklonite iz tabele takođe mora biti prethodno selektovan.  

# TABELA PREDMET  

I)

Dodavanje predmeta se vrši pomoću dugmeta u toolbar-u, takođe je moguće i preko: File -> New pod uslovom da je tab predmeti otvoren.  
Provera ispravnosti unetih podataka:  
	- Šifra predmeta mora biti u formatu: string+int - npr. p1.  
	- Ostala polja nemaju specijalnih ograničenja  
Prilikom dodavanja predmeta, imamo opciju da predmetu "dodamo" profesora(svakom predmetu dodaćemo koji profesor ga predaje), a profesor može ostati i nepopunjen(u slučaju da niko trenutno ne predaje predmet).  

II) 

Izmena predmeta se vrši pomoću dugmeta  u toolbar-u, takođe je moguće i preko: File -> Edit -> Edit pod uslovom da je tab predmeti otvoren.  
Predmet prethodno mora biti selektovan u tabeli kako bi izmena bila moguća.   
Dijalog za izmenu predmeta je potpuno isti kao dijalog za dodavanje predmeta samo je popunjen sa akutelnim podacima iz tabele za označeni predmet.   

III)   

Brisanje predmeta se vrši pomoću dugmeta u toolbar-u, takođe je moguće i preko: File -> Edit -> Delete pod uslovom da je tab predmeti otvoren.   
Predmet kog želite da uklonite iz tabele takođe mora biti prethodno selektovan.    

# TABELA KATEDRE   

Tabeli katedre pristupamo pomoći FILE -> OPEN -> KATEDRE ili preko mnemonika CTRL + K.  
U ovoj tabeli imamo informacije o rukovodiocima katedri. Moguće je postaviti nove rukovodioce. Lista katedri se ne može menjati.  

# SORTIRANJE  

Sortiranje je moguće izvršiti na osnovu bilo koje kolone. Klikom na naziv odgovarajuće kolone, tabela se sortira po toj koloni.   

# PRETRAGA   

Prilikom pretrage, pretražuje se tabela odgovarajućeg otvorenog taba.  
U koliko je otvoren tab:  
1)Studenti  
Pretraga se vrši u formatu: "prezime[,ime,broj_indeksa]"!  
2)Profesori  
Pretraga se vrši u formatu: "prezime[" "ime]"!  
3)Predmeti  
Pretraga se vrši u formatu: "naziv[,sifra]"!  
gde [] označavaju opciono navođenje.   

# LOKALIZACIJA(JEZIK)  

U okviru Meni bara odabirom opcije "JEZIK" možemo odabrati ponuđene jezike.  
Podržava se srpski i engleski jezik.  

# PREČICE   

CTRL + N - otvara novi prozor za dodavanje novog(studenta, predmeta, profesora) u zavisnosti koji je tab otvoren.  
CTRL + S - sačuvava izmene   
CTRL + C - zatvaranje programa  
CTRL + E - otvara novi prozor za izmenu (studenta, predmeta, profesora) u zavisnosti koji je tab otvoren.  
CTRL + D - brisanje (studenta, predmeta, profesora) u zavisnoti koji je tab otvoren.  
CTRL + H - otvaranje ovog prozora(HELP).   
CTRL + A - otvaranje "about" prozora.   
CTRL + K - otvaranje tabela katedri.  

