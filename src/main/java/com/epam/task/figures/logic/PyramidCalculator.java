package com.epam.task.figures.logic;

import com.epam.task.figures.entities.Point;
import com.epam.task.figures.entities.Pyramid;

public class PyramidCalculator {         //the base is assumed to be a quadrangle
    private static final double ZERO = 0.0;

    public boolean isCorrectPyramid(Pyramid pyramid){
        Point e=pyramid.getE();
        Point a=pyramid.getA();
        if(e.getY()==a.getY()){
            return false;
        }
        Point b=pyramid.getB();
        Point c=pyramid.getC();
        Point d=pyramid.getD();

        return (!a.equals(b)&&!b.equals(c)&&!c.equals(d)&&!d.equals(a)&&!a.equals(c)&&!b.equals(d));
    }

    public boolean isBaseOfPyramidOnXOZPlane(Pyramid pyramid){
        Point a=pyramid.getA();
        Point b=pyramid.getB();
        Point c=pyramid.getC();
        Point d=pyramid.getD();

        return (a.getY()==ZERO&&b.getY()==ZERO&&c.getY()==ZERO&&d.getY()==ZERO);
    }

    public double getVolumeRatio(Pyramid pyramid, double offset){
        Point a=pyramid.getA();
        Point e=pyramid.getE();
        if(offset<=a.getY()||offset>=e.getY()){
            return ZERO;
        }
        else{
            double height=e.getY()-a.getY();
            double heightOfSmallPyramid=e.getY()-offset;
            double volumeRatio=(heightOfSmallPyramid/(height-heightOfSmallPyramid));

            return volumeRatio;
        }
    }

    public double findSurfaceAreaOfPyramid(Pyramid pyramid){
        Point a=pyramid.getA();
        Point b=pyramid.getB();
        Point c=pyramid.getC();
        Point e=pyramid.getE();

        double baseArea=findBaseArea(pyramid);

        double areaABE=findTriangleArea(a,b,e);
        double areaBCE=findTriangleArea(b,c,e);

        double surfaceArea=baseArea+(areaABE+areaBCE)*2;

        return surfaceArea;
    }

    public double findVolumeOfPyramid(Pyramid pyramid){
        double baseArea=findBaseArea(pyramid);

        Point a=pyramid.getA();
        Point e=pyramid.getE();
        double height=Math.abs(e.getY()-a.getY());
        double volume=(baseArea*height)/3;
        return volume;
    }

    public double findLineLength(Point a,Point b){
        double lengthInX = a.getX()-b.getX();
        double lengthInY = a.getY()-b.getY();
        double lengthInZ = a.getZ()-b.getZ();

        double lengthInZX=Math.sqrt(lengthInX*lengthInX+lengthInZ*lengthInZ);
        double length = Math.sqrt(lengthInZX*lengthInZX+lengthInY*lengthInY);

        return length;
    }

    public double findBaseArea(Pyramid pyramid){
        Point a=pyramid.getA();
        Point b=pyramid.getB();
        Point c=pyramid.getC();

        double ab=findLineLength(a,b);
        double bc=findLineLength(b,c);

        double baseArea=Math.abs(ab*bc);
        return baseArea;
    }

    public double findTriangleArea(Point a,Point b,Point e){
        double lengthAB=findLineLength(a,b);
        double lengthAE=findLineLength(a,e);
        double lengthBE=findLineLength(b,e);

        double halfOfPerimetr=(lengthAB+lengthAE+lengthBE)/2;
        double area=Math.sqrt(halfOfPerimetr*(halfOfPerimetr-lengthAB)*(halfOfPerimetr-lengthAE)*(halfOfPerimetr-lengthBE));
        return area;
    }



}
