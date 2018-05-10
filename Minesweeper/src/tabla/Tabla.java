package tabla;

/**
 * Logicka tabla na kojoj se postavljaju mine i oznacavaju polja.
 * 
 * @author Milos Brkic
 * @version 0.3
 */
public class Tabla {

	/** Matrica polja koja predstavlja tablu. */
	public Polje[][] polja;

	/** Broj otvorenih polja na tabli. */
	public int brOtvorenih;

	/** Broj zatvorenih polja na tabli. */
	public int brPreostalih;

	/** Dimenzija table X. */
	private int dimX;

	/** Dimenzija table Y. */
	private int dimY;

	/** Broj mina koji se nalaze na tabli. */
	public int brMina;

	/**
	 * Konstruktor za tablu.
	 * 
	 * @param dimX
	 *            Dimenzija table X.
	 * @param dimY
	 *            Dimenzija table Y.
	 * @param brMina
	 *            Broj mina koji se nalazi na tabli.
	 */
	public Tabla(int dimX, int dimY, int brMina) {
		this.dimX = dimX;
		this.dimY = dimY;
		this.brMina = brMina;
		brOtvorenih = 0;
		brPreostalih = dimX * dimY - brMina;
		polja = new Polje[dimX][dimY];

		if (brMina > dimX * dimY)
			brMina = dimX * dimY;

		for (int x = 0; x < dimX; x++)
			for (int y = 0; y < dimY; y++)
				polja[x][y] = new Polje();

	}

	/** Vraca dimenziju table X. */
	public int getX() {
		return dimX;
	}

	/** Vraca dimenziju table Y. */
	public int getY() {
		return dimY;
	}
}
