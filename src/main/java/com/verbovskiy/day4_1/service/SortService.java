package com.verbovskiy.day4_1.service;

import com.verbovskiy.day4_1.entity.IntArray;
import com.verbovskiy.day4_1.exception.TaskException;
import com.verbovskiy.day4_1.validator.IndexValidator;
import com.verbovskiy.day4_1.validator.ArrayValidator;

public class SortService {
    public void ShellSort(IntArray array, boolean isReverse) throws TaskException {
        int j;
        ArrayValidator arrayValidator = new ArrayValidator();

        if ((array == null) || (!arrayValidator.validateArrayElementNotNull(array))) {
            throw new TaskException("incorrect data");
        }
        for (int step = array.length() / 2; step > 0; step /= 2) {
            for (int i = step; i < array.length(); i++) {
                Integer element = array.getElement(i);

                for (j = i; j >= step; j -= step) {
                    if (element < array.getElement(j - step)) {
                        array.setElement(j, array.getElement(j - step));
                    } else {
                        break;
                    }
                }
                array.setElement(j, element);
            }
        }
        if (isReverse) {
            reverse(array);
        }
    }

    public void selectionSort(IntArray array, boolean isReverse) throws TaskException {
        SearchService searchService = new SearchService();
        ArrayValidator arrayValidator = new ArrayValidator();

        if ((array == null) || (!arrayValidator.validateArrayElementNotNull(array))) {
            throw new TaskException("incorrect data");
        }
        int n = array.length();

        for (int i = 0; i < n; i ++) {
            int indexMinElement = searchService.findIndexMinElement(array, i, n - 1);
            swap(array, i, indexMinElement);
        }
        if (isReverse) {
            reverse(array);
        }
    }

    public void bubbleSort(IntArray array, boolean isReverse) throws TaskException {
        boolean isSorted;
        ArrayValidator arrayValidator = new ArrayValidator();

        if ((array == null) || (!arrayValidator.validateArrayElementNotNull(array))) {
            throw new TaskException("incorrect data");
        }
        for(int i = 0; i < array.length() - 1; i++) {
            isSorted = true;

            for (int j = 0; j < array.length() - 1 - i; j++) {
                if (array.getElement(j) > array.getElement(j + 1)) {
                    swap(array, j, j + 1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
        if (isReverse) {
            reverse(array);
        }
    }

    private void reverse(IntArray array) throws TaskException {
        if (array == null) {
            throw new TaskException();
        }
        for (int i = 0; i < array.length() / 2; i++) {
            swap(array, i, (array.length() - 1) - i);
        }
    }

    private void swap(IntArray array, int indexFirstElement, int indexSecondElement) throws TaskException {
        IndexValidator indexValidator = new IndexValidator();

        if ((array == null) || (!indexValidator.isIndexCorrect(indexFirstElement, array.length()))
                || (!indexValidator.isIndexCorrect(indexSecondElement, array.length()))) {
            throw new TaskException("incorrect data");
        }
        int temp = array.getElement(indexFirstElement);

        array.setElement(indexFirstElement, array.getElement(indexSecondElement));
        array.setElement(indexSecondElement, temp);
    }
}
