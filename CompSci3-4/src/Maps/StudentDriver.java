/**
 *	@author G. Volger
 *	@version March 2, 2004
 *	@version Revised march 2, 2006
 *	@version Driver for School class using a HashMap
 */
package Maps;
import java.util.Scanner;

public class StudentDriver
{
	static String menu = "1  Enter student data.\n2  Remove a student\n" +
	                     "3  Edit a students grade\n4  Display all students\n" +
	                     "5  Quit";
	static Scanner consoleReader = new Scanner(System.in);
	                     
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		School students = new School();
		boolean done = false;
		do {
			boolean good = true;
			String input;
			int choice = 5;
			do {
				System.out.println();
				good = true;
				System.out.println(menu);
				System.out.print("Choice: ");
				input = consoleReader.nextLine();
				if (input == null || input.equals(""))
					good = false;
				try {
					choice = Integer.parseInt(input);
					if (choice < 1 || choice > 5)
						good = false;
				} catch (Exception e)
				{
					good = false;
				}
			} while (!good);
			System.out.println();
			switch (choice)
			{
				case 1: addStudent(students);
				        break;
				case 2: removeStudent(students);
				        break;
				case 3: editStudent(students);
				        break;
				case 4: displayStudents(students);
				        break;
				case 5: done = true;
			}
		} while (!done);
		System.exit(0);
	}
	
	public static void addStudent(School students)
	{
		System.out.print("First name of student: ");
		String first = consoleReader.nextLine();
		System.out.print("Last name of student: ");
		String last = consoleReader.nextLine();
		System.out.print("Grade name of student: ");
		String grade = consoleReader.nextLine();
		Student stu = new Student(first, last);
		students.add(stu, grade);
	}
	
	public static void removeStudent(School students)
	{
		System.out.print("First name of student: ");
		String first = consoleReader.nextLine();
		System.out.print("Last name of student: ");
		String last = consoleReader.nextLine();
		Student stu = new Student(first, last);
		if (students.remove(stu) != null)
			System.out.println(stu + " was removed from school");
		else
			System.out.println("Can't find " + stu);
	}
	
	public static void editStudent(School students)
	{
		System.out.print("First name of student: ");
		String first = consoleReader.nextLine();
		System.out.print("Last name of student: ");
		String last = consoleReader.nextLine();
		Student stu = new Student(first, last);
		if (students.find(stu))
		{
			System.out.print("New grade for student: ");
			String grade = consoleReader.nextLine();
			if (students.modify(stu, grade))
				System.out.println(stu + " grade has been changed");
			else
				System.out.println("Can't find " + stu);
		}
		else
			System.out.println("Can't find " + stu);	}
	
	public static void displayStudents(School students)
	{
		students.display();
	}
}