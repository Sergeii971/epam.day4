package com.verbovskiy.day4_1.entity;

import com.verbovskiy.day4_1.exception.TaskException;

public class IntArray {
    private Integer[] array;

    public IntArray(Integer[] array) {
        this.array = array;
    }

    public IntArray(int elementNumber) {
        array = new Integer[elementNumber];
    }

    public int length() {
        return array.length;
    }

    public Integer getElement(int index) throws TaskException {
        if (index < 0 || array.length - 1 < index) {
            throw new TaskException("incorrect index");
        }
        return array[index];
    }

    public void setElement(int index, Integer element) throws TaskException {
        if (index < 0 || array.length - 1 < index) {
            throw new TaskException("incorrect index");
        }
        array[index] = element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (this == null || getClass() != o.getClass()) {
            return false;
        }
        IntArray intArray = (IntArray) o;

        if (this.array == null || intArray.array == null) {
            if (this.array == intArray.array) {
                return true;
            } else {
                return false;
            }
        }
        if (this.array.length != intArray.array.length) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (this.array[i] != intArray.array[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;

        if ((this != null) && (this.array != null)) {
            for (int i = 0; i < array.length; i++) {
                result = 31 * array[i] + result;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();

        if ((this != null) && (this.array != null)) {
            for(int i = 0; i < array.length; i++) {
                stringBuilder.append(array[i]);
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
