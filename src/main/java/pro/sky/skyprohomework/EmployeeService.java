package pro.sky.skyprohomework;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private static final int EMPLOYEE_COUNT = 10;
    private int addedEmployees = 0;
    private final Map<String,Employee> employees = new HashMap<>();

    public Employee addEmployee(String firstName, String lastName) {
        if (addedEmployees >= EMPLOYEE_COUNT) {
            throw new EmployeeStorageIsFullException("Сотрудник уже зарегистрирован");
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Хранилище заполнено");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee target = new Employee(firstName, lastName);
        if (employees.containsKey(target.getFullName())) {
            return employees.remove(target.getFullName());
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }
    public Employee containsEmployee(String firstName, String lastName) {
        Employee target = new Employee(firstName, lastName);
        if (employees.containsKey(target.getFullName())) {
            return employees.get(target.getFullName());
        }
        throw new EmployeeNotFoundException("");
    }


    public List<Employee> getEmployees() {
        return null;
    }
}
