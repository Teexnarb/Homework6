package pro.sky.skyprohomework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
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

    @GetMapping("/add")
    public Map add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String passwordNumber, @RequestParam Integer yearBirth, @RequestParam (value = "accepted", required = false) Employee employee) {
        return service.add(firstName, lastName, passwordNumber, yearBirth, employee);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String passwordNumber) {
        return service.remove(firstName, lastName, passwordNumber);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String passwordNumber) {
        return service.find(firstName, lastName, passwordNumber);
    }

    @GetMapping
    public Map<String, Employee> allEmployeeInfo() {
        return service.allEmployeeInfo();
    }

    @GetMapping("/departments/max-salary")
    public Employee maxWageDepartment(@RequestParam(value = "department", required = false) Integer departmentNumber) {
        return service.maxWageDepartment(departmentNumber);
    }

    @GetMapping("/departments/min-salary")
    public Employee minWageDepartment(@RequestParam(value = "department", required = false) Integer departmentNumber) {
        return service.minWageDepartment(departmentNumber);
    }

    @GetMapping("/departments/all")
    public String employeeDepartment(@RequestParam(value = "department", required = false) Integer departmentNumber) {
        return service.allEmployeeGroup(departmentNumber);
    }
}