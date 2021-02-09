package com.epam.task.figures.logic;

import com.epam.task.figures.entities.Point;
import com.epam.task.figures.entities.Pyramid;
import org.junit.Assert;
import org.junit.Test;

public class PyramidCalculatorTest {
    private PyramidCalculator calculator=new PyramidCalculator();
    private static final double OFFSET = 0.01;

    @Test
    public void testIsCorrectPyramidShouldReturnTrueWhenCorrectPyramidApplied(){
        Pyramid pyramid=new Pyramid(new Point(0, 0, 0),new Point(0, 0, 5),new Point(5,0,5),new Point(5,0,0),new Point(2.5,5,2.5));

        boolean actual=calculator.isCorrectPyramid(pyramid);

        Assert.assertEquals(true,actual);
    }

    @Test
    public void testIsCorrectPyramidShouldReturnFalseWhenNotPyramidApplied(){
        Pyramid pyramid=new Pyramid(new Point(0, 0, 0),new Point(0, 0, 0),new Point(5,5,0),new Point(0,0,0),new Point(2.5,2.5,5));

        boolean actual=calculator.isCorrectPyramid(pyramid);

        Assert.assertEquals(false,actual);
    }

    @Test
    public void testIsBaseOfPyramidOnXOZPlaneShouldReturnTrueWhenPyramidIsOnXOZPlane(){
        Pyramid pyramid=new Pyramid(new Point(0, 0, 0),new Point(0, 0, 5),new Point(5,0,5),new Point(5,0,0),new Point(2.5,5,2.5));

        boolean actual=calculator.isBaseOfPyramidOnXOZPlane(pyramid);

        Assert.assertEquals(true,actual);
    }

    @Test
    public void testIsBaseOfPyramidOnXOZPlaneShouldReturnFalseWhenPyramidIsNotOnXOZPlane(){
        Pyramid pyramid=new Pyramid(new Point(0, 2, 0),new Point(0, 2, 5),new Point(5,2,5),new Point(5,2,0),new Point(2.5,5,2.5));

        boolean actual=calculator.isBaseOfPyramidOnXOZPlane(pyramid);

        Assert.assertEquals(false,actual);
    }

    @Test
    public void testGetVolumeRatioShouldReturnVolumeRatioWhenPyramidCuttedByPlsne(){
        Pyramid pyramid=new Pyramid(new Point(0, 0, 0),new Point(0, 0, 6),new Point(6,0,6),new Point(6,0,0),new Point(3,7,3));

        double actual=calculator.getVolumeRatio(pyramid,2.5);

        Assert.assertEquals(1.8,actual,OFFSET);
    }

    @Test
    public void testFindSurfaceAreaOfPyramidShouldReturnSurfaceAreaOfPyramidWhenCorrectPyramidApplied(){
        Pyramid pyramid=new Pyramid(new Point(0, 0, 0),new Point(0, 0, 6),new Point(6,0,6),new Point(6,0,0),new Point(3,7,3));

        double actual=calculator.findSurfaceAreaOfPyramid(pyramid);

        Assert.assertEquals(127.389,actual,OFFSET);
    }

    @Test
    public void testFindVolumeOfPyramidShouldReturnVolumeOfPyramidWhenCorrectPyramidApplied(){
        Pyramid pyramid=new Pyramid(new Point(0, 0, 0),new Point(0, 0, 6),new Point(6,0,6),new Point(6,0,0),new Point(3,7,3));

        double actual=calculator.findVolumeOfPyramid(pyramid);

        Assert.assertEquals(84,actual,OFFSET);
    }

    @Test
    public void testFindLineLengthShouldReturnLineLengthWhenTwoPointsApplied(){
        Point a=new Point(0,0,0);
        Point b=new Point(5,0,0);

        double actual=calculator.findLineLength(a,b);

        Assert.assertEquals(5,actual,OFFSET);
    }

    @Test
    public void testFindBaseAreaShouldReturnBaseAreaWhenCorrectPyramidApplied(){
        Pyramid pyramid=new Pyramid(new Point(0, 0, 0),new Point(0, 0, 6),new Point(6,0,6),new Point(6,0,0),new Point(3,7,3));

        double actual=calculator.findBaseArea(pyramid);

        Assert.assertEquals(36,actual,OFFSET);
    }

    @Test
    public void testFindTriangleAreaShouldReturnTriangleAreaWhenThreePointsApplied(){
        Point a=new Point(0,0,0);
        Point b=new Point(6,0,0);
        Point c=new Point(0,3,0);

        double actual=calculator.findTriangleArea(a,b,c);

        Assert.assertEquals(9,actual,OFFSET);
    }
}
