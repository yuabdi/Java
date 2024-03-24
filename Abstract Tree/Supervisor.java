//package organization;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

//import util.Gender;

/**
 * This class represents an employee in a supervisory role. This means that this
 * employee supervises at least one other employee
 */
public class Supervisor extends GenericEmployee {

    private List<Employee> superviseeList;

    public Supervisor(String name, double pay, Gender gender) {
        super(name, pay, gender);
        superviseeList = new LinkedList<Employee>();
    }
    /**
     * Add supervisee to this organization with the given specifics and
     * supervisor. This supervisee will not be added to the organization if the
     * supervisor cannot be found.
     * @return this supervisee.
     *
     */

    @Override
    public Employee addSupervisee(String supervisorName, Employee supervisee) {
        if (this.name.equals(supervisorName)) {
            this.superviseeList.add(supervisee);
            return this;
        }
        for (int i = 0; i < this.superviseeList.size(); i++) {
            this.superviseeList.set(
                    i,
                    this.superviseeList.get(i).addSupervisee(supervisorName,
                            supervisee));
        }
        return this;
    }


    /**
     * Terminate an survisee to this organization with the given specifics.
     * If the supervisee doesn't exist, return false else return true.
     * @param name name of employee to be added
     */
    @Override
    public Employee removeSupervisee(String supervisorName, Employee supervisee) {
        if (this.name.equals(supervisorName)) {
            this.superviseeList.remove(supervisee);
            return this;
        }
        for (int i = 0; i < this.superviseeList.size(); i++) {
            this.superviseeList.set(
                    i,
                    this.superviseeList.get(i).removeSupervisee(supervisorName,
                            supervisee));
        }
        return this;
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
        Stream<Employee> stream = this.superviseeList.stream();
        return this.superviseeList.stream()
                .mapToInt(b -> b.count(condition))
                .sum()
                + super.count(condition);
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
        for (Employee e : superviseeList) {
            result.addAll(e.toList());
        }
        return result;
    }

    @Override
    public List<Employee> toList(Predicate<Employee> predicate) {
        List<Employee> result = new ArrayList<Employee>();

        if (predicate.test(this)) result.add(this);

        for (Employee e : superviseeList) {
            result.addAll(e.toList(predicate));
        }
        return result;
    }
    // print employee base on root
    public void printEmployees() {
        System.out.println("SUPERVISOR " + this);

        for (Employee e : superviseeList) {
            e.printEmployees();
        }
    }
}