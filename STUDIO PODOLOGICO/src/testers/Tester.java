package testers;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import classes.Manager;

/**
 * Questa classe testa il programma.
 * @author robertogarzone
 */
public class Tester {
	public static void main(String args[]) throws FileNotFoundException, ParseException {
		// inizializzo lo Scanner e la classe Manager per scrivere sul file o leggere da esso.
		Scanner sc = new Scanner(new File("prenotazioni.txt"));
		Manager manager = new Manager(sc);
		
		// Inizializzo il frame.
		JFrame frame = new JFrame("HOME");
		// Inizializzo l'etichetta.
		JLabel label_scelta = new JLabel("Scegli l'operazione");
		// Inizializzo i bottoni per scegliere l'operazione adatta.
		JButton button_add = new JButton("Inserisci un nuovo paziente");
		JButton button_elimina = new JButton("Elimina un paziente");
		JButton button_cf = new JButton("Cerca un paziente dal codice fiscale");
		JButton button_nome = new JButton("Cerca un paziente dal nome");
		JButton button_cognome = new JButton("Cerca un paziente dal cognome");
		JButton button_tipo = new JButton("Cerca un paziente dal tipo di visita");
		JButton button_giorno = new JButton("Cerca un paziente dal giorno della visita");
		JButton button_esc = new JButton("EXIT");
		
		// Manage the layout of the frame.
		GridLayout layout = new GridLayout(9, 1, 0, 10);
		frame.setLayout(layout);
		
		// Add the components to the frame.
		frame.add(label_scelta);
		frame.add(button_add);
		frame.add(button_elimina);
		frame.add(button_cf);
		frame.add(button_nome);
		frame.add(button_cognome);
		frame.add(button_tipo);
		frame.add(button_giorno);
		frame.add(button_esc);
		
		// Implements the function of the buttons.
		class Add implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				try {
					manager.addPaziente();
				}
				catch(FileNotFoundException e) {
				}
			}
		}
		
		class Elimina implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				manager.eliminaPaziente();
			}
		}
		
		class CodiceFiscale implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				manager.searchPazientebyCodiceFiscale();
			}
		}
		
		class Name implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				manager.searchPazientebyNome();
			}
		}
		
		class Surname implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				manager.searchPazientebyCognome();
			}
		}
		
		class Type implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				manager.searchPazientebyTipoDiVisita();;
			}
		}
		
		class Day implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				manager.searchPazientebyGiornoDellaVisita();;
			}
		}
		
		class Exit implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		}
		
		// Initialize the classes
		ActionListener listener_add = new Add();
		ActionListener listener_elimina = new Elimina();
		ActionListener listener_cf = new CodiceFiscale();
		ActionListener listener_nome = new Name();
		ActionListener listener_cognome = new Surname();
		ActionListener listener_tipo = new Type();
		ActionListener listener_giorno = new Day();
		ActionListener listener_exit = new Exit();
		
		// Connect the buttons with the classes.
		button_add.addActionListener(listener_add);
		button_elimina.addActionListener(listener_elimina);
		button_cf.addActionListener(listener_cf);
		button_nome.addActionListener(listener_nome);
		button_cognome.addActionListener(listener_cognome);
		button_tipo.addActionListener(listener_tipo);
		button_giorno.addActionListener(listener_giorno);
		button_esc.addActionListener(listener_exit);
		
		// Define the frame.
		frame.setSize(500,  1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
