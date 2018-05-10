package sistemskeoperacije2;

import ranglista.Rezultat;

/**
 * Sistemska operacija koja dodaje rezultat u listu rezultata sortiranu po
 * vremenu u rastucem redosledu
 * 
 * @author Vanja Vlahovic
 * @version 1.0
 */
public class SODodajRezultat {

	/**
	 * Metoda koja izvrsava sistemsku operaciju
	 * 
	 * @param rezultat
	 *            Rezultat koji se unosi
	 * @param rangLista
	 *            lista rezultata
	 * @param brRezultata
	 *            broj rezultata koji se nalazi u listi
	 * @throws java.lang.RuntimeException
	 *             ako rezultat ima null vrednost ili ne ulazi u prvih sto
	 *             rezultata
	 */
	public static void izvrsi(Rezultat rezultat, Rezultat[] rangLista, int brRezultata) {
		if (rezultat == null)
			throw new RuntimeException("Rezultat ne sme biti null");
		if (brRezultata == 100) {
			if (rezultat.getVreme() < rangLista[99].getVreme()) {
				for (int i = 0; i < brRezultata; i++)
					if (rangLista[i].getVreme() > rezultat.getVreme()) {
						for (int k = brRezultata - 1; k > i; k--)
							rangLista[k] = rangLista[k - 1];
						rangLista[i] = rezultat;
						return;
					}
			} else
				throw new RuntimeException("Rezultat ne ulazi u rang listu.");
		}
		if (brRezultata == 0) {
			rangLista[0] = rezultat;
			brRezultata++;
			return;
		}
		if (rezultat.getVreme() < rangLista[brRezultata - 1].getVreme())
			for (int i = 0; i < brRezultata; i++) {
				if (rezultat.getVreme() < rangLista[i].getVreme()) {
					Rezultat pom = rangLista[brRezultata - 1];
					for (int k = brRezultata - 1; k > i; k--)
						rangLista[k] = rangLista[k - 1];
					rangLista[i] = rezultat;
					rangLista[brRezultata] = pom;
					brRezultata++;
					return;
				}

			}
		else {
			rangLista[brRezultata] = rezultat;
			brRezultata++;
		}

	}
}
