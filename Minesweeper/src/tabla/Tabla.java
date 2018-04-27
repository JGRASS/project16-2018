package tabla;

import java.util.Random;

public class Tabla {
	
	private Polje [][] polja;
	
	
	public Tabla(int dimX, int dimY, int brMina) {
		polja = new Polje[dimX][dimY];
		int brPostMina=0;
		int x,y;
		Random rand = new Random();

		for(x=0;x<dimX;x++)
		for(y=0;y<dimY;y++)
			polja[x][y]= new Polje();
		
		while(brPostMina<brMina) {
			x=rand.nextInt(dimX);
			y=rand.nextInt(dimY);
			if(polja[x][y].isMina()==false) {
				polja[x][y].setMina(true);
				brPostMina++;
			}
		}

		
		
	}
	

}
