package com.epam.task.figures.repository.specifications;

import com.epam.task.figures.entities.Pyramid;
import com.epam.task.figures.logic.PyramidCalculator;

public class PyramidQuerySpecificationByArea implements PyramidQuerySpecification{
    private PyramidCalculator calculator;
    private double minArea;
    private double maxArea;

    public PyramidQuerySpecificationByArea(PyramidCalculator calculator, double minArea, double maxArea) {
        this.calculator = calculator;
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specified(Pyramid pyramid) {
        double area = calculator.findSurfaceAreaOfPyramid(pyramid);
        return  area > minArea && area < maxArea;
    }
}
