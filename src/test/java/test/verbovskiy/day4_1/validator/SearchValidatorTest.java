package test.verbovskiy.day4_1.validator;

import com.verbovskiy.day4_1.entity.IntArray;
import com.verbovskiy.day4_1.validator.SearchValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearchValidatorTest {
    SearchValidator searchValidator;

    @BeforeClass
    public void setUp() {
        searchValidator = new SearchValidator();
    }

    @Test
    public void validateSearchDataPositiveTest() {
        Integer[] array = {25, 253, 34, 25, 74};
        IntArray intArray = new IntArray(array);
        boolean actual = searchValidator.validateSearchData(intArray, 3,4);

        assertTrue(actual);
    }

    @Test
    public void validateSearchDataNegativeTest() {
        Integer[] array = {25, 253, 34, 25, 74};
        IntArray intArray = new IntArray(array);
        boolean actual = searchValidator.validateSearchData(intArray, 5,3);

        assertFalse(actual);
    }
}