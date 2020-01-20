/**
 * This class contains the infomations about a university's professor
 */
package classes;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import util.GraduationGradeException;

public class Professor {
	
	/** Constructor. */
	public Professor(String name, String surname, Date date, String birth_place, String residence, String fiscal_code,
			         String university, int grade, String type) {
		name = this.Name;
		surname = this.Surname;
		date = this.date;
		birth_place = this.Birth_Place;
		residence = this.Residence;
		fiscal_code = this.Fiscal_Code;
		university = this.University;
		grade = this.University_Grade;
		type = this.Type_Professor;
	}
	
	/** This method return the name of the professor. */
	public String getName() {
		return this.Name;
	}
	
	/** This method return the surname of the professor. */
	public String getSurname() {
		return this.Surname;
	}

	/** This method return the born date of the professor, */
	public Date getDate() {
		return this.date;
	}

	/** This method return the birth palce of the professor. */
	public String getBirthPlace() {
		return this.Birth_Place;
	}

	/** This method return the residece of the professor- */
	public String getResidence() {
		return this.Residence;
	}

	/** This method return the fiscal code of the professor. */
	public String getFiscalCode() {
		return this.Fiscal_Code;
	}
	
	/** This method return the university haunted by the professor. */
	public String getUniversity() {
		return this.University;
	}

	/** This method return the graduation grade of the professor. */
	public int getGraduationGrade() {
		return this.University_Grade;
	}

	/** This method return the type of the professor (ordianry or associated). */
	public String getType() {
		return this.Type_Professor;
	}

	/** This method create a new object professor. 
	 * @throws ParseException */
	public Professor read() throws ParseException {
		Scanner sc = new Scanner(System.in);
		// read the name of the professor
		System.out.println ("Insert the name of the professor.");
		String name = sc.nextLine();
		// read the surname of the professor
		System.out.println ("Insert the surname of the professor.");
		String surname = sc.nextLine();
		// read the born date of the professor
		System.out.println ("Insert the born date of the professor.");
		String dates = sc.nextLine();
		Date date;
		try {
			date = sdf.parse(dates);
		}
		catch (ParseException e) {
			System.err.println("Error! The date is wrong. " + name + " " + surname);
			System.out.println("Please insert a new date: ");
			dates = sc.nextLine();
			date = sdf.parse(dates);
		}
		// read the birth palce of the professor
		System.out.println ("Insert the bird place of the professor.");
		String birth_place = sc.nextLine();
		// read the residence of the professor
		System.out.println ("Insert the residence of the professor.");
		String residence = sc.nextLine();
		// read the fiscal code of the professor
		System.out.println ("Insert the fiscal code of the professor.");
		String fiscal_code = sc.nextLine();
		// read the university haunted by the professor
		System.out.println ("Insert the university hauted by the professor.");
		String university = sc.nextLine();
		// read the graduation grade of the professor
		System.out.println ("Insert the graduation grade of the professor (insert 112 for the laud).");
		int grade = sc.nextInt();
		if (grade < 60 || grade > 112 || grade == 111) {
			new GraduationGradeException("Error! The grade is wrong. Please insert a new grade");
			grade = sc.nextInt();
		}
		// read the type of the professor
		System.out.println ("The professor is associated or ordinary?");
		String type = sc.nextLine();
		sc.close();
		return new Professor(name, surname, date, birth_place, residence, fiscal_code, university, grade, type);
	}
	
	/** This method read a professor by the file 
	 * @throws ParseException */
	public static Professor read(Scanner sc) throws ParseException {
		// read the name of the professor
		if (!sc.hasNextLine())
			return null;
		String name = sc.nextLine();
		// read the surname of the professor
		if (!sc.hasNextLine())
			return null;
		String surname = sc.nextLine();
		// read the date of the professor
		if (!sc.hasNextLine())
			return null;
		String dates = sc.nextLine();
		Date date;
		try {
			date = ssdf.parse(dates);
		}
		catch(ParseException e) {
			System.err.println("Error! The date is wrong. " + name + " " + surname);
			System.out.println("Please insert a new date: ");
			dates = sc.nextLine();
			date = ssdf.parse(dates);
		}
		// read the bitrh place of the professor
		if (!sc.hasNextLine())
			return null;
		String birth = sc.nextLine();
		// read the residence of the professor
		if (!sc.hasNextLine())
			return null;
		String residence = sc.nextLine();
		// read the fiscal code of the professor
		if (!sc.hasNextLine())
			return null;
		String fiscal_code = sc.nextLine();
		// read the university haunted by the professor
		if (!sc.hasNextLine())
			return null;
		String university = sc.nextLine();
		// read the graduation grade of the professor
		if (!sc.hasNextLine())
			return null;
		String grades = sc.nextLine();
		int grade = Integer.parseInt(grades);
		// read the type of the professor
		if (!sc.hasNextLine())
			return null;
		String type = sc.nextLine();
		return new Professor(name, surname, date, birth, residence, fiscal_code, university, grade, type);
	}
	
	/** This method print on the screen the information about a professor */ 
	public void print() {
		System.out.println("Name			: " + this.Name);
		System.out.println("Surname			: " + this.Surname);
		System.out.println("Date			: " + this.date);
		System.out.println("Birth place		: " + this.Birth_Place);
		System.out.println("Residence		: " + this.Residence);
		System.out.println("Fiscal code		: " + this.Fiscal_Code);
		System.out.println("University		: " + this.University);
		System.out.println("Graduation gade : " + this.University_Grade);
		System.out.println("Type			: " + this.Type_Professor);
	}
	
	/** This method print on the file the information about the professor */ 
	public void print(PrintStream ps) {
		ps.println(this.Name);
		ps.println(this.Surname);
		ps.println(this.date);
		ps.println(this.Birth_Place);
		ps.println(this.Residence);
		ps.println(this.Fiscal_Code);
		ps.println(this.University);
		ps.println(this.University_Grade);
		ps.println(this.Type_Professor);
	}
		
	// Instance variables.
	private String Name, Surname, Birth_Place, Residence, Fiscal_Code, University, Type_Professor;
	private Date date;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat ssdf = new SimpleDateFormat("dd/MM/yyyy");
	private int University_Grade;
}