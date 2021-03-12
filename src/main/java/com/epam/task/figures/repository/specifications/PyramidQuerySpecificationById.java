package com.epam.task.figures.repository.specifications;

import com.epam.task.figures.entities.Pyramid;

public class PyramidQuerySpecificationById implements PyramidQuerySpecification{
    private int id;

    public PyramidQuerySpecificationById(int desiredId) {
        this.id = desiredId;
    }

    @Override
    public boolean specified(Pyramid pyramid) {
        return this.id == pyramid.getId();
    }
}
