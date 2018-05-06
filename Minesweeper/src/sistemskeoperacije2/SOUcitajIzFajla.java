package sistemskeoperacije2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import ranglista.Rezultat;

public class SOUcitajIzFajla {
	public static Rezultat[] izvrsi(String putanja) {
		try{
			ObjectInputStream in = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(putanja)));
			
			return (Rezultat[])(in.readObject());
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
