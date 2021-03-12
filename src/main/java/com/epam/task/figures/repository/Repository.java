package com.epam.task.figures.repository;

import com.epam.task.figures.entities.Point;
import com.epam.task.figures.entities.Pyramid;
import com.epam.task.figures.repository.specifications.PyramidQuerySpecification;

import java.util.Comparator;
import java.util.List;

public interface Repository {
    void addPyramid(Pyramid pyramid);
    void removePyramid(Pyramid pyramid);
    void updatePyramid(Pyramid pyramid, Point a);

    List<Pyramid> query(PyramidQuerySpecification pyramidQuerySpecification);
    List<Pyramid> query(PyramidQuerySpecification sphereQuerySpecification, Comparator<Pyramid> pyramidomparator);
}
