package com.epam.task.figures.creating;

import com.epam.task.figures.data.DataException;
import com.epam.task.figures.data.DataReader;
import com.epam.task.figures.entities.Point;
import com.epam.task.figures.entities.Pyramid;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class PyramidCreatorTest {
    private static final List<String> STRING_TEST_DATA = Arrays.asList("1 3 5 6 7.7 8.0 7 5 4 6 2 0.7 5 6 3", "a b 3z 3.0", "9.1 5 6 8 56.8 5 8 9 0 7 5.6 2 3 14 12 ");
    private static final Pyramid[] EXPECTED = {new Pyramid(new Point(1, 3, 5), new Point(6, 7.7, 8.0),new Point(7, 5, 4),new Point(6, 2, 0.7),new Point(5, 6, 3)),
            new Pyramid(new Point(9.1, 5, 6), new Point(8, 56.8, 5),new Point(8, 9, 0),new Point(7, 5.6, 2),new Point(3, 14, 12))};

    @Test
    public void testProcessShouldReturnListOfPyramidsWhenAllLinesAreCorrect() throws DataException {
        DataReader reader = Mockito.mock(DataReader.class);
        when(reader.readData(anyString())).thenReturn(STRING_TEST_DATA);

        PyramidValidator validator = Mockito.mock(PyramidValidator.class);
        when(validator.validate(STRING_TEST_DATA.get(0))).thenReturn(true);
        when(validator.validate(STRING_TEST_DATA.get(1))).thenReturn(false);
        when(validator.validate(STRING_TEST_DATA.get(2))).thenReturn(true);

        PyramidParser parser = Mockito.mock(PyramidParser.class);
        when(parser.parse(STRING_TEST_DATA.get(0))).thenReturn(EXPECTED[0]);
        when(parser.parse(STRING_TEST_DATA.get(2))).thenReturn(EXPECTED[1]);

        PyramidCreator creator = new PyramidCreator(validator, parser, reader);
        List<Pyramid> actual = creator.process("anyfilename");


        Assert.assertArrayEquals(actual.toArray(), EXPECTED);
    }
}
