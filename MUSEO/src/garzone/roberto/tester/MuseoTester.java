package garzone.roberto.tester;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

import garzone.roberto.classi.Museo;

public class MuseoTester {
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		Scanner scSt = new Scanner(new File("statue.txt"));
		Scanner scDi = new Scanner(new File("dipinti.txt"));
		Museo museo = new Museo(scSt, scDi);
		museo.print();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-----------------------");
		System.out.println("-----------------------");
		
		System.out.println("\nCerca opera dell'id");
		String id = sc.next();
		Museo m0 = museo.filteredOperabyID(id);
		m0.print();
		
		System.out.println("-----------------------");
		System.out.println("-----------------------");
		
		System.out.println("\nCerca opera dalla tipologia (Dipinto / Statua).");
		String tipologia = sc.next();
		if(tipologia.equalsIgnoreCase("Statua"))
			museo.printStatua();
		else if(tipologia.equalsIgnoreCase("Dipinto"))
			museo.printDipinto();
		else
			System.out.println("LA TIPOLOGIA INSERITA NON E' VALIDA.");
		
		System.out.println("-----------------------");
		System.out.println("-----------------------");
		
		System.out.println("\nCerca opera dal nome della sala.");
		String sala = sc.next();
		Museo m2 = museo.filteredOperabyNomeSala(sala);
		m2.print();
		
		System.out.println("-----------------------");
		System.out.println("-----------------------");
		
		System.out.println("\nCerca opera dal nome.");
		String opera = sc.next();
		Museo m3 = museo.filteredOperabyNomeOpera(opera);
		m3.print();
		
		System.out.println("-----------------------");
		System.out.println("-----------------------");
		
		System.out.println("\nCerca opera dall'anno di pubblicazione.");
		String anno = sc.next();
		Museo m4 = museo.filteredOperabyAnno(anno);
		m4.print();
		
		System.out.println("-----------------------");
		System.out.println("-----------------------");
		
		System.out.println("\nCerca opera dall'autore.");
		String autore = sc.next();
		Museo m5 = museo.filteredOperabyAutore(autore);
		m5.print();
		
		System.out.println("-----------------------");
		System.out.println("-----------------------");
		
		System.out.println("\nCerca statua dal materiale.");
		String materiale = sc.nextLine();
		Museo m6 = museo.filteredStatuabyMateriale(materiale);
		m6.printStatua();
		
		System.out.println("-----------------------");
		System.out.println("-----------------------");
		
		System.out.println("\nCerca dipinto dalla tecnica.");
		String tecnica = sc.nextLine();
		Museo m7 = museo.filteredDipintobyTecnica(tecnica);
		m7.printDipinto();
		
		System.out.println("-----------------------");
		System.out.println("-----------------------");
		
		System.out.println("\nCerca dipinto dalle dimensioni.");
		String dimensioni = sc.next();
		Museo m8 = museo.filteredDipintobyDimensioni(dimensioni);
		m8.printDipinto();
		
		sc.close();
	}
}
