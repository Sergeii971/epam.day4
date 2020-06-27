package com.verbovskiy.day4_1.validator;

public class NumberValidator {
    private final int MIN_THREE_DIGIT_NUMBER = 100;
    private final int MAX_THREE_DIGIT_NUMBER = 999;

    public boolean isNumberThreeDigit(int number) {
        boolean result = true;

        number = Math.abs(number);
        if ((number < MIN_THREE_DIGIT_NUMBER) || (number > MAX_THREE_DIGIT_NUMBER)) {
            result = false;
        }
        return result;
    }
}
