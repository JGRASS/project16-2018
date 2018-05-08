package ranglista;

import java.io.Serializable;

public class Rezultat implements Serializable {

	private static final long serialVersionUID = 6756762953346763169L;
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
	public void setIme(String ime) throws Exception{
		if (ime==null || ime.isEmpty())
			throw new Exception("String ime ne sme biti prazan string ili null");
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) throws Exception{
		if (prezime==null || prezime.isEmpty())
			throw new Exception("String prezime ne sme biti prazan string ili null");
		this.prezime = prezime;
	}
	@Override
	public String toString() {
		return "            " +vreme + "        " + tipIgre + "      " + ime + "      " + prezime;
	}
	
	
}
