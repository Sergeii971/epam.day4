package test.verbovskiy.day4_1.validator;

import com.verbovskiy.day4_1.entity.IntArray;
import com.verbovskiy.day4_1.exception.TaskException;
import com.verbovskiy.day4_1.validator.ArrayValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayValidatorTest {
    ArrayValidator arrayValidator;

    @BeforeClass
    public void setUp() {
        arrayValidator = new ArrayValidator();
    }

    @Test
    public void validateArrayElementNotNullPositiveTest() {
        try {
        Integer[] array = {2254, 25, 45, 4235, 536};
        IntArray intArray = new IntArray(array);
        boolean actual = arrayValidator.validateArrayElementNotNull(intArray);

        assertTrue(actual);
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void validateArrayElementNotNullNegativeTest() {
        try {
            Integer[] array = {2254, null, 45, 4235, 536};
            IntArray intArray = new IntArray(array);
            boolean actual = arrayValidator.validateArrayElementNotNull(intArray);

            assertFalse(actual);
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }
}