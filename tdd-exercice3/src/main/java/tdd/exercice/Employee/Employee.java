package tdd.exercice.Employee;

public class Employee {

    private int id;
    private String name;
    private String email;
    private String baseSalary;
    private EmployeeOffices office;
    
    public Employee(int id, String name, String email, String baseSalary, EmployeeOffices office) {
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
    public String getBaseSalary() {
        return baseSalary;
    }
    public void setBaseSalary(String baseSalary) {
        this.baseSalary = baseSalary;
    }
    public EmployeeOffices getOffice() {
        return office;
    }
    public void setOffice(EmployeeOffices office) {
        this.office = office;
    }
    
}
