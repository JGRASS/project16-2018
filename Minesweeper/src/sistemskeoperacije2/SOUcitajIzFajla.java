package sistemskeoperacije2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import ranglista.RangLista;

/**
 * Sistemska operacija za uciravanje rang liste iz nekog fajla
 * 
 * @author Vanja Vlahovic
 * @version 1.0
 *
 */
public class SOUcitajIzFajla {
	/**
	 * Metoda koja izvrsava sistemsku operaciju
	 * 
	 * @param putanja
	 *            apsolutna putanja do fajla
	 * @return Rang lista sa rezultatima
	 */
	public static RangLista izvrsi(String putanja) {
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(putanja)));

			return (RangLista) (in.readObject());
		} catch (Exception e) {
			return new RangLista();
		}
	}
}
