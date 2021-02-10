package com.epam.task.figures.repository.specifications;

import com.epam.task.figures.entities.Pyramid;

public interface PyramidQuerySpecification {
    boolean specified(Pyramid pyramid);
}
