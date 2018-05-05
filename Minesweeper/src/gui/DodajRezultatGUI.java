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
import ranglista.RangLista;
import ranglista.RangListaInterface;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	public static RangListaInterface rangLista = new RangLista();
	public static Minesweeper ms;
	private JButton btnDodaj;

	/**
	 * Create the frame.
	 */
	public DodajRezultatGUI() {
		setTitle("Upisivanje rezultata");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DodajRezultatGUI.class.getResource("/icons/Throphy-512.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 366);
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
			textFieldTipIgre.setBounds(162, 40, 147, 25);
			textFieldTipIgre.setColumns(10);
			/*if (ms.rdbtnmntmBeginner.isSelected())
				textFieldTipIgre.setText("Beginner");
			if (ms.rdbtnmntmIntermediate.isSelected())
				textFieldTipIgre.setText("Intermediate");
			if (ms.rdbtnmntmExpert.isSelected())
				textFieldTipIgre.setText("Expert");
			*/
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
			scrollPane.setBounds(5, 146, 300, 181);
			scrollPane.setViewportView(getTextAreaRangLista());
			scrollPane.setColumnHeaderView(getBtnDodaj());
		}
		return scrollPane;
	}
	private JTextArea getTextAreaRangLista() {
		if (textAreaRangLista == null) {
			textAreaRangLista = new JTextArea();
			textAreaRangLista.setBorder(new TitledBorder(null, "Rang lista", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
					textAreaRangLista.setText(rangLista.prikaziListu());
				}
			});
		}
		return btnDodaj;
	}
}
