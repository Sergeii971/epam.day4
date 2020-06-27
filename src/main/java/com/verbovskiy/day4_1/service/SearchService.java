package com.verbovskiy.day4_1.service;

import com.verbovskiy.day4_1.entity.IntArray;
import com.verbovskiy.day4_1.exception.TaskException;
import com.verbovskiy.day4_1.validator.ArrayValidator;
import com.verbovskiy.day4_1.validator.NumberValidator;
import com.verbovskiy.day4_1.validator.SearchValidator;

public class SearchService {
    private final int NUMBER_OF_DIGITS_IN_MATH = 10;
    public int findIndexMinElement(IntArray array, int begin, int end) throws TaskException {
        SearchValidator searchValidator = new SearchValidator();
        ArrayValidator arrayValidator = new ArrayValidator();

        if ((array == null) || (!searchValidator.validateSearchData(array, begin, end))
                || (!arrayValidator.validateArrayElementNotNull(array))) {
            throw new TaskException("incorrect data");
        }
        int minValue = array.getElement(begin);
        int indexMinElement = begin;

        for (int i = begin + 1; i <= end; i++) {
            if (array.getElement(i) < minValue) {
                minValue = array.getElement(i);
                indexMinElement = i;
            }
        }
        return indexMinElement;
    }

    public int findIndexMaxElement(IntArray array, int begin, int end) throws TaskException {
        SearchValidator searchValidator = new SearchValidator();
        ArrayValidator arrayValidator = new ArrayValidator();

        if ((array == null) || (!searchValidator.validateSearchData(array, begin, end))
                || (!arrayValidator.validateArrayElementNotNull(array))) {
            throw new TaskException("incorrect data");
        }
        int maxValue = array.getElement(begin);
        int indexMaxElement = begin;

        for (int i = begin + 1; i <= end; i++) {
            if (array.getElement(i) > maxValue) {
                maxValue = array.getElement(i);
                indexMaxElement = i;
            }
        }
        return indexMaxElement;
    }

    public int binarySearch(IntArray array, int first, int last, int item) throws TaskException {
        SearchValidator searchValidator = new SearchValidator();
        ArrayValidator arrayValidator = new ArrayValidator();

        if ((array == null) || (!searchValidator.validateSearchData(array, first, last))
                || (!arrayValidator.validateArrayElementNotNull(array))) {
            throw new TaskException("incorrect data");
        }
        int position = (first + last) / 2;

        while ((array.getElement(position) != item) && (first <= last)) {
            if (array.getElement(position) > item) {
                last = position - 1;
            } else {
                first = position + 1;
            }
            position = (first + last) / 2;
        }
        if (first > last) {
            position = -1;
        }
        return position;
    }

    public IntArray searchPrimeNumber(IntArray array) throws TaskException {
        ArrayValidator arrayValidator = new ArrayValidator();

        if (((array == null)) || (!arrayValidator.validateArrayElementNotNull(array))) {
            throw new TaskException("incorrect data");
        }
        IntArray primeNumberArray = new IntArray(array.length());
        int primeNumberQuantity = 0;

        for (int i = 0; i < array.length(); i++) {
            Integer element = array.getElement(i);

            if (isNumberPrime(element)) {
                primeNumberArray.setElement(primeNumberQuantity, element);
                primeNumberQuantity++;
            }
        }
        IntArray primeNumberArray1 = new IntArray(primeNumberQuantity);

        for (int i = 0; i < primeNumberArray1.length(); i++) {
            primeNumberArray1.setElement(i, primeNumberArray.getElement(i));
        }
        return primeNumberArray1;
    }

    public IntArray searchFibonacciNumber(IntArray array) throws TaskException {
        ArrayValidator arrayValidator = new ArrayValidator();

        if (((array == null)) || (!arrayValidator.validateArrayElementNotNull(array))) {
            throw new TaskException("incorrect data");
        }
        IntArray fibonacciNumberArray = new IntArray(array.length());
        int fibonacciNumberQuantity = 0;

        for (int i = 0; i < array.length(); i++) {
            Integer element = array.getElement(i);

            if (isFibonacciNumber(element)) {
                fibonacciNumberArray.setElement(fibonacciNumberQuantity, element);
                fibonacciNumberQuantity++;
            }
        }
        IntArray fibonacciNumberArray1 = new IntArray(fibonacciNumberQuantity);
        for (int i = 0; i < fibonacciNumberArray1.length(); i++) {
            fibonacciNumberArray1.setElement(i, fibonacciNumberArray.getElement(i));
        }
        return fibonacciNumberArray1;
    }

    public IntArray searchThreeUniqueDigitNumber(IntArray array) throws TaskException {
        ArrayValidator arrayValidator = new ArrayValidator();

        if (((array == null)) || (!arrayValidator.validateArrayElementNotNull(array))) {
            throw new TaskException("incorrect data");
        }
        IntArray threeUniqueDigitNumberArray = new IntArray(array.length());
        int threeUniqueDigitNumberQuantity = 0;

        for (int i = 0; i < array.length(); i++) {
            Integer element = array.getElement(i);

            if (isNumberDigitDifferent(element)) {
                threeUniqueDigitNumberArray.setElement(threeUniqueDigitNumberQuantity, element);
                threeUniqueDigitNumberQuantity++;
            }
        }
        IntArray threeUniqueDigitNumberArray1 = new IntArray(threeUniqueDigitNumberQuantity);

        for (int i = 0; i < threeUniqueDigitNumberArray1.length(); i++) {
            threeUniqueDigitNumberArray1.setElement(i, threeUniqueDigitNumberArray.getElement(i));
        }
        return threeUniqueDigitNumberArray1;
    }

    private boolean isNumberDigitDifferent(int number) {
        boolean result = true;
        NumberValidator numberValidator = new NumberValidator();

        if (numberValidator.isNumberThreeDigit(number)) {
            int[] digitCounter = new int[NUMBER_OF_DIGITS_IN_MATH];
            int digit;

            while (number > 0) {
                digit = number % 10;
                digitCounter[digit]++;
                number /= 10;
            }
            for (int i = 0; i < NUMBER_OF_DIGITS_IN_MATH; i++) {
                if (digitCounter[i] > 1) {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }
        return result;
    }

    private boolean isFibonacciNumber(int element) {
        double estimatedSquare = 5 * element * element - 4;
        double estimatedSquare1 = 5 * element * element + 4;
        double estimatedSquareRoot = Math.sqrt(estimatedSquare);
        double estimatedSquareRoot1 = Math.sqrt(estimatedSquare1);
        boolean isSquare = ((estimatedSquareRoot % 1 == 0.0) || (estimatedSquareRoot1 % 1 == 0.0));

        return isSquare;
    }

    private boolean isNumberPrime(Integer number) {
        boolean result = true;

        if (number != null) {
            for (int i = 2; i < number / 2 + 1; i++) {
                if (number % i == 0) {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }
        return result;
    }
}
