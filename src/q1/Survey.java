package q1;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <p>
 * This Class reads survey information from a file and manipulates, and prints
 * said information for ease of viewing.
 * </p>
 *
 * @author Deric
 * @version 1.0
 */
public class Survey {
	/**
	 * <p>
	 * This is the main method (entry point) that gets called by the JVM.
	 * </p>
	 *
	 * @param args
	 *            command line arguments.
	 */
	public static void main(String[] args) {
		final Integer[] lowIncomeBracket = { 22_229, 27_674, 34_022, 41_307, 46_850, 52_838, 58_827 };
		final int additional = 5_989;

		ArrayList<Household> list = new ArrayList<Household>();
		String lineFromFile;
		Scanner scan = new Scanner(System.in);
		Scanner fileScan;

		int average;
		int incomeBracket;
		int gdp = 0;
		int povertyNumber = 0;

		// read in information, put it in Household Objects,
		// then add it to the array list.
		while (scan.hasNext()) {
			lineFromFile = scan.nextLine();
			fileScan = new Scanner(lineFromFile);

			list.add(new Household(fileScan.nextInt(), fileScan.nextInt(), fileScan.nextInt()));
		}
		scan.close();

		// print off the full survey.
		printSurvey(list);

		// calculate the gdp of the survey.
		for (int i = 0; i < list.size(); i++) {
			gdp += list.get(i).getIncome();
		}
		average = gdp / list.size();

		// print off the above average households.
		printAboveAvg(list, average);

		// calculate how many are below the poverty line.
		for (int i = 0; i < list.size() - 1; i++) {
			// if they have more than 8 members use
			// this formula to get the poverty line.
			if (list.get(i).getMembers() > lowIncomeBracket.length) {
				int extra = ((list.get(i).getMembers() - lowIncomeBracket.length) * additional);
				incomeBracket = lowIncomeBracket[lowIncomeBracket.length - 1] + extra;
			}
			// else they have less than 8 members, so use the matching
			// value for the correct poverty line.
			else {
				incomeBracket = lowIncomeBracket[list.get(i).getMembers() - 1];
			}
			// check if they are below their poverty line
			if (list.get(i).getIncome() < incomeBracket) {
				povertyNumber++;
			}
		}

		// print the results
		printResults(list, povertyNumber);

		System.out.println("Question one was called and ran sucessfully.");
	}

	/**
	 * Prints the entire survey.
	 * 
	 * @param list
	 *            name and addresses of student.
	 */
	public static void printSurvey(ArrayList<Household> list) {

		System.out.println("---------------------------------------");
		System.out.println("ID\t\tINCOME\t\tMEMBERS");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		System.out.println("---------------------------------------\n");
	}

	/**
	 * Prints the above average .
	 * 
	 * @param list
	 *            name and addresses of student.
	 * @param average
	 *            number of averages
	 */
	public static void printAboveAvg(ArrayList<Household> list, int average) {

		System.out.println("------------ABOVE AVERAGE--------------");
		System.out.println("ID\t\tINCOME");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIncome() > average) {
				System.out.println(list.get(i).toStringIdIncome());
			}
		}
		System.out.println("---------------------------------------\n");
	}

	/**
	 * Prints the results .
	 * 
	 * @param list
	 *            name and addresses of student.
	 * @param povertyNumber
	 *            number of households below poverty
	 */
	public static void printResults(ArrayList<Household> list, int povertyNumber) {
		NumberFormat percent = NumberFormat.getPercentInstance();
		percent.setMinimumFractionDigits(1);
		System.out.println("Accounts below poverty level:" + povertyNumber);
		System.out.print("Percentage of households below the (LICO) level:");
		System.out.println(percent.format(1.0 * povertyNumber / list.size()) + "\n");
	}

};
