package com.epam.task.figures.observer;

import com.epam.task.figures.entities.Pyramid;
import com.epam.task.figures.entities.PyramidRegistrar;
import com.epam.task.figures.logic.PyramidCalculator;

import java.util.HashMap;
import java.util.Map;

public class PyramidObserver implements Observer{
    private final PyramidCalculator calculator;
    private static PyramidObserver EXAMPLE;
    private Map<Integer, PyramidRegistrar> observablePyramids = new HashMap<>();

    private PyramidObserver(PyramidCalculator calculator){
        this.calculator=calculator;
    }

    public static PyramidObserver getExample(PyramidCalculator calculator) {
        if (EXAMPLE == null) {
            EXAMPLE = new PyramidObserver(calculator);
        }
        return EXAMPLE;
    }

    public Map<Integer, PyramidRegistrar> getObservablePyramids() {
        return observablePyramids;
    }

    @Override
    public void update(Pyramid updatedPyramid) {
        double newArea=calculator.findSurfaceAreaOfPyramid(updatedPyramid);
        double newVolume=calculator.findVolumeOfPyramid(updatedPyramid);

        PyramidRegistrar registrar=new PyramidRegistrar(newVolume,newArea);
        observablePyramids.put(updatedPyramid.getId(),registrar);
    }
}
