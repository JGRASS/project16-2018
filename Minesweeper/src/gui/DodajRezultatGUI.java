package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import gui.kontroler.GUIKontroler;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.FlowLayout;

public class DodajRezultatGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblVreme;
	public JTextField textFieldVreme;
	private JLabel lblTipIgre;
	public JTextField textFieldTipIgre;
	private JLabel lblIme;
	private JTextField textFieldIme;
	private JLabel lblPrezime;
	private JTextField textFieldPrezime;
	private JScrollPane scrollPane;
	public JTextArea textAreaRangLista;
	private JButton btnDodaj;
	private JPanel panel;
	private JButton btnUcitajIzFajla;
	private JButton btnSacuvajUFajl;

	/**
	 * Create the frame.
	 */
	public DodajRezultatGUI(String vreme, String tipIgre) {
		setResizable(false);
		setTitle("Upisivanje rezultata");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DodajRezultatGUI.class.getResource("/icons/Throphy-512.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 453, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblVreme());
		contentPane.add(getTextFieldVreme());
		contentPane.add(getLblTipIgre());
		contentPane.add(getTextFieldTipIgre());
		contentPane.add(getLblIme());
		contentPane.add(getTextFieldIme());
		contentPane.add(getLblPrezime());
		contentPane.add(getTextFieldPrezime());
		contentPane.add(getScrollPane());
		textFieldVreme.setText(vreme);
		textFieldTipIgre.setText(tipIgre);
		contentPane.add(getPanel());
		
	}
	
	private JLabel getLblVreme() {
		if (lblVreme == null) {
			lblVreme = new JLabel("Vreme");
			lblVreme.setBounds(5, 5, 147, 25);
		}
		return lblVreme;
	}
	private JTextField getTextFieldVreme() {
		if (textFieldVreme == null) {
			textFieldVreme = new JTextField();
			textFieldVreme.setEditable(false);
			textFieldVreme.setBounds(162, 5, 147, 25);
			textFieldVreme.setColumns(10);
			
		}
		return textFieldVreme;
	}
	private JLabel getLblTipIgre() {
		if (lblTipIgre == null) {
			lblTipIgre = new JLabel("Tip igre");
			lblTipIgre.setBounds(5, 40, 147, 25);
		}
		return lblTipIgre;
	}
	private JTextField getTextFieldTipIgre() {
		if (textFieldTipIgre == null) {
			textFieldTipIgre = new JTextField();
			textFieldTipIgre.setEditable(false);
			textFieldTipIgre.setBounds(162, 40, 147, 25);
			textFieldTipIgre.setColumns(10);
		}
		return textFieldTipIgre;
	}
	private JLabel getLblIme() {
		if (lblIme == null) {
			lblIme = new JLabel("Ime");
			lblIme.setBounds(5, 75, 147, 25);
		}
		return lblIme;
	}
	private JTextField getTextFieldIme() {
		if (textFieldIme == null) {
			textFieldIme = new JTextField();
			textFieldIme.setBounds(162, 75, 147, 25);
			textFieldIme.setColumns(10);
		}
		return textFieldIme;
	}
	private JLabel getLblPrezime() {
		if (lblPrezime == null) {
			lblPrezime = new JLabel("Prezime");
			lblPrezime.setBounds(5, 110, 147, 25);
		}
		return lblPrezime;
	}
	private JTextField getTextFieldPrezime() {
		if (textFieldPrezime == null) {
			textFieldPrezime = new JTextField();
			textFieldPrezime.setBounds(162, 110, 147, 25);
			textFieldPrezime.setColumns(10);
		}
		return textFieldPrezime;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(5, 182, 432, 240);
			scrollPane.setViewportView(getTextAreaRangLista());
			scrollPane.setColumnHeaderView(getBtnDodaj());
		}
		return scrollPane;
	}
	private JTextArea getTextAreaRangLista() {
		if (textAreaRangLista == null) {
			textAreaRangLista = new JTextArea();
			textAreaRangLista.setText("Mesto:  Vreme:   Tip igre:       Ime:          Prezime:");
			textAreaRangLista.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Rang lista", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		}
		return textAreaRangLista;
	}
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.unesiRezultat(Integer.parseInt(textFieldVreme.getText()), textFieldTipIgre.getText(), 
							textFieldIme.getText(), textFieldPrezime.getText());
					String text = textAreaRangLista.getText();
					textAreaRangLista.setText(text + "\n"+GUIKontroler.vlatiListuPrikaz());
				}
			});
		}
		return btnDodaj;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(5, 146, 432, 33);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel.add(getButton_1());
			panel.add(getButton_2());
		}
		return panel;
	}
	private JButton getButton_1() {
		if (btnUcitajIzFajla == null) {
			btnUcitajIzFajla = new JButton("Ucitaj iz fajla");
			btnUcitajIzFajla.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.ucitajIzFajla();
					textAreaRangLista.setText(GUIKontroler.vlatiListuPrikaz());
				}
			});
		}
		return btnUcitajIzFajla;
	}
	private JButton getButton_2() {
		if (btnSacuvajUFajl == null) {
			btnSacuvajUFajl = new JButton("Sacuvaj u fajl");
			btnSacuvajUFajl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.sacuvajUFajl();
				}
			});
		}
		return btnSacuvajUFajl;
	}
}
