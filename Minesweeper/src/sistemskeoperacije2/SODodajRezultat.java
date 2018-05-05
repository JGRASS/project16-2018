package sistemskeoperacije2;

import ranglista.Rezultat;

public class SODodajRezultat {

	public static void izvrsi(Rezultat rezultat, Rezultat[] rangLista, int brRezultata) {
		if (rezultat==null)
			throw new RuntimeException("Rezultat ne sme biti null");
		if (brRezultata==100) {
			if (rezultat.getVreme()<rangLista[99].getVreme()) {
				for (int i=0; i<brRezultata; i++)
					if (rangLista[i].getVreme()>rezultat.getVreme()) {
						for (int k=brRezultata-1; k>i; k--)
							rangLista[k]=rangLista[k-1];
						rangLista[i]=rezultat;
						return;
					}
			}else
				throw new RuntimeException("Rezultat ne ulazi u rang listu.");			
		}
		if (brRezultata==0) {
			rangLista[0]=rezultat;
			brRezultata++;
			return;
			
		}
		if (rezultat.getVreme()<rangLista[brRezultata-1].getVreme())
			for(int i=0; i<brRezultata; i++) {
				if (rezultat.getVreme()<rangLista[i].getVreme()) {
					Rezultat pom = rangLista[brRezultata-1];
					for (int k=brRezultata-1; k>i; k--)
						rangLista[k]=rangLista[k-1];
					rangLista[i]=rezultat;
					rangLista[brRezultata]=pom;
					brRezultata++;	
				}
			
			}
		else {
			rangLista[brRezultata]=rezultat;
			brRezultata++;			
		}
		
		
		
	}
}
