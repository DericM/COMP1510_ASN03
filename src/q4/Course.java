package q4;

import java.util.ArrayList;
import q3.Student;

/**
 * Represents a college student.
 * @author Deric
 * @version 1.0
 */
public class Course {
	
	/** Students of this course. */
	private ArrayList<Student> students;
	/** Course Name. */
	private String name;
	
    /**
    * Constructor: Sets up this course with the specified value.
    * @param name The name of the course.
    */
	Course(String name){
		this.name = name;
		students = new ArrayList<Student>();
	}
	
    /**
     * Adds a student to the course.
     * @param s The student Object to add.
     */
	public void addStudent(Student s){
		students.add(s);
	}
	
    /**
     * Returns the average scores for the course.
     * @return average test score of the entire course.
     */
	public double average(){
		double average = 0;
		for(int i = 0;i < students.size();i++){
			average += students.get(i).average();
		}
		average /= students.size();
		return average;
	}
	
    /**
    * Returns a string description of this Course object.
    * @return formatted representation of every student in the course.
    */
	public String roll(){
		String result = "";
        for(int i = 0;i < students.size();i++){
        	result += students.get(i).toString() + "\n";
   	 	}
        return result;
	}
	
    /**
    * Returns the course name.
    * @return the course name.
    */
	public String getName(){
		return name;
	}
}
