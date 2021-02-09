package com.epam.task.figures.creating;

import com.epam.task.figures.data.DataException;
import com.epam.task.figures.data.DataReader;
import com.epam.task.figures.entities.Pyramid;

import java.util.ArrayList;
import java.util.List;

public class PyramidCreator {
    private final PyramidValidator validator;
    private final PyramidParser parser;
    private final DataReader dataReader;

    public PyramidCreator(PyramidValidator validator, PyramidParser parser, DataReader fileDataReader) {
        this.validator = validator;
        this.parser = parser;
        this.dataReader = fileDataReader;
    }

    public List<Pyramid> process(String filename) throws DataException {
        List<Pyramid> result = new ArrayList<>();
        List<String> lines = dataReader.readData(filename);
        for (String line : lines) {
            boolean isValidLine = validator.validate(line);
            if (isValidLine) {
                Pyramid pyramid = parser.parse(line);
                result.add(pyramid);
            }
        }
        return result;
    }
}
