package com.verbovskiy.day4_1.parser;

import com.verbovskiy.day4_1.exception.TaskException;

public class ArrayParser {
    public Integer[] parseToIntArray(String ... stringNumbers) throws TaskException {
        try {
            Integer[] elements = new Integer[stringNumbers.length];

            for (int i = 0; i < stringNumbers.length; i++) {
                int element = Integer.parseInt(stringNumbers[i]);
                elements[i] = element;
            }

            return elements;
        } catch (NumberFormatException e) {
            throw new TaskException(e);
        }
    }
}
