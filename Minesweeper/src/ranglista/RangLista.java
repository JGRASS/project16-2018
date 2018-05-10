package ranglista;

import java.io.Serializable;


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
	 * Metoda koja vraca rang listu
	 * 
	 * @return rangLista lista rezultata
	 */
	public Rezultat[] vratiRangListu() {
		return rangLista;
	}

}
