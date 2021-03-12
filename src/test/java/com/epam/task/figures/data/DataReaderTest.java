package com.epam.task.figures.data;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DataReaderTest {
    private final DataReader reader = new DataReader();
    private static final String FILE_PATH = "./src/test/resources/";

    @Test(expected = DataException.class)
    public void testReadLinesShouldThrowDataExceptionWhenFileDoesntExist() throws DataException {
        String filename = FILE_PATH + "noFile.txt";

        reader.readData(filename);
    }

    @Test
    public void testReadLinesShouldReturnListOfLineWhenFileExists() throws DataException {
        String filename =  FILE_PATH + "input.txt";
        String[] expected = new String[] {"12345 45 6", "hi", "bye"};

        List<String> actual = reader.readData(filename);

        Assert.assertArrayEquals(expected, actual.toArray());
    }

    @Test(expected = DataException.class)
    public void testReadLinesShouldThrowDataExceptionWhenEmptyFileApplied() throws DataException {
        String filename = FILE_PATH + "empty.txt";

        List<String> actual = reader.readData(filename);

        Assert.assertArrayEquals(new String[] {}, actual.toArray());
    }

}
