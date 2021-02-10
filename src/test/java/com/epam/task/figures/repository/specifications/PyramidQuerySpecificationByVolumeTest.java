package com.epam.task.figures.repository.specifications;

import com.epam.task.figures.entities.Point;
import com.epam.task.figures.entities.Pyramid;
import com.epam.task.figures.logic.PyramidCalculator;
import com.epam.task.figures.observer.PyramidObservable;

public class PyramidQuerySpecificationByVolumeTest extends PyramidQuerySpecificationTest{
    @Override
    public PyramidQuerySpecification getSpecification() {
        return new PyramidQuerySpecificationByArea(new PyramidCalculator(),0,200);
    }

    @Override
    public Pyramid getSpecifiedPyramid() {
        return new PyramidObservable(new Point(0, 0, 0),new Point(0, 0, 6),new Point(6,0,6),new Point(6,0,0),new Point(3,7,3));
    }

    @Override
    public Pyramid getNonSpecifiedPyramid() {
        return new Pyramid(new Point(0, 0, 0),new Point(0, 0, 10),new Point(10,0,10),new Point(10,0,0),new Point(5,12,5));
    }
}
