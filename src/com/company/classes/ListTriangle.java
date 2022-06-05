package com.company.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListTriangle implements Serializable {
    private final ArrayList<Triangle> triangles;

    public ListTriangle() {
        triangles = new ArrayList<>();
    }

    public ArrayList<Triangle> getList() {
        return triangles;
    }

    @Override
    public String toString() {
        return "AllTriangle " + triangles;
    }

    public void add(Triangle triangle) {
        triangles.add(triangle);
    }

    public void remove(int number) {
        if (number < triangles.size() && number >= 0)
            triangles.remove(number);
    }

    public void remove(Triangle triangle) {
        triangles.remove(triangle);
    }

    public double maxSquare() {
        double value = 0;
        for (Triangle triangle : triangles) {
            if (value < triangle.getSquare()) {
                value = triangle.getSquare();
            }
        }
        return value;
    }

}

