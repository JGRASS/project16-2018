package sistemskeoperacije2;

import ranglista.Rezultat;

/**
 * Sistemska operacija koja vraca rang listu kao String vrednost
 * 
 * @author Vanja Vlahovic
 * @version 1.0
 */
public class SOPrikazListe {
	/**
	 * Metoda koja izvrsava sistemsku operaciju.
	 * 
	 * @param rangLista
	 *            lista rezultata
	 * @param brRezultata
	 *            broj rezultata koji se nalaze u listi
	 * @return listu kao String vrednost
	 */
	public static String izvrsi(Rezultat[] rangLista, int brRezultata) {
		if (brRezultata != 0) {
			int k = 1;
			String tekst = "Mesto:  Vreme:   Tip igre:       Ime:          Prezime:\n1.  " + rangLista[0].toString();
			for (int i = 1; i < brRezultata; i++) {
				k++;
				tekst = tekst + "\n" + k + ".  " + rangLista[i].toString();
			}
			return tekst;
		}
		return "Mesto:  Vreme:   Tip igre:       Ime:          Prezime:\n";
	}
}
