package com.company.classes;

import java.util.Arrays;

public class AllTriangle {
    private Triangle[] AllTriangle;

    public AllTriangle(int length) {
        this.AllTriangle = new Triangle[length];
    }

    public AllTriangle() {
        AllTriangle = new Triangle[0];
    }

    public void setTriangleAt(int index, Triangle triangle) {
        AllTriangle[index] = triangle;
    }

    public void add(Triangle triangle) {
        int n = 0;
        for (Triangle triangle1 : AllTriangle) {
            if (triangle1 == null) {
                break;
            } else {
                n++;
            }
        }
        if (AllTriangle.length == n) {
            resize(n + 1);
        }
        setTriangleAt(n, triangle);
    }

    public void resize(int newLength) {
        Triangle[] tempTriangles = new Triangle[newLength];
        tempTriangles = Arrays.copyOf(AllTriangle, newLength);
        AllTriangle = tempTriangles;
    }

    public double maxSquare() {
        double value = 0;
        for (Triangle triangle : AllTriangle) {
            if (value < triangle.getSquare()) {
                value = triangle.getSquare();
            }
        }
        return value;
    }

    public Triangle minHypotenuseRightTriangle() {
        int minHypotenuse = 9999;
        Triangle tmpTriangle = new Triangle(0, 0, 0);
        for (Triangle triangle : AllTriangle) {
            if ((triangle instanceof RightTriangle) && (((RightTriangle) triangle).getHypotenuse() < minHypotenuse)) {
                tmpTriangle = triangle;
                minHypotenuse = Math.max(Math.max(triangle.getSideOne(), triangle.getSideTwo()), triangle.getSideThree());
            }
        }
        return tmpTriangle;
    }

    @Override
    public String toString() {
        String result = "AllTriangle :" + System.lineSeparator();
        for (Triangle triangle : AllTriangle) {
            result += triangle;
        }
        return result;
    }
}
