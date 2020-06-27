package test.verbovskiy.day4_2.validator;

import com.verbovskiy.day4_2.validator.IndexValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IndexValidatorTest {
    IndexValidator indexValidator;

    @BeforeClass
    public void setUp() {
        indexValidator = new IndexValidator();
    }

    @Test
    public void isIndexCorrectPositiveTest() {
        boolean actual = indexValidator.isIndexCorrect(4,5);

        assertTrue(actual);
    }

    @Test
    public void isIndexCorrectNegativeTest() {
        boolean actual = indexValidator.isIndexCorrect(6,5);

        assertFalse(actual);
    }
}