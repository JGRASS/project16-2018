package tabla;

import ranglista.RangLista;
import sistemskeoperacije2.SOSacuvajUFajl;
import sistemskeoperacije2.SOUcitajIzFajla;
import tabla.sistemskeoperacije.SOOznacavanjePolja;
import tabla.sistemskeoperacije.SOPostavljanjeMina;
import tabla.sistemskeoperacije.SOPritisnutoPolje;

/**
 * Sistemski kontroler iz kog se pozivaju sistemske operacije logickog nivoa aplikacije.
 * @author Milos Brkic
 * @version 1.0
 */
public class SistemskiKontroler {
	
	/** Logicka tabla. */
	private Tabla tabla;
	
	/** Rang lista igraca. */
	private RangLista lista;

	/**
	 * Konstruktor koji kreira pocetnu tablu i ucitava rang listu iz fajla ukoliko postoji.
	 */
	public SistemskiKontroler() {
		tabla = new Tabla(10,10,10);
		lista = SOUcitajIzFajla.izvrsi("data/lista");
	}

	/**
	 * Vraca rang listu.
	 * @return lista kao RangLista.
	 */
	public RangLista getRangLista() {
		return lista;
	}

	/**
	 * Postavlja rang listu preko unetog parametra.
	 * @param lista Rang lista koja se unosi.
	 */
	public void setRangLista(RangLista lista) {
		this.lista = lista;
	}

	/**
	 * Vraca tabli.
	 * @return tabla kao Tabla.
	 */
	public Tabla getTabla() {
		return tabla;
	}

	/**
	 * Kreira novi tabli sa unetim parametrima.
	 * @param dimX Dimenzija table X.
	 * @param dimY Dimenzija table Y.
	 * @param brMina Broj mina koji se postavlja na tablu.
	 */
	public void novaTabla(int dimX, int dimY, int brMina) {
		this.tabla = new Tabla(dimX,dimY,brMina);
	}
	
	
	/**
	 * Azurira stanje tabla u zavisnosti od otvorenog polja i odredjuje stanje igre.
	 * @param x Koordinata X pritisnutog polja.
	 * @param y Koordinata Y pritisnutog polja.
	 * @return 2 ako su sva polja osim mina otvorena,
	 * 1 ako se na otvorenom polju nalazi mina,
	 * 0 u ostalim slucajevima.
	 */
	public int  pritisnutoPolje(int x, int y) {
		return SOPritisnutoPolje.izvrsi(x,y,tabla);
	}
	
	
	/**
	 * Nakon prvog poteza postavljaju se mine i oznake.
	 * @param xp Koordinata X prvog protisnutog polja.
	 * @param yp Koordinata Y prvog protisnutog polja.
	 */
	public void postaviMine(int xp,int yp) {
		SOPostavljanjeMina.izvrsi(tabla,xp,yp);
		SOOznacavanjePolja.izvrsi(tabla.getX(),tabla.getY(),tabla.polja);
	}
	
	/**
	 * Cuva rang litu u fajl na zadatoj putanji.
	 * @param putanja Putanja gde se fajl cuva.
	 */
	public void sacuvajUFajl(String putanja) {
		SOSacuvajUFajl.izvrsi(putanja, lista);
	}

}
