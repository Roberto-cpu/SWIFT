package classes;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/** Questa classe gestisce le informazioni riguardo un paziente.*/
public class Paziente {

	/**
	 * Costruttore.
	 * @param codicefiscale: String
	 * @param nome: String
	 * @param cognome: String
	 * @param tel: String
	 * @param tipo: String
	 * @param giorno: Date
	 */
	public Paziente(String codicefiscale, String nome, String cognome, String tel, String tipo, Date giorno) {
		this.CodiceFiscale = codicefiscale;
		this.Nome = nome;
		this.Cognome = cognome;
		this.Telefono = tel;
		this.Tipo = tipo;
		this.Giorno = giorno;
	}
	
	/**
	 * Questo metodo resituisce il codice fiscale del paziente.
	 * @return
	 */
	public String getCodiceFiscale() {
		return this.CodiceFiscale;
	}
	
	/**
	 * Questo metodo restituisce il nome di un paziente.
	 * @return Nome: String
	 */
	public String getNome() {
		return this.Nome;
	}
	
	/**
	 * Questo metodo restituisce il cognome di un paziente.
	 * @return Cognome: String
	 */
	public String getCognome() {
		return this.Cognome;
	}
	
	/**
	 * Questo metodo restituisce il numero di telefono di un paziente.
	 * @return Telefono: String
	 */
	public String getNumeroDiTelefono() {
		return this.Telefono;
	}
	
	/**
	 * Questo metodo restituisce la visita prenotata.
	 * @return Tipo: String
	 */
	public String getVisita() {
		return this.Tipo;
	}
	
	/**
	 * Questo metodo restituisce il giorno in cui la visita è prenotata.
	 * @return Giorno: Date
	 */
	public Date getGiornoDellaVisita() {
		return this.Giorno;
	}
	
	/**
	 * Questo metodo modifica il codice fiscale.
	 * @param codicefiscale: String
	 */
	public void setCodiceFiscale(String codicefiscale) {
		this.CodiceFiscale = codicefiscale;
	}
	
	/**
	 * Questo metodo modifica il nome di un paziente.
	 * @param nome: String
	 */
	public void setNome(String nome) {
		this.Nome = nome;
	}
	
	/**
	 * Questo metodo modifica il cognome di un paziente.
	 * @param cognome: String
	 */
	public void setCognome(String cognome) {
		this.Cognome = cognome;
	}

	/**
	 *  Questo metodo modifica il numero di telefono di un paziente.
	 * @param telefono: String
	 */
	public void setNumeroDiTelefono(String telefono) {
		this.Telefono = telefono;
	}

	/**
	 * Questo metodo modifica il giorno in cui la visita è prenotata.
	 * @param giorno: Date
	 */
	public void setDateOfTheVisit(Date giorno) {
		this.Giorno = giorno;
	}
	
	/**
	 * Questo metodo legge le informazioni dal file.
	 * @param sc: Scanner
	 * @return new Paziente(String, String, String, String, String, Date)
	 * @throws ParseException 
	 */
	public static Paziente read(Scanner sc) throws ParseException {
		// leggi il codice fiscale del paziente.
		if(!sc.hasNextLine())
			return null;
		String codicefiscale = sc.nextLine();
		// leggi il nome del paziente.
		if(!sc.hasNextLine())
			return null;
		String nome = sc.nextLine();
		// leggi il cognome del paziente.
		if(!sc.hasNextLine())
			return null;
		String cognome = sc.nextLine();
		// leggi il numero di telefono del paziente.
		if(!sc.hasNextLine())
			return null;
		String tel = sc.nextLine();
		// leggi il tipo di visita.
		if(!sc.hasNextLine())
			return null;
		String tipo = sc.nextLine();
		// leggi il giorno in cui è prenotata la visita.
		if(!sc.hasNextLine())
			return null;
		String giornos = sc.nextLine();
		Date giorno;
		try {
			giorno = sdf.parse(giornos);
		}
		catch(ParseException e) {
			System.err.println("Insert the correct date (in the format: gg/mm/aaaa) (" + nome + "): ");
			giornos = sc.nextLine();
			giorno = sdf.parse(giornos);
		}
		// return a new object of this class.
		return new Paziente(codicefiscale, nome, cognome, tel, tipo, giorno);
	}
	
	/**
	 * Questo metodo crea un oggetto della classe Paziente.
	 * @return new Paziente(String, String, String, String, String, Date)
	 * @throws ParseException 
	 */
	public Paziente read() throws ParseException {
		// Inizializza lo scanner.
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Inserisci il codice fiscale del paziente");
		String codicefiscale = sc.nextLine();
		
		System.out.println("Inserisci il nome del paziente:");
		String nome = sc.nextLine();
		
		System.out.println("Inserisci il cognome del paziente:");
		String cognome = sc.nextLine();
	
		System.out.println("Inserisci il numero di telefono del paziente:");
		String tel = sc.nextLine();
		
		System.out.println("Inserisci il tipo di visita:");
		String tipo = sc.nextLine();
		
		System.out.println("Inserisci il giorno in cui è prenotata la visita:");
		String giornos = sc.nextLine();
		Date giorno;
		try {
			giorno = sdf1.parse(giornos);
		}
		catch (ParseException e) {
			System.out.println("Insert the correct date (in the format: dd/mm/yyyy): ");
			giornos = sc.nextLine();
			giorno = sdf1.parse(giornos); 
		}
		sc.close();
		// return a new patietn.
		return new Paziente(codicefiscale, nome, cognome, tel, tipo, giorno);
	}

	/**
	 * Questo metodo stampa le informazioni del paziente sullo schermo.
	 */
	public void print() {
		System.out.println("Codice fiscale	 	: " + this.CodiceFiscale);
		System.out.println("Nome			 	: " + this.Nome);
		System.out.println("Cognome			 	: " + this.Cognome);
		System.out.println("Numero di telefono  : " + this.Telefono);
		System.out.println("Tipo di visita    	: " + this.Tipo);
		System.out.println("Giorno della visita	: " + this.Giorno);
	}
	
	/**
	 * Questo metodo stampa le informazioni del paziente sul file.
	 * @param ps: PrintStream
	 */
	public void print(PrintStream ps) {
		ps.println(this.CodiceFiscale);
		ps.println(this.Nome);
		ps.println(this.Cognome);
		ps.println(this.Telefono);
		ps.println(this.Tipo);
		String giornos = sdf1.format(this.Giorno);
		ps.println(giornos);
	}
	
	// Instance variables
	private String CodiceFiscale, Nome, Cognome, Telefono, Tipo;
	private Date Giorno;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");	
}