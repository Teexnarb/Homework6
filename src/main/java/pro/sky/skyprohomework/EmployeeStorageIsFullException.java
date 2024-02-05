package pro.sky.skyprohomework;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException(String massage) {
        super(massage);
    }
}
