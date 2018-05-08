package tabla;

import tabla.sistemskeoperacije.SOOznacavanjePolja;
import tabla.sistemskeoperacije.SOPostavljanjeMina;
import tabla.sistemskeoperacije.SOPritisnutoPolje;

/**
 * Glavna klasa logickog nivoa koja sadrzi logicku tablu i pomocne atribute, poziva sistemske operacije za tablu.
 * @author brkic
 * @version 0.2
 */
public class Tabla {
	
	/** Matrica polja koja predstavlja tablu. */
	public Polje [][] polja;
	
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

	//ovde ce mozda biti jos izmena
	public Tabla(int dimX, int dimY, int brMina) {
		this.dimX=dimX;
		this.dimY=dimY;
		this.brMina=brMina;
		brOtvorenih = 0;
		brPreostalih = dimX*dimY-brMina;
		polja = new Polje[dimX][dimY];
		
		if(brMina>dimX*dimY)
			brMina=dimX*dimY;

		for(int x=0;x<dimX;x++)
		for(int y=0;y<dimY;y++)
			polja[x][y]= new Polje();
	
	}
	
	
	/** Vraca dimenziju table X. */
	public int getX() {
		return dimX;
	}

	/** Vraca dimenziju table Y. */
	public int getY() {
		return dimY;
	}
	
	/** Vraca broj mina na tabli. */
	/*public int getBrMina(){
		return brMina;
	}*/
	
	
	/*public void novaTabla(int dimX, int dimY, int brMina) {
		
	}
	
	/*
	/**
	 * Azurira stanje tabla u zavisnosti od otvorenog polja i odredjuje stanje igre.
	 * @param x Koordinata X pritisnutog polja.
	 * @param y Koordinata Y pritisnutog polja.
	 * @return 2 ako su sva polja osim mina otvorena,
	 * 1 ako se na otvorenom polju nalazi mina,
	 * 0 u ostalim slucajevima.
	 */
	/*public int  pritisnutoPolje(int x, int y) {
		return SOPritisnutoPolje.izvrsi(x,y,this);
	}
	
	/**
	 * Nakon prvog poteza postavljaju se mine i oznake.
	 * @param xp Koordinata X prvog protisnutog polja.
	 * @param yp Koordinata Y prvog protisnutog polja.
	 */
	/*public void postaviMine(int xp,int yp) {
		SOPostavljanjeMina.izvrsi(dimX, dimY, brMina, polja,xp,yp);
		SOOznacavanjePolja.izvrsi(dimX,dimY,polja);	
	}*/
	

}
