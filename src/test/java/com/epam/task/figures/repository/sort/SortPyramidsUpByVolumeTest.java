package com.epam.task.figures.repository.sort;

import com.epam.task.figures.entities.Point;
import com.epam.task.figures.entities.Pyramid;
import com.epam.task.figures.observer.PyramidObservable;

import java.util.Comparator;

public class SortPyramidsUpByVolumeTest extends SortPyramidsTest{
    @Override
    public Comparator<Pyramid> getComparator() {
        return (Comparator<Pyramid>) new SortPyramidsDownByVolume();
    }

    @Override
    public Pyramid getBiggerVolumePyramid() {
        return new Pyramid(new Point(0, 0, 0),new Point(0, 0, 10),new Point(10,0,10),new Point(10,0,0),new Point(5,12,5));
    }

    @Override
    public Pyramid getSmallerVolumePyramid() {
        return new Pyramid(new Point(0, 0, 0),new Point(0, 0, 6),new Point(6,0,6),new Point(6,0,0),new Point(3,7,3));
    }
}
