package com.epam.task.figures.observer;

import com.epam.task.figures.entities.Point;
import com.epam.task.figures.entities.Pyramid;

import java.util.ArrayList;
import java.util.List;

public class PyramidObservable extends Pyramid implements Observable {
    List<Observer> pyramidObservers = new ArrayList<>();

    public PyramidObservable(Point a, Point b, Point c, Point d, Point e){
        super(a,b,c,d,e);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer:pyramidObservers){
            observer.update(this);
        }
    }

    @Override
    public void addObserver(Observer observer) {
        pyramidObservers.add(observer);
        observer.update(this);
    }

    @Override
    public void deleteObserver(Observer observer) {
        pyramidObservers.remove(observer);
    }

    @Override
    public void setA(Point a){
        super.setA(a);
        notifyObservers();
    }

    @Override
    public void setB(Point b){
        super.setB(b);
        notifyObservers();
    }

    @Override
    public void setC(Point c){
        super.setC(c);
        notifyObservers();
    }

    @Override
    public void setD(Point d){
        super.setD(d);
        notifyObservers();
    }

    @Override
    public void setE(Point e){
        super.setE(e);
        notifyObservers();
    }
}
