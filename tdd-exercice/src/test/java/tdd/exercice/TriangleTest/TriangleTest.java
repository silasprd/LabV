package tdd.exercice.TriangleTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import tdd.exercice.Triangle.Triangle;

public class TriangleTest {

    private static Stream<Object[]> provideDataToGetTypeTriangleTest() {
        return Stream.of(
            new Object[] { new Triangle(5, 5, 5), "Equilateral"}, // equilateral valid triangle
            new Object[] { new Triangle(5, 5, 6), "Isosceles"}, // isosceles valid triangle
            new Object[] { new Triangle(6, 5, 5), "Isosceles"}, // isosceles valid triangle
            new Object[] { new Triangle(6, 5, 6), "Isosceles"},  // isosceles valid triangle
            new Object[] { new Triangle(7, 5, 6), "Scalene"}  // Scalene valid triangle
        );
    }

    private static Stream<Object[]> provideDataToIsValidTriangleTest() {
        return Stream.of(
            new Object[] { new Triangle(0, 2, 2) }, // invalid triangle, one side with value 0
            new Object[] { new Triangle(3, 3, -1) }, // invalid triangle, one side with value negative
            new Object[] { new Triangle(2, 2, 4) }, // invalid triangle, the sum of two sides is equal to the third side
            new Object[] { new Triangle(3, 2, 1) }, // invalid triangle, the sum of two sides is equal to the third side
            new Object[] { new Triangle(2, 1, 4) }, // invalid triangle, the sum of two sides is minor to the third side
            new Object[] { new Triangle(4, 1, 1) }, // invalid triangle, the sum of two sides is minor to the third side
            new Object[] { new Triangle(0, 0, 0) }  // invalid triangle, all sides with values 0
        );
    }

    @ParameterizedTest
    @MethodSource("provideDataToIsValidTriangleTest")
    public void testIsInvalidTriangle(Triangle triangles) {
        assertFalse(triangles.isValidTriangle());
    }

    @ParameterizedTest
    @MethodSource("provideDataToGetTypeTriangleTest")
    public void testGetTypeTriangle(Triangle triangles, String expectedType) {
        assertEquals(expectedType, triangles.getType());
    }
    
}
