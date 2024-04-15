package tdd.exercice.Employee;
import static tdd.exercice.Employee.EmployeeOffices.*;

public class Employee {

    private int id;
    private String name;
    private String email;
    private Double baseSalary;
    private EmployeeOffices office;
    
    public Employee(int id, String name, String email, Double baseSalary, EmployeeOffices office) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.baseSalary = baseSalary;
        this.office = office;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Double getBaseSalary() {
        return baseSalary;
    }
    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }
    public EmployeeOffices getOffice() {
        return office;
    }
    public void setOffice(EmployeeOffices office) {
        this.office = office;
    }

    public double calculateSalary(Employee employee) {
        double discountRate;
        switch (employee.getOffice()) {
            case DESENVOLVEDOR:
                discountRate = employee.getBaseSalary() >= 3000 ? 0.2 : 0.1;
                break;
            case DBA:
                discountRate = employee.getBaseSalary() >= 2000 ? 0.25 : 0.15;
                break;
            case TESTADOR:
                discountRate = employee.getBaseSalary() >= 2000 ? 0.25 : 0.15;
                break;
            case GERENTE:
                discountRate = employee.getBaseSalary() >= 5000 ? 0.3 : 0.2;
                break;
            default:
                throw new IllegalArgumentException("Invalid employee position");
        }
        return employee.getBaseSalary() * (1 - discountRate);
    }
    
}
