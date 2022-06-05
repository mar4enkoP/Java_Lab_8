package com.company.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Triangle implements Serializable {
    protected int sideOne;
    protected int sideTwo;
    protected int sideThree;



    public Triangle(int sideOne, int sideTwo, int sideThree) {
        this.setSideOne(sideOne);
        this.setSideTwo(sideTwo);
        this.setSideThree(sideThree);
    }

    public Triangle() {
    }

    public static boolean existsTriangle(int side1, int side2, int side3) {
        return (side1 > 0) && (side2 > 0) && (side3 > 0) && (side1 + side2 > side3) && (side1 + side3 > side2) && (side3 + side2 > side1);
    }

    public int getSideOne() {
        return sideOne;
    }

    protected void setSideOne(int side1) {
        this.sideOne = side1;
    }

    public int getSideTwo() {
        return sideTwo;
    }

    protected void setSideTwo(int sideTwo) {
        this.sideTwo = sideTwo;
    }

    public int getSideThree() {
        return sideThree;
    }

    protected void setSideThree(int sideThree) {
        this.sideThree = sideThree;
    }

    public float getAngles(float sideA, float sideB, float sideC) {
        return (float) Math.toDegrees(Math.acos((sideA * sideA + sideB * sideB - sideC * sideC) / (2 * sideB * sideA)));
    }

    public int getPerimeter() {
        return (sideOne + sideTwo + sideThree);
    }

    public float getSquare() {
        float p = (sideOne + sideTwo + sideThree) / 2f;
        return (float) Math.sqrt(p * (p - sideOne) * (p - sideTwo) * (p - sideThree));
    }

    @Override
    public String toString() {
        return "Triangle : {" +
                "sideOne = " + sideOne +
                ", sideTwo = " + sideTwo +
                ", sideThree = " + sideThree +
                ", angleA = " + getAngles(sideOne, sideTwo, sideThree) +
                ", angleB = " + getAngles(sideOne, sideThree, sideTwo) +
                ", angleC = " + getAngles(sideThree, sideTwo, sideOne) +
                ", perimeter = " + getPerimeter() +
                ", square = " + getSquare() +
                '}' +
                System.lineSeparator();
    }
}
