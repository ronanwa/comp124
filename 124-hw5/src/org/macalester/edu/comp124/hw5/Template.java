package org.macalester.edu.comp124.hw5;

import java.util.List;

public class Template {
    private String name;
    private List<Point> points;

   public Template(String name, List<Point> points){
        this.points = points;
        this.name = name;
    }

    public List<Point> getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

}
