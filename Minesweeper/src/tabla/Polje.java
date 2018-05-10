package tabla;

/**
 * Polje na tabli.
 * 
 * @author Milos Brkic
 * @version 1.0
 */
public class Polje {

	/** Da li je polje otvoreno ili zatvoreno. */
	private boolean otvoreno = false;

	/** Da li se na polju nalazi mina. */
	private boolean mina = false;

	/** Broj mina koji se nalazi oko ovog polja sa kojima se polje granici. */
	private int brMinaOkolo = 0;

	/**
	 * Vraca stanje da li je polje otvoreno.
	 * 
	 * @return true ako je polje otvoreno, false ako je zatvoreno.
	 */
	public boolean isOtvoreno() {
		return otvoreno;
	}

	/**
	 * Postavlja stanje polja na otvoreno ili zatvoreno.
	 * 
	 * @param otvoreno
	 *            Stanje koje se unosi.
	 */
	public void setOtvoreno(boolean otvoreno) {
		this.otvoreno = otvoreno;
	}

	/**
	 * Vraca stanje da li je na polju mina.
	 * 
	 * @return true ako je na polju mina, false ako nema mine.
	 */
	public boolean isMina() {
		return mina;
	}

	/**
	 * Postavlja ili skljanja minu sa polja.
	 * 
	 * @param mina
	 *            Stanje koje se unosi.
	 */
	public void setMina(boolean mina) {
		this.mina = mina;
	}

	/**
	 * Vraca broj mina koje se nalaze u okolini.
	 * 
	 * @return brMinaOkolo kao int.
	 */
	public int getbrMinaOkolo() {
		return brMinaOkolo;
	}

	/**
	 * Postavlja broj mina u okolini.
	 * 
	 * @param brMina
	 *            broj mina koji se unosi.
	 * @throws java.lang.RuntimeException
	 *             ako broj mina nije u dozvoljenim granicima (od 0 do 8).
	 */
	public void setbrMinaOkolo(int brMina) throws RuntimeException {
		if (brMina >= 0 && brMina <= 8)
			this.brMinaOkolo = brMina;
		else
			throw new RuntimeException("Broj mora biti od 0 do 8");
	}

}
