package tabla;

import ranglista.RangLista;
import sistemskeoperacije2.SOSacuvajUFajl;
import sistemskeoperacije2.SOUcitajIzFajla;
import tabla.sistemskeoperacije.SOOznacavanjePolja;
import tabla.sistemskeoperacije.SOPostavljanjeMina;
import tabla.sistemskeoperacije.SOPritisnutoPolje;

public class SistemskiKontroler {
	
	private Tabla tabla;
	private RangLista lista;

	public SistemskiKontroler() {
		tabla = new Tabla(10,10,10);
		lista = SOUcitajIzFajla.izvrsi("data/lista");
	}

	public RangLista getRangLista() {
		return lista;
	}

	public void setRangLista(RangLista lista) {
		this.lista = lista;
	}

	public Tabla getTabla() {
		return tabla;
	}

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
	
	
	public void sacuvajUFajl(String putanja) {
		SOSacuvajUFajl.izvrsi(putanja, lista);
	}

}
