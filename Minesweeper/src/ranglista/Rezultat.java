package ranglista;

import java.io.Serializable;

public class Rezultat implements Serializable {
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
		if (ime==null && ime.isEmpty())
			throw new RuntimeException("String ime ne sme biti prazan string ili null");
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		if (prezime==null && prezime.isEmpty())
			throw new RuntimeException("String prezime ne sme biti prazan string ili null");
		this.prezime = prezime;
	}
	@Override
	public String toString() {
		return "            " +vreme + "        " + tipIgre + "      " + ime + "      " + prezime;
	}
	
	
}
