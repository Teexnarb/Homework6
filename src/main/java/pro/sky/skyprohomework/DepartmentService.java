package pro.sky.skyprohomework;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private EmployeeService employeeService;
    public void indexSalariesForDepartment(double index, int department) {
        employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .forEach(employee -> employee.setSalary((int) (employee.getSalary() + employee.getSalary() * index / 100)));
        for (Employee employee : employeeService.findAll()) {
            if (employee.getDepartment() == department) {
                employee.setSalary((int) (employee.getSalary()+employee.getSalary()*index/100));
            }
        }
    }

    public double averageSalaryForDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .average()
                .orElse(0D);
    }

    public Employee findEmployeeWithMinSalaryForDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }
    public Employee findEmployeeWithMaxSalaryForDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public double totalSalaryForDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public void printAllEmployeeFromDepartment(int department) {
        employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .forEach(employee -> System.out.printf(
                        "ФИ: %s %s, ЗП: %d%n",
                        employee.getLastName(),
                        employee.getFirstName(),
                        employee.getDepartment()));
    }

    public Employee findEmployeeWithMaxSalaryFromDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee findEmployeeWithMinSalaryFromDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Collection<Employee> findEmployeesFromDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> findEmployees(int department) {
        return employeeService.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
