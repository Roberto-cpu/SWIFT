package garzone.roberto.classi;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Opera {
	
	public Opera() {}
	
	public Opera(String id, String sala, String opera, Date anno, String autore) {
		this.id = id;
		this.sala = sala;
		this.opera = opera;
		this.anno = anno;
		this.autore = autore;
	}
	
	public String getId() {
		return id;
	}
	
	public String getSala() {
		return sala;
	}
	
	public String getOpera() {
		return opera;
	}
	
	public String getAutore() {
		return autore;
	}
	
	public Date getAnno() {
		return anno;
	}

	public static Opera read() throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci l'id dell'opera.");
		String id = sc.nextLine();
		System.out.println("Inserisci il nome della sala.");
		String sala = sc.nextLine();
		System.out.println("Inserisci il nome dell'opera.");
		String opera = sc.nextLine();
		System.out.println("Inserisci l'anno di pubblicazione.");
		String annos = sc.nextLine();
		Date anno = sdf.parse(annos);
		System.out.println("Inserisci il nome ed il cognome dell'autore.");
		String autore = sc.nextLine();
		sc.close();
		return new Opera(id, sala, opera, anno, autore);
	}
	
	public static Opera read(Scanner sc) {
		if(!sc.hasNextLine())
			return null;
		String id = sc.nextLine();
		if(!sc.hasNextLine())
			return null;
		String sala = sc.nextLine();
		if(!sc.hasNextLine())
			return null;
		String opera = sc.nextLine();
		if(!sc.hasNextLine())
			return null;
		String annos = sc.nextLine();
		Date anno;
		try {
			anno = sdf.parse(annos);
		}
		catch(ParseException e) {
			System.out.println("Errore");
			anno = new Date();
		}
		if(!sc.hasNextLine())
			return null;
		String autore = sc.nextLine();
		return new Opera(id, sala, opera, anno, autore);
	}
	
	public void print(PrintStream ps) {
		ps.println(this.id);
		ps.println(this.sala);
		ps.println(this.opera);
		String annos = sdf1.format(this.anno);
		ps.println(annos);
		ps.println(this.autore);
	}
	
	public void print() {
		System.out.println("ID dell'opera: " + this.id);
		System.out.println("Nome della sala: " + this.sala);
		System.out.println("Nome dell'opera: " + this.opera);
		String annos = sdf1.format(this.anno);
		System.out.println("Anno di pubblicazione: " + annos);
		System.out.println("Autore: " + this.autore);
	}
	
	protected String id, sala, opera, autore;
	protected Date anno;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	private SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy");
}
