package q4;

import java.text.DecimalFormat;
import java.util.Scanner;

import q3.Student;
import q3.Address;

/**
 * <p>This Class creates Student objects from a text file and adds,
 * them to a Course Object.</p>
 *
 * @author Deric
 * @version 1.0
 */
public class TestCourse {
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
		
    	Course javaProgram = new Course("Introduction To Programing");
		
    	String lineFromFile;
		Scanner scan = new Scanner(System.in);
		Scanner fileScan;
		
		//read from file, create to objects.
		while(scan.hasNext()){
			
			String first, second, street;
			
			lineFromFile = scan.nextLine();
			fileScan = new Scanner(lineFromFile);
			
			first = fileScan.next();
			second = fileScan.next();
			
			street = fileScan.next() + " " + fileScan.next() + " " + fileScan.next();
			Address ad1 = new Address(street, fileScan.next(), fileScan.next(), fileScan.next());
			
			street = fileScan.next() + " " + fileScan.next() + " " + fileScan.next();
			Address ad2 = new Address(street, fileScan.next(), fileScan.next(), fileScan.next());
			
			int [] scores = new int [] {fileScan.nextInt(), fileScan.nextInt(), fileScan.nextInt()};
			
			Student st = new Student(first, second, ad1, ad2, scores);
			
			javaProgram.addStudent(st);
		}
		scan.close();
    	
		//print results
		System.out.println("Course: " + javaProgram.getName() + "\n");
		System.out.print(javaProgram.roll());
		DecimalFormat df = new DecimalFormat("0.00");
		df.setMinimumFractionDigits(0);
		System.out.println("Course Average: " + df.format(javaProgram.average()) + "%\n");
    	
        System.out.println("Question four was called and ran sucessfully.");
    }

};
