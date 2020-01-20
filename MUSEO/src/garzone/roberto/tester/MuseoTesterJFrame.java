package garzone.roberto.tester;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

import garzone.roberto.classi.MuseoArrayList;

public class MuseoTesterJFrame {
	public static void main(String[] args) throws FileNotFoundException {
		/* Inizializzo lo scanner per la scrittura, la classe MuseoArrayList, la classe FileOuputStream
		 * e PrintStream per la scrittura sul file.
		 */
		Scanner scST = new Scanner(new File("statue.txt"));
		Scanner scDI = new Scanner(new File("dipinti.txt"));
		MuseoArrayList museo = new MuseoArrayList(scST, scDI);
		
		// Creo il frame principale.
		JFrame frame = new JFrame("HOME");

		// Creo i vari componenti.
		JButton button1 = new JButton("Inserisci nuovo dipinto");
		JButton button2 = new JButton("Inserisci nuova statua");
		JButton button3 = new JButton("Cerca un'opera dal ID");
		JButton button4 = new JButton("Cerca un opera dal nome della sala");
		JButton button5 = new JButton("Cerca un opera del nome");
		JButton button6 = new JButton("Cerca un'opera dall'anno di pubblicazione");
		JButton button7 = new JButton("Cerca un'opera dal nome dell'autore");
		JButton button8 = new JButton("Cerca un dipinto dalle dimensioni");
		JButton button9 = new JButton("Cerca un dipinto dalla tecnica");
		JButton button10 = new JButton("Cerca una statua dal materiale");
		JButton button11 = new JButton("Esci");
		
		// Gestisco il layout del frame.
		GridLayout layout = new GridLayout(11, 1, 0, 10);
		frame.setLayout(layout);
		
		// Aggiungo i componenti al frame:
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);
		frame.add(button5);
		frame.add(button6);
		frame.add(button7);
		frame.add(button8);
		frame.add(button9);
		frame.add(button10);
		frame.add(button11);
		
		// Gestisco l'aggiunta di un nuovo dipinto.
		class Button1 implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				try {
					museo.addDipinto();
				}
				catch (FileNotFoundException | ParseException e) { 
				}
			}
		}
		
		// Gestisco l'aggiunta di una nuova statua.
		class Button2 implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				try {
					museo.addStatua();
				}
				catch (FileNotFoundException | ParseException e) {
				}
			}
		}
		
		// Gestisco la ricerca di un'opera dall'ID.
		class Button3 implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				museo.CercaOperabyID();
			}
		}
		
		// Gestisco la ricerca di un'opera dal nome della sala.
		class Button4 implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				museo.CercaOperabyNomeSala();
			}
		}
		
		// Gestisco la ricerca di un'opera dal nome dell'opera stessa.
		class Button5 implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				museo.CercaOperabyNomeOpera();
			}
		}
		
		// Gestisco la ricerca di un'opera dall'anno di pubblicazione.
		class Button6 implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				museo.CercaOperabyAnnoDiPubblicazione();
			}
		}
		
		// Gestisco la ricerca di un'opera dal nome dell'autore.
		class Button7 implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				museo.CercaOperabyNomeAutore();
			}
		}
		
		// Gestisco la ricerca di un dipinto dalle dimensioni.
		class Button8 implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				museo.CercaDipintobyDimensioni();
			}
		}
		
		// Gestisco la ricerca di un dipinto dalla tecnica.
		class Button9 implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				museo.CercaDipintobyTecnica();
			}
		}
		
		// Gestisco la ricerca di una statua dal materiale.
		class Button10 implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				museo.CercaStatuabyMateriale();
			}
		}
		
		// Gestisco la chiusura del programma.
		class Button11 implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		}
		
		// Inizializzo le innes class.
		ActionListener listener1 = new Button1();
		ActionListener listener2 = new Button2();
		ActionListener listener3 = new Button3();
		ActionListener listener4 = new Button4();
		ActionListener listener5 = new Button5();
		ActionListener listener6 = new Button6();
		ActionListener listener7 = new Button7();
		ActionListener listener8 = new Button8();
		ActionListener listener9 = new Button9();
		ActionListener listener10 = new Button10();
		ActionListener listener11 = new Button11();
		
		// Aggiungo i listener ai bottoni.
		button1.addActionListener(listener1);
		button2.addActionListener(listener2);
		button3.addActionListener(listener3);
		button4.addActionListener(listener4);
		button5.addActionListener(listener5);
		button6.addActionListener(listener6);
		button7.addActionListener(listener7);
		button8.addActionListener(listener8);
		button9.addActionListener(listener9);
		button10.addActionListener(listener10);
		button11.addActionListener(listener11);
		
		// Definisco le dimensioni del frame principale.
		frame.setSize(500, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
