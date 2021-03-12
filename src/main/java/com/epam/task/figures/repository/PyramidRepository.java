package com.epam.task.figures.repository;

import com.epam.task.figures.entities.Point;
import com.epam.task.figures.entities.Pyramid;
import com.epam.task.figures.repository.specifications.PyramidQuerySpecification;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class PyramidRepository implements Repository{
    private  List<Pyramid> pyramids = new LinkedList<>();

    @Override
    public void addPyramid(Pyramid pyramid) {
       if (!pyramids.contains(pyramid)) {
            pyramids.add(pyramid);
        }
    }

    public void addPyramids(List<Pyramid> pyramidList) {
        for (Pyramid pyramid : pyramidList) {
            addPyramid(pyramid);
        }
    }

    @Override
    public void removePyramid(Pyramid pyramid) {
        pyramids.remove(pyramid);
    }

    @Override
    public void updatePyramid(Pyramid pyramid, Point a) {
        if (pyramids.contains(pyramid)) {
            removePyramid(pyramid);
            pyramid.setA(a);
            addPyramid(pyramid);
        }
    }

    @Override
    public List<Pyramid> query(PyramidQuerySpecification pyramidQuerySpecification) {
        List<Pyramid> listPyramids = new LinkedList<>();
        for (Pyramid pyramid : pyramids) {
            if (pyramidQuerySpecification.specified(pyramid)) {
                listPyramids.add(pyramid);
            }
        }
        return listPyramids;
    }

    @Override
    public List<Pyramid> query(PyramidQuerySpecification pyramidQuerySpecification, Comparator<Pyramid> pyramidComparator) {
        List<Pyramid> resultList = query(pyramidQuerySpecification);
        resultList.sort(pyramidComparator);
        return resultList;
    }
}
