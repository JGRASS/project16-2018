package gui.kontroler;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import gui.DodajRezultatGUI;
import gui.Minesweeper;
import gui.RezultatiGUI;
import ranglista.Rezultat;
import tabla.SistemskiKontroler;

/**
 * Klasa iz koje se pokrece aplikacija, upravlja GUI prozorima i komunicira sa
 * sistemskim kontrolerom.
 * 
 * @author Milos Brkic
 * @author Vanja Vlahovic
 * @version 1.0
 */
public class GUIKontroler {

	/** Prozor za prikaz i dodavanje rezultata u rang listu. */
	public static DodajRezultatGUI dp;

	/** Prozor koji samo prikayuje rang listu */
	public static RezultatiGUI rp;

	/** Sistemski kontroler za poziv sistemskih operacija. */
	public static SistemskiKontroler sk;

	/** Glavni prozor aplikacije sa GUI tablom. */
	public static Minesweeper ms;

	/** Da li je na radu da se odigrna prvi potez (orvaranje prvog polja). */
	private static boolean prviPotez;

	/** Status igre, da li je pobeda, poraz ili se nastavlja. */
	private static int status;

	/** Broj preostalih mina u odnosu na postavljene zastavice. */
	private static int brojPreostalih = 10;

	/** Broj sekundi na tajmeru. */
	private static int k = 0;

	/** Timer koji odbrojava vreme igranja. */
	private static Timer t;

	/** Main klasa iz koje se pokrece aplikacije. */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					status = 0;
					prviPotez = true;
					sk = new SistemskiKontroler();
					ms = new Minesweeper(10, 10);
					ms.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Tajmer koji odbrojava vreme trajanje igre u sekundama i ispisuje ga na
	 * prozoru Minesweeper.
	 */
	public static void pokreniTimer() {
		t = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ms.lblTimer.setText(String.valueOf(k));
				k++;
			}
		});
		t.start();
	}

	/**
	 * Na pocetku nove igre se restartuje vreme i tajmer se ponovo pokrece.
	 */
	public static void restartovanjeTimera() {
		k = 0;
		t.stop();
		t.start();
	}

	/**
	 * U slucaju poraza otvara se prozor koji obavestava korisnika da je izgubio.
	 */
	public static void prikaziKrajProzor() {
		JOptionPane.showMessageDialog(ms, "Zao nam je. Izgubili ste.", "Minesweeper", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Nakon pobede pojavljuje se dijalog koje Vas pita da li zelite da unesete
	 * rezultat igre. Ako se pritisne YES otvara se DodajRezultatGUI prozor.
	 */
	public static void prikaziPobedaProzor() {
		int opcija = JOptionPane.showConfirmDialog(ms, "Cestitamo! Pobedili ste. Da li zelite da unesete rezultat?",
				"Minesweeper", JOptionPane.YES_NO_OPTION);
		if (opcija == JOptionPane.YES_OPTION)
			prikaziDodajRezultatGUI();

	}

	/**
	 * Pokrece se nova igra u zavisnosti od izabranog tipa igre.
	 */
	public static void novaIgra() {
		status = 0;
		prviPotez = true;
		ms.btnNovaIgra.setIcon(new ImageIcon(Minesweeper.class.getResource("/icons/Smile.png")));
		if (ms.rdbtnmntmBeginner.isSelected()) {
			brojPreostalih = 10;
			sk.novaTabla(10, 10, 10);
			ms.remove(ms.panelMatrica);
			ms.postavljanjePolja(10, 10);
			ms.repaint();
		}
		if (ms.rdbtnmntmIntermediate.isSelected()) {
			brojPreostalih = 40;
			sk.novaTabla(20, 20, 40);
			ms.remove(ms.panelMatrica);
			ms.postavljanjePolja(20, 20);
			ms.repaint();
		}
		if (ms.rdbtnmntmExpert.isSelected()) {
			brojPreostalih = 100;
			sk.novaTabla(40, 20, 100);
			ms.remove(ms.panelMatrica);
			ms.postavljanjePolja(40, 20);
			ms.repaint();
		}
		restartovanjeTimera();
	}

	/**
	 * Nakon svakog otvorenog polja se azurira tabla na logickom novou nakon
	 * cega se proverava stanje igre. Ako je stanje 1 znaci da je otvorena mina
	 * i prikazuje se poruka da je igrac izgubuo. Ako je stanje 2 znaci da se
	 * sve mine pronadjene i prikazuje se poruka da je igrac pobedio. Ako je
	 * stanje 0 igra se nastavlja i azurira se Minesweeper prozor.
	 * 
	 * @param xp
	 *            Koordinata X otvorenog polja.
	 * @param yp
	 *            Koordinata Y otvorenog polja.
	 */
	public static void pritisnutoPolje(int xp, int yp) {
		if (prviPotez) {
			sk.postaviMine(xp, yp);
			prviPotez = false;
		}

		if (status == 0) {
			status = sk.pritisnutoPolje(xp, yp);
		}

		if (status == 1) {// poraz
			ms.btnNovaIgra.setIcon(
					new ImageIcon(Minesweeper.class.getResource("/icons/2000px-Sad_smiley_yellow_simple.svg.png")));
			t.stop();
			prikaziKrajProzor();
		}
		if (status == 2) {// pobeda
			ms.btnNovaIgra.setIcon(new ImageIcon(Minesweeper.class.getResource("/icons/s-l300.jpg")));
			t.stop();
			prikaziPobedaProzor();
		}
		azurirajGUI();
	}

	/**
	 * Metoda kojom se azurira tabla. Proverava se status (da li se igra
	 * nastavlja) Ako se igra nastavlja, prolazi se kroz svako polje na tabli i
	 * ako je otvoreno onemogucava se ponovno otvaranje polja Odredjuje se
	 * koliko mina ima oko tog polja i i u skladu sa brojem postavlja se boja
	 * broja Ako se na tom polju nalazi mina, postavlja se slicica mine
	 */

	private static void azurirajGUI() {

		for (int x = 0; x < sk.getTabla().getX(); x++)
			for (int y = 0; y < sk.getTabla().getY(); y++) {

				if (status == 0 && sk.getTabla().polja[x][y].isOtvoreno()) {
					{

						try {
							ms.matrica[x][y].removeActionListener(ms.matrica[x][y].getActionListeners()[0]);
							ms.matrica[x][y].removeMouseListener(ms.matrica[x][y].getMouseListeners()[0]);
							ms.matrica[x][y].removeMouseListener(ms.matrica[x][y].getMouseListeners()[0]);
						} catch (Exception e) {
						}

						ms.matrica[x][y].setBackground(java.awt.Color.white);
						String t = Integer.toString(sk.getTabla().polja[x][y].getbrMinaOkolo());

						if (sk.getTabla().polja[x][y].getbrMinaOkolo() == 1) {
							ms.matrica[x][y].setText(t);
							ms.matrica[x][y].setForeground(java.awt.Color.BLUE);
						}
						if (sk.getTabla().polja[x][y].getbrMinaOkolo() == 2) {
							ms.matrica[x][y].setText(t);
							ms.matrica[x][y].setForeground(java.awt.Color.GREEN);
						}
						if (sk.getTabla().polja[x][y].getbrMinaOkolo() == 3) {
							ms.matrica[x][y].setText(t);
							ms.matrica[x][y].setForeground(java.awt.Color.RED);
						}
						if (sk.getTabla().polja[x][y].getbrMinaOkolo() == 4) {
							ms.matrica[x][y].setText(t);
							ms.matrica[x][y].setForeground(java.awt.Color.MAGENTA);
						}
						if (sk.getTabla().polja[x][y].getbrMinaOkolo() == 5) {
							ms.matrica[x][y].setText(t);
							ms.matrica[x][y].setForeground(java.awt.Color.ORANGE);
						}
						if (sk.getTabla().polja[x][y].getbrMinaOkolo() == 6) {
							ms.matrica[x][y].setText(t);
							ms.matrica[x][y].setForeground(java.awt.Color.BLACK);
						}
						if (sk.getTabla().polja[x][y].getbrMinaOkolo() == 7) {
							ms.matrica[x][y].setText(t);
							ms.matrica[x][y].setForeground(java.awt.Color.BLACK);
						}
						if (sk.getTabla().polja[x][y].getbrMinaOkolo() == 8) {
							ms.matrica[x][y].setText(t);
							ms.matrica[x][y].setForeground(java.awt.Color.BLACK);
						}
					}

				}

				if (status == 1 && sk.getTabla().polja[x][y].isMina()) {
					ms.matrica[x][y].setIcon(new ImageIcon(Minesweeper.class.getResource("/icons/915944-200.png")));
				}

				if (status == 2 && sk.getTabla().polja[x][y].isMina()) {
					ms.matrica[x][y].setIcon(new ImageIcon(Minesweeper.class.getResource("/icons/915944-200.png")));
				}
			}
	}

	/**
	 * Vraca status igre
	 * 
	 * @return status 1 igrac je izgubio 2 igrac je pobedio 0 nastavlja se sa
	 *         igrom
	 */
	public static int getStatus() {
		return status;
	}

	/**
	 * Vraca broj preostalih mina koje igrac nije obelezio zastavicom
	 * 
	 * @return brojPreostalih mina kao int
	 */
	public static int getBrojPreostalihMina() {
		return brojPreostalih;
	}

	/**
	 * Metoda koja smanjuje broj preostalih mina koje nisu oznacene zastavicom
	 */
	public static void SmanjiBrojPreostalihMina() {
		brojPreostalih--;
	}

	/**
	 * Metoda koja povecava broj preostalih mina koje nisu oznacene zastavicom
	 */
	public static void PovecajBrojPreostalihMina() {
		brojPreostalih++;
	}

	/**
	 * Metoda koja opisuje prozor koji se otvara nakon pobede Taj prozor uzima
	 * podatke iz glavnog prozora kao sto su tip igre i vreme i prikazuje radg
	 * listu
	 */
	public static void prikaziDodajRezultatGUI() {
		String tip = null;
		if (ms.rdbtnmntmBeginner.isSelected())
			tip = "Beginner";
		if (ms.rdbtnmntmIntermediate.isSelected())
			tip = "Intermediate";
		if (ms.rdbtnmntmExpert.isSelected())
			tip = "Expert";
		DodajRezultatGUI prozor = new DodajRezultatGUI(ms.lblTimer.getText(), tip);
		prozor.setLocationRelativeTo(ms);
		prozor.textAreaRangLista.setText(sk.prikaziListu());
		prozor.setVisible(true);
	}

	/**
	 * Metoda koja opisuje prozor koji se otvara kada korisnik samo zeli da vidi
	 * rang listu
	 */
	public static void prikaziRezultatiGUI() {
		RezultatiGUI prozor = new RezultatiGUI();
		prozor.setLocationRelativeTo(ms);
		prozor.textArea.setText(sk.prikaziListu());
		prozor.setVisible(true);
	}

	/**
	 * Metoda za unos rezultata
	 * 
	 * @param vreme
	 *            kao int vrednost, uzima se iz glavnog prozora
	 * @param tip
	 *            tip igre (Begginer, Intermadiate ili Expert), uzima se iz
	 *            glavnog prozora
	 * @param ime
	 *            kao String, upisuje igrac
	 * @param prezime
	 *            kao String, upisuje igrac
	 * @return true ako je reyultat uspesno unet false ako se pojavi greska
	 *         prilikom unosa
	 */
	public static boolean unesiRezultat(int vreme, String tip, String ime, String prezime) {
		try {
			Rezultat rezultat = new Rezultat();
			rezultat.setVreme(vreme);
			rezultat.setTipIgre(tip);
			rezultat.setIme(ime);
			rezultat.setPrezime(prezime);
			sk.dodajRezultatSortirano(rezultat);
			sk.sacuvajUFajl("data/lista");
			return true;

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
			return false;
		}

	}

	/**
	 * Metoda koja vraca listu rezultata
	 * 
	 * @return lista kao String
	 */
	public static String vlatiListuPrikaz() {
		return sk.prikaziListu();
	}

}
