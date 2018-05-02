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

	public Tabla(int dimX, int dimY, int brMina) {
		this.dimX=dimX;
		this.dimY=dimY;
		brOtvorenih = 0;
		brPreostalih = dimX*dimY-brMina;
		polja = new Polje[dimX][dimY];
		
		if(brMina>dimX*dimY)
			brMina=dimX*dimY;

		for(int x=0;x<dimX;x++)
		for(int y=0;y<dimY;y++)
			polja[x][y]= new Polje();
		
		SOPostavljanjeMina.izvrsi(dimX, dimY, brMina, polja);
		SOOznacavanjePolja.izvrsi(dimX,dimY,polja);
	}
	
	
	public int getX() {
		return dimX;
	}

	public int getY() {
		return dimY;
	}
	
	public int  pritisnutoPolje(int x, int y) {
		return SOPritisnutoPolje.izvrsi(x,y,this);
	}
	
	
	
	
	
	//privremeno
	public void prikaz() {
		int x,y;
		for(y=0;y<dimY;y++) {
			System.out.println();
	
			for(x=0;x<dimX;x++) {
				if(polja[x][y].isMina())
					System.out.print("* ");
				else
					System.out.print(polja[x][y].getbrMinaOkolo()+" ");
			}
		}
		System.out.println("\n");
		for(y=0;y<dimY;y++) {
			System.out.println();
	
			for(x=0;x<dimX;x++) {
				if(polja[x][y].isOtvoreno())
					System.out.print(". ");
				else
					System.out.print("X ");
			}
		}
	}
	//privremeno
	public static void main(String[] args) {
		Tabla t = new Tabla(10,10,10);
		t.pritisnutoPolje(0, 0);
		t.pritisnutoPolje(5, 7);
		t.prikaz();
		System.out.println(t.brOtvorenih);
	}

}
