package pro.sky.skyprohomework;

import java.util.Objects;

public class Employee {

    private final String firstName;
    private final String lastName;
    private final String passwordNumber;
    private final Integer yearBirth;
    private final Integer wage;
    private final Integer departmentNumber;

    public Employee(String firstName, String lastName, String passwordNumber, Integer yearBirth, Integer wage, Integer departmentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwordNumber = passwordNumber;
        this.yearBirth = yearBirth;
        this.wage = wage;
        this.departmentNumber = departmentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPasswordNumber() {
        return passwordNumber;
    }

    public Integer getYearBirth() {
        return yearBirth;
    }

    public Integer getWage() {
        return wage;
    }

    public Integer getDepartmentNumber() {
        return departmentNumber;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Employee)) return false;
        Employee employee = (Employee) object;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(passwordNumber, employee.passwordNumber) && Objects.equals(yearBirth, employee.yearBirth) && Objects.equals(wage, employee.wage) && Objects.equals(departmentNumber, employee.departmentNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, passwordNumber, yearBirth, wage, departmentNumber);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passwordNumber='" + passwordNumber + '\'' +
                ", yearBirth=" + yearBirth +
                ", wage=" + wage +
                ", departmentNumber=" + departmentNumber +
                '}';
    }
}
