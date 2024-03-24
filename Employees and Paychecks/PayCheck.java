package cs 2n;

/**
 * PayCheck class to calculate the employee paycheck for a week using rate, hours.
 * @author Yusuf Abdi
 */
public class PayCheck {
	private String name;
	private double rate;
	private double hours;
	private double totalPay;
	
	/**
	 * Create a paycheck object with employee details and calculate the total weekly pay for later use.
	 * @param name of the employee
	 * @param rate as hourly charges of employee
	 * @param hours of total work done by the employee
	 */
	public PayCheck(String name, double rate, double hours) {
		this.name = name;
		this.rate = rate;
		this.hours = hours;
		totalPay = getTotalPay();
	}
	
	/**
	 * Calculate the weekly pay and allocate bonus if the working hours exceed 40 hours limit.
	 * @return total weekly payment of the employee
	 */
	public double getTotalPay() {
		double total = 0;
		if(hours >40) {
			total = 40 * rate;
			double remainingHours = hours - 40;
			double incrementedRate =  rate * 1.5;
			total += (remainingHours * incrementedRate);
		}else {
			total = hours * rate;
		}
		return total;
	}
	
	/**
	 * Formated the paycheck details as string.
	 * @return a formatted payment as $xxx.yy
	 */
	@Override
	public String toString() {
		return String.format("$%3.2f", totalPay);
	}
}
