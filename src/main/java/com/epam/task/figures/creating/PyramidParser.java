package com.epam.task.figures.creating;

import com.epam.task.figures.entities.Point;
import com.epam.task.figures.entities.Pyramid;

public class PyramidParser {
    public Pyramid parse(String data) {
        String[] Elements = data.split(" ");

        Double ax = new Double(Elements[0]);
        Double ay = new Double(Elements[1]);
        Double az = new Double(Elements[2]);

        Double bx = new Double(Elements[3]);
        Double by = new Double(Elements[4]);
        Double bz = new Double(Elements[5]);

        Double cx = new Double(Elements[6]);
        Double cy = new Double(Elements[7]);
        Double cz = new Double(Elements[8]);

        Double dx = new Double(Elements[9]);
        Double dy = new Double(Elements[10]);
        Double dz = new Double(Elements[11]);

        Double ex = new Double(Elements[12]);
        Double ey = new Double(Elements[13]);
        Double ez = new Double(Elements[14]);

        return new Pyramid(new Point(ax, ay, az), new Point(bx, by, bz),new Point(cx, cy, cz),new Point(dx, dy, dz),new Point(ex, ey, ez));
    }
}
