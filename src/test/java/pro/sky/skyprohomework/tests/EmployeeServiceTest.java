package pro.sky.skyprohomework.tests;


import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;
import pro.sky.skyprohomework.Employee;
import pro.sky.skyprohomework.exeptions.EmployeeStorageIsFullException;
import pro.sky.skyprohomework.service.EmployeeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeServiceTest {

    private EmployeeService employeeService = new EmployeeService();

    private final String firstName = "Ivan";
    private final String lastName = "Ivanov";
    private final double salary = 60000.40;
    private final int departmentId = 1;

    @BeforeEach
    private void restoreService() {
        employeeService = new EmployeeService();
    }

    @Test
    void add_success() {
        //Подготовка ожидаемого результата
        Employee expectedEmployee = new Employee(firstName, lastName, salary, departmentId);

        //Начало теста
        Employee actualEmployee = employeeService.add(firstName, lastName, salary, departmentId);
        assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void add_withEmployeeStorageIsFullException() {
        //Подготовка входных данных

        //Подготовка ожидаемого результата
        String expectedMessage = "400 Массив сотрудников переполнен";
        employeeService.add("Petr", "Petrov", 56000, 1);
        employeeService.add("Oleg", "Olegov", 35000, 2);

        //Начало теста
        Exception exception = assertThrows(EmployeeStorageIsFullException.class,
                () -> employeeService.add(firstName, lastName, salary, departmentId));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void add_withEmployeeAlreadyAddedException() {
        //Подготовка входных данных

        //Подготовка ожидаемого результата

        //Начало теста

    }

    @Test
    void find_success() {
        //Подготовка входных данных

        //Подготовка ожидаемого результата

        //Начало теста

    }

    @Test
    void remove_success() {
        //Подготовка входных данных

        //Подготовка ожидаемого результата

        //Начало теста

    }

    @Test
    void remove_withEmployeeNotFoundException() {
        //Подготовка входных данных

        //Подготовка ожидаемого результата

        //Начало теста

    }

    @Test
    void getAll_success() {
        //Подготовка входных данных

        //Подготовка ожидаемого результата

        //Начало теста

    }
}