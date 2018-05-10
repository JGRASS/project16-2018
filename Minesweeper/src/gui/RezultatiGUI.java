package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Toolkit;

/**
 * Prozor koji prikazuje rang listu
 * 
 * @author Vanja Vlahovic
 * @version 1.0
 */
public class RezultatiGUI extends JFrame {
	/**
	 * Panel na kome su sve komponente prozora
	 */
	private JPanel contentPane;
	/**
	 * Panel koji se skroluje
	 */
	private JScrollPane scrollPane;
	/**
	 * Tekstualno polje za viseredni ispis na kome je rang lista
	 */
	public JTextArea textArea;

	/**
	 * Kreiranje prozora.
	 */
	public RezultatiGUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RezultatiGUI.class.getResource("/icons/Throphy-512.png")));
		setTitle("Rang lista");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 386, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getScrollPane());
	}

	/**
	 * Vraca panel koji se skroluje
	 * 
	 * @return JScrollPane panel
	 */
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(5, 182, 432, 240);
			scrollPane.setViewportView(getTextAreaRangLista());
		}
		return scrollPane;
	}

	/**
	 * Vraca tekstualno polje za viseredni ispis na kome je rang lista
	 * 
	 * @return JTextArea polje
	 */
	private JTextArea getTextAreaRangLista() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
		}
		return textArea;
	}
}
