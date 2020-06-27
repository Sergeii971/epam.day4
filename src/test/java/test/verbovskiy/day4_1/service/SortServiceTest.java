package test.verbovskiy.day4_1.service;

import com.verbovskiy.day4_1.entity.IntArray;
import com.verbovskiy.day4_1.exception.TaskException;
import com.verbovskiy.day4_1.service.SortService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SortServiceTest {
    SortService sortService;

    @BeforeClass
    public void setUp() {
        sortService = new SortService();
    }

    @Test
    public void shellSortPositiveTest() {
        try {
            Integer[] array = {5, 4, 3, 2, 1};
            IntArray actual = new IntArray(array);
            sortService.ShellSort(actual,false);
            Integer[] arrayExpected = {1,2,3,4,5};
            IntArray expected = new IntArray(arrayExpected);

            assertTrue(arrayEquals(actual, expected));
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void shellSortNegativeTest() {
        try {
            Integer[] array = {5, 4, 3, 2, 1};
            IntArray actual = new IntArray(array);
            sortService.ShellSort(actual,false);
            Integer[] arrayExpected = {1,2,5,4,3};
            IntArray expected = new IntArray(arrayExpected);

            assertFalse(arrayEquals(actual, expected));
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = TaskException.class)
    public void shellSortExceptionTest() throws TaskException {
        sortService.ShellSort(null,false);
    }

    @Test
    public void selectionSortPositiveTest() {
        try {
            Integer[] array = {5, 4, 3, 2, 1};
            IntArray actual = new IntArray(array);
            sortService.selectionSort(actual,false);
            Integer[] arrayExpected = {1,2,3,4,5};
            IntArray expected = new IntArray(arrayExpected);

            assertTrue(arrayEquals(actual, expected));
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void selectionSortNegativeTest() {
        try {
            Integer[] array = {5, 4, 3, 2, 1};
            IntArray actual = new IntArray(array);
            sortService.selectionSort(actual,false);
            Integer[] arrayExpected = {1,2,5,4,3};
            IntArray expected = new IntArray(arrayExpected);

            assertFalse(arrayEquals(actual, expected));
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = TaskException.class)
    public void selectionSortExceptionTest() throws TaskException {
        sortService.selectionSort(null,false);
    }


    @Test
    public void bubbleSortPositiveTest() {
        try {
            Integer[] array = {5, 4, 3, 2, 1};
            IntArray actual = new IntArray(array);
            sortService.bubbleSort(actual,false);
            Integer[] arrayExpected = {1,2,3,4,5};
            IntArray expected = new IntArray(arrayExpected);

            assertTrue(arrayEquals(actual, expected));
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void bubbleSortNegativeTest() {
        try {
            Integer[] array = {5, 4, 3, 2, 1};
            IntArray actual = new IntArray(array);
            sortService.bubbleSort(actual,false);
            Integer[] arrayExpected = {1,2,5,4,3};
            IntArray expected = new IntArray(arrayExpected);

            assertFalse(arrayEquals(actual, expected));
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = TaskException.class)
    public void bubbleSortExceptionTest() throws TaskException {
        sortService.bubbleSort(null,false);
    }

    private boolean arrayEquals(IntArray intArrayActual, IntArray intArrayExpected) throws TaskException {
        boolean result = true;
        if (intArrayActual.length() == intArrayExpected.length()) {
            for (int i = 0; i < intArrayActual.length(); i++) {
                if (!intArrayActual.getElement(i).equals(intArrayExpected.getElement(i))) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}