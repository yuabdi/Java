package cs5004lab2ndclass;

/**
 * Drive class. Also to create 3 instances of Employees and demonstrate, 
 * And not test, each created method for your grader.
 * @author Yusuf Abdi
 *
 */

public class Driver 
{

	public static void main(String[] args) {
		Employee e1 = new Employee("Jill", 23.00);
		Employee e2 = new Employee("John", 18.23);
		Employee e3 = new Employee("Eban", 22.78);
		e1.addHoursWorked(45);
		e2.addHoursWorked(45);
		e3.addHoursWorked(45);
		

		System.out.println("Now demonstrating constructors :" );
		System.out.print(e1 + "\n" + e2 + "\n" + e3);

	}

}