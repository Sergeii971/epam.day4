package com.verbovskiy.day4_1.validator;

import com.verbovskiy.day4_1.entity.IntArray;

public class SearchValidator {
    public boolean validateSearchData(IntArray array, int begin, int end) {
        return (((array != null) && (begin >= 0) && (end >= 0) && (begin <= end) && (array.length() - 1 >= end)));
    }
}
