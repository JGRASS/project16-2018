package tabla.sistemskeoperacije;

import tabla.Polje;

public class SOOznacavanjePolja {
	
	public static void izvrsi(int dimX, int dimY, Polje[][] polja) {
		int x,y;
		int brMina=0;
		for(x=0;x<dimX;x++)
		for(y=0;y<dimY;y++)
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

			if (y<dimY-1 &&polja[x][y+1].isMina())
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
