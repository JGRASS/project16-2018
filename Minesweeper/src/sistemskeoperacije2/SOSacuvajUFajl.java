package sistemskeoperacije2;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import ranglista.RangLista;
import ranglista.Rezultat;

public class SOSacuvajUFajl {
	public static void izvrsi(String putanja, RangLista rangLista) {
		try(
			ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(putanja)))){
			
			out.writeObject(rangLista);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
