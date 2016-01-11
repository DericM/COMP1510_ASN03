package q1;

import java.text.NumberFormat;

/**
 * Represents a college student.
 * @author Deric
 * @version 1
 */
public class Household {
    /** Identification Number. */
	private int id;
	/** Household Income. */
	private int income;
	/** Number of residents in the house. */
	private int members;
	
	/**
    * Constructor: Sets up this household with the specified values.
    * @param id The identification number.
    * @param income The household income.
    * @param members The number of residents.
    */
	Household(int id, int income, int members) {
		this.id = id;
		this.income = income;
		this.members = members;
	}
	
    /**
    * Returns a string description of this Household object.
    * @return formatted id, income and members.
    */
	public String toString() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
        return "" + id + "\t\t" + currency.format(income) + "\t" + members;
    }
	
    /**
    * Returns a string description of this Household object.
    * minus the residents.
    * @return formatted id, income.
    */
	public String toStringIdIncome() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
        return "" + id + "\t\t" + currency.format(income);
    }
	
	/**
    * Returns an int id of the household.
    * @return id.
    */
	public int getId() {
		return id;
	}
	
	/**
    * Returns income of the household.
    * @return income.
    */
	public int getIncome() {
		return income;
	}
	
	/**
    * Returns residents of the household.
    * @return members.
    */
	public int getMembers() {
		return members;
	}
}
