package test.verbovskiy.day4_1.parser;

import com.verbovskiy.day4_1.exception.TaskException;
import com.verbovskiy.day4_1.parser.ArrayParser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ArrayParserTest {
    ArrayParser arrayParser;

    @BeforeClass
    public void setUp() {
    arrayParser = new ArrayParser();
    }

    @Test
    public void parseToIntArrayPositiveTest() {
        try {
            Integer[] actual = arrayParser.parseToIntArray("2", "3", "4");
            Integer[] expected = {2, 3, 4};

            assertTrue(arrayEquals(actual,expected));
        } catch (TaskException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parseToIntArrayNegativeTest() {
        try {
            Integer[] actual = arrayParser.parseToIntArray("2", "3", "4");
            Integer[] expected = {2, 5, 4};

            assertFalse(arrayEquals(actual,expected));
        } catch (TaskException e) {
            e.printStackTrace();
        }
    }

    @Test(expectedExceptions = TaskException.class)
    public void parseToIntArrayExceptionTest() throws TaskException {
        arrayParser.parseToIntArray("e");
    }

    private boolean arrayEquals(Integer[] intArrayActual, Integer[] intArrayExpected) throws TaskException {
        boolean result = true;
        if (intArrayActual.length == intArrayExpected.length) {
            for (int i = 0; i < intArrayActual.length; i++) {
                if (!intArrayActual[i].equals(intArrayExpected[i])) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}