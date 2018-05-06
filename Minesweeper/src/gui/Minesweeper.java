package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import gui.kontroler.GUIKontroler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
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
import java.awt.event.InputEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class Minesweeper extends JFrame {

	private JPanel contentPane;
	public JButton matrica[][];
	public final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textPreostaliBrojMina;
	public JPanel panelMatrica;
	public JPanel panelZaglavlje;
	public JRadioButtonMenuItem rdbtnmntmBeginner;
	public JRadioButtonMenuItem rdbtnmntmIntermediate;
	public JRadioButtonMenuItem rdbtnmntmExpert;
	public JButton btnNovaIgra;
	public JLabel lblTimer;
	
	/**
	 * Create the frame.
	 */
	public Minesweeper(int dimX, int dimY) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIKontroler.prikaziExitProzor();
			}
		});
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Minesweeper.class.getResource("/icons/915944-200.png")));
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
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnmntmBeginner.isSelected())
					GUIKontroler.novaIgra();
				
				if(rdbtnmntmIntermediate.isSelected())
					GUIKontroler.novaIgra();
				
				if(rdbtnmntmExpert.isSelected())
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
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.novaIgra();
			}
		});
		buttonGroup.add(rdbtnmntmBeginner);
		mnGame.add(rdbtnmntmBeginner);
		
		rdbtnmntmIntermediate = new JRadioButtonMenuItem("Intermediate");
		rdbtnmntmIntermediate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.novaIgra();
			}
		});
		buttonGroup.add(rdbtnmntmIntermediate);
		mnGame.add(rdbtnmntmIntermediate);
		
		rdbtnmntmExpert = new JRadioButtonMenuItem("Expert");
		rdbtnmntmExpert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.novaIgra();
			}
		});
		buttonGroup.add(rdbtnmntmExpert);
		mnGame.add(rdbtnmntmExpert);
		
		JSeparator separator_1 = new JSeparator();
		mnGame.add(separator_1);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIKontroler.prikaziExitProzor();
			}
		});
		mnGame.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.prikaziAboutProzor();
			}
		});
		mnHelp.add(mntmAbout);
		
		JSeparator separator_2 = new JSeparator();
		mnHelp.add(separator_2);
		
		JMenuItem mntmInstructions = new JMenuItem("Instructions");
		mntmInstructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.prikaziInstrukcijeProzor();
			}
		});
		mnHelp.add(mntmInstructions);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelZaglavlje = new JPanel();
		panelZaglavlje.setBounds(5, 5, 310, 41);
		contentPane.add(panelZaglavlje);
		panelZaglavlje.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textPreostaliBrojMina = new JTextField();
		textPreostaliBrojMina.setEditable(false);
		textPreostaliBrojMina.setHorizontalAlignment(SwingConstants.LEFT);
		panelZaglavlje.add(textPreostaliBrojMina);
		textPreostaliBrojMina.setColumns(10);
		
		btnNovaIgra = new JButton("");
		btnNovaIgra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.novaIgra();	
			}
		});
		btnNovaIgra.setPreferredSize(new Dimension(30, 30));
		btnNovaIgra.setIcon(new ImageIcon(Minesweeper.class.getResource("/icons/Smile.png")));
		panelZaglavlje.add(btnNovaIgra);
		
		lblTimer = new JLabel("");
		panelZaglavlje.add(lblTimer);
			
		postavljanjePolja(dimX, dimY);
		
		
		}
	
	public void postavljanjePolja(int dimX, int dimY) {
		
		panelMatrica = new JPanel();
		panelMatrica.setBounds(5, 49, 10+dimX*30, 10+dimY*30);
		contentPane.add(panelMatrica);
		panelMatrica.setLayout(null);		
		panelZaglavlje.setBounds(5, 5, 10+30*dimX, 41);
		setSize(36+dimX*30, 125+dimY*30);
		matrica = new JButton[dimX][dimY];
		textPreostaliBrojMina.setText(""+GUIKontroler.getBrojPreostalihMina());
		for(int x=0;x<dimX;x++)
		for(int y=0;y<dimY;y++) {
				matrica[x][y] = new JButton();
				panelMatrica.add(matrica[x][y]);
				matrica[x][y].setLocation(10+x*30, 10+y*30);
				matrica[x][y].setVisible(true);
				matrica[x][y].setSize(30, 30);
				matrica[x][y].setMargin(new Insets(2, 2, 2, 2));	
				matrica[x][y].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)	// levi klik za svako polje:
					{	
						if (GUIKontroler.getStatus() == 0) {
							JButton dugme = (JButton) e.getSource(); // nalazi dugme koje je pozvalo event
							dugme.setEnabled(false);
							dugme.setEnabled(true);//da skine neki okvir oko dugmeta

							int x = (dugme.getX() - 10) / 30;// kordinate dugmeta koje ce se slati logickom delu(Tabla)
							int y = (dugme.getY() - 10) / 30;

							GUIKontroler.pritisnutoPolje(x, y);
						}
					}
					}
				);
				matrica[x][y].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {	//desni klik za svako polje
						JButton dugme = (JButton)e.getSource();
						if(e.getButton()==3 && dugme.isEnabled() && GUIKontroler.getStatus() == 0){//posto ne postoji obican event za desni klik ovde se proverava da li je klik desni (3)
							if (dugme.getIcon()==null){
								dugme.setIcon(new ImageIcon(Minesweeper.class.getResource("/icons/images.png")));
								GUIKontroler.SmanjiBrojPreostalihMina();
								textPreostaliBrojMina.setText(""+GUIKontroler.getBrojPreostalihMina());
							}
							else{
								dugme.setIcon(null);
								GUIKontroler.PovecajBrojPreostalihMina();
								textPreostaliBrojMina.setText(""+GUIKontroler.getBrojPreostalihMina());
							}
						}
					}
				});
			}
		
		
	}
	
	
	
	
	
}
