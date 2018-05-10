package tabla.sistemskeoperacije;

import tabla.Tabla;

/**
 * Sistemska operacija koja azurira stanje tabla u zavisnosti od otvorenog polja
 * i odredjuje stanje igre.
 * 
 * @author Milos Brkic
 * @version 1.0
 */
public class SOPritisnutoPolje {

	/**
	 * Metoda koja izvrsava sistemsku operaciju.
	 * 
	 * @param x
	 *            Koordinata X pritisnutog polja.
	 * @param y
	 *            Koordinata Y pritisnutog polja.
	 * @param tabla
	 *            Tabla nad kojom se vrse izmene.
	 * @return 2 ako su sva polja osim mina otvorena, 1 ako se na otvorenom
	 *         polju nalazi mina, 0 u ostalim slucajevima.
	 */
	public static int izvrsi(int x, int y, Tabla tabla) {

		if (tabla.polja[x][y].isMina())
			return 1;// poraz

		if (tabla.polja[x][y].getbrMinaOkolo() == 0)
			lancanoOtvaranje(x, y, tabla);
		else
			tabla.brOtvorenih++;

		tabla.polja[x][y].setOtvoreno(true);

		if (tabla.brPreostalih <= tabla.brOtvorenih)
			return 2;// pobeda

		return 0;// igra se nastavlja
	}

	/**
	 * Pomocna privatna metoda za rekurzivno otvaranje polja koja se granice i
	 * nemaju mine u okolini.
	 * 
	 * @param x
	 *            Koordinata X polja koje se otvara.
	 * @param y
	 *            Koordinata X polja koje se otvara.
	 * @param tabla
	 *            Tabla nad kojom se vrse izmene.
	 */
	private static void lancanoOtvaranje(int x, int y, Tabla tabla) {
		if (tabla.polja[x][y].isMina() || tabla.polja[x][y].isOtvoreno())
			return;

		if (tabla.polja[x][y].isOtvoreno() == false) {
			tabla.polja[x][y].setOtvoreno(true);
			tabla.brOtvorenih++;
		}

		if (tabla.polja[x][y].getbrMinaOkolo() == 0) {
			if (x > 0 && y > 0)
				lancanoOtvaranje(x - 1, y - 1, tabla);

			if (x > 0)
				lancanoOtvaranje(x - 1, y, tabla);

			if (y > 0)
				lancanoOtvaranje(x, y - 1, tabla);

			if (x > 0 && y < tabla.getY() - 1)
				lancanoOtvaranje(x - 1, y + 1, tabla);

			if (y < tabla.getY() - 1)
				lancanoOtvaranje(x, y + 1, tabla);

			if (x < tabla.getX() - 1 && y > 0)
				lancanoOtvaranje(x + 1, y - 1, tabla);

			if (x < tabla.getX() - 1)
				lancanoOtvaranje(x + 1, y, tabla);

			if (x < tabla.getX() - 1 && y < tabla.getY() - 1)
				lancanoOtvaranje(x + 1, y + 1, tabla);

		}

	}

}
