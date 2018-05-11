package gui;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import gui.kontroler.GUIKontroler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;


/**
 * Klasa koja predstavlja minesweeper aplikaciju
 * 
 * @author Milos Brkic
 * @author Vanja Vlahovic
 * @version 1.0
 */
public class Minesweeper extends JFrame {

	/**
	 * panel na kome su grupisane sve GUI komponente
	 */
	private JPanel contentPane;
	/**
	 * Matrica dugmica koja predstavlja tablu
	 */
	public JButton matrica[][];
	/**
	 * Grupa dugmica koji su iskljucivi i odredjuju tip igre
	 */
	public final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Tekstualno polje u kome je prikazan broj mina koje se nalaze na tabli, a
	 * koje nisu oznacene zastavicom
	 */
	private JTextField textPreostaliBrojMina;
	/**
	 * Panel na kome se nalazi tabla
	 */
	public JPanel panelMatrica;
	/**
	 * Panel na kome se nalazi broj preostalih mina, dugme za novu igru i vreme
	 * koje je proteklo
	 */
	public JPanel panelZaglavlje;
	/**
	 * Dugme koje pokrece novu igru kao Beginner
	 */
	public JRadioButtonMenuItem rdbtnmntmBeginner;
	/**
	 * Dugme koje pokrece novu igru kao Intermediate
	 */
	public JRadioButtonMenuItem rdbtnmntmIntermediate;
	/**
	 * Dugme koje pokrece novu igru kao Expert
	 */
	public JRadioButtonMenuItem rdbtnmntmExpert;
	/**
	 * Dugme koje pokrece novu igru
	 */
	public JButton btnNovaIgra;
	/**
	 * Labela koja prikazuje vreme koje je proteklo igrajuci igru
	 */
	public JLabel lblTimer;

	/**
	 * Kreiranje prozora
	 */
	public Minesweeper(int dimX, int dimY) {
		addWindowListener(new WindowAdapter() {
			/**
			 * Otvaranje novog prozora u slucaju izlaza iz aplikacije
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				int opcija = JOptionPane.showConfirmDialog(contentPane, "Da li ZAISTA zelite da izadjete iz apliacije?",
						"Izlazak", JOptionPane.YES_NO_OPTION);

				if (opcija == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Minesweeper.class.getResource("/icons/mina.png")));
		setTitle("Minesweeper");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 336, 438);
		GUIKontroler.pokreniTimer();

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnGame = new JMenu("Game");
		menuBar.add(mnGame);

		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			/**
			 * Pokretanje nove igre u skladu sa tipom igre koji je selektovan
			 */
			public void actionPerformed(ActionEvent e) {

				if (rdbtnmntmBeginner.isSelected())
					GUIKontroler.novaIgra();

				if (rdbtnmntmIntermediate.isSelected())
					GUIKontroler.novaIgra();

				if (rdbtnmntmExpert.isSelected())
					GUIKontroler.novaIgra();

			}
		});
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mnGame.add(mntmNew);

		JSeparator separator = new JSeparator();
		mnGame.add(separator);

		rdbtnmntmBeginner = new JRadioButtonMenuItem("Beginner");
		rdbtnmntmBeginner.setSelected(true);
		rdbtnmntmBeginner.addActionListener(new ActionListener() {
			/**
			 * Pokretanje nove igre kada se selektuje dugme Beginner
			 */
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.novaIgra();
				textPreostaliBrojMina.setText("" + GUIKontroler.getBrojPreostalihMina());
			}
		});
		buttonGroup.add(rdbtnmntmBeginner);
		mnGame.add(rdbtnmntmBeginner);

		rdbtnmntmIntermediate = new JRadioButtonMenuItem("Intermediate");
		rdbtnmntmIntermediate.addActionListener(new ActionListener() {
			/**
			 * Pokretanje nove igre kada se selektuje dugme Intermediate
			 */
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.novaIgra();
				textPreostaliBrojMina.setText("" + GUIKontroler.getBrojPreostalihMina());
			}
		});
		buttonGroup.add(rdbtnmntmIntermediate);
		mnGame.add(rdbtnmntmIntermediate);

		rdbtnmntmExpert = new JRadioButtonMenuItem("Expert");
		rdbtnmntmExpert.addActionListener(new ActionListener() {
			/**
			 * Pokretanje nove igre kada se selektuje dugme Expert
			 */
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.novaIgra();
				textPreostaliBrojMina.setText("" + GUIKontroler.getBrojPreostalihMina());
			}
		});
		buttonGroup.add(rdbtnmntmExpert);
		mnGame.add(rdbtnmntmExpert);

		JSeparator separator_1 = new JSeparator();
		mnGame.add(separator_1);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			/**
			 * Otvaranje novog prozora u slucaju izlaza iz aplikacije
			 */
			public void actionPerformed(ActionEvent arg0) {
				int opcija = JOptionPane.showConfirmDialog(contentPane, "Da li ZAISTA zelite da izadjete iz apliacije?",
						"Izlazak", JOptionPane.YES_NO_OPTION);

				if (opcija == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		mnGame.add(mntmExit);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			/**
			 * Otvaranje prozora na kome se nalaze podaci o igrici
			 */
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane,
						"Pronadjite mine u minskom polju, a da ne stanete ni na jednu od njih!", "Minesweeper",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmAbout);

		JSeparator separator_2 = new JSeparator();
		mnHelp.add(separator_2);

		JMenuItem mntmInstructions = new JMenuItem("Instructions");
		mntmInstructions.addActionListener(new ActionListener() {
			/**
			 * Otvaranje prozora na kome se nalaze instrukcije kako se igra
			 * minesweeper
			 */
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane,
						"Kliknite na polje da biste otkrili minu. Brojevi pokazuju koliko ima mina oko tog polja.",
						"Minesweeper", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmInstructions);

		JMenuItem mntmRangLista = new JMenuItem("Rang lista");
		mntmRangLista.addActionListener(new ActionListener() {
			/**
			 * Otvaranje novog prozora na kome se prikazuje rang lista
			 */
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.prikaziRezultatiGUI();
			}
		});
		mnHelp.add(mntmRangLista);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelZaglavlje = new JPanel();
		panelZaglavlje.setBounds(6, 5, 310, 41);
		contentPane.add(panelZaglavlje);
		panelZaglavlje.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		textPreostaliBrojMina = new JTextField();
		textPreostaliBrojMina.setEditable(false);
		textPreostaliBrojMina.setBorder(null);
		textPreostaliBrojMina.setFont(new Font(null,0,15));
		textPreostaliBrojMina.setHorizontalAlignment(SwingConstants.RIGHT);
		panelZaglavlje.add(textPreostaliBrojMina);
		textPreostaliBrojMina.setColumns(2);

		btnNovaIgra = new JButton("");
		btnNovaIgra.addActionListener(new ActionListener() {
			/**
			 * Pokretanje nove igre kada se pritisne dugme sa smajlijem
			 */
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.novaIgra();
			}
		});
		btnNovaIgra.setPreferredSize(new Dimension(30, 30));
		btnNovaIgra.setIcon(new ImageIcon(Minesweeper.class.getResource("/icons/Smile.png")));
		panelZaglavlje.add(btnNovaIgra);

		lblTimer = new JLabel("0");
		lblTimer.setPreferredSize(new Dimension(32, 14));
		lblTimer.setHorizontalTextPosition(SwingConstants.LEFT);
		lblTimer.setHorizontalAlignment(SwingConstants.LEFT);
		lblTimer.setMinimumSize(new Dimension(16, 14));
		lblTimer.setFont(new Font(null,0,15));
		panelZaglavlje.add(lblTimer);

		postavljanjePolja(dimX, dimY);

	}

	/**
	 * Metoda koja kreira tabelu u odnosu na prosledjene dimenzije
	 * 
	 * @param dimX
	 *            broj polja po redovima
	 * @param dimY
	 *            broj polja po kolonama
	 */
	public void postavljanjePolja(int dimX, int dimY) {

		panelMatrica = new JPanel();
		panelMatrica.setBounds(5, 49, 10 + dimX * 30, 10 + dimY * 30);
		contentPane.add(panelMatrica);
		panelMatrica.setLayout(null);
		panelZaglavlje.setBounds(22, 5, 30 * dimX - 10, 41);
		setSize(36 + dimX * 30, 125 + dimY * 30);
		matrica = new JButton[dimX][dimY];
		textPreostaliBrojMina.setText("" + GUIKontroler.getBrojPreostalihMina());
		for (int x = 0; x < dimX; x++)
			for (int y = 0; y < dimY; y++) {
				matrica[x][y] = new JButton();
				panelMatrica.add(matrica[x][y]);
				matrica[x][y].setLocation(10 + x * 30, 10 + y * 30);
				matrica[x][y].setVisible(true);
				matrica[x][y].setSize(30, 30);
				matrica[x][y].setBackground(new Color(210,210,255));
				matrica[x][y].setMargin(new Insets(2, 2, 2, 2));
				matrica[x][y].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) // levi klik za
																// svako polje:
					{
						if (GUIKontroler.getStatus() == 0) {
							JButton dugme = (JButton) e.getSource(); 
							dugme.setEnabled(false);
							dugme.setEnabled(true);// da skine neki okvir oko
													// dugmeta

							int x = (dugme.getX() - 10) / 30;
							int y = (dugme.getY() - 10) / 30;

							if (dugme.getIcon() == null) {
								GUIKontroler.pritisnutoPolje(x, y);
								textPreostaliBrojMina.setText("" + GUIKontroler.getBrojPreostalihMina());
							}
						}
					}
				});
				matrica[x][y].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) { // desni klik za
																// svako polje
						JButton dugme = (JButton) e.getSource();
						if (e.getButton() == 3 && dugme.isEnabled() && GUIKontroler.getStatus() == 0) {
							
							if (dugme.getIcon() == null) {
								dugme.setIcon(new ImageIcon(Minesweeper.class.getResource("/icons/zastavica.png")));
								GUIKontroler.SmanjiBrojPreostalihMina();
								textPreostaliBrojMina.setText("" + GUIKontroler.getBrojPreostalihMina());
							} else {
								dugme.setIcon(null);
								GUIKontroler.PovecajBrojPreostalihMina();
								textPreostaliBrojMina.setText("" + GUIKontroler.getBrojPreostalihMina());
							}
						}
					}
				});
			}

	}

}
