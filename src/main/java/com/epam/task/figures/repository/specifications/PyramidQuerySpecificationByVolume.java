package com.epam.task.figures.repository.specifications;

import com.epam.task.figures.entities.Pyramid;
import com.epam.task.figures.logic.PyramidCalculator;

public class PyramidQuerySpecificationByVolume implements PyramidQuerySpecification{
    private PyramidCalculator calculator;
    private double minVolume;
    private double maxVolume;

    public PyramidQuerySpecificationByVolume(PyramidCalculator calculator, double minVolume, double maxVolume) {
        this.calculator = calculator;
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specified(Pyramid pyramid) {
        double volume = calculator.findVolumeOfPyramid(pyramid);
        return  volume > minVolume && volume < maxVolume;
    }
}
