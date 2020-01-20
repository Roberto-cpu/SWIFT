package garzone.roberto.classi;

import java.io.PrintStream;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Statua extends Opera{

	public Statua(String id, String sala, String opera, Date anno, String autore, String materiale) {
		super(id, sala, opera, anno, autore);
		this.materiale = materiale;
	}
	
	public String getMateriale() {
		return materiale;
	}

	public static Statua read() throws ParseException {
		Opera opera = Opera.read();
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci il materiale usato.");
		String materiale = sc.next();
		sc.close();
		return new Statua(opera.id, opera.sala, opera.opera, opera.anno, opera.autore, materiale);
	}
	
	public static Statua read(Scanner sc) {
		Opera opera = Opera.read(sc);
		if(!sc.hasNextLine())
			return null;
		String materiale = sc.nextLine();
		return new Statua(opera.id, opera.sala, opera.opera, opera.anno, opera.autore, materiale);
	}

	public void print(PrintStream ps) {
		super.print(ps);
		ps.println(this.materiale);
	}
	
	public void print() {
		super.print();
		System.out.println("Materiale: " + this.materiale);
	}
	
	private String materiale;
}
