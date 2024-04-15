package tdd.exercice.EmployeeTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import tdd.exercice.Employee.Employee;
import tdd.exercice.Employee.EmployeeOffices;

public class EmployeeTest {

    private static Stream<Object[]> provideDataForSalaryCalculateTest(){
        return Stream.of(
            new Object[] {new Employee(1, "Charles Oliveira", "charles.oliveira@example.com", 2500.00, EmployeeOffices.DBA), 1875.00},  // 25% discount for DBA salary >= 2000
            new Object[] {new Employee(1, "Max Holloway", "max.holloway@example.com", 1500.00, EmployeeOffices.DBA), 1275.00},  // 15% discount for DBA salary <= 2000
            new Object[] {new Employee(1, "Dustin Poirier", "dustin.poirier@example.com", 3500.00, EmployeeOffices.DESENVOLVEDOR), 2800.00},  // 20% discount for DEVELOPER salary >= 3000
            new Object[] {new Employee(1, "Justin Gaethje", "justin.gaethje@example.com", 2000.00, EmployeeOffices.DESENVOLVEDOR), 1800.00},  // 10% discount for DEVELOPER salary <= 3000
            new Object[] {new Employee(1, "Alexandre Pantoja", "alexandre.pantoja@example.com", 2500.00, EmployeeOffices.TESTADOR), 1875.00},  // 25% discount for TESTADOR salary >= 2000
            new Object[] {new Employee(1, "Max Holloway", "max.holloway@example.com", 1800.00, EmployeeOffices.TESTADOR), 1530.00},  // 15% discount for TESTADOR salary <= 2000
            new Object[] {new Employee(1, "Alex Poatan", "alex.poatan@example.com", 6000.00, EmployeeOffices.GERENTE), 4200.00},  // 30% discount for GERENTE salary <= 5000
            new Object[] {new Employee(1, "Jon Jones", "jon.jones@example.com", 4000.00, EmployeeOffices.GERENTE), 3200.00}  // 20% discount for GERENTE salary <= 5000
        );
    }

    @ParameterizedTest
    @MethodSource("provideDataForSalaryCalculateTest")
    public void testCalculateSalary(Employee employee, Double expectedSalary){
        double calculateSalary = employee.calculateSalary(employee);
        assertEquals(expectedSalary, calculateSalary, 0.01);
    }

}
