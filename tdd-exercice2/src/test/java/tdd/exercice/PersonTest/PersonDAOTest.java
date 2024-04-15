package tdd.exercice.PersonTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import tdd.exercice.Email.Email;
import tdd.exercice.Person.Person;
import tdd.exercice.Person.PersonDAO;

public class PersonDAOTest {

    private static Stream<Object[]> provideDataForValidPerson(){
        return Stream.of(
            new Object[] {new Person(1, "John Wick", 30, List.of(new Email(1, "john.wick@example.com")))},
            new Object[] {new Person(2, "Alice Smith", 25, List.of(new Email(2, "alice.smith@example.com")))}
        );
    }

    private static Stream<Object[]> provideDataForInvalidPerson(){
        return Stream.of(
            new Object[] {new Person(1, "John", 30, List.of(new Email(1, "john.wick@example.com")))}, // Invalid name, only the first name
            new Object[] {new Person(2, "Alice Smith", 201, List.of(new Email(2, "alice.smith@example.com")))}, // Invalid age, above 200
            new Object[] {new Person(2, "Jordan Smith", 40, List.of())}, // No emails
            new Object[] {new Person(2, "Thomas Andre", 40, List.of(new Email(5, "invalid@example")))}  // Invalid email format
        );
    }

    @ParameterizedTest
    @MethodSource("provideDataForValidPerson")
    public void testIsValidToIncludeValidPerson(Person person){
        PersonDAO personDAO = new PersonDAO();
        assertTrue(personDAO.isValidToInclude(person).isEmpty());
    }

    @ParameterizedTest
    @MethodSource("provideDataForInvalidPerson")
    public void testIsValidToIncludeInvalidPerson(Person person){
        PersonDAO personDAO = new PersonDAO();
        List<String> errors = personDAO.isValidToInclude(person);
        assertTrue(errors.size() > 0);
    }

}
