package tabla.sistemskeoperacije;

import java.util.Random;

import tabla.Polje;

public class SOPostavljanjeMina {
	
	public static void izvrsi(int dimX, int dimY, int brMina, Polje[][] polja,int xp, int yp) {
		Random rand = new Random();
		int brPostMina=0;
		int x,y;
		while(brPostMina<brMina) {
			x=rand.nextInt(dimX);
			y=rand.nextInt(dimY);
			if(polja[x][y].isMina()==false && (x!=xp || y!=yp)) {
				polja[x][y].setMina(true);
				brPostMina++;
			}
		}	
	}
}
