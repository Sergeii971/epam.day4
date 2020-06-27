package test.verbovskiy.day4_1.service;

import com.verbovskiy.day4_1.entity.IntArray;
import com.verbovskiy.day4_1.exception.TaskException;
import com.verbovskiy.day4_1.service.SearchService;
import com.verbovskiy.day4_1.validator.ArrayValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearchServiceTest {
    SearchService searchService;

    @BeforeClass
    public void setUp() {
        searchService = new SearchService();
    }

    @Test
    public void findIndexMinElementPositiveTest() {
        try {
        Integer[] array = {2254, 25, 45, 4235, 536};
        IntArray intArray = new IntArray(array);
        int actual = searchService.findIndexMinElement(intArray,0,4);
        int expected = 1;

        assertEquals(actual, expected);
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void findIndexMinElementNegativeTest() {
        try {
            Integer[] array = {2254, 25, 45, 4235, 536};
            IntArray intArray = new IntArray(array);
            int actual = searchService.findIndexMinElement(intArray,0,4);
            int expected = 2;

            assertNotEquals(actual, expected);
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = TaskException.class)
    public void findIndexMinElementExceptionTest() throws TaskException {
        searchService.findIndexMinElement(null,0,4);
    }

    @Test
    public void findIndexMaxElementPositiveTest() {
        try {
            Integer[] array = {2254, 25, 45, 4235, 536};
            IntArray intArray = new IntArray(array);
            int actual = searchService.findIndexMaxElement(intArray,0,4);
            int expected = 3;

            assertEquals(actual, expected);
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void findIndexMaxElementNegativeTest() {
        try {
            Integer[] array = {2254, 25, 45, 4235, 536};
            IntArray intArray = new IntArray(array);
            int actual = searchService.findIndexMaxElement(intArray,0,4);
            int expected = 2;

            assertNotEquals(actual, expected);
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = TaskException.class)
    public void findIndexMaxElementExceptionTest() throws TaskException {
        searchService.findIndexMinElement(null,0,4);
    }

    @Test
    public void binarySearchPositiveTest() {
        try {
            Integer[] array = {1, 2, 3, 4, 5};
            IntArray intArray = new IntArray(array);
            int actual = searchService.binarySearch(intArray,0,4,3);
            int expected = 2;

            assertEquals(actual, expected);
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void binarySearchNegativeTest() {
        try {
            Integer[] array = {1, 2, 3, 4, 5};
            IntArray intArray = new IntArray(array);
            int actual = searchService.binarySearch(intArray,0,4,3);
            int expected = 3;

            assertNotEquals(actual, expected);
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = TaskException.class)
    public void binarySearchExceptionTest() throws TaskException {
        searchService.binarySearch(null,0,4,45);
    }

    @Test
    public void searchPrimeNumberPositiveTest() {
        try {
            Integer[] array = {25, 35, 45, 2, 3};
            IntArray intArray = new IntArray(array);
            IntArray actual = searchService.searchPrimeNumber(intArray);
            Integer[] arrayExpected = {2,3};
            IntArray expected = new IntArray(arrayExpected);

            assertTrue(arrayEquals(actual, expected));
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void searchPrimeNumberNegativeTest() {
        try {
            Integer[] array = {25, 35, 45, 2, 3};
            IntArray intArray = new IntArray(array);
            IntArray actual = searchService.searchPrimeNumber(intArray);
            Integer[] arrayExpected = {45,3};
            IntArray expected = new IntArray(arrayExpected);

            assertFalse(arrayEquals(actual, expected));
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = TaskException.class)
    public void searchPrimeNumberExceptionTest() throws TaskException {
        searchService.searchPrimeNumber(null);
    }


    @Test
    public void searchFibonacciNumberPositiveTest() {
        try {
            Integer[] array = {25, 35, 45, 2, 3};
            IntArray intArray = new IntArray(array);
            IntArray actual = searchService.searchFibonacciNumber(intArray);
            Integer[] arrayExpected = {2,3};
            IntArray expected = new IntArray(arrayExpected);

            assertTrue(arrayEquals(actual, expected));
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void searchFibonacciNumberNegativeTest() {
        try {
            Integer[] array = {25, 35, 45, 2, 3};
            IntArray intArray = new IntArray(array);
            IntArray actual = searchService.searchPrimeNumber(intArray);
            Integer[] arrayExpected = {45,3};
            IntArray expected = new IntArray(arrayExpected);

            assertFalse(arrayEquals(actual, expected));
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = TaskException.class)
    public void searchFibonacciNumberExceptionTest() throws TaskException {
        searchService.searchFibonacciNumber(null);
    }

    @Test
    public void searchThreeUniqueDigitNumberPositiveTest() {
        try {
            Integer[] array = {225, 135, 145};
            IntArray intArray = new IntArray(array);
            IntArray actual = searchService.searchThreeUniqueDigitNumber(intArray);
            Integer[] arrayExpected = {135,145};
            IntArray expected = new IntArray(arrayExpected);

            assertTrue(arrayEquals(actual, expected));
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void searchThreeUniqueDigitNumberNegativeTest() {
        try {
            Integer[] array = {225, 135, 145};
            IntArray intArray = new IntArray(array);
            IntArray actual = searchService.searchThreeUniqueDigitNumber(intArray);
            Integer[] arrayExpected = {225,145};
            IntArray expected = new IntArray(arrayExpected);

            assertFalse(arrayEquals(actual, expected));
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = TaskException.class)
    public void searchThreeUniqueDigitNumberExceptionTest() throws TaskException {
        searchService.searchThreeUniqueDigitNumber(null);
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