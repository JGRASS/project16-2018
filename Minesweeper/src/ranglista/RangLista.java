package ranglista;

import java.io.Serializable;

import sistemskeoperacije2.SODodajRezultat;
import sistemskeoperacije2.SOPrikazListe;


public class RangLista implements Serializable {


	private static final long serialVersionUID = 345435L;
	private Rezultat[] rangLista= new Rezultat[100];
	private int brRezultata=0;
	

	public void dodajRezultatSortirano(Rezultat rezultat) {
		SODodajRezultat.izvrsi(rezultat, rangLista, brRezultata);
		if (brRezultata!=100)
			brRezultata++;
	}

	
	public Rezultat[] vratiRangListu() {
		return rangLista;
	}
	
	public String prikaziListu() {
		return SOPrikazListe.izvrsi(rangLista, brRezultata);
	}


}
