package com.company.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
@JsonIgnoreProperties(ignoreUnknown = true)
public class RightListTriangle implements Serializable {
    private final ArrayList<RightTriangle> triangles;

    public RightListTriangle() {
        triangles = new ArrayList<>();
    }

    public  ArrayList<RightTriangle> getList() {
        return triangles;
    }
    @Override
    public String toString() {
        return "AllTriangle " + triangles;
    }

    public void add(RightTriangle triangle) {triangles.add(triangle);
    }

    public void remove(int number) {
        if (number < triangles.size() && number >= 0)
            triangles.remove(number);
    }

    public void remove(RightTriangle triangle) {
        triangles.remove(triangle);
    }

    public Triangle minHypotenuseRightTriangle() {
        int minHypotenuse = 9999;
        Triangle tmpTriangle = new Triangle(0, 0, 0);
        for (Triangle triangle : triangles) {
            if ((triangle instanceof RightTriangle) && (((RightTriangle) triangle).getHypotenuse() < minHypotenuse)) {
                tmpTriangle = triangle;
                minHypotenuse = Math.max(Math.max(triangle.getSideOne(), triangle.getSideTwo()), triangle.getSideThree());
            }
        }
        return tmpTriangle;
    }
}
