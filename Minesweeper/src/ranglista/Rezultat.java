package ranglista;

import java.io.Serializable;

/**
 * Klasa koja predstavlja rezultat koji igrac ostvari igrajuci Minesweeper
 * 
 * @author Vanja Vlahovic
 * @version 1.0 *
 */
public class Rezultat implements Serializable {

	/**
	 * Serijski broj rezultata;
	 */
	private static final long serialVersionUID = 6756762953346763169L;
	/**
	 * Vreme za koje je igrac ostvario pobedu
	 */
	private int vreme;
	/**
	 * Tip igre koju je igrac igrao (Begginer, Intermediate ili Expert)
	 */
	private String tipIgre;
	/**
	 * Ime igraca
	 */
	private String ime;
	/**
	 * Prezime igraca
	 */
	private String prezime;

	/**
	 * Vraca vreme za koje je igrac pobedio (broj sekundi izrazene kao int
	 * vrednost)
	 * 
	 * @return vreme kao int vrednost
	 */
	public int getVreme() {
		return vreme;
	}

	/**
	 * Postavlja vreme za koje je igrac pobedio (broj sekundi izrazene kao int
	 * vrednost)
	 * 
	 * @param vreme
	 *            kao int vrednost
	 */
	public void setVreme(int vreme) {
		this.vreme = vreme;
	}

	/**
	 * Vraca tip igre koju je igrac igrao kada je ostvario taj rezultat
	 * 
	 * @return tip igre kao String vrednost
	 */
	public String getTipIgre() {
		return tipIgre;
	}

	/**
	 * Postavlja tip igre koju je igrac igrao kada je ostvario taj rezultat
	 * 
	 * @param tipIgre
	 *            kao String vrednost
	 */
	public void setTipIgre(String tipIgre) {
		this.tipIgre = tipIgre;
	}

	/**
	 * Vraca ime igraca
	 * 
	 * @return ime kao String
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Postavlja ime igraca
	 * 
	 * @param ime
	 *            kao String
	 * @throws java.lang.RuntimeException
	 *             ako se unese prazan string umesto imena ili null vrednost
	 */
	public void setIme(String ime) {
		if (ime == null || ime.isEmpty())
			throw new RuntimeException("String ime ne sme biti prazan string ili null");
		this.ime = ime;
	}

	/**
	 * Vraca prezime igraca
	 * 
	 * @return prezime kao String vrednost
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Postavlja prezime igraca
	 * 
	 * @param prezime
	 *            kao String
	 * @throws java.lang.RuntimeException
	 *             ako se unese prazan string umesto prezimena ili null vrednost
	 */
	public void setPrezime(String prezime) {
		if (prezime == null || prezime.isEmpty())
			throw new RuntimeException("String prezime ne sme biti prazan string ili null");
		this.prezime = prezime;
	}

	/**
	 * Vraca sve podatke rezultata kao String vrednost
	 * 
	 * @return rezultat kao String
	 */
	@Override
	public String toString() {
		return "            " + vreme + "        " + tipIgre + "      " + ime + "      " + prezime;
	}

}
