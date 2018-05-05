package ranglista;

public class Rezultat {
	private int vreme;
	private String tipIgre;
	private String ime;
	private String prezime;
	public int getVreme() {
		return vreme;
	}
	public void setVreme(int vreme) {
		this.vreme = vreme;
	}
	public String getTipIgre() {
		return tipIgre;
	}
	public void setTipIgre(String tipIgre) {
		this.tipIgre = tipIgre;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	@Override
	public String toString() {
		return "Rezultat [vreme=" + vreme + ", tipIgre=" + tipIgre + ", ime=" + ime + ", prezime=" + prezime + "]";
	}
	
	
}
