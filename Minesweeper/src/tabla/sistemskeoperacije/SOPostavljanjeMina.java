package tabla.sistemskeoperacije;

import java.util.Random;

import tabla.Tabla;

/**
 * Sistemska operacija koja na tabli postavlja mine na nasumicnin pozicijama
 * osim na prvo otvoreno polje.
 * 
 * @author Milos Brkic
 * @version 1.0
 */
public class SOPostavljanjeMina {

	/**
	 * Metoda koja izvrsava sistemsku operaciju.
	 * 
	 * @param dimX
	 *            Dimenzija table X.
	 * @param dimY
	 *            Dimenzija table Y.
	 * @param brMina
	 *            Broj mina koji se postavlja.
	 * @param polja
	 *            Matrica polja na kojoj se postavljaju mine.
	 * @param xp
	 *            Koordinata X prvog otvorenog polja.
	 * @param yp
	 *            Koordinata Y prvog otvorenog polja.
	 */
	public static void izvrsi(Tabla t, int xp, int yp) {
		Random rand = new Random();
		int brPostMina = 0;
		int x, y;
		while (brPostMina < t.brMina) {
			x = rand.nextInt(t.getX());
			y = rand.nextInt(t.getY());
			if (t.polja[x][y].isMina() == false && (x != xp || y != yp)) {
				t.polja[x][y].setMina(true);
				brPostMina++;
			}
		}
	}
}
