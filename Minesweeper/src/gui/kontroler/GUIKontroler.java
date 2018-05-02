package gui.kontroler;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import gui.Minesweeper;
import tabla.Tabla;

public class GUIKontroler {
	
	public static Tabla tabla;
	public static Minesweeper ms;
	private static boolean prviPotez;
	private static int status;
	
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
	
	public static void novaIgra(int dimX, int dimY, int brMina) {
		status=0;
		prviPotez=true;
		tabla = new Tabla(dimX,dimY,brMina);
		ms.remove(ms.panelMatrica);
		ms.postavljanjePolja(dimX, dimY);
		ms.repaint();
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
			ms.panelMatrica.setEnabled(false);
			System.out.println("poraz");
		}
		if(status==2) {//pobeda
			//ovde stavi neki prozorcic, ili dodaj one cvikere smajliju
			//trebalo bi i da se doda rezultat u rang listu
			System.out.println("pobeda");
		}
		azurirajGUI();

	}
		
	
	
	private static void azurirajGUI() {
		for(int x=0; x<tabla.getX();x++)
		for(int y=0; y<tabla.getY();y++) {
			
			if(status==0 && tabla.polja[x][y].isOtvoreno()) {
				ms.matrica[x][y].setEnabled(false);
				if(tabla.polja[x][y].getbrMinaOkolo()!=0)
					ms.matrica[x][y].setText(Integer.toString(tabla.polja[x][y].getbrMinaOkolo()));//moglo bi da se doda da se brojevi boje
			}
					

			if(status==1 && tabla.polja[x][y].isMina())
				ms.matrica[x][y].setText("M");//ovde bi trebala slicica mine
			
					
			if(status==2 && tabla.polja[x][y].isMina())
				ms.matrica[x][y].setIcon(new ImageIcon(Minesweeper.class.getResource("/icons/images.png")));
		
		}
	}
	
	public static int getStatus() {
		return status;
	}
	
}
