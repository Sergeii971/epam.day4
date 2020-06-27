package test.verbovskiy.day4_1.validator;

import com.verbovskiy.day4_1.validator.NumberValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumberValidatorTest {
    NumberValidator numberValidator;

    @BeforeClass
    public void setUp() {
        numberValidator  = new NumberValidator();
    }

    @Test
    public void isNumberThreeDigitPositiveTest() {
        boolean actual = numberValidator.isNumberThreeDigit(123);

        assertTrue(actual);
    }

    @Test
    public void isNumberThreeDigitNegativeTest() {
        boolean actual = numberValidator.isNumberThreeDigit(1234);

        assertFalse(actual);
    }
}