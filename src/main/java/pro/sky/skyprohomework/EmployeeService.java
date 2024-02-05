package pro.sky.skyprohomework;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static final int EMPLOYEE_COUNT = 10;
    private int addedEmployees = 0;
    private final List<Employee> employees = new ArrayList<>(List.of());

    public Employee addEmployee(String firstName, String lastName) {
        if (addedEmployees >= EMPLOYEE_COUNT) {
            throw new EmployeeStorageIsFullException("Сотрудник уже зарегистрирован");
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Хранилище заполнено");
        }
        employees.add(employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee target = new Employee(firstName, lastName);
        if (employees.remove(target)) {
            throw new EmployeeNotFoundException("СОтрудник не найден");
        }
        return target;
    }
    public Employee containsEmployee(String firstName, String lastName) {
        Employee target = new Employee(firstName, lastName);
        int targetId = employees.indexOf(target);
        if (targetId < 0) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employees.get(targetId);
    }

    public List<Employee> getEmployees() {
        return null;
    }
}
