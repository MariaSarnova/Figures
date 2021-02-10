package com.epam.task.figures.repository.specifications;

import com.epam.task.figures.entities.Pyramid;
import com.epam.task.figures.repository.specifications.PyramidQuerySpecification;
import org.junit.Assert;
import org.junit.Test;

public abstract class PyramidQuerySpecificationTest {
    public abstract PyramidQuerySpecification getSpecification();
    public abstract Pyramid getSpecifiedPyramid();
    public abstract Pyramid getNonSpecifiedPyramid();

    @Test
    public void testSpecifiedShouldReturnTrueWhenSpecifiedPyramidApplied() {
        PyramidQuerySpecification specification = getSpecification();
        Pyramid specifiedPyramid = getSpecifiedPyramid();

        boolean actual = specification.specified(specifiedPyramid);

        Assert.assertTrue(actual);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenNonSpecifiedSPyramidApplied() {
        PyramidQuerySpecification specification = getSpecification();
        Pyramid specifiedPyramid= getNonSpecifiedPyramid();

        boolean actual = specification.specified(specifiedPyramid);

        Assert.assertFalse(actual);
    }
}
