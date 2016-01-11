package q2;

import java.util.Random;
import java.util.Scanner;

/**
 * <p>This is a guessing game that promps the user to guess a random number
 *  between 1 and 100, and keeps asking until they guess correctly.</p>
 *
 * @author Deric
 * @version 1.0
 */
public class Guess {
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {

    	final int max = 100;
    	
        int attempt, guess, target;
        String newGame = "y";
        Scanner scan = new Scanner(System.in); 
        Random generator = new Random();
        
        do {
	        System.out.print("Guess a number between 1 and 100 or to quit enter 0: ");

	        target = generator.nextInt(max) + 1;
	        attempt = 0;
	        
	    	while (true) {
	    		guess = scan.nextInt();
	    		attempt++;
	    		
	    		if (guess == 0) {
	    			System.out.println("Thanks for trying! ");
	    			break;
	    		}
	    		else if(guess == target) {
	    			System.out.println("Congratulations! The number was " + guess);
	    			break;
	    		}
	    		else {
		            if (guess > target) {
		                System.out.print("Wrong number. Guess lower: ");
		            }
		            else {
		                System.out.print("Wrong number. Guess higher: ");
		            }
	    		}    
	        }
	    	
	    	
	    	System.out.println("You made " + attempt + " attempts.");
	    	
	    	System.out.print("New game (y/n)? "); 
	        newGame = scan.next();
	    }
	    while (newGame.equals("y")); 
        scan.close();
	    	
        System.out.println("Question two was called and ran sucessfully.");
    }

};
