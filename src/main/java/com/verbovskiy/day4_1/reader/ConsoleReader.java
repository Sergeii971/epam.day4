package com.verbovskiy.day4_1.reader;

import com.verbovskiy.day4_1.exception.TaskException;

import java.util.Scanner;

public class ConsoleReader {
    public int readArrayLength() throws TaskException {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();

        if (length < 1) {
            throw new TaskException("incorrect index");
        }
        return length;
    }

    public int readArrayElement() {
        Scanner scanner = new Scanner(System.in);
        int element = scanner.nextInt();

        return element;
    }
}
