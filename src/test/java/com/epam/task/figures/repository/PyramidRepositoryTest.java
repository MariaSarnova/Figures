package com.epam.task.figures.repository;

import com.epam.task.figures.entities.Point;
import com.epam.task.figures.entities.Pyramid;
import com.epam.task.figures.observer.PyramidObservable;
import com.epam.task.figures.repository.sort.SortPyramidsUpByVolume;
import com.epam.task.figures.repository.specifications.PyramidQuerySpecification;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PyramidRepositoryTest {
    private final Pyramid FIRST_PYRAMID = new Pyramid(new Point(0, 0, 0),new Point(0, 0, 6),new Point(6,0,6),new Point(6,0,0),new Point(3,7,3));
    private final Pyramid SECOND_PYRAMID =  new Pyramid(new Point(0, 0, 0),new Point(0, 0, 10),new Point(10,0,10),new Point(10,0,0),new Point(5,12,5));
    private final Pyramid THIRD_PYRAMID =  new Pyramid(new Point(0, 0, 0),new Point(0, 0, 10),new Point(10,0,10),new Point(10,0,0),new Point(5,12,5));


    @Test
    public void testQueryShouldReturnListOfPyramidsWhenUniquePiramidsInserted() {
        Repository repository = new PyramidRepository();
        PyramidQuerySpecification PyramidSpecification = Mockito.mock(PyramidQuerySpecification.class);
        when(PyramidSpecification.specified(any(Pyramid.class))).thenReturn(true);

        repository.addPyramid(FIRST_PYRAMID);
        repository.addPyramid(SECOND_PYRAMID);

        List<Pyramid> actualList = repository.query(PyramidSpecification);
        Pyramid[] actual = new Pyramid[actualList.size()];
        actualList.toArray(actual);

        Assert.assertArrayEquals(new Pyramid[]{FIRST_PYRAMID, SECOND_PYRAMID}, actual);
    }

    @Test
    public void testQueryShouldReturnListOfElementsWhenNonUniquePyramidsInserted() {
        Repository repository = new PyramidRepository();
        PyramidQuerySpecification PyramidSpecification = Mockito.mock(PyramidQuerySpecification.class);
        when(PyramidSpecification.specified(any(Pyramid.class))).thenReturn(true);

        repository.addPyramid(FIRST_PYRAMID);
        repository.addPyramid(SECOND_PYRAMID);
        repository.addPyramid(SECOND_PYRAMID);

        List<Pyramid> actualList = repository.query(PyramidSpecification);
        Pyramid[] actual = new Pyramid[actualList.size()];
        actualList.toArray(actual);

        Assert.assertArrayEquals(new Pyramid[]{FIRST_PYRAMID, SECOND_PYRAMID}, actual);
    }


}
