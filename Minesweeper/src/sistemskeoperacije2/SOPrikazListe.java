package sistemskeoperacije2;

import ranglista.Rezultat;

public class SOPrikazListe {
	public static String izvrsi(Rezultat[] rangLista, int brRezultata) {
		if (brRezultata!=0) {
			int k=1;
			String tekst = "1.  "+rangLista[0].toString();
			for (int i=1; i<brRezultata; i++) {
				k++;
				tekst = tekst +"\n"+ k +".  "+rangLista[i].toString();
			}
			return tekst;
		}
		return "prazna lista";
	}
}
