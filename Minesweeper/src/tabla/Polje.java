package tabla;

public class Polje {
	
	private boolean otvoreno = false;
	private boolean mina = false;
	private int brMinaOkolo = 0;
	
	
	public boolean isOtvoreno() {
		return otvoreno;
	}
	
	public void setOtvoreno(boolean otvoreno) {
		this.otvoreno = otvoreno;
	}
	
	public boolean isMina() {
		return mina;
	}
	
	public void setMina(boolean mina) {
		this.mina = mina;
	}
	
	public int getbrMinaOkolo() {
		return brMinaOkolo;
	}
	
	public void setbrMinaOkolo(int brMina) {
		if(brMina>= 0 || brMina<=8)
			this.brMinaOkolo = brMina;
		else throw new RuntimeException("Broj mora biti od 0 do 8");
	}
	
	

}
