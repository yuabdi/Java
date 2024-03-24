
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//mport util.Gender;
//import util.Organization;

/**
 * This class represents an organization with employees.
 */

public class OrganizationImpl implements Organization {
    private Employee root;

    public String toString() {
        return root.toString();
    }

    public OrganizationImpl(String nameCEO, double pay, Gender gender) {
        root = new InternalEmployee(nameCEO, pay, gender); // InternalEmployee are supervisor of them-self
    }

    /**
     * Add an employee to this organization with the given specifics and
     * supervisor. This employee will not be added to the organization if the
     * supervisor cannot be found.
     *
     * @param name           name of employee to be added
     * @param pay            the annual pay of this employee
     * @param gender         the gender of this employee
     * @param supervisorName the name of the supervisor. The supervisor should
     *                       be an existing employee
     */
    @Override
    public void addEmployee(String name, double pay, Gender gender, String supervisorName) {
        Employee newEmployee = new NonManagerEmployee(name, pay, gender);
        root = root.addSupervisee(supervisorName, newEmployee);
    }

    public void addEmployee(Employee newEmployee, String supervisorName) {// bob, "Ug the Terrible"
        //Employee newEmployee = new NonManagerEmployee(name,pay,gender);
        root = root.addSupervisee(supervisorName, newEmployee);
        System.out.println("'" + newEmployee.getName() + "' has been added as an employee under the supervision of '" + supervisorName + "'");

    }

    public void removeEmployee(Employee employee, String supervisorName) {

        root.removeSupervisee(supervisorName, employee);
    }

    /**
     * Add a contract employee to this organization with the given specifics
     * and supervisor. This employee will not be added to the organization if the
     * supervisor cannot be found.
     *
     * @param name           name of employee to be added
     * @param pay            the annual pay of this employee
     * @param gender         the gender of this employee
     * @param endDate        the date on which this employee's contract ends
     * @param endMonth       the month in which this employee's contract ends
     * @param endYear        the year in which this employee's contract ends
     * @param supervisorName the name of the supervisor. The supervisor should
     *                       be an existing employee
     */
    @Override
    public void addContractEmployee(String name, double pay, Gender gender, int
            endDate, int endMonth, int endYear, String supervisorName) {
        Employee newEmployee = new ContractEmployee(name, pay, gender, endDate, endMonth,
                endYear);
        root = root.addSupervisee(supervisorName, newEmployee);
    }

    /**
     * Get the size of the organization, i.e. the total number of employees in
     * this organization.
     *
     * @return the number of employees in this organization
     */

    @Override
    public int getSize() {

        return root.count(b -> true);
    }

    public int getSize(Predicate<Employee> predicate) {

        return root.count(predicate);
    }

    /**
     * Get the number of employees of the specified gender in this organization.
     *
     * @param gender the specific gender that must be counted
     * @return the number of employees of the specified gender in this
     * organization
     */

    @Override
    public int getSizeByGender(Gender gender) {

        return root.count(b -> b.getGender() == gender);
    }

    /**
     * Get a list of names of all employees in this organization.
     *
     * @return a list of names of all employees as a list of {@link String}
     */

    @Override
    public List<String> allEmployees() {
        return root.toList().stream().map(e -> e.getName()).collect(Collectors
                .toList());
    }

    /**
     * Get a list of names of all employees in this organization.
     *
     * @param predicate predicate
     * @return a list of names of all employees as a list of {@link String}
     */
    @Override
    public List<String> allEmployees(Predicate<Employee> predicate) {
        return root.toList(predicate).stream().map(e -> e.getName()).collect(Collectors
                .toList());
    }

    /**
     * print all employee of the organization
     */
    public void printEmployees() {

        root.printEmployees();
    }
}

