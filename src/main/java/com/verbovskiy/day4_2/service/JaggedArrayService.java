package com.verbovskiy.day4_2.service;

import com.verbovskiy.day4_2.entity.SortingMethod;
import com.verbovskiy.day4_2.exception.TaskException;
import com.verbovskiy.day4_2.validator.IndexValidator;

public class JaggedArrayService {
    public void bubbleSort(int[][] jaggedArray, SortingMethod sortingMethod,
                           boolean isReverse) throws TaskException {
        if ((jaggedArray == null) || (sortingMethod == null)) {
            throw new TaskException("incorrect data");
        }
        boolean isSorted;
        for(int i = 0; i < jaggedArray.length - 1; i++) {
            isSorted = true;

            for (int j = 0; j < jaggedArray.length - 1 - i; j++) {
                int firstElement = sortingMethod.sortMethod(jaggedArray[j]);
                int nextElement = sortingMethod.sortMethod(jaggedArray[j + 1]);

                if (firstElement > nextElement) {
                    swapRows(jaggedArray, j, j + 1);
                    isSorted = false;
                }
                if (isSorted) {
                    break;
                }
            }
        }
        if (isReverse) {
            reverseRows(jaggedArray);
        }
}

    private void reverseRows(int[][] jaggedArray) throws TaskException {
        if (jaggedArray == null) {
            throw new TaskException("incorrect data");
        }
        for (int i = 0; i < jaggedArray.length / 2; i++) {
            swapRows(jaggedArray, i, (jaggedArray.length - 1) - i);
        }
    }

    private void swapRows(int[][] jaggedArray, int firstIndex, int secondIndex) throws TaskException {
        IndexValidator indexValidator = new IndexValidator();

        if ((jaggedArray == null) || (!(indexValidator.isIndexCorrect(firstIndex, jaggedArray.length)))
                || (!(indexValidator.isIndexCorrect(secondIndex, jaggedArray.length)))) {
            throw new TaskException("incorrect data");
        }
        int[] swapRow = jaggedArray[firstIndex];
        jaggedArray[firstIndex] = jaggedArray[secondIndex];
        jaggedArray[secondIndex] = swapRow;
    }

}
