//package organization;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//import util.Gender;

/**
 * This class represents the data and operations of any employee. It defines
 * all the operations that either ought to be common to all implementations,
 * or have a reasonable default to be overridden by them.
 */

public abstract class GenericEmployee implements Employee {
    protected String name;
    protected double pay;
    protected Gender gender;

    /**
     * Create contractor has parameters String name, double pay, and Gender gender
     * @param name
     * @param pay
     * @param gender
     */

    public GenericEmployee(String name, double pay, Gender gender) {
        this.name = name;
        this.pay = pay;
        this.gender = gender;
    }


    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Get the gender of this employee as per the organization records
     * * @return the gender of this employee as an enum {@link organization.Gender}
     */


    @Override
    public Gender getGender() {
        return this.gender;
    }

    /**
     * Get the annual pay of this employee as per the organization records
     *
     * @return the annual pay of this employee
     */

    @Override
    public double getAnnualPay() {
        return this.pay;
    }


    /**
     * By default, there is no end date for an employee. Only contract
     * employees have an actual end date.
     *
     * @return
     */
    @Override
    public String getEmploymentEndDate() {

        return "XXXXXXXX";
    }

    /**
     * Count the number of employees in this hierarchy
     * who fulfill the given predicate
     *
     * @return the number of employees in this hierarchy that fulfill the
     * given predicate
     */

    @Override
    public int count(Predicate<Employee> condition) {
        if (condition.test(this)) {
            return 1;
        }
        return 0;
    }


    /**
     * Convert the employee hierarchy into a list.
     *
     * @return the resulting list
     */

    @Override
    public List<Employee> toList() {
        List<Employee> result = new ArrayList<Employee>();
        result.add(this);
        return result;
    }

    @Override
    public List<Employee> toList(Predicate<Employee> predicate) {
        List<Employee> result = new ArrayList<Employee>();

        if (predicate.test(this)) result.add(this);

        return result;
    }
    /**
     * Generic's default value
     *
     * @return name adding,gender adding, pay.
     */

    public String toString() {
        return "Name : " + name + ", Gender : " + gender + ", Pay : " + pay;
    }

}