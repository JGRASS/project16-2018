package ranglista;

import sistemskeoperacije2.SODodajRezultat;

public class RangLista implements RangListaInterface {

	private Rezultat[] rangLista= new Rezultat[100];
	private int brRezultata = 0;
	
	@Override
	public void dodajRezultatSortirano(Rezultat rezultat) {
		SODodajRezultat.izvrsi(rezultat, rangLista, brRezultata);
	}

	@Override
	public Rezultat[] vratiRangListu() {
		return rangLista;
	}
	
	public String prikaziListu() {
		String tekst = rangLista[0].toString();
		for(int i=1; i<brRezultata; i++)
			tekst = tekst +"\n"+rangLista[i].toString();
		return tekst;
		
	}

}
