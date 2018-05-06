package tabla;

import tabla.sistemskeoperacije.SOOznacavanjePolja;
import tabla.sistemskeoperacije.SOPostavljanjeMina;
import tabla.sistemskeoperacije.SOPritisnutoPolje;

public class Tabla {
	
	public Polje [][] polja;
	public int brOtvorenih;
	public int brPreostalih;
	private int dimX;
	private int dimY;
	public int brMina;

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
	
	
	public int getX() {
		return dimX;
	}

	public int getY() {
		return dimY;
	}
	
	public int getBrMina(){
		return brMina;
	}
	
	public int  pritisnutoPolje(int x, int y) {
		return SOPritisnutoPolje.izvrsi(x,y,this);
	}
	
	public void postaviMine(int xp,int yp) {
		SOPostavljanjeMina.izvrsi(dimX, dimY, brMina, polja,xp,yp);
		SOOznacavanjePolja.izvrsi(dimX,dimY,polja);	
	}
	

}
