package pro.sky.skyprohomework;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public final Map<String, Employee> employeeMap;

//    Employee employeeDefault1 = new Employee("Иванов", "Иван", "12345", 1980, wageValueGenerator(), departmentNumberGenerator());
//    Employee employeeDefault2 = new Employee("Петров", "Пётр", "34789", 1975, wageValueGenerator(), departmentNumberGenerator());
//    Employee employeeDefault3 = new Employee("Смирнов", "Максим", "30237", 1989, wageValueGenerator(), departmentNumberGenerator());
//    Employee employeeDefault4 = new Employee("Новая", "Мария", "48905", 1990, wageValueGenerator(), departmentNumberGenerator());
//    Employee employeeDefault5 = new Employee("Симонов", "Тимофей", "01242", 1983, wageValueGenerator(), departmentNumberGenerator());
//    Employee employeeDefault6 = new Employee("Виноградова", "Анастасия", "29384", 1991, wageValueGenerator(), departmentNumberGenerator());
//    Employee employeeDefault7 = new Employee("Неизвестный", "Никита", "45892", 1980, wageValueGenerator(), departmentNumberGenerator());
//    Employee employeeDefault8 = new Employee("Громыко", "Павел", "32947", 1995, wageValueGenerator(), departmentNumberGenerator());
//    Employee employeeDefault9 = new Employee("Ким", "Юрий", "78118", 1999, wageValueGenerator(), departmentNumberGenerator());
//    Employee employeeDefault10 = new Employee("Великий", "Антон", "32460", 2001, wageValueGenerator(), departmentNumberGenerator());
//    Employee employeeDefault11 = new Employee("Крымская", "Маргарита", "34901", 1979, wageValueGenerator(), departmentNumberGenerator());

    public EmployeeServiceImpl(Map<String, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    public int departmentNumberGenerator() {
        java.util.Random random = new java.util.Random();
        int minimumScore = 1;
        int departmentNumberGenerator = random.nextInt(5) + minimumScore;
        return departmentNumberGenerator;
    }

    public int wageValueGenerator() {
        java.util.Random random = new java.util.Random();
        int minimumScore = 100_000;
        int wageValueGenerator = random.nextInt(300_000) + minimumScore;
        return wageValueGenerator;
    }

//    @PostConstruct
//    public void init() {
//        employeeMap = new HashMap<>();
//
//        Employee employeeDefault1 = new Employee("John", "Doe", 1990);
//        employeeMap.put(employeeDefault1.getFirstName() + employeeDefault1.getLastName() + employeeDefault1.getYearBirth(), employeeDefault1);
//
//        Employee employeeDefault2 = new Employee("Jane", "Smith", 1985);
//        employeeMap.put(employeeDefault2.getFirstName() + employeeDefault2.getLastName() + employeeDefault2.getYearBirth(), employeeDefault2);
//    }


    @Override
    public Map add(String firstName, String lastName, String passwordNumber, Integer yearBirth, Employee employee) {
//        employeeMap.put(employeeDefault1.getFirstName() + employeeDefault1.getLastName() + employeeDefault1.getYearBirth(), employeeDefault1);
//        employeeMap.put(employeeDefault2.getFirstName() + employeeDefault2.getLastName() + employeeDefault2.getYearBirth(), employeeDefault2);
//        employeeMap.put(employeeDefault3.getFirstName() + employeeDefault3.getLastName() + employeeDefault3.getYearBirth(), employeeDefault3);
//        employeeMap.put(employeeDefault4.getFirstName() + employeeDefault4.getLastName() + employeeDefault4.getYearBirth(), employeeDefault4);
//        employeeMap.put(employeeDefault5.getFirstName() + employeeDefault5.getLastName() + employeeDefault5.getYearBirth(), employeeDefault5);
//        employeeMap.put(employeeDefault6.getFirstName() + employeeDefault6.getLastName() + employeeDefault6.getYearBirth(), employeeDefault6);
//        employeeMap.put(employeeDefault7.getFirstName() + employeeDefault7.getLastName() + employeeDefault7.getYearBirth(), employeeDefault7);
//        employeeMap.put(employeeDefault8.getFirstName() + employeeDefault8.getLastName() + employeeDefault8.getYearBirth(), employeeDefault8);
//        employeeMap.put(employeeDefault9.getFirstName() + employeeDefault9.getLastName() + employeeDefault9.getYearBirth(), employeeDefault9);
//        employeeMap.put(employeeDefault10.getFirstName() + employeeDefault10.getLastName() + employeeDefault10.getYearBirth(), employeeDefault10);
//        employeeMap.put(employeeDefault11.getFirstName() + employeeDefault11.getLastName() + employeeDefault11.getYearBirth(), employeeDefault11);
        if (employee == null) {
            Employee employeeNew = new Employee(firstName, lastName, passwordNumber, yearBirth, wageValueGenerator(), departmentNumberGenerator());
            String idEmployeeInfo = firstName + lastName + passwordNumber;

            if (employeeMap.containsKey(idEmployeeInfo)) {
                throw new EmployeeAlreadyAddedException("");
            }
            employeeMap.put(idEmployeeInfo, employeeNew);
//        String executionInformation = "";
//        return employee;
        } else {
            String idEmployeeInfo = firstName + lastName + passwordNumber;
            employeeMap.put(idEmployeeInfo, employee);
        }
        return employeeMap;
    }

    @Override
    public Employee remove(String firstName, String lastName, String passwordNumber) {
        String idEmployeeInfo = firstName + lastName + passwordNumber;
        Employee employee = employeeMap.get(idEmployeeInfo);
        if (employee != null) {
            employeeMap.remove(idEmployeeInfo, employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName, String passwordNumber) {
        String idEmployeeInfo = firstName + lastName + passwordNumber;
        Employee employee = employeeMap.get(idEmployeeInfo);
        if (employee != null) {
            employeeMap.get(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee maxWageDepartment(Integer departmentNumber) {
//        final Map<Integer, Employee> employeeDepartment = new HashMap<>(Map.of());

        Optional<Employee> maxDepartmentEmployee;
        if (departmentNumber == null) {
            maxDepartmentEmployee = employeeMap.values()
                    .stream()
                    .max(Comparator.comparingInt(employee -> employee.getWage()));
        } else {
            maxDepartmentEmployee = employeeMap.values()
                    .stream()
                    .filter(employee -> employee.getDepartmentNumber().equals(departmentNumber))
                    .max(Comparator.comparingInt(employee -> employee.getWage()));
        }
        return maxDepartmentEmployee.orElseThrow();
    }

//        if (departmentNumber == null) {
//            Optional<Employee> maxDepartmentEmployee = employeeMap.values().stream()
//                    .max(Comparator.comparingInt(employee -> employee.getWage()));
//            return maxDepartmentEmployee.orElseThrow();
//        } else {
//            Optional<Employee> maxDepartmentEmployee = employeeMap.values().stream()
//                    .filter(employee -> employee.getDepartmentNumber().equals(departmentNumber))
//                    .max(Comparator.comparingInt(employee -> employee.getWage()));
//            return maxDepartmentEmployee.orElseThrow();
//        }
//        }
//        return maxDepartmentEmployee.get();
//    }
//        employeeDepartment.get(departmentNumber);
//        int max = Stream.of(1, 2, 3).max(Comparator.naturalOrder()).get();
//
//        if (maxDepartmentEmployee == null) {
//            throw new EmployeeNotFoundException();

    @Override
    public Map<String, Employee> allEmployeeInfo() {
//        return new HashMap<> (employeeMap);
        return Collections.unmodifiableMap(employeeMap);
    }

    @Override
    public Employee minWageDepartment(Integer departmentNumber) {

        Optional<Employee> minDepartmentEmployee;
        if (departmentNumber == null) {
            minDepartmentEmployee = employeeMap.values()
                    .stream()
                    .min(Comparator.comparingInt(employee -> employee.getWage()));
        } else {
            minDepartmentEmployee = employeeMap.values()
                    .stream()
                    .filter(employee -> employee.getDepartmentNumber().equals(departmentNumber))
                    .min(Comparator.comparingInt(employee -> employee.getWage()));
        }
        return minDepartmentEmployee.orElseThrow();
    }
//        final Map<Integer, Employee> employeeDepartment = new HashMap<>(Map.of());
//
//        Optional<Employee> minDepartmentEmployee = employeeMap.values().stream()
//                .filter(employee -> employee.getDepartmentNumber().equals(departmentNumber))
//                .min(Comparator.comparingInt(employee -> employee.getWage()));
//
//        minDepartmentEmployee.orElseThrow();
//
//        if (minDepartmentEmployee == null) {
//            throw new EmployeeNotFoundException();
//        }
//        return minDepartmentEmployee.get();
//    }

    @Override
    public String allEmployeeGroup(Integer department) {

        Map<Integer, List<Employee>> employeeGroup = new HashMap<>();
        List<Employee> employeeList = new ArrayList<>(employeeMap.values());
        for (Employee employee : employeeList) {
            Integer departmentNumber = employee.getDepartmentNumber();
            List<Employee> employees = employeeGroup.getOrDefault(departmentNumber, new ArrayList<>());
            employees.add(employee);
            employeeGroup.put(departmentNumber, employees);
        }
        if (department == null) {
            return employeeGroup.toString();
        } else {
            return employeeGroup.get(department).toString();
        }
    }

//    @Override
//    public String allEmployeeGroup(Integer department) {
//        Map<Integer, List<Employee>> employeeGroup = new HashMap<>(employeeMap.values().stream()
//                .collect(Collectors.groupingBy(employee -> employee.getDepartmentNumber())));
//
//        if (department == null) {
//            return employeeGroup.toString();
//        } else {
//            return employeeGroup.getOrDefault(department, Collections.emptyList()).toString();
//        }
//    }

}
