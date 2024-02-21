package pro.sky.skyprohomework;

import java.util.Collection;
import java.util.Map;

public interface EmployeeService {

//    Employee add(String firstName, String lastName, String passwordNumber, Integer yearBirth, Employee employee);

//    Employee add(String firstName, String lastName, String passwordNumber, Integer yearBirth);

    Map add(String firstName, String lastName, String passwordNumber, Integer yearBirth, Employee employee);

    Employee remove(String firstName, String lastName, String passwordNumber);

    Employee find(String firstName, String lastName, String passwordNumber);

    Map<String, Employee> allEmployeeInfo();

    Employee maxWageDepartment(Integer departmentNumber);

    Employee minWageDepartment(Integer departmentNumber);

    String allEmployeeGroup(Integer department);
}
