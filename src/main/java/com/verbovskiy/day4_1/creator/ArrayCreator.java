package com.verbovskiy.day4_1.creator;

import com.verbovskiy.day4_1.entity.IntArray;
import com.verbovskiy.day4_1.exception.TaskException;
import com.verbovskiy.day4_1.parser.ArrayParser;
import com.verbovskiy.day4_1.reader.ConsoleReader;
import com.verbovskiy.day4_1.reader.CustomFileReader;

public class ArrayCreator {
    private final int MAX_RANDOM = 1000;
    private final int MIN_RANDOM = 0;
    
    public IntArray createAndFillArrayRandom(int arrayLength) throws TaskException {
        if (arrayLength < 1) {
            throw new TaskException("incorrect index");
        } else {
            Integer[] elements = new Integer[arrayLength];

            for(int i = 0; i < elements.length; ++i) {
                elements[i] = MIN_RANDOM + (int)(Math.random() * MAX_RANDOM);
            }

            return new IntArray(elements);
        }
    }

    public IntArray createAndFillArrayConsole() throws TaskException {
        ConsoleReader consoleReader = new ConsoleReader();
        int length = consoleReader.readArrayLength();
        Integer[] array = new Integer[length];

        for(int i = 0; i < array.length; ++i) {
            array[i] = consoleReader.readArrayElement();
        }

        return new IntArray(array);
    }

    public IntArray createAndFillArrayFile(String file) throws TaskException {
        CustomFileReader customFileReader = new CustomFileReader();
        ArrayParser arrayParser = new ArrayParser();
        String[] data = customFileReader.readFromFile(file);
        Integer[] elements = arrayParser.parseToIntArray(data);
        return new IntArray(elements);
    }
}

