package garzone.roberto.classi;

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
import java.util.Locale;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MuseoArrayList {
	public MuseoArrayList(Scanner scSt, Scanner scDi) {
		statue = new ArrayList<Statua>();
		Statua st = Statua.read(scSt);
		while(st != null) {
			statue.add(st);
			st = Statua.read(scSt);
		}
		dipinti = new ArrayList<Dipinto>();
		Dipinto di = Dipinto.read(scDi);
		while(di != null) {
			dipinti.add(di);
			di = Dipinto.read(scDi);
		}
	}
	
	private MuseoArrayList(ArrayList<Statua> statue1, ArrayList<Dipinto> dipinti1) {
		statue = statue1;
		dipinti = dipinti1;
	}

	public void addStatua() throws FileNotFoundException, ParseException {
		FileOutputStream file = new FileOutputStream("statue.txt", true);
		PrintStream ps = new PrintStream(file);
		
		JFrame frame = new JFrame();
		JTextField text1 = new JTextField("			");
		JTextField text2 = new JTextField("			");
		JTextField text3 = new JTextField("			");
		JTextField text4 = new JTextField("			");
		JTextField text5 = new JTextField("			");
		JTextField text6 = new JTextField("			");
		JLabel label1 = new JLabel("ID: ");
		JLabel label2 = new JLabel("Nome sala: ");
		JLabel label3 = new JLabel("Nome statua: ");
		JLabel label4 = new JLabel("Anno di pubblicazione (aaaa): ");
		JLabel label5 = new JLabel("Nome autore: ");
		JLabel label6 = new JLabel("Materiale: ");
		JButton button1 = new JButton("OK");
		JButton button2 = new JButton("ANNULLA");
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		frame.setLayout(layout);
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.gridx = 0;
		c.gridy = 0;
		layout.setConstraints(label1, c);
		frame.add(label1);
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 1;
		layout.setConstraints(text1, c);
		frame.add(text1);
		c.gridx = 0;
		c.gridy = 1;
		layout.setConstraints(label2, c);
		frame.add(label2);
		c.gridx = 3;
		c.gridy = 1;
		c.gridwidth = 3;
		c.gridheight = 1;
		layout.setConstraints(text2, c);
		frame.add(text2);
		c.gridx = 0;
		c.gridy = 2;
		layout.setConstraints(label3, c);
		frame.add(label3);
		c.gridx = 3;
		c.gridy = 2;
		c.gridwidth = 3;
		c.gridheight = 1;
		layout.setConstraints(text3, c);
		frame.add(text3);
		c.gridx = 0;
		c.gridy = 3;
		layout.setConstraints(label4, c);
		frame.add(label4);
		c.gridx = 3;
		c.gridy = 3;
		c.gridwidth = 3;
		c.gridheight = 1;
		layout.setConstraints(text4, c);
		frame.add(text4);
		c.gridx = 0;
		c.gridy = 4;
		layout.setConstraints(label5, c);
		frame.add(label5);
		c.gridx = 3;
		c.gridy = 4;
		c.gridwidth = 3;
		c.gridheight = 1;
		layout.setConstraints(text5, c);
		frame.add(text5);
		c.gridx = 0;
		c.gridy = 5;
		layout.setConstraints(label6, c);
		frame.add(label6);
		c.gridx = 3;
		c.gridy = 5;
		c.gridwidth = 3;
		c.gridheight = 1;
		layout.setConstraints(text6, c);
		frame.add(text6);
		c.gridx = 3;
		c.gridy = 6;
		layout.setConstraints(button1, c);
		frame.add(button1);
		c.gridx = 0;
		c.gridy = 6;
		layout.setConstraints(button2, c);
		frame.add(button2);
		
		class Ok implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				Date anno;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
				try {
					anno = sdf.parse(text4.getText());
					Statua st = new Statua(text1.getText(), text2.getText(), text3.getText(), anno, text5.getText(), text6.getText());
					st.print(ps);
				}
				catch(ParseException e) {
				}
				JFrame frameAdd = new JFrame();
				JLabel labelAdd = new JLabel("STATUA AGGIUNTA");
				frameAdd.add(labelAdd, BorderLayout.CENTER);
				frameAdd.setSize(500, 500);
				frameAdd.setVisible(true);
				frameAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
		
		class Annulla implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				frame.toBack();
			}
		}
		
		ActionListener listener1 = new Ok();
		ActionListener listener2 = new Annulla();
		button1.addActionListener(listener1);
		button2.addActionListener(listener2);
		frame.setSize(700, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addDipinto() throws FileNotFoundException, ParseException {
		FileOutputStream file = new FileOutputStream("dipinti.txt", true);
		PrintStream ps = new PrintStream(file);
		
		JFrame frame = new JFrame();
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button1 = new JButton("OK");
		JButton button2 = new JButton("ANNULLA");
		JLabel label1 = new JLabel("ID:");
		JLabel label2 = new JLabel("Nome della sala:");
		JLabel label3 = new JLabel("Nome del dipinto:");
		JLabel label4 = new JLabel("Anno di pubblicazione (aaaa):");
		JLabel label5 = new JLabel("Nome dell'autore:");
		JLabel label6 = new JLabel("Tecnica:");
		JLabel label7 = new JLabel("Dimensioni (base x altezza):");
		JTextField text1 = new JTextField("			");
		JTextField text2 = new JTextField("			");
		JTextField text3 = new JTextField("			");
		JTextField text4 = new JTextField("			");
		JTextField text5 = new JTextField("			");
		JTextField text6 = new JTextField("			");
		JTextField text7 = new JTextField("			");
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		frame.setLayout(layout);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		layout.setConstraints(label1, c);
		frame.add(label1);
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 1;
		layout.setConstraints(text1, c);
		frame.add(text1);
		c.gridx = 0;
		c.gridy = 1;
		layout.setConstraints(label2, c);
		frame.add(label2);
		c.gridx = 3;
		c.gridy = 1;
		c.gridwidth = 3;
		c.gridheight = 1;
		layout.setConstraints(text2, c);
		frame.add(text2);
		c.gridx = 0;
		c.gridy = 2;
		layout.setConstraints(label3, c);
		frame.add(label3);
		c.gridx = 3;
		c.gridy = 2;
		c.gridwidth = 3;
		c.gridheight = 1;
		layout.setConstraints(text3, c);
		frame.add(text3);
		c.gridx = 0;
		c.gridy = 3;
		layout.setConstraints(label4, c);
		frame.add(label4);
		c.gridx = 3;
		c.gridy = 3;
		c.gridwidth = 3;
		c.gridheight = 1;
		layout.setConstraints(text4, c);
		frame.add(text4);
		c.gridx = 0;
		c.gridy = 4;
		layout.setConstraints(label5, c);
		frame.add(label5);
		c.gridx = 3;
		c.gridy = 4;
		c.gridwidth = 3;
		c.gridheight = 1;
		layout.setConstraints(text5, c);
		frame.add(text5);
		c.gridx = 0;
		c.gridy = 5;
		layout.setConstraints(label6, c);
		frame.add(label6);
		c.gridx = 3;
		c.gridy = 5;
		c.gridwidth = 3;
		c.gridheight = 1;
		layout.setConstraints(text6, c);
		frame.add(text6);
		c.gridx = 0;
		c.gridy = 6;
		layout.setConstraints(label7, c);
		frame.add(label7);
		c.gridx = 3;
		c.gridy = 6;
		c.gridwidth = 3;
		c.gridheight = 1;
		layout.setConstraints(text7, c);
		frame.add(text7);
		c.gridx = 0;
		c.gridy = 7;
		layout.setConstraints(button1, c);
		frame.add(button1);
		c.gridx = 3;
		c.gridy = 7;
		layout.setConstraints(button2, c);
		frame.add(button2);
		class Annulla implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				frame.toBack();
			}
		}
		class Ok implements ActionListener {
			public void actionPerformed(ActionEvent ev) {
				Date anno;
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy", Locale.ITALY);
					anno = sdf.parse(text4.getText());
					Dipinto di = new Dipinto(text1.getText(), text2.getText(), text3.getText(), anno, text5.getText(), text6.getText(),text7.getText());
					di.print(ps);
				}
				catch(ParseException e) {
				}
				JFrame frameAdd = new JFrame();
				JLabel labelAdd = new JLabel("DIPINTO AGGIUNTO");
				frameAdd.add(labelAdd, BorderLayout.CENTER);
				frameAdd.setSize(500, 500);
				frameAdd.setVisible(true);
				frameAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
		ActionListener listener1 = new Ok();
		ActionListener listener2 = new Annulla();
		button1.addActionListener(listener1);
		button2.addActionListener(listener2);
	}
	
	public MuseoArrayList filteredOperabyID(String id) {
		ArrayList<Statua> stfilter = new ArrayList<Statua>();
		ArrayList<Dipinto> difilter = new ArrayList<Dipinto>();
		for(Statua st : statue) {
			if(st.getId().equals(id))
				stfilter.add(st);
		}
		for(Dipinto di : dipinti) {
			if(di.getId().equals(id))
				difilter.add(di);
		}
		return new MuseoArrayList(stfilter, difilter);
	}
		
	public MuseoArrayList filteredOperabyNomeSala(String sala) {
		ArrayList<Statua> stfilter = new ArrayList<Statua>();
		ArrayList<Dipinto> difilter = new ArrayList<Dipinto>();
		for(Statua st : statue) {
			if(st.getSala().equalsIgnoreCase(sala))
				stfilter.add(st);
		}
		for(Dipinto di : dipinti) {
			if(di.getSala().equalsIgnoreCase(sala))
				difilter.add(di);
		}
		return new MuseoArrayList(stfilter, difilter);
	}
	
	public MuseoArrayList filteredOperabyNomeOpera(String opera) {
		ArrayList<Statua> stfilter = new ArrayList<Statua>();
		ArrayList<Dipinto> difilter = new ArrayList<Dipinto>();
		for(Statua st : statue) {
			if(st.getOpera().equalsIgnoreCase(opera))
				stfilter.add(st);
		}
		for(Dipinto di : dipinti) {
			if(di.getOpera().equalsIgnoreCase(opera))
				difilter.add(di);
		}
		return new MuseoArrayList(stfilter, difilter);
	}
	
	public MuseoArrayList filteredOperabyAnno(String annos) throws ParseException {
		ArrayList<Statua> stfilter = new ArrayList<Statua>();
		ArrayList<Dipinto> difilter = new ArrayList<Dipinto>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date anno = sdf.parse(annos);
		for(Statua st : statue) {
			if(st.getAnno().equals(anno))
				stfilter.add(st);
		}
		for(Dipinto di : dipinti) {
			if(di.getAnno().equals(anno))
				difilter.add(di);
		}
		return new MuseoArrayList(stfilter, difilter);
	}
		
	public MuseoArrayList filteredOperabyAutore(String autore) {
		ArrayList<Statua> stfilter = new ArrayList<Statua>();
		ArrayList<Dipinto> difilter = new ArrayList<Dipinto>();
		for(Statua st : statue) {
			if(st.getAutore().equalsIgnoreCase(autore))
				stfilter.add(st);
		}
		for(Dipinto di : dipinti) {
			if(di.getAutore().equalsIgnoreCase(autore))
				difilter.add(di);
		}
		return new MuseoArrayList(stfilter, difilter);
	}
	
	public MuseoArrayList filteredStatuabyMateriale(String materiale) {
		ArrayList<Statua> stfilter = new ArrayList<Statua>();
		ArrayList<Dipinto> difilter = new ArrayList<Dipinto>();
		for(Statua st : statue) {
			if(st.getMateriale().equalsIgnoreCase(materiale))
				stfilter.add(st);
		}
		return new MuseoArrayList(stfilter, difilter);
	}
	
	public MuseoArrayList filteredDipintobyTecnica(String tecnica) {
		ArrayList<Statua> stfilter = new ArrayList<Statua>();
		ArrayList<Dipinto> difilter = new ArrayList<Dipinto>();
		for(Dipinto di : dipinti) {
			if(di.getTecnica().equalsIgnoreCase(tecnica))
				difilter.add(di);
		}
		return new MuseoArrayList(stfilter, difilter);
	}
	
	public MuseoArrayList filteredDipintobyDimensioni(String dimensioni) {
		ArrayList<Statua> stfilter = new ArrayList<Statua>();
		ArrayList<Dipinto> difilter = new ArrayList<Dipinto>();
		for(Dipinto di : dipinti) {
			if(di.getDimensioni().equalsIgnoreCase(dimensioni))
				difilter.add(di);
		}
		return new MuseoArrayList(stfilter, difilter);
	}

	public void CercaOperabyID() {
		JFrame frame = new JFrame();
		JLabel label = new JLabel("Inserisci l'ID");
		JTextField text = new JTextField("     	");
		JButton button = new JButton("Cerca");
		JButton button2 = new JButton("Annulla");
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
		c.gridy = 1;
		c.gridx = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		layout.setConstraints(button, c);
		frame.add(button);
		c.gridx = 0;
		c.gridy = 1;		
		c.gridheight = 1;
		c.gridwidth = 2;
		layout.setConstraints(button2, c);
		frame.add(button2);
		class Cerca implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				MuseoArrayList museo = filteredOperabyID(text.getText());
				museo.printSuFrame();
			}
		}
		class Annulla implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				frame.toBack();
			}
		}
		ActionListener listener = new Cerca();
		ActionListener listener2 = new Annulla();
		button.addActionListener(listener);
		button2.addActionListener(listener2);
		frame.setSize(300, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void CercaOperabyNomeSala() {
		JFrame frame = new JFrame();
		JLabel label = new JLabel("Inserisci il nome della sala: ");
		JTextField text = new JTextField("			");
		JButton button = new JButton("Cerca");
		JButton button2 = new JButton("Annulla");
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
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
		c.gridx = 5;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		layout.setConstraints(button, c);
		frame.add(button);
		c.gridx = 0;
		c.gridy = 1;		
		c.gridheight = 1;
		c.gridwidth = 2;
		layout.setConstraints(button2, c);
		frame.add(button2);
		class Cerca implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				MuseoArrayList museo = filteredOperabyNomeSala(text.getText());
				museo.printSuFrame();
			}
		}
		class Annulla implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				frame.toBack();
			}
		}
		ActionListener listener = new Cerca();
		ActionListener listener2 = new Annulla();
		button.addActionListener(listener);
		button2.addActionListener(listener2);
		frame.setSize(650, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	public void CercaOperabyNomeOpera() {
		JFrame frame = new JFrame();
		JLabel label = new JLabel("Inserisi il nome dell'opera: ");
		JTextField text = new JTextField("			");
		JButton button = new JButton("Cerca");
		JButton button2 = new JButton("Annulla");
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		frame.setLayout(layout);
		c.gridx = 0;
		c.gridy = 0;
		layout.setConstraints(label, c);
		frame.add(label);
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 1;
		layout.setConstraints(text, c);
		frame.add(text);
		c.gridx = 5;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		layout.setConstraints(button, c);
		frame.add(button);
		c.gridx = 0;
		c.gridy = 1;		
		c.gridheight = 1;
		c.gridwidth = 2;
		layout.setConstraints(button2, c);
		frame.add(button2);
		class Cerca implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				MuseoArrayList museo = filteredOperabyNomeOpera(text.getText());
				museo.printSuFrame();
			}
		}
		class Annulla implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				frame.toBack();
			}
		}
		ActionListener listener = new Cerca();
		ActionListener listener2 = new Annulla();
		button.addActionListener(listener);
		button2.addActionListener(listener2);
		frame.setSize(650, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void CercaOperabyAnnoDiPubblicazione() {
		JFrame frame = new JFrame();
		JLabel label = new JLabel("Inserisci l'anno di pubblicazione: ");
		JTextField text = new JTextField("			");
		JButton button = new JButton("Cerca");
		JButton button2 = new JButton("Annulla");
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		frame.setLayout(layout);
		c.gridx = 0;
		c.gridy = 0;
		layout.setConstraints(label, c);
		frame.add(label);
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 1;
		layout.setConstraints(text, c);
		frame.add(text);
		c.gridx = 5;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		layout.setConstraints(button, c);
		frame.add(button);
		c.gridx = 0;
		c.gridy = 1;		
		c.gridheight = 1;
		c.gridwidth = 2;
		layout.setConstraints(button2, c);
		frame.add(button2);
		class Cerca implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				try {
					MuseoArrayList museo = filteredOperabyAnno(text.getText());
					museo.printSuFrame();
				} catch (ParseException e) {
				}
			}
		}
		class Annulla implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				frame.toBack();
			}
		}
		ActionListener listener = new Cerca();
		ActionListener listener2 = new Annulla();
		button.addActionListener(listener);
		button2.addActionListener(listener2);
		frame.setSize(650, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void CercaOperabyNomeAutore() {
		JFrame frame = new JFrame();
		JLabel label = new JLabel("Inserisci il nome dell'autore: ");
		JTextField text = new JTextField("			");
		JButton button = new JButton("Cerca");
		JButton button2 = new JButton("Annulla");
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		frame.setLayout(layout);
		c.gridx = 0;
		c.gridy = 0;
		layout.setConstraints(label, c);
		frame.add(label);
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 1;
		layout.setConstraints(text, c);
		frame.add(text);
		c.gridx = 5;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		layout.setConstraints(button, c);
		frame.add(button);
		c.gridx = 0;
		c.gridy = 1;		
		c.gridheight = 1;
		c.gridwidth = 2;
		layout.setConstraints(button2, c);
		frame.add(button2);
		class Cerca implements ActionListener {
			public void actionPerformed(ActionEvent event) {
					MuseoArrayList museo = filteredOperabyAutore(text.getText());
					museo.printSuFrame();
			}
		}
		class Annulla implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				frame.toBack();
			}
		}
		ActionListener listener = new Cerca();
		ActionListener listener2 = new Annulla();
		button.addActionListener(listener);
		button2.addActionListener(listener2);
		frame.setSize(650, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void CercaDipintobyDimensioni() {
		JFrame frame = new JFrame();
		JLabel label = new JLabel("Inserisci le dimensioni del dipinto: ");
		JTextField text = new JTextField("			");
		JButton button = new JButton("Cerca");
		JButton button2 = new JButton("Annulla");
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		frame.setLayout(layout);
		c.gridx = 0;
		c.gridy = 0;
		layout.setConstraints(label, c);
		frame.add(label);
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 1;
		layout.setConstraints(text, c);
		frame.add(text);
		c.gridx = 5;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		layout.setConstraints(button, c);
		frame.add(button);
		c.gridx = 0;
		c.gridy = 1;		
		c.gridheight = 1;
		c.gridwidth = 2;
		layout.setConstraints(button2, c);
		frame.add(button2);
		class Cerca implements ActionListener {
			public void actionPerformed(ActionEvent event) {
					MuseoArrayList museo = filteredDipintobyDimensioni(text.getText());
					museo.printSuFrame();
			}
		}
		class Annulla implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				frame.toBack();
			}
		}
		ActionListener listener = new Cerca();
		ActionListener listener2 = new Annulla();
		button.addActionListener(listener);
		button2.addActionListener(listener2);
		frame.setSize(650, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void CercaDipintobyTecnica() {
		JFrame frame = new JFrame();
		JLabel label = new JLabel("Inserisci il tipo di tecnica: ");
		JTextField text = new JTextField("			");
		JButton button = new JButton("Cerca");
		JButton button2 = new JButton("Annulla");
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		frame.setLayout(layout);
		c.gridx = 0;
		c.gridy = 0;
		layout.setConstraints(label, c);
		frame.add(label);
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 1;
		layout.setConstraints(text, c);
		frame.add(text);
		c.gridx = 5;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		layout.setConstraints(button, c);
		frame.add(button);
		c.gridx = 0;
		c.gridy = 1;		
		c.gridheight = 1;
		c.gridwidth = 2;
		layout.setConstraints(button2, c);
		frame.add(button2);
		class Cerca implements ActionListener {
			public void actionPerformed(ActionEvent event) {
					MuseoArrayList museo = filteredDipintobyTecnica(text.getText());
					museo.printSuFrame();
			}
		}
		class Annulla implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				frame.toBack();
			}
		}
		ActionListener listener = new Cerca();
		ActionListener listener2 = new Annulla();
		button.addActionListener(listener);
		button2.addActionListener(listener2);
		frame.setSize(650, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void CercaStatuabyMateriale() {
		JFrame frame = new JFrame();
		JLabel label = new JLabel("Inserisci il materiale della statua: ");
		JTextField text = new JTextField("			");
		JButton button = new JButton("Cerca");
		JButton button2 = new JButton("Annulla");
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
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
		c.gridx = 5;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		layout.setConstraints(button, c);
		frame.add(button);
		c.gridx = 0;
		c.gridy = 1;		
		c.gridheight = 1;
		c.gridwidth = 1;
		layout.setConstraints(button2, c);
		frame.add(button2);
		class Cerca implements ActionListener {
			public void actionPerformed(ActionEvent event) {
					MuseoArrayList museo = filteredStatuabyMateriale(text.getText());
					museo.printStatuaSuFrame();
			}
		}
		class Annulla implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				frame.toBack();
			}
		}
		ActionListener listener = new Cerca();
		ActionListener listener2 = new Annulla();
		button.addActionListener(listener);
		button2.addActionListener(listener2);
		frame.setSize(650, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void print() {
		for(Statua st : statue)
			st.print();
		for(Dipinto di : dipinti)
			di.print();
	}

	public void printStatua() {
		for(Statua st : statue)
			st.print();
	}
	
	public void printDipinto() {
		for(Dipinto di : dipinti)
			di.print();
	}
	
	public void printSuFrame() {
		this.printStatuaSuFrame();
		this.printDipintoSuFrame();
	}

	public void printStatuaSuFrame() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		for(Statua st : statue) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String annos = sdf.format(st.getAnno());
			JTextField text = new JTextField();
			text.setText(st.getId() + "\n" + st.getSala() + "\n" + st.getOpera() + "\n" + annos + "\n" + st.getAutore() + "\n" + st.getMateriale());
			
			GridLayout layout = new GridLayout(6, 1);
			frame.setLayout(layout);
			panel.add(text);
			
			frame.add(panel);
		}
		JScrollPane scroll = new JScrollPane(panel);
		frame.getContentPane().add(scroll);
		frame.setSize(450, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}
	
	public void printDipintoSuFrame() {
		JFrame frame = new JFrame();
		for(Dipinto di : dipinti) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String annos = sdf.format(di.getAnno());
			JLabel label = new JLabel();
			label.setText(di.getId() + " " + di.getSala() + " " + di.getOpera() + " " + annos + " " + di.getAutore() + " " + di.getTecnica() + " " + di.getDimensioni());
			GridLayout layout = new GridLayout(6, 1);
			frame.setLayout(layout);
			frame.add(label);
		}
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}
	
	private ArrayList<Statua> statue;
	private ArrayList<Dipinto> dipinti;

}
