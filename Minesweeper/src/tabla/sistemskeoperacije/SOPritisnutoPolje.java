package tabla.sistemskeoperacije;

import tabla.Polje;
import tabla.Tabla;

public class SOPritisnutoPolje {
	
	public static int izvrsi(int x, int y, Tabla tabla) {
		
		if(tabla.polja[x][y].isMina())
			return 1;//poraz
		
		if(tabla.polja[x][y].getbrMinaOkolo()==0)
			lancanoOtvaranje(x,y,tabla);
		else
			tabla.brOtvorenih++;
		
		tabla.polja[x][y].setOtvoreno(true);
		
		if(tabla.brPreostalih<=tabla.brOtvorenih)
			return 2;//pobeda
		
		return 0;//igra se nastavlja
	}

	private static void lancanoOtvaranje(int x,int y,Tabla tabla) {
		if(tabla.polja[x][y].isMina() || tabla.polja[x][y].isOtvoreno())
			return;
		
		if(tabla.polja[x][y].isOtvoreno()==false) {
			tabla.polja[x][y].setOtvoreno(true);
			tabla.brOtvorenih++;
		}
		
		if (tabla.polja[x][y].getbrMinaOkolo() == 0) {
			if (x > 0 && y > 0)
				lancanoOtvaranje(x - 1, y - 1, tabla);

			if (x > 0)
				lancanoOtvaranje(x - 1, y, tabla);

			if (y > 0)
				lancanoOtvaranje(x, y - 1, tabla);

			if (x > 0 && y < tabla.getY() - 1)
				lancanoOtvaranje(x - 1, y + 1, tabla);

			if (y < tabla.getY() - 1)
				lancanoOtvaranje(x, y + 1, tabla);

			if (x < tabla.getX() - 1 && y > 0)
				lancanoOtvaranje(x + 1, y - 1, tabla);

			if (x < tabla.getX() - 1)
				lancanoOtvaranje(x + 1, y, tabla);

			if (x < tabla.getX() - 1 && y < tabla.getY() - 1)
				lancanoOtvaranje(x + 1, y + 1, tabla);
			
		}
		
	}

}
