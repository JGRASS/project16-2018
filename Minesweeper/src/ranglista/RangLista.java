package ranglista;

import sistemskeoperacije2.SODodajRezultat;
import sistemskeoperacije2.SOPrikazListe;
import sistemskeoperacije2.SOSacuvajUFajl;
import sistemskeoperacije2.SOUcitajIzFajla;

public class RangLista implements RangListaInterface {

	private Rezultat[] rangLista= new Rezultat[100];
	private int brRezultata=0;
	
	@Override
	public void dodajRezultatSortirano(Rezultat rezultat) {
		SODodajRezultat.izvrsi(rezultat, rangLista, brRezultata);
		if (brRezultata!=100)
			brRezultata++;
	}

	@Override
	public Rezultat[] vratiRangListu() {
		return rangLista;
	}
	
	public String prikaziListu() {
		return SOPrikazListe.izvrsi(rangLista, brRezultata);
	}

	@Override
	public void ucitajIzFajla(String putanja) {
		SOUcitajIzFajla.izvrsi(putanja);
		
	}

	@Override
	public void sacuvajUFajl(String putanja) {
		SOSacuvajUFajl.izvrsi(putanja, rangLista);
		
	}

}
