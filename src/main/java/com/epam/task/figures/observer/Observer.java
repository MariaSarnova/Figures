package com.epam.task.figures.observer;

import com.epam.task.figures.entities.Pyramid;

public interface Observer {
    void update(Pyramid updatedPyramid);
}
