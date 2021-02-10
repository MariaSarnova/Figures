package com.epam.task.figures.observer;

import com.epam.task.figures.entities.Point;
import com.epam.task.figures.entities.Pyramid;
import com.epam.task.figures.entities.PyramidRegistrar;
import com.epam.task.figures.logic.PyramidCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

import static org.mockito.Mockito.when;

public class PyramidObserverTest {
    private static final PyramidObservable FIRST_PYRAMID = new PyramidObservable(new Point(0, 0, 0),new Point(0, 0, 6),new Point(6,0,6),new Point(6,0,0),new Point(3,7,3));
    private static final PyramidObservable SECOND_PYRAMID = new PyramidObservable(new Point(0, 0, 0),new Point(0, 0, 10),new Point(10,0,10),new Point(10,0,0),new Point(5,12,5));


    private static PyramidCalculator calculator = Mockito.mock(PyramidCalculator.class);

    private void updateMockCalculatorValues(Pyramid pyramid, double volume,double area) {
        when(calculator.findVolumeOfPyramid(pyramid)).thenReturn(volume);
        when(calculator.findSurfaceAreaOfPyramid(pyramid)).thenReturn(area);
    }
    @Before
    public void clearSphereObserver() throws NoSuchFieldException, IllegalAccessException {
        Field example = PyramidObserver.class.getDeclaredField("EXAMPLE");
        example.setAccessible(true);
        example.set(null, null);
    }

    @Test
    public void testObserverShouldDeletePyramidRegistrarObjectWhenPyramidHasRemovedObserver() {
        PyramidObserver pyramidObserver = PyramidObserver.getExample(calculator);

        updateMockCalculatorValues(FIRST_PYRAMID, 84,127.389);
        FIRST_PYRAMID.addObserver(pyramidObserver);
        updateMockCalculatorValues(SECOND_PYRAMID, 400.0,360.0);
        SECOND_PYRAMID.addObserver(pyramidObserver);

        PyramidRegistrar[] expected = {
                new PyramidRegistrar(calculator.findVolumeOfPyramid(SECOND_PYRAMID),calculator.findSurfaceAreaOfPyramid(SECOND_PYRAMID))
        };


        FIRST_PYRAMID.deleteObserver(pyramidObserver);
        FIRST_PYRAMID.setA(new Point(-2,0,-2));
        updateMockCalculatorValues(FIRST_PYRAMID, 115.4469,160.2257);


        Map<Integer, PyramidRegistrar> map = pyramidObserver.getObservablePyramids();
        Collection<PyramidRegistrar> values = map.values();
        PyramidRegistrar[] actualArray = new PyramidRegistrar[values.size()];
        values.toArray(actualArray);


        Assert.assertArrayEquals(expected, actualArray);
    }


}
