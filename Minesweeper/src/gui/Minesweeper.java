package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class Minesweeper extends JFrame {

	private JPanel contentPane;
	private JButton matrica[][];
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textPreostaliBrojMina;
	private JTextField textField_1;

	
	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 488);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnGame = new JMenu("Game");
		menuBar.add(mnGame);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mnGame.add(mntmNew);
		
		JSeparator separator = new JSeparator();
		mnGame.add(separator);
		
		JRadioButtonMenuItem rdbtnmntmBeginner = new JRadioButtonMenuItem("Beginner");
		rdbtnmntmBeginner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		buttonGroup.add(rdbtnmntmBeginner);
		mnGame.add(rdbtnmntmBeginner);
		
		JRadioButtonMenuItem rdbtnmntmIntermediate = new JRadioButtonMenuItem("Intermediate");
		buttonGroup.add(rdbtnmntmIntermediate);
		mnGame.add(rdbtnmntmIntermediate);
		
		JRadioButtonMenuItem rdbtnmntmExpert = new JRadioButtonMenuItem("Expert");
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
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 311, 41);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textPreostaliBrojMina = new JTextField();
		textPreostaliBrojMina.setEditable(false);
		textPreostaliBrojMina.setBounds(10, 5, 86, 36);
		textPreostaliBrojMina.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(textPreostaliBrojMina);
		textPreostaliBrojMina.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(222, 5, 86, 36);
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNovaIgra = new JButton("");
		btnNovaIgra.setPreferredSize(new Dimension(25, 25));
		btnNovaIgra.setIcon(new ImageIcon(Minesweeper.class.getResource("/icons/Smile.png")));
		btnNovaIgra.setBounds(140, 5, 38, 37);
		panel.add(btnNovaIgra);
		
		JPanel panelMatrica = new JPanel();
		panelMatrica.setBounds(5, 49, 527, 378);
		contentPane.add(panelMatrica);
		panelMatrica.setLayout(null);

		int x=0,y=0;
		
		matrica = new JButton[20][20];		
		
		for(x=0;x<dimX;x++)
		for(y=0;y<dimY;y++) {
			matrica[x][y] = new JButton();
			panelMatrica.add(matrica[x][y]);
			matrica[x][y].setLocation(10+x*30, 10+y*30);
			matrica[x][y].setVisible(true);
			matrica[x][y].setSize(30, 30);
			matrica[x][y].setMargin(new Insets(2, 2, 2, 2));	
			matrica[x][y].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)	// levi klik za svako polje:
				{	
					
					JButton dugme = (JButton)e.getSource();	//nalazi dugme koje je pozvalo event
					dugme.setEnabled(false);
					int x = dugme.getX()/30;//kordinate dugmeta koje ce se slati logickom delu(Tabla)
					int y = dugme.getY()/30;
				}
				}
			);
			matrica[x][y].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	//desni klik za svako polje
					JButton dugme = (JButton)e.getSource();
					if(e.getButton()==3 && dugme.isEnabled())//posto ne postoji obican event za desni klik ovde se proverava da li je klik desni (3)
					dugme.setIcon(new ImageIcon(Minesweeper.class.getResource("/icons/images.png")));
				}
			});
		}
		}
	
	
	
}
