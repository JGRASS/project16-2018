package tabla.sistemskeoperacije;

import tabla.Polje;

/**
 * Sistemska operacija koja na tabli postavlja oznake za broj mina oko svakog polja, osim za polja na kojima je mina.
 * @author Milos Brkic
 * @version 1.0
 */
public class SOOznacavanjePolja {
	
	/**
	 * Metoda koja izvrsava sistemsku operaciju.
	 * @param dimX Dimenzija table X.
	 * @param dimY Dimenzija table Y.
	 * @param polja Matrica polja na kojoj se postavljaju oznake.
	 */
	public static void izvrsi(int dimX, int dimY, Polje[][] polja) {
		int brMina=0;
		for(int x=0;x<dimX;x++)
		for(int y=0;y<dimY;y++)
		if(polja[x][y].isMina()==false) {
			brMina=0;
			
			if (x > 0 && y > 0 && polja[x-1][y-1].isMina())
				brMina++;

			if (x > 0 && polja[x-1][y].isMina())
				brMina++;

			if (y > 0 && polja[x][y-1].isMina())
				brMina++;

			if (x > 0 && y < dimY-1 && polja[x-1][y+1].isMina())
				brMina++;

			if (y<dimY-1 && polja[x][y+1].isMina())
				brMina++;

			if (x < dimX- 1 && y > 0 && polja[x+1][y-1].isMina())
				brMina++;

			if (x < dimX - 1 && polja[x+1][y].isMina())
				brMina++;

			if (x < dimX - 1 && y < dimY - 1 && polja[x+1][y+1].isMina())
				brMina++;
			
			polja[x][y].setbrMinaOkolo(brMina);
			brMina=0;			
			}
	}

}
