package com.verbovskiy.day4_2.validator;

public class IndexValidator {
    public boolean isIndexCorrect(int index, int length) {
        boolean result = true;

        if ((index < 0) || (index > length - 1)) {
            result = false;
        }
        return result;
    }
}
