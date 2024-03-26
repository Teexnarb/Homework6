package pro.sky.skyprohomework.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import pro.sky.skyprohomework.Employee;
import pro.sky.skyprohomework.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @ExceptionHandler({HttpStatusCodeException.class})
    public String handleException(HttpStatusCodeException e) {
        return "Code: " + e.getStatusCode() + ". Error: " + e.getMessage();
    }

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesByDepartment(@PathVariable Integer id) {
        return departmentService.getEmployeesByDepartment(id);
    }

    @GetMapping("/{id}/salary/sum")
    public Double getSalarySumByDepartment(@PathVariable Integer id) {
        return departmentService.getSalarySumByDepartment(id);
    }

    @GetMapping("/{id}/salary/max")
    public Double getMinSalaryInDepartment(@PathVariable Integer id) {
        return departmentService.getMaxSalaryInDepartment(id);
    }

    @GetMapping("/{id}/salary/min")
    public Double getMaxSalaryInDepartment(@PathVariable Integer id) {
        return departmentService.getMinSalaryInDepartment(id);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        return departmentService.getAllEmployeesByDepartment();
    }
}