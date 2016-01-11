package q3;

/**
 * <p>This class exercises the student class and its methods.</p>
 *
 * @author Deric
 * @version 1.0
 */
public class TestStudent {
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // your code will go here!!!
    	Address ad1 = new Address("6162 Fredrick Ave", "Burnaby", "BC", "12345"); 
    	Address ad2 = new Address("1234 Some Street", "Burnaby", "BC", "54321"); 
    	Address ads = new Address("School Ave", "Burnaby", "BC", "77777");
    	
    	Student test1 = new Student("Jimmy", "Jimjim", ad1, ads, new int [] {20, 25, 30 });
    	Student test2 = new Student("Some", "Body", ad2, ads);
    	
    	System.out.println(test1);
    	System.out.println(test2);
    	
    	final int score1 = 75;
    	final int score2 = 80;
    	final int score3 = 83;
    	
    	test2.setTestScore(1, score1);
    	test2.setTestScore(2, score2);
    	test2.setTestScore(3, score3);
    	
    	System.out.println(test1);
    	System.out.println(test2);
    	
        System.out.println("Question three was called and ran sucessfully.");
    }

};
