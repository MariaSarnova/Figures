package com.epam.task.figures.repository.sort;

import com.epam.task.figures.entities.Pyramid;
import com.epam.task.figures.logic.PyramidCalculator;

import java.util.Comparator;

public class SortPyramidsDownByVolume implements Comparator<Pyramid> {
    PyramidCalculator calculator=new PyramidCalculator();
    @Override
    public int compare(Pyramid first, Pyramid second) {
        double firstVolume=calculator.findVolumeOfPyramid(first);
        double secondVolume=calculator.findVolumeOfPyramid(second);
        return Double.compare(firstVolume,secondVolume);
    }
}
