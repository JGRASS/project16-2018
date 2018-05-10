package sistemskeoperacije2;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import ranglista.RangLista;


/**
 * Sistemska operacija koja cuva rang listu u nekom fajlu
 * 
 * @author Vanja Vlahovic
 * @version 1.0
 *
 */
public class SOSacuvajUFajl {
	/**
	 * Metoda koja izvrsava sistemsku operaciju
	 * 
	 * @param putanja
	 *            apsolutna putanja fajla
	 * @param rangLista
	 *            rabg lista rezultata
	 */
	public static void izvrsi(String putanja, RangLista rangLista) {
		try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(putanja)))) {

			out.writeObject(rangLista);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
