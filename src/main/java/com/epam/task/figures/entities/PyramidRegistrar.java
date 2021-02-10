package com.epam.task.figures.entities;

import java.util.Objects;

public class PyramidRegistrar {
    private double volume;
    private double area;

    public PyramidRegistrar(double volume,double area){
        this.volume=volume;
        this.area=area;
    }

    public double getArea(){
        return area;
    }

    public void setArea(double area){
        this.area=area;
    }

    public double getVolume(){
        return volume;
    }

    public void setVolume(double volume){
        this.volume=volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PyramidRegistrar that = (PyramidRegistrar) o;
        return Double.compare(that.volume, volume) == 0 &&
                Double.compare(that.area, area) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume, area);
    }

    @Override
    public String toString() {
        return "PyramidRegistrar{" +
                "volume=" + volume +
                ", area=" + area +
                '}';
    }
}
