package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Minesweeper extends JFrame {

	private JPanel contentPane;
	private JButton matrica[][];
	private JLabel label;

	
	
	/**
	 * Create the frame.
	 */
	public Minesweeper(int dimX, int dimY) {
		setTitle("Minesweeper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLabel());

		int x=0,y=0;
		matrica = new JButton[dimX][dimY];
		
		for(x=0;x<dimX;x++)
		for(y=0;y<dimY;y++) {
			matrica[x][y] = new JButton();
			contentPane.add(matrica[x][y]);
			matrica[x][y].setLocation(10+x*30, 10+y*30);
			matrica[x][y].setVisible(true);
			matrica[x][y].setSize(30, 30);
			matrica[x][y].setMargin(new Insets(2, 2, 2, 2));	
			matrica[x][y].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)	// levi klik za svako polje:
				{	
					
					JButton dugme = (JButton)e.getSource();	//nalazi dugme koje je pozvalo event
					dugme.setEnabled(false);
					int x = (dugme.getX()-10)/30;//kordinate dugmeta koje ce se slati logickom delu(Tabla)
					int y = (dugme.getY()-10)/30;
				}
				}
			);
			matrica[x][y].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	//desni klik za svako polje
					JButton dugme = (JButton)e.getSource();
					if(e.getButton()==3 && dugme.isEnabled())//posto ne postoji obican event za desni klik ovde se proverava da li je klik desni (3)
					dugme.setText("X");//umesto ovog se stavlja zastavica
				}
			});
		}
		}
	
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("0");
			label.setBounds(139, 336, 104, 14);
		}
		return label;
	}
}
