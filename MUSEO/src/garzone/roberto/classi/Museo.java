package garzone.roberto.classi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Museo {

	public Museo(Scanner scSt, Scanner scDi) {
		statue = new HashMap<String, Statua>();
		Statua st = Statua.read(scSt);
		while(st != null) {
			statue.put(st.getId(), st);
			st = Statua.read(scSt);
		}
		dipinti = new HashMap<String, Dipinto>();
		Dipinto di = Dipinto.read(scDi);
		while(di != null) {
			dipinti.put(di.getId(), di);
			di = Dipinto.read(scDi);
		}
	}
	
	private Museo(HashMap<String, Statua> statue1, HashMap<String, Dipinto> dipinti1) {
		statue = statue1;
		dipinti = dipinti1;
	}

	public Museo filteredOperabyID(String id) {
		HashMap<String, Statua> stfilter = new HashMap<String, Statua>();
		HashMap<String, Dipinto> difilter = new HashMap<String, Dipinto>();
		Set<String> stkeys = statue.keySet();
		Set<String> dikeys = dipinti.keySet();
		for(String stkey : stkeys) {
			if(statue.get(stkey).getId().equals(id))
				stfilter.put(stkey, statue.get(stkey));
		}
		for(String dikey : dikeys) {
			if(dipinti.get(dikey).getId().equals(id))
				difilter.put(dikey, dipinti.get(dikey));
		}
		return new Museo(stfilter, difilter);
	}
		
	public Museo filteredOperabyNomeSala(String sala) {
		HashMap<String, Statua> stfilter = new HashMap<String, Statua>();
		HashMap<String, Dipinto> difilter = new HashMap<String, Dipinto>();
		Set<String> stkeys = statue.keySet();
		Set<String> dikeys = dipinti.keySet();
		for(String stkey : stkeys) {
			if(statue.get(stkey).getSala().equalsIgnoreCase(sala))
				stfilter.put(stkey, statue.get(stkey));
		}
		for(String dikey : dikeys) {
			if(dipinti.get(dikey).getSala().equalsIgnoreCase(sala))
				difilter.put(dikey, dipinti.get(dikey));
		}
		return new Museo(stfilter, difilter);
	}
	
	public Museo filteredOperabyNomeOpera(String opera) {
		HashMap<String, Statua> stfilter = new HashMap<String, Statua>();
		HashMap<String, Dipinto> difilter = new HashMap<String, Dipinto>();
		Set<String> stkeys = statue.keySet();
		Set<String> dikeys = dipinti.keySet();
		for(String stkey : stkeys) {
			if(statue.get(stkey).getOpera().equalsIgnoreCase(opera))
				stfilter.put(stkey, statue.get(stkey));
		}
		for(String dikey : dikeys) {
			if(dipinti.get(dikey).getOpera().equalsIgnoreCase(opera))
				difilter.put(dikey, dipinti.get(dikey));
		}
		return new Museo(stfilter, difilter);
	}
	
	public Museo filteredOperabyAnno(String annos) throws ParseException {
		HashMap<String, Statua> stfilter = new HashMap<String, Statua>();
		HashMap<String, Dipinto> difilter = new HashMap<String, Dipinto>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date anno = sdf.parse(annos);
		Set<String> stkeys = statue.keySet();
		Set<String> dikeys = dipinti.keySet();
		for(String stkey : stkeys) {
			if(statue.get(stkey).getAnno().equals(anno))
				stfilter.put(stkey, statue.get(stkey));
		}
		for(String dikey : dikeys) {
			if(dipinti.get(dikey).getAnno().equals(anno))
				difilter.put(dikey, dipinti.get(dikey));
		}
		return new Museo(stfilter, difilter);
	}
		
	public Museo filteredOperabyAutore(String autore) {
		HashMap<String, Statua> stfilter = new HashMap<String, Statua>();
		HashMap<String, Dipinto> difilter = new HashMap<String, Dipinto>();
		Set<String> stkeys = statue.keySet();
		Set<String> dikeys = dipinti.keySet();
		for(String stkey : stkeys) {
			if(statue.get(stkey).getAutore().equalsIgnoreCase(autore))
				stfilter.put(stkey, statue.get(stkey));
		}
		for(String dikey : dikeys) {
			if(dipinti.get(dikey).getAutore().equalsIgnoreCase(autore))
				difilter.put(dikey, dipinti.get(dikey));
		}
		return new Museo(stfilter, difilter);
	}
	
	public Museo filteredStatuabyMateriale(String materiale) {
		HashMap<String, Statua> stfilter = new HashMap<String, Statua>();
		HashMap<String, Dipinto> difilter = new HashMap<String, Dipinto>();
		Set<String> stkeys = statue.keySet();
		for(String stkey : stkeys) {
			if(statue.get(stkey).getMateriale().equalsIgnoreCase(materiale))
				stfilter.put(stkey, statue.get(stkey));
		}
		return new Museo(stfilter, difilter);
	}
	
	public Museo filteredDipintobyTecnica(String tecnica) {
		HashMap<String, Statua> stfilter = new HashMap<String, Statua>();
		HashMap<String, Dipinto> difilter = new HashMap<String, Dipinto>();
		Set<String> dikeys = dipinti.keySet();
		for(String dikey : dikeys) {
			if(dipinti.get(dikey).getTecnica().equalsIgnoreCase(tecnica))
				difilter.put(dikey, dipinti.get(dikey));
		}
		return new Museo(stfilter, difilter);
	}
	
	public Museo filteredDipintobyDimensioni(String dimensioni) {
		HashMap<String, Statua> stfilter = new HashMap<String, Statua>();
		HashMap<String, Dipinto> difilter = new HashMap<String, Dipinto>();
		Set<String> dikeys = dipinti.keySet();
		for(String dikey : dikeys) {
			if(dipinti.get(dikey).getDimensioni().equalsIgnoreCase(dimensioni))
				difilter.put(dikey, dipinti.get(dikey));
		}
		return new Museo(stfilter, difilter);
	}
	
	public void print() {
		Set<String> stkeys = statue.keySet();
		for(String stkey : stkeys)
			statue.get(stkey).print();
		Set<String> dikeys = dipinti.keySet();
		for(String dikey : dikeys)
			dipinti.get(dikey).print();
	}
	
	public void printStatua() {
		Set<String> stkeys = statue.keySet();
		for(String stkey : stkeys)
			statue.get(stkey).print();
	}
	
	public void printDipinto() {
		Set<String> dikeys = dipinti.keySet();
		for(String dikey : dikeys)
			dipinti.get(dikey).print();
	}
	
	private HashMap<String, Statua> statue;
	private HashMap<String, Dipinto> dipinti;
}
