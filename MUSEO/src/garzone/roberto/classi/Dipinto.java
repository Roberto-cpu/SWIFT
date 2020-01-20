package garzone.roberto.classi;

import java.io.PrintStream;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Dipinto extends Opera {

	public Dipinto(String id, String sala, String opera, Date anno, String autore, String tecnica, String dimensioni) {
		super(id, sala, opera, anno, autore);
		this.tecnica = tecnica;
		this.dimensioni = dimensioni;
	}
	
	public String getTecnica() {
		return tecnica;
	}

	public String getDimensioni() {
		return dimensioni;
	}

	public static Dipinto read() throws ParseException {
		Opera opera = Opera.read();
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci la tecnica usata.");
		String tecnica = sc.nextLine();
		System.out.println("Inserisci le dimensioni del dipinto (base x altezza).");
		String dimensioni = sc.nextLine();
		sc.close();
		return new Dipinto(opera.id, opera.sala, opera.opera, opera.anno, opera.autore, tecnica, dimensioni);
	}

	public static Dipinto read(Scanner sc) {
		Opera opera = Opera.read(sc);
		if(!sc.hasNextLine())
			return null;
		String tecnica = sc.nextLine();
		if(!sc.hasNextLine())
			return null;
		String dimensioni = sc.nextLine();
		return new Dipinto(opera.id, opera.sala, opera.opera, opera.anno, opera.autore, tecnica, dimensioni);
	}
	
	public void print(PrintStream ps) {
		super.print(ps);
		ps.println(this.tecnica);
		ps.println(this.dimensioni);
	}
	
	public void print() {
		super.print();
		System.out.println("Tecnica: " + this.tecnica);
		System.out.println("Dimensioni: " + this.dimensioni);
	}
	
	private String tecnica, dimensioni;
}
