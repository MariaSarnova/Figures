package com.epam.task.figures.entities;

import com.epam.task.figures.generators.IdGenerator;

import java.util.Objects;

public class Pyramid extends Point{
    private Point a;
    private Point b;
    private Point c;
    private Point d;
    private Point e;
    private final int id;
    IdGenerator generator =new IdGenerator();

    public Pyramid(Point a,Point b,Point c,Point d,Point e){
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
        this.e=e;
        this.id=generator.nextId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pyramid pyramid = (Pyramid) o;
        return id == pyramid.id &&
                Objects.equals(a, pyramid.a) &&
                Objects.equals(b, pyramid.b) &&
                Objects.equals(c, pyramid.c) &&
                Objects.equals(d, pyramid.d) &&
                Objects.equals(e, pyramid.e) &&
                Objects.equals(generator, pyramid.generator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d,e);
    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", e=" + e +
                '}';
    }

    public int getId() {
        return id;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public Point getD() {
        return d;
    }

    public Point getE(){
        return e;
    }

    public void setA(Point a){
        this.a=a;
    }

    public void setB(Point b){
        this.b=b;
    }

    public void setC(Point c){
        this.c=c;
    }

    public void setD(Point d){
        this.d=d;
    }

    public void setE(Point e){
        this.e=e;
    }
}
