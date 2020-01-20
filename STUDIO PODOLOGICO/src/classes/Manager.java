package classes;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * Questa classe gestisce le funzioni del programma.
 * @author robertogarzone
 */
public class Manager {

	/**
	 * Costruttore.
	 * @param sc: Scanner
	 * @throws ParseException
	 */
	public Manager(Scanner sc) throws ParseException {
		pazienti = new ArrayList<Paziente>();
		Paziente pa = Paziente.read(sc);
		while(pa != null) {
			pazienti.add(pa);
			pa = Paziente.read(sc);
		}
	}
	
	
	/**
	 * Costruttore per filtri.
	 * @param pazienti1: ArrayList
	 */
	private Manager(ArrayList<Paziente> pazienti1) {
		pazienti = pazienti1;
	}
	
	
	/**
	 * Questo metodo aggiunge un paziente.
	 * @throws FileNotFoundException
	 */
	public void addPaziente() throws FileNotFoundException {
		// cerco un file su cui scrivere.
		FileOutputStream file = new FileOutputStream("prenotazioni.txt", true);
		// stampo sul file.
		PrintStream ps = new PrintStream(file);
		
		// creo una finestra denominata "Aggiungi Paziente".
		JFrame frame = new JFrame("AGGIUNGI PAZIENTE");
		
		// implemento lo spazio per inserire informazioni
		JTextField text_cf = new JTextField("");
		JTextField text_nome = new JTextField("");
		JTextField text_cognome = new JTextField("");
		JTextField text_telefono = new JTextField("");
		JTextField text_tipo = new JTextField("");
		JTextField text_giorno = new JTextField("");
		
		// implemento le etichette.
		JLabel label_cf = new JLabel("Codice Fiscale:");
		JLabel label_nome = new JLabel("Nome:");
		JLabel label_cognome = new JLabel("Cognome:");
		JLabel label_telefono = new JLabel("Telefono:");
		JLabel label_tipo = new JLabel("Tipo di visita:");
		JLabel label_giorno = new JLabel("Giorno della visita:");
		
		// implemento due bottoni per avviare o annullare l'inserimento.
		JButton OK = new JButton("OK");
		JButton ANNULLA = new JButton("ANNULLA");
		
		// implements a layout manager.
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		frame.setLayout(gbl);
		c.fill = GridBagConstraints.HORIZONTAL;
		
		// organize the frame.
		c.gridx = 0;
		c.gridy = 1;
		gbl.setConstraints(label_cf, c);
		frame.add(label_cf);
		c.gridx = 3;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 3;
		gbl.setConstraints(text_cf, c);
		frame.add(text_cf);
		
		c.gridx = 0;
		c.gridy = 2;
		gbl.setConstraints(label_nome, c);
		frame.add(label_nome);
		c.gridx = 3;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 3;
		gbl.setConstraints(text_nome, c);
		frame.add(text_nome);
		
		c.gridx = 0;
		c.gridy = 3;
		gbl.setConstraints(label_cognome, c);
		frame.add(label_cognome);
		c.gridx = 3;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 3;
		gbl.setConstraints(text_cognome, c);
		frame.add(text_cognome);
		
		c.gridx = 0;
		c.gridy = 4;
		gbl.setConstraints(label_telefono, c);
		frame.add(label_telefono);
		c.gridx = 3;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 3;
		gbl.setConstraints(text_telefono, c);
		frame.add(text_telefono);
		
		c.gridx = 0;
		c.gridy = 5;
		gbl.setConstraints(label_tipo, c);
		frame.add(label_tipo);
		c.gridx = 3;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 3;
		gbl.setConstraints(text_tipo, c);
		frame.add(text_tipo);		
		
		c.gridx = 0;
		c.gridy = 6;
		gbl.setConstraints(label_giorno, c);
		frame.add(label_giorno);
		c.gridx = 3;
		c.gridy = 6;
		c.gridheight = 1;
		c.gridwidth = 3;
		gbl.setConstraints(text_giorno, c);
		frame.add(text_giorno);		
		
		c.gridx = 0;
		c.gridy = 7;
		gbl.setConstraints(OK, c);
		frame.add(OK);
		
		c.gridx = 3;
		c.gridy = 7;
		gbl.setConstraints(ANNULLA, c);
		frame.add(ANNULLA);
		
		// Implements the classes for the buttons.
		class Ok implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				
				Date giorno;
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				try {
					giorno = sdf.parse(text_giorno.getText());
					Paziente pa = new Paziente(text_cf.getText(), text_nome.getText(), text_cognome.getText(), text_telefono.getText(), text_tipo.getText(), giorno);
					pa.print(ps);
				}
				catch(ParseException e) {
				}
			}
		}
		
		class Annulla implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				frame.toBack();
			}
		}
		
		// connects the classes with the buttons.
		ActionListener listenerOk = new Ok();
		ActionListener listenerAnnulla = new Annulla();
		OK.addActionListener(listenerOk);
		ANNULLA.addActionListener(listenerAnnulla);
		
		// Define the frame.
		frame.setSize(700, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	/**
	 * Questo metodo consente di eliminare un paziente.
	 */
	public void eliminaPaziente() {
		JFrame frame = new JFrame();
		JLabel label = new JLabel("Inserisci il codice fiscale del paziente");
		JTextField text = new JTextField("");
		JButton buttonOk = new JButton("OK");
		JButton buttonAnnulla = new JButton("ANNULLA");
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		frame.setLayout(layout);
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.gridx = 0;
		c.gridy = 0;
		layout.setConstraints(label, c);
		frame.add(label);
		
		c.gridx = 3;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 3;
		layout.setConstraints(text, c);
		frame.add(text);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 2;
		layout.setConstraints(buttonOk, c);
		frame.add(buttonOk);
		
		c.gridx = 3;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 2;
		layout.setConstraints(buttonAnnulla, c);
		frame.add(buttonAnnulla);
		
		class Ok implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				JFrame frame = new JFrame();
				JLabel label = new JLabel("Sei sicuro di vole eliminare il paziente?\nPremere SI per procedere.");
				JButton buttonSi = new JButton("SI");
				JButton buttonNo = new JButton("NO");
				
				frame.add(label, BorderLayout.CENTER);
				frame.add(buttonNo, BorderLayout.SOUTH);
				frame.add(buttonSi, BorderLayout.SOUTH);
				
				class Si implements ActionListener {
					@SuppressWarnings("unlikely-arg-type")
					public void actionPerformed(ActionEvent event) {
						Manager manager = filteredPazientebyCodiceFiscale(text.getText());
						pazienti.remove(manager);
					}
				}
				
				class No implements ActionListener {
					public void actionPerformed(ActionEvent event) {
						frame.toBack();
					}
				}
				
				ActionListener listenerSi = new Si();
				ActionListener listenerNo = new No();
				buttonSi.addActionListener(listenerSi);
				buttonNo.addActionListener(listenerNo);
				
				frame.setSize(300, 300);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
		
		class Annulla implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				frame.toBack();
			}
		}
		
		ActionListener listenerOk = new Ok();
		ActionListener listenerAnnulla = new Annulla();
		buttonOk.addActionListener(listenerOk);
		buttonAnnulla.addActionListener(listenerAnnulla);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	/**
	 * Questo metodo cerca un paziente dal codice fiscale.
	 * @param codice: String
	 * @return Manager(ArrayList<Paziente>)
	 */
	public Manager filteredPazientebyCodiceFiscale(String codice) {
		// inizializzo l'array.
		ArrayList<Paziente> pafilter = new ArrayList<Paziente>();
		// cerco il paziente.
		for(Paziente pa : pazienti) {
			if(pa.getCodiceFiscale().equals(codice)) {
				// salvo il paziente nell'array.
				pafilter.add(pa);
			}
		}
		// restituisco un nuovo oggetto della classe Manager.
		return new Manager(pafilter);
	}
	
	
	/**
	 * Questo metodo cerca un paziente dal nome
	 * @param nome: String
	 * @return Manager(ArrayList<Paziente>)
	 */
	public Manager filteredPazientebyNome(String nome) {
		// inizializzo un array.
		ArrayList<Paziente> pafilter = new ArrayList<Paziente>();
		// cerco un paziente.
		for (Paziente pa : pazienti) {
			if (pa.getNome().equalsIgnoreCase(nome))
				// salvo il paziente nel'array.
				pafilter.add(pa);
		}
		// restituisce un nuovo oggetto della classe Manager.
		return new Manager(pafilter);
	}
	
	
	/**
	 * Questo metodo cerca un paziente dal cognome.
	 * @param cognome: String
	 * @return Manager(ArrayList<Paziente>)
	 */
	public Manager filteredPazientebyCognome(String cognome) {
		// inizializzo un array.
		ArrayList<Paziente> pafilter = new ArrayList<Paziente>();
		// cerco un paziente.
		for (Paziente pa : pazienti) {
			if (pa.getCognome().equalsIgnoreCase(cognome))
				// salvo il paziente nell'array.
				pafilter.add(pa);
		}
		// restituisco un oggetto della classe Manager.
		return new Manager(pafilter);
	}
	
	
	/**
	 * Questo metodo cerca un paziente dal tipo di visita.
	 * @param tipo: String
	 * @return Manager(ArrayList<Paziente>)
	 */
	public Manager filteredPazientebyTipoDiVisita(String tipo) {
		// inizializzo l'array.
		ArrayList<Paziente> pafilter = new ArrayList<Paziente>();
		// cerco un paziente.
		for (Paziente pa : pazienti) {
			if (pa.getVisita().equalsIgnoreCase(tipo))
				// salvo il paziente nell'array.
				pafilter.add(pa);
		}
		// restituisco un nuovo oggetto della classe Manager.
		return new Manager(pafilter);
	}
	
	
	/**
	 * Questo metodo cerca un paziente dal giorno in cui è prenotata la visita
	 * @param giornos: String
	 * @return Manager(ArrayList<Paziente>)
	 * @throws ParseException
	 */
	public Manager filteredPazientebyGiornoDellaVisita(String giornos) throws ParseException {
		// inizializzo l'array.
		ArrayList<Paziente> pafilter = new ArrayList<Paziente>();
		// inizializzo il format del giorno.
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date giorno;
		// formatto il giorno.
		giorno = sdf.parse(giornos);
		// cerco un paziente.
		for (Paziente pa : pazienti) {
			if (pa.getGiornoDellaVisita().equals(giorno))
				// salvo il paziente nell'array.
				pafilter.add(pa);
		}
		// resituisco un oggetto della classe Manager.
		return new Manager(pafilter);
	}
	
	
	/**
	 * Questo metodo esegue la ricerca dal codice fiscale, su frame. 
	 */
	public void searchPazientebyCodiceFiscale() {
		JFrame frame = new JFrame("CERCA DAL CODICE FISCALE");
		JLabel label = new JLabel("Inserisci il codice fiscale del paziente");
		JTextField text = new JTextField("");
		JButton buttonOk = new JButton("OK");
		JButton buttonAnnulla = new JButton("ANNULLA");
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints  c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		frame.setLayout(layout);
		
		c.gridx = 0;
		c.gridy = 0;
		layout.setConstraints(label, c);
		frame.add(label);
		
		c.gridx = 3;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 3;
		layout.setConstraints(text, c);
		frame.add(text);
		
		c.gridx = 0;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		layout.setConstraints(buttonOk, c);
		frame.add(buttonOk);
		
		c.gridx = 3;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		layout.setConstraints(buttonAnnulla, c);
		frame.add(buttonAnnulla);
		
		class Ok implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				Manager manager = filteredPazientebyCodiceFiscale(text.getText());
				manager.printOnFrame();
			}
		}
		
		class Annulla implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				frame.toBack();
			}
		}
		
		ActionListener listenerOk = new Ok();
		ActionListener listenerAnnulla = new Annulla();
		buttonOk.addActionListener(listenerOk);
		buttonAnnulla.addActionListener(listenerAnnulla);
		
		frame.setVisible(true);
		frame.setSize(450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	/**
	 * Questo metodo esegue la funzione di ricerca di un paziente dal nome in un frame.
	 */
	public void searchPazientebyNome() {
		JFrame frame = new JFrame("CERCA DAL NOME");
		JLabel label = new JLabel("Inserisci il nome del paziente");
		JTextField text = new JTextField("");
		JButton buttonOk = new JButton("OK");
		JButton buttonAnnulla = new JButton("ANNULLA");
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints  c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		frame.setLayout(layout);
		
		c.gridx = 0;
		c.gridy = 0;
		layout.setConstraints(label, c);
		frame.add(label);
		
		c.gridx = 3;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 3;
		layout.setConstraints(text, c);
		frame.add(text);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		layout.setConstraints(buttonOk, c);
		frame.add(buttonOk);
		
		c.gridx = 3;
		c.gridy = 3;		
		c.gridheight = 1;
		c.gridwidth = 1;
		layout.setConstraints(buttonAnnulla, c);
		frame.add(buttonAnnulla);
		
		class Ok implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				Manager manager = filteredPazientebyNome(text.getText());
				manager.printOnFrame();
			}
		}
		
		class Annulla implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				frame.toBack();
			}
		}
		
		ActionListener listenerOk = new Ok();
		ActionListener listenerAnnulla = new Annulla();
		
		buttonOk.addActionListener(listenerOk);
		buttonAnnulla.addActionListener(listenerAnnulla);
		
		frame.setSize(300, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	/**
	 * Questo metodo esegue la funzione di ricerca di un paziente dal cognome in un frame.
	 */
	public void searchPazientebyCognome() {
		JFrame frame = new JFrame("CERCA DAL COGNOME");
		JLabel label = new JLabel("Inserisci il cognome del paziente");
		JTextField text = new JTextField("");
		JButton buttonOk = new JButton("OK");
		JButton buttonAnnulla = new JButton("ANNULLA");
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints  c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		frame.setLayout(layout);
		
		c.gridx = 0;
		c.gridy = 0;
		layout.setConstraints(label, c);
		frame.add(label);
		
		c.gridx = 3;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 3;
		layout.setConstraints(text, c);
		frame.add(text);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		layout.setConstraints(buttonOk, c);
		frame.add(buttonOk);
		
		c.gridx = 3;
		c.gridy = 3;		
		c.gridheight = 1;
		c.gridwidth = 1;
		layout.setConstraints(buttonAnnulla, c);
		frame.add(buttonAnnulla);
		
		class Ok implements ActionListener {
			public void actionPerformed(ActionEvent event) {
			Manager manager = filteredPazientebyCognome(text.getText());
				manager.printOnFrame();
			}
		}
		
		class Annulla implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				frame.toBack();
			}
		}
		
		ActionListener listenerOk = new Ok();
		ActionListener listenerAnnulla = new Annulla();
		
		buttonOk.addActionListener(listenerOk);
		buttonAnnulla.addActionListener(listenerAnnulla);
		
		frame.setSize(500, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	/**
	 * Questo metodo esegue la funzione di ricerca di un paziente dal tipo di visita in un frame.
	 */
	public void searchPazientebyTipoDiVisita() {
		JFrame frame = new JFrame("CERCA DAL TIPO DI VISITA");
		JLabel label = new JLabel("Inserisci il tipo di visita");
		JTextField text = new JTextField("");
		JButton buttonOk = new JButton("OK");
		JButton buttonAnnulla = new JButton("ANNULLA");
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints  c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		frame.setLayout(layout);
		
		c.gridx = 0;
		c.gridy = 0;
		layout.setConstraints(label, c);
		frame.add(label);
		
		c.gridx = 3;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 3;
		layout.setConstraints(text, c);
		frame.add(text);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		layout.setConstraints(buttonOk, c);
		frame.add(buttonOk);
		
		c.gridx = 3;
		c.gridy = 3;		
		c.gridheight = 1;
		c.gridwidth = 1;
		layout.setConstraints(buttonAnnulla, c);
		frame.add(buttonAnnulla);
		
		class Ok implements ActionListener {
			public void actionPerformed(ActionEvent event) {
			Manager manager = filteredPazientebyTipoDiVisita(text.getText());
				manager.printOnFrame();
			}
		}
		
		class Annulla implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				frame.toBack();
			}
		}
		
		ActionListener listenerOk = new Ok();
		ActionListener listenerAnnulla = new Annulla();
		
		buttonOk.addActionListener(listenerOk);
		buttonAnnulla.addActionListener(listenerAnnulla);
		
		frame.setSize(600, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	/**
	 * Questo metodo esegue la funzione di ricerca di un paziente dal giorno della visita in un frame.
	 */
	public void searchPazientebyGiornoDellaVisita() {
		JFrame frame = new JFrame("CERCA DAL GIORNO DELLA VISITA");
		JLabel label = new JLabel("Inserisci il giorno interessato (gg/mm/aaaa)");
		JTextField text = new JTextField("");
		JButton buttonOk = new JButton("OK");
		JButton buttonAnnulla = new JButton("ANNULLA");
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints  c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		frame.setLayout(layout);
		
		c.gridx = 0;
		c.gridy = 0;
		layout.setConstraints(label, c);
		frame.add(label);
		
		c.gridx = 3;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 3;
		layout.setConstraints(text, c);
		frame.add(text);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		layout.setConstraints(buttonOk, c);
		frame.add(buttonOk);
		
		c.gridx = 3;
		c.gridy = 3;		
		c.gridheight = 1;
		c.gridwidth = 1;
		layout.setConstraints(buttonAnnulla, c);
		frame.add(buttonAnnulla);
		
		class Ok implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				Manager manager;
				try {
					manager = filteredPazientebyGiornoDellaVisita(text.getText());
					manager.printOnFrame();
				} 
				catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		
		class Annulla implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				frame.toBack();
			}
		}
		
		ActionListener listenerOk = new Ok();
		ActionListener listenerAnnulla = new Annulla();
		
		buttonOk.addActionListener(listenerOk);
		buttonAnnulla.addActionListener(listenerAnnulla);
		
		frame.setSize(700, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	/**
	 * Questo metodo stampa i dati sul monitor.
	 */
	public void print() {
		for(Paziente pa : pazienti) {
			pa.print();
		}
	}
	
	
	/**
	 * Questo metodo stampa i dati su un frame.
	 */
	public void printOnFrame() {
		JFrame frame = new JFrame("RISULTATI");
		JPanel panel = new JPanel();
		for (Paziente pa : pazienti) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String giornos = sdf.format(pa.getGiornoDellaVisita());
			JLabel label = new JLabel();
			label.setText(pa.getCodiceFiscale() + "\n" + pa.getNome() + "\n" + pa.getCognome() + "\n" + pa.getNumeroDiTelefono() + "\n" + pa.getVisita() + "\n" + giornos + "\n");
			panel.add(label);
		}
		JScrollPane scroll = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		frame.add(scroll);

		JButton button_annulla = new JButton("ANNULLA");
		GridLayout layout_frame = new GridLayout(2, 1);
		frame.setLayout(layout_frame);
		button_annulla.setSize(10, 10);
		frame.add(button_annulla, BorderLayout.PAGE_END);
		
		
		class Annulla implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				frame.toBack();
			}
		}
		
		ActionListener listener = new Annulla();
		button_annulla.addActionListener(listener);
		
		GridLayout layout_panel = new GridLayout(34, 6);
		panel.setLayout(layout_panel);
		
		panel.setSize(600, 1000);
		
		frame.setSize(600, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	// Instance variables
	private ArrayList<Paziente> pazienti;
}
