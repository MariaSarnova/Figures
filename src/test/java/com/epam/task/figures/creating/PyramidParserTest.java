package com.epam.task.figures.creating;

import com.epam.task.figures.entities.Point;
import com.epam.task.figures.entities.Pyramid;
import org.junit.Assert;
import org.junit.Test;

public class PyramidParserTest {
    PyramidParser parser = new PyramidParser();

    @Test
    public void testParseShouldReturnPyramidWhenValidStringApplied() {
        String elements = "1.0 2 7.8 4.0 5 2 3 4.7 2 8 1 46.8 13 4.1 5.1";

        Pyramid actual = parser.parse(elements);

        Assert.assertEquals(new Pyramid(new Point(1.0, 2, 7.8), new Point(4.0, 5, 2),new Point(3, 4.7, 2),new Point(8, 1, 46.8),new Point(13, 4.1, 5.1)),actual);
    }

}
