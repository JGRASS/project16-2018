package sistemskeoperacije2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import ranglista.RangLista;
import ranglista.Rezultat;

public class SOUcitajIzFajla {
	public static RangLista izvrsi(String putanja) {
		try{
			ObjectInputStream in = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(putanja)));
			
			return (RangLista)(in.readObject());
		}catch(Exception e){
			return new RangLista();
			//throw new RuntimeException(e);
		}
	}
}
