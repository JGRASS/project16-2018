package sistemskeoperacije2;

import ranglista.RangLista;
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
	 * @param lista
	 *            Lista u koju se unosi rezultat
	 * @throws java.lang.RuntimeException
	 *             ako rezultat ima null vrednost ili ne ulazi u prvih sto
	 *             rezultata
	 */
	public static void izvrsi(Rezultat rezultat, RangLista lista) {
		if (rezultat == null)
			throw new RuntimeException("Rezultat ne sme biti null");
		
		Rezultat[] rangLista = lista.vratiRangListu();
		
		if (lista.brRezultata == 100) {
			if (rezultat.getVreme() < rangLista[99].getVreme()) {
				for (int i = 0; i < lista.brRezultata; i++)
					if (rangLista[i].getVreme() > rezultat.getVreme()) {
						for (int k = lista.brRezultata - 1; k > i; k--)
							rangLista[k] = rangLista[k - 1];
						rangLista[i] = rezultat;
						return;
					}
			} else
				throw new RuntimeException("Rezultat ne ulazi u rang listu.");
		}
		if (lista.brRezultata == 0) {
			rangLista[0] = rezultat;
			lista.brRezultata++;
			return;
		}
		if (rezultat.getVreme() < rangLista[lista.brRezultata - 1].getVreme())
			for (int i = 0; i < lista.brRezultata; i++) {
				if (rezultat.getVreme() < rangLista[i].getVreme()) {
					Rezultat pom = rangLista[lista.brRezultata - 1];
					for (int k = lista.brRezultata - 1; k > i; k--)
						rangLista[k] = rangLista[k - 1];
					rangLista[i] = rezultat;
					rangLista[lista.brRezultata] = pom;
					lista.brRezultata++;
					return;
				}

			}
		else {
			rangLista[lista.brRezultata] = rezultat;
			lista.brRezultata++;
		}

	}
}
