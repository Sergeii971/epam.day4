package test.verbovskiy.day4_2.service;

import com.verbovskiy.day4_2.service.SortingMethod;
import com.verbovskiy.day4_2.exception.TaskException;
import com.verbovskiy.day4_2.service.JaggedArrayService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class JaggedArrayServiceTest {
    JaggedArrayService jaggedArrayService;

    @BeforeClass
    public void setUp() {
    jaggedArrayService = new JaggedArrayService();
    }

    @Test
    public void bubbleSortPositiveTest() {
        try {
            int[][] actual = {{500},{1,2,3},{0}};
            jaggedArrayService.bubbleSort(actual, SortingMethod.MAX_ELEMENT_ROW,false);
            int[][] expected = {{0}, {1,2,3}, {500}};

            assertTrue(arrayEquals(actual, expected));
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void bubbleSortNegativeTest() {
        try {
            int[][] actual = {{500},{1,2,3},{0}};
            jaggedArrayService.bubbleSort(actual, SortingMethod.MAX_ELEMENT_ROW,false);
            int[][] expected = {{500}, {1,2,3}, {0}};

            assertFalse(arrayEquals(actual, expected));
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = TaskException.class)
    public void bubbleSortExceptionTest() throws TaskException {
        jaggedArrayService.bubbleSort(null,SortingMethod.SUM_ROW,false);
    }

    private boolean arrayEquals(int[][] intArrayActual, int[][] intArrayExpected) {
        boolean result = true;

            if (intArrayActual.length == intArrayExpected.length) {
                for (int i = 0; i < intArrayActual.length;i++) {
                    if (intArrayActual[i].length != intArrayExpected[i].length) {
                        result = false;
                        break;
                    }
                }
            }
            for (int i = 0; i < intArrayActual.length && result == true; i++) {
                for (int j = 0; j < intArrayActual[i].length; j++) {
                if (intArrayActual[i][j] != intArrayExpected[i][j]) {
                    result = false;
                    break;
                }
            }
            }
        return result;
    }
}