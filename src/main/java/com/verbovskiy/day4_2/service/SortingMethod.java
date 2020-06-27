package com.verbovskiy.day4_2.service;

import com.verbovskiy.day4_2.exception.TaskException;

public enum SortingMethod {
    SUM_ROW {
        public int sortMethod(int[] row) throws TaskException {
            if (row == null) {
                throw new TaskException();
            }
            int rowElementSum = 0;

            for (int i = 0; i < row.length; i++) {
                rowElementSum += row[i];
            }
            return rowElementSum;
        }
    },
    MIN_ELEMENT_ROW {
        public int sortMethod(int[] row) throws TaskException {
            if (row == null) {
                throw new TaskException();
            }
            int minElement = row[0];

            for (int i = 1; i < row.length; i++) {
                if (row[i] < minElement) {
                    minElement = row[i];
                }
            }
            return minElement;
        }
    },
    MAX_ELEMENT_ROW {
        public int sortMethod(int[] row) throws TaskException {
            if (row == null) {
                throw new TaskException();
            }
            int maxElement = row[0];

            for (int i = 1; i < row.length; i++) {
                if (row[i] > maxElement) {
                    maxElement = row[i];
                }
            }
            return maxElement;
        }
    };

    public abstract int sortMethod(int[] row) throws TaskException;
}
