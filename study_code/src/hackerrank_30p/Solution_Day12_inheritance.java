package hackerrank_30p;

import java.util.Scanner;

class Person {
	protected String firstName;
	protected String lastName;
	protected int idNumber;

// Constructor
	Person(String firstName, String lastName, int identification) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}

// Print person data
	public void printPerson() {
		System.out.println("Name: " + lastName + "," + firstName + "\\nID: " + idNumber);
	}

}

class Student extends Person {
	Student(String firstName, String lastName, int identification, int[] testScores) {
		super(firstName, lastName, identification);
		
		this.testScores= testScores;
		// TODO Auto-generated constructor stub
	}

	 static private int[] testScores;

	public String calculate() {
		String d = "";
		int total=0;
		for (int i = 0; i < testScores.length; i++) {
			total += testScores[i];
		}
		
		float avg = total/testScores.length;
		
		if (avg >= 90 && avg <= 100) {
			d = "O";
		} else if (avg >= 80 && avg <90) {
			d = "E";
		} else if (avg >= 70 && avg <80) {
			d = "A";
		} else if (avg >= 55 && avg <70) {
			d = "P";
		} else if (avg >= 40&& avg <55) {
			d = "D";
		} else if (avg <40) {
			d = "T";
			
		}
		
		return d;
	}

	/*
	 * Class Constructor
	 * 
	 * @param firstName - A string denoting the Person's first name.
	 * 
	 * @param lastName - A string denoting the Person's last name.
	 * 
	 * @param id - An integer denoting the Person's ID number.
	 * 
	 * @param scores - An array of integers denoting the Person's test scores.
	 */
	// Write your constructor here

	/*
	 * Method Name: calculate
	 * 
	 * @return A character denoting the grade.
	 */
	// Write your method here
}

public class Solution_Day12_inheritance {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for (int i = 0; i < numScores; i++) {
			testScores[i] = scan.nextInt();
		}
		scan.close();

		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate());
	}
}
