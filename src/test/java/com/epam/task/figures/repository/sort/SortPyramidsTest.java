package com.epam.task.figures.repository.sort;

import com.epam.task.figures.entities.Pyramid;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public abstract class SortPyramidsTest {
    public abstract Comparator<Pyramid> getComparator();
    public abstract Pyramid getBiggerVolumePyramid();
    public abstract Pyramid getSmallerVolumePyramid();

    @Test
    public void testCompareShouldReturnPositiverWhenFirstPyramidIsLarger() {
        Comparator<Pyramid> comparator = getComparator();
        Pyramid biggerPyramid = getBiggerVolumePyramid();
        Pyramid smallerPyramid = getSmallerVolumePyramid();


        int actual = comparator.compare(biggerPyramid, smallerPyramid);

        Assert.assertEquals(1, actual);
    }
    @Test
    public void testCompareShouldReturnNegativeWhenFirstPyramidIsSmaller() {
        Comparator<Pyramid> comparator = getComparator();
        Pyramid biggerPyramid= getBiggerVolumePyramid();
        Pyramid smallerPyramid = getSmallerVolumePyramid();

        int actual = comparator.compare(smallerPyramid, biggerPyramid);

        Assert.assertEquals(-1, actual);
    }

    @Test
    public void testCompareShouldReturnNegativeWhenPyramidsAreEqual() {
        Comparator<Pyramid> comparator = getComparator();
        Pyramid pyramid = getSmallerVolumePyramid();

        int actual = comparator.compare(pyramid, pyramid);

        Assert.assertEquals(0, actual);
    }
}
