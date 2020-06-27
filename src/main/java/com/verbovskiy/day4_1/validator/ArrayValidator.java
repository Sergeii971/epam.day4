package com.verbovskiy.day4_1.validator;

import com.verbovskiy.day4_1.entity.IntArray;
import com.verbovskiy.day4_1.exception.TaskException;

public class ArrayValidator {
    public boolean validateArrayElementNotNull(IntArray array) throws TaskException {
        boolean result = true;

        for (int i = 0; i < array.length(); i++) {
            if (array.getElement(i) == null) {
                result = false;
                break;
            }
        }
        return result;
    }
}
