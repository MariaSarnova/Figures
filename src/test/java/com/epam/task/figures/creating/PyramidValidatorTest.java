package com.epam.task.figures.creating;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class PyramidValidatorTest {
    public final PyramidValidator validator = new PyramidValidator();

    @Test
    public void testValidateShouldReturnTrueWhenCorrectStringWithPositiveNumbersApplied() {
        String testLine = "1.0 2 7.8 4.0 5 2 3 4.7 2 8 1 46.8 13 4.1 5.1";

        boolean actual = validator.validate(testLine);

        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateShouldReturnTrueWhenCorrectStringWithNegativeNumbersApplied() {
        String testLine = "-1.0 -2 -7.8 -4.0 -5 -2 -3 -4.7 -2 -8 -1 -46.8 -13 -4.1 -5.1";

        boolean actual = validator.validate(testLine);

        Assert.assertTrue(actual);
    }


    @Test
    public void testValidateShouldReturnTrueWhenCorrectStringWithIntegerNumbersApplied() {
        String testLine = "1.0 -2 7.8 -4.0 -5 0 3 -4.7 -2 8 1 -46.8 -13 -4.1 5.1";

        boolean actual = validator.validate(testLine);

        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateShouldReturnFalseWhenStringWithWrongElementsApplied() {
        String testLine = "1w.0 -2 7.8 fg -5 0 3 -4.7 -2 7 1 t5.8 -13 -4.1 5.1";

        boolean actual = validator.validate(testLine);

        Assert.assertFalse(actual);
    }

    @Test
    public void testValidateShouldReturnFalseWhenStringWithNotEnoughElementsApplied() {
        String testLine = "1.0 -2 7.8 7 -5 0 -13 -4.1 5.1";

        boolean actual = validator.validate(testLine);

        Assert.assertFalse(actual);
    }

    @Test
    public void testValidateShouldReturnFalseWhenEmptyStringApplied() {
        String testLine = "";

        boolean actual = validator.validate(testLine);

        Assert.assertFalse(actual);
    }

    @Test
    public void testValidateShouldReturnFalseWhenStringWithMoreThenOneSpaceBetweenTwoElementsApplied() {
        String testLine = "1.0 2 7.8 4.0 5   2 3 4.7   2 8   1 46.8 13 4.1 5.1";

        boolean actual = validator.validate(testLine);

        Assert.assertFalse(actual);
    }
}
