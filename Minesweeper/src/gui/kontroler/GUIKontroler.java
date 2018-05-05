package gui.kontroler;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import gui.DodajRezultatGUI;
import gui.Minesweeper;
import ranglista.RangLista;
import ranglista.RangListaInterface;
import ranglista.Rezultat;
import tabla.Tabla;

public class GUIKontroler {
	
	public static RangListaInterface rangLista = new RangLista();
	public static DodajRezultatGUI dp;
	public static Tabla tabla;
	public static Minesweeper ms;
	private static boolean prviPotez;
	private static int status;
	private static int brojPreostalih=10;
	private static int k=0;
	private static Timer t;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					status=0;
					prviPotez=true;
					tabla = new Tabla(10,10,10);
					ms = new Minesweeper(10,10);
					ms.setVisible(true);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void pokreniTimer() {
		t = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ms.lblTimer.setText(String.valueOf(k));
				k++;
				}
			});		
		t.start();
	}
	
	public static void restartovanjeTimera() {
		k=0;
		t.stop();
		t.start();		
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
	
	public static void prikaziKrajProzor(){
		JOptionPane.showMessageDialog(ms, "Zao nam je. Izgubili ste.",
				"Minesweeper", JOptionPane.INFORMATION_MESSAGE);		
	}
	
	public static void prikaziPobedaProzor(){
		int opcija = JOptionPane.showConfirmDialog(ms, "Cestitamo! Pobedili ste. Da li zelite da unesete rezultat?",
				"Minesweeper", JOptionPane.YES_NO_OPTION);
		if (opcija== JOptionPane.YES_OPTION)
			prikaziDodajRezultatGUI();
			
		
	}
	public static void novaIgra() {
		status=0;
		prviPotez=true;
		ms.btnNovaIgra.setIcon(new ImageIcon(Minesweeper.class.getResource("/icons/Smile.png")));
		if (ms.rdbtnmntmBeginner.isSelected()){
			tabla = new Tabla(10,10,10);
			ms.remove(ms.panelMatrica);
			ms.postavljanjePolja(10, 10);
			ms.repaint();
			brojPreostalih=10;
		}
		if (ms.rdbtnmntmIntermediate.isSelected()){
			tabla = new Tabla(20,20,40);
			ms.remove(ms.panelMatrica);
			ms.postavljanjePolja(20, 20);
			ms.repaint();
			brojPreostalih=40;
		}
		if (ms.rdbtnmntmExpert.isSelected()){
			tabla = new Tabla(40,40,100);
			ms.remove(ms.panelMatrica);
			ms.postavljanjePolja(40, 40);
			ms.repaint();
			brojPreostalih=100;
		}
		restartovanjeTimera();
	}
	
	
	public static void pritisnutoPolje(int xp, int yp) {
		if(prviPotez) {
			tabla.postaviMine();
			prviPotez=false;
		}
		
		if(status==0) {
			status = tabla.pritisnutoPolje(xp, yp);
			
		}
		
		if(status==1) {//poraz
			ms.btnNovaIgra.setIcon(new ImageIcon(Minesweeper.class.getResource("/icons/2000px-Sad_smiley_yellow_simple.svg.png")));
			t.stop();
			prikaziKrajProzor();
		}
		if(status==2) {//pobeda
			ms.btnNovaIgra.setIcon(new ImageIcon(Minesweeper.class.getResource("/icons/s-l300.jpg")));
			t.stop();
			prikaziPobedaProzor();
			
			//trebalo bi i da se doda rezultat u rang listu
			
		}
		azurirajGUI();

	}
		
	
	
	private static void azurirajGUI() {
		for(int x=0; x<tabla.getX();x++)
		for(int y=0; y<tabla.getY();y++) {
			
			if(status==0 && tabla.polja[x][y].isOtvoreno()) {
				ms.matrica[x][y].setEnabled(false);
				if(tabla.polja[x][y].getbrMinaOkolo()!=0){
					if (tabla.polja[x][y].getbrMinaOkolo()==1){
						String t = Integer.toString(tabla.polja[x][y].getbrMinaOkolo());
						ms.matrica[x][y].setText(t);
						ms.matrica[x][y].setBackground(java.awt.Color.BLUE);		
					}
					if (tabla.polja[x][y].getbrMinaOkolo()==2){
						String t = Integer.toString(tabla.polja[x][y].getbrMinaOkolo());
						ms.matrica[x][y].setText(t);
						ms.matrica[x][y].setBackground(java.awt.Color.GREEN);					
					}
					if (tabla.polja[x][y].getbrMinaOkolo()==3){
						String t = Integer.toString(tabla.polja[x][y].getbrMinaOkolo());
						ms.matrica[x][y].setText(t);
						ms.matrica[x][y].setBackground(java.awt.Color.RED);					
					}
					if (tabla.polja[x][y].getbrMinaOkolo()==4){
						String t = Integer.toString(tabla.polja[x][y].getbrMinaOkolo());
						ms.matrica[x][y].setText(t);
						ms.matrica[x][y].setBackground(java.awt.Color.MAGENTA);					
					}
					if (tabla.polja[x][y].getbrMinaOkolo()==5){
						String t = Integer.toString(tabla.polja[x][y].getbrMinaOkolo());
						ms.matrica[x][y].setText(t);
						ms.matrica[x][y].setBackground(java.awt.Color.ORANGE);					
					}
					if (tabla.polja[x][y].getbrMinaOkolo()==6){
						String t = Integer.toString(tabla.polja[x][y].getbrMinaOkolo());
						ms.matrica[x][y].setText(t);
						ms.matrica[x][y].setBackground(java.awt.Color.BLACK);					
					}
					if (tabla.polja[x][y].getbrMinaOkolo()==7){
						String t = Integer.toString(tabla.polja[x][y].getbrMinaOkolo());
						ms.matrica[x][y].setText(t);
						ms.matrica[x][y].setBackground(java.awt.Color.BLACK);					
					}
					if (tabla.polja[x][y].getbrMinaOkolo()==8){
						String t = Integer.toString(tabla.polja[x][y].getbrMinaOkolo());
						ms.matrica[x][y].setText(t);
						ms.matrica[x][y].setBackground(java.awt.Color.BLACK);					
					}
				}
				
			}					

			if(status==1 && tabla.polja[x][y].isMina()){
				ms.matrica[x][y].setIcon(new ImageIcon(Minesweeper.class.getResource("/icons/915944-200.png")));
			}
					
			if(status==2 && tabla.polja[x][y].isMina()){
				ms.matrica[x][y].setIcon(new ImageIcon(Minesweeper.class.getResource("/icons/915944-200.png")));
			}			
		}
	}
	public static int getStatus() {
		return status;
	}
	
	public static int getBrojPreostalihMina(){
		return brojPreostalih;
	}
	public static void SmanjiBrojPreostalihMina(){
		brojPreostalih--;
	}
	public static void PovecajBrojPreostalihMina(){
		brojPreostalih++;
	}
	
	public static void prikaziDodajRezultatGUI() {
		DodajRezultatGUI prozor = new DodajRezultatGUI();
		prozor.setLocationRelativeTo(ms);
		prozor.setVisible(true);
	}
	
	public static void unesiRezultat (int vreme, String tip, String ime, String prezime) {
		try {
			Rezultat rezultat = new Rezultat();
			rezultat.setVreme(vreme);
			rezultat.setTipIgre(tip);
			rezultat.setIme(ime);
			rezultat.setPrezime(prezime);
			
			rangLista.dodajRezultatSortirano(rezultat);
						
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(),
					"Greska", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	
}
