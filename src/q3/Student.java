package q3;

import java.text.DecimalFormat;

/**
 * Represents a college student.
 * @author Lewis
 * @author Loftus
 * @author Deric
 * @version 1.1
 */
public class Student {
	
	/** The maximum number of tests for this student. If more are submitted than is allowed,
	 * it will throw an exception. */
	private final int MAX_TESTS = 3;
	
    /** First name of this student. */
    private String firstName;

    /** Last name of this student. */
    private String lastName;

    /** Home address of this student. */
    private Address homeAddress;

    /** School address of this student.  Can be shared by other students */
    private Address schoolAddress;
    
    /** Test scores of this student. I used an array so that it can be adjusted if needed */
    private int [] testScores;

    /**
    * Constructor: Sets up this student with the specified values.
    * @param first The first name of the student
    * @param last The last name of the student
    * @param home The home address of the student
    * @param school The school address of the student
    */
    public Student(String first, String last, Address home, Address school, int [] testScores) {
    	//check if we need to throw exception
    	for(int i = 0;i < testScores.length;i++) {
        	checkArgument(i + 1, testScores[i]);
    	}

        firstName = first;
        lastName = last;
        homeAddress = home;
        schoolAddress = school;
        this.testScores = testScores;        
    }
    
   /**
    * Constructor: Sets up this student with the specified values.
    * @param first The first name of the student
    * @param last The last name of the student
    * @param home The home address of the student
    * @param school The school address of the student
    */
    public Student(String first, String last, Address home, Address school) {
        firstName = first;
        lastName = last;
        homeAddress = home;
        schoolAddress = school;
        testScores = new int [] {0, 0, 0};
    }
     
    
    /**
	 * Checks the arguments for inputed test scores 
	 * to make sure they are valid
	 * @param testNumber the test that will be set.
	 * @param testScore the score of the test.
	 */
    private void checkArgument(int testNumber, int testScore) {
    	boolean error1 = testNumber > MAX_TESTS;
    	boolean error2 = testScore < 0;
    	boolean error3 = testScore > 100;
    	if(error1 || error2 || error3){
    		throw new IllegalArgumentException();
    	}
    }
     
	/**
	 * Sets one test score of the student.
	 * @param testNumber the test that will be set.
	 * @param testScore the score of the test.
	 */
    public void setTestScore(int testNumber, int testScore) {
    	//check if we need to throw exception
    	checkArgument(testNumber, testScore);
    	testScores [testNumber - 1] = testScore;
    }
     
    /**
     * Returns a double average of all the test scores.
     * @return average test score of the student.
     */
	public double average() {
		double average = 0;
		for(int i = 0;i < testScores.length;i++) {
			average += testScores[i];
		}
	
		average /= testScores.length;
		return average;
	}

    /**
    * Returns a string description of this Student object.
    * @return formatted name and addresses of student.
    */
    public String toString() {
    	DecimalFormat df = new DecimalFormat("0.00");
		df.setMinimumFractionDigits(0);
   	 	
        String result;

        result = firstName + " " + lastName + "\n";
        result += "Home Address: " + homeAddress + "\n";
        result += "School Address: " + schoolAddress + "\n";
        
        for(int i = 0;i < testScores.length;i++){
        	result += "Test" + (i + 1) + ": " +  df.format(testScores[i]) + "%\n";
   	 	}
        result += "Average: " + df.format(average()) + "%\n";
        
        return result;
    }
}
