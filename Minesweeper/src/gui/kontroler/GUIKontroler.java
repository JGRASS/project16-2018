package gui.kontroler;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

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
	
	public static void prikaziAboutProzor(){
		JOptionPane.showMessageDialog(ms,
				"Pronadjite mine u minskom polju, a da ne stanete ni na jednu od njih!", "Minesweeper",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void prikaziExitProzor() {
		int opcija = JOptionPane.showConfirmDialog(ms,
				"Da li ZAISTA zelite da izadjete iz apliacije", "Izlazak",
				JOptionPane.YES_NO_OPTION);

		if (opcija == JOptionPane.YES_OPTION)
			System.exit(0);
	}
	
	public static void prikaziInstrukcijeProzor(){
		JOptionPane.showMessageDialog(ms, "Kliknite na polje da biste otkrili minu. Brojevi pokazuju koliko ima mina oko tog polja.",
				"Minesweeper", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
}
