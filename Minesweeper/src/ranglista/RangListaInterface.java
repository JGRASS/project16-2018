package ranglista;

public interface RangListaInterface {
	
	public void dodajRezultatSortirano (Rezultat rezultat);
	
	public Rezultat[] vratiRangListu();
	
	public String prikaziListu();
	
	public void ucitajIzFajla(String putanja);
	public void sacuvajUFajl(String putanja);
}
