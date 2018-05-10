package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
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

/**
 * Prozor koji sluzi za unos novog rezultata
 * 
 * @author Vanja Vlahovic
 * @version 1.0
 */
public class DodajRezultatGUI extends JFrame {
	/**
	 * panel na kome su grupisane sve GUI komponente
	 */
	private JPanel contentPane;
	/**
	 * Natpis vreme
	 */
	private JLabel lblVreme;
	/**
	 * tekstualno polje u kome se prikazuje vreme
	 */
	public JTextField textFieldVreme;
	/**
	 * Natpis tip igre
	 */
	private JLabel lblTipIgre;
	/**
	 * Tekstualno polje u kom je prikazan tip igre
	 */
	public JTextField textFieldTipIgre;
	/**
	 * Natpis ime
	 */
	private JLabel lblIme;
	/**
	 * Tekstualno polje u koje se upisuje ime igraca
	 */
	private JTextField textFieldIme;
	/**
	 * Natpis prezime
	 */
	private JLabel lblPrezime;
	/**
	 * Tekstualno polje u koje se upisuje prezime idraca
	 */
	private JTextField textFieldPrezime;
	/**
	 * Panel koji se skroluje
	 */
	private JScrollPane scrollPane;
	/**
	 * Tekstualno polje za viseredni ispis u kome se prikazuje rang lista
	 */
	public JTextArea textAreaRangLista;
	/**
	 * Dugme dodaj koje dodaje rezultat u rang listu
	 */
	public JButton btnDodaj;
	/**
	 * panel za unost komponenti
	 */
	private JPanel panel;

	/**
	 * Kreiranje prozora
	 */
	public DodajRezultatGUI(String vreme, String tipIgre) {
		setResizable(false);
		setTitle("Upisivanje rezultata");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(DodajRezultatGUI.class.getResource("/icons/Throphy-512.png")));
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

	/**
	 * Vraca labelu vreme
	 * 
	 * @return JLabel vreme
	 */
	private JLabel getLblVreme() {
		if (lblVreme == null) {
			lblVreme = new JLabel("Vreme");
			lblVreme.setBounds(5, 5, 147, 25);
		}
		return lblVreme;
	}

	/**
	 * Vraca tekstualno polje u kome je upisano ostvareno vreme
	 * 
	 * @return JTextField vreme
	 */
	private JTextField getTextFieldVreme() {
		if (textFieldVreme == null) {
			textFieldVreme = new JTextField();
			textFieldVreme.setEditable(false);
			textFieldVreme.setBounds(162, 5, 147, 25);
			textFieldVreme.setColumns(10);

		}
		return textFieldVreme;
	}

	/**
	 * Vraca labelu tip igre
	 * 
	 * @return JLabel tip igre
	 */
	private JLabel getLblTipIgre() {
		if (lblTipIgre == null) {
			lblTipIgre = new JLabel("Tip igre");
			lblTipIgre.setBounds(5, 40, 147, 25);
		}
		return lblTipIgre;
	}

	/**
	 * Vraca tekstualno polje u kome je upisan tip igre
	 * 
	 * @return JTExtField tip igre
	 */
	private JTextField getTextFieldTipIgre() {
		if (textFieldTipIgre == null) {
			textFieldTipIgre = new JTextField();
			textFieldTipIgre.setEditable(false);
			textFieldTipIgre.setBounds(162, 40, 147, 25);
			textFieldTipIgre.setColumns(10);
		}
		return textFieldTipIgre;
	}

	/**
	 * Vraca labelu ime
	 * 
	 * @return JLabel ime
	 */
	private JLabel getLblIme() {
		if (lblIme == null) {
			lblIme = new JLabel("Ime");
			lblIme.setBounds(5, 75, 147, 25);
		}
		return lblIme;
	}

	/**
	 * Vraca tekstualno polje u kome je upisano ime igraca
	 * 
	 * @return JTextFiela ime
	 */
	private JTextField getTextFieldIme() {
		if (textFieldIme == null) {
			textFieldIme = new JTextField();
			textFieldIme.setBounds(162, 75, 147, 25);
			textFieldIme.setColumns(10);
		}
		return textFieldIme;
	}

	/**
	 * Vraca labelu prezime
	 * 
	 * @return JLabel prezime
	 */
	private JLabel getLblPrezime() {
		if (lblPrezime == null) {
			lblPrezime = new JLabel("Prezime");
			lblPrezime.setBounds(5, 110, 147, 25);
		}
		return lblPrezime;
	}

	/**
	 * Vraca tekstualno polje u kome je upisano prezime igraca
	 * 
	 * @return JTextField prezime
	 */
	private JTextField getTextFieldPrezime() {
		if (textFieldPrezime == null) {
			textFieldPrezime = new JTextField();
			textFieldPrezime.setBounds(162, 110, 147, 25);
			textFieldPrezime.setColumns(10);
		}
		return textFieldPrezime;
	}

	/**
	 * Vraca panel koji se skroluje
	 * 
	 * @return JScrollPane
	 */
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(5, 182, 432, 240);
			scrollPane.setViewportView(getTextAreaRangLista());
			scrollPane.setColumnHeaderView(getBtnDodaj());
		}
		return scrollPane;
	}

	/**
	 * Vraca tekstualno polje za viseredni ispis u kome je rangl lista
	 * 
	 * @return JTextArea rang lista
	 */
	private JTextArea getTextAreaRangLista() {
		if (textAreaRangLista == null) {
			textAreaRangLista = new JTextArea();
			textAreaRangLista.setEditable(false);
			textAreaRangLista.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
					"Rang lista", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		}
		return textAreaRangLista;
	}

	/**
	 * Vraca dugme koje unosi novi rezultat u rang listu
	 * 
	 * @return JButton dodaj
	 */
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					boolean uneto = GUIKontroler.unesiRezultat(Integer.parseInt(textFieldVreme.getText()),
							textFieldTipIgre.getText(), textFieldIme.getText(), textFieldPrezime.getText());

					textAreaRangLista.setText(GUIKontroler.vlatiListuPrikaz());
					if (uneto)
						btnDodaj.setEnabled(false);
				}
			});
		}
		return btnDodaj;
	}

	/**
	 * Vraca panel na kome se nalazi dugme
	 * 
	 * @return JPanel panel
	 */
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(5, 146, 432, 33);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		}
		return panel;
	}
}
