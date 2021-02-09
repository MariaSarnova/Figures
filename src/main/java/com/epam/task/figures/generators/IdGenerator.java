package com.epam.task.figures.generators;

public class IdGenerator {
    private int counter;

    public IdGenerator() {
        counter = 0;
    }

    public int nextId() {
        return counter++;
    }
}
