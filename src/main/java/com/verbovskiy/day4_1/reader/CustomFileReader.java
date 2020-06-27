package com.verbovskiy.day4_1.reader;

import com.verbovskiy.day4_1.exception.TaskException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomFileReader {
    private static final String DEFAULT_FILE = "data\\defaultFile.txt";
    private final String REGEX = " ";

    public String[] readFromFile(String file) throws TaskException {
        Path path = Paths.get(file);
        if (Files.notExists(path)) {
            path = Paths.get(DEFAULT_FILE);
        }
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String stringLine = reader.readLine();
            return stringLine.split(REGEX);
        } catch (IOException e) {
            throw new TaskException();
        }
    }
}
