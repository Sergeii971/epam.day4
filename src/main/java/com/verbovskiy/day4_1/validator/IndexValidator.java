package com.verbovskiy.day4_1.validator;

public class IndexValidator {
    public boolean isIndexCorrect(int index, int arrayLength) {
        return ((index >= 0) && (index < arrayLength));
    }
}
