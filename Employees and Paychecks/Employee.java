package cs5004lab2ndclass;

/**
 * Employee class to store the name of employee with payment process details.
 * @author Yusuf Abdi
 *
 */
public class Employee {
	private String name;
	private double payRate;
	private double hoursWorked;
	
	/**
	 * Creates an employee object with name and hourly rate
	 * @param name of the Employee
	 * @param payRate as hourly charges
	 */
	public Employee(String name, double payRate) {
		this.name =name;
		this.payRate = payRate;
		hoursWorked = 0;
	}
	
	/**
	 * Add the working hours to the current working hours total
	 * @param hours to be added in the current working hours
	 */
	public void addHoursWorked(double hours) {
		hoursWorked += hours;
	}
	
	/**
	 * Set the working hours value to zero
	 */
	public void resetHours() {
		hoursWorked = 0;
	}
	
	/**
	 * Calculate the  weekly payment of the employee (encapsulation)
	 * @return PayCheck object containing weekly payment details
	 */
	public PayCheck getWeeklyCheck() {
		return new PayCheck(name, payRate, hoursWorked);
	}
	
	/**
	 * Create a string representation of employee and payment
	 * @return string object with employee and payment details
	 */
	@Override
	public String toString() {
		return String.format("%s %s", name, getWeeklyCheck().toString());
	}
}
