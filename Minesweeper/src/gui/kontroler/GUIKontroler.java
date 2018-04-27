package gui.kontroler;

import java.awt.EventQueue;

import gui.Minesweeper;
import tabla.Tabla;

public class GUIKontroler {
	
	public static Tabla tabla;
	public static Minesweeper ms;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tabla = new Tabla(10,10,10);//ovo bi trebalo premestiti tako da tek kada se pristisne prvo polje da se kreira tabla 
												//da ne bi mogao odmah da pritisnes minu
					ms = new Minesweeper(10,10);
					ms.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
}
