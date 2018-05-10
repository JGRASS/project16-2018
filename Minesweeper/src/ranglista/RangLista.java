package ranglista;

import java.io.Serializable;

import sistemskeoperacije2.SODodajRezultat;
import sistemskeoperacije2.SOPrikazListe;

/**
 * Klasa koja predstavlja rang listu
 * 
 * @author Vanja Vlahovic
 * @version 1.0
 *
 */

public class RangLista implements Serializable {

	/**
	 * Serijski broj liste
	 */
	private static final long serialVersionUID = 345435L;
	/**
	 * Rang lista implementirana kao niz koja sadrzi najvise 100 rezultata
	 */
	private Rezultat[] rangLista = new Rezultat[100];
	/**
	 * Broj rezultata koji se nalaze u listi
	 */
	public int brRezultata = 0;

	/**
	 * Metoda koja ubacuje rezultate sortirano u listu
	 * 
	 * @param rezultat
	 *            rezultat koji se unosi u listu
	 */
	public void dodajRezultatSortirano(Rezultat rezultat) {
		SODodajRezultat.izvrsi(rezultat, rangLista, brRezultata);
		if (brRezultata != 100)
			brRezultata++;
	}

	/**
	 * Metoda koja vraca rang listu
	 * 
	 * @return rangLista lista rezultata
	 */
	public Rezultat[] vratiRangListu() {
		return rangLista;
	}

	/**
	 * Metoda koja vraca listu rezultata
	 * 
	 * @return lista rezultata kao String vrednost
	 */
	public String prikaziListu() {
		return SOPrikazListe.izvrsi(rangLista, brRezultata);
	}

}
