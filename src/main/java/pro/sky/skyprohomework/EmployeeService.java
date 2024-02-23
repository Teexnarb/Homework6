package pro.sky.skyprohomework;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmployeeService {
    private static final int MAX_Employees = 10;

    public final Map<String, Employee> employees=new HashMap<>();
    public void add(String firstName, String lastName, int salary, int department) {
        if (employees.size() == MAX_Employees) {
            throw new EmployeeStorageIsFullException("");
        }
        String key = buildKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeStorageIsFullException("");
        }
        employees.put(key, new Employee(firstName, lastName, salary, department));
    }

    public Employee remove(String firstName, String lastName) {
        String key = buildKey(firstName, lastName);
        Employee employee = employees.remove(key);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }
    public Employee find(String firstName, String lastName) {
        String key = buildKey(firstName, lastName);
        Employee employee = employees.remove(key);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    private String buildKey(String name, String surname) {
        return name + surname;
    }

    public Collection<Employee> findAll() {
       return Collections.unmodifiableCollection(employees.values());
    }
}
