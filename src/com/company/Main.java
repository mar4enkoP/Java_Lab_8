package com.company;

import com.company.classes.*;

import java.io.IOException;

public class Main {

    public static final int M = 5;
    public static final int N = 5;
    public static final int MAX_SIDE = 100;

    public Main() {
    }

    /**
     * 11.  Создать класс треугольник, члены класса – длины 3-х сторон.
     *      Предусмотреть в классе методы проверки существования треугольника,
     *      вычисления и вывода сведений о фигуре – длины сторон, углы, периметр, площадь.
     *      Создать производный класс – прямоугольный треугольник, предусмотреть в классе проверку, является ли треугольник прямоугольным.
     *      Написать программу, демонстрирующую работу с классом: дано N треугольников и M прямоугольных треугольников,
     *      найти треугольник с максимальной площадью и прямоугольный треугольник с наименьшей гипотенузой.
     *
     *      Реализовать сериализацию/десериализацию данных в файл/из файла на диске для Задания №6 в виде отдельного класса с методами Save и Load (2 балла).
     *      Использовать независимых 2 способа: нативную Java-сериализацию и любую внешнюю библиотеку (2 балла).
     *      Предусмотреть автоматическое создание новой резервной копии файла данных при завершении работы программы, имя файла - метка времени (1 балл)
     *      Реализовать восстановление данных из последней созданной копии при запуске (1 балл).
     */
    public static void main(String[] args) throws IOException {
        int sideOne, sideTwo, sideThree;


        System.out.println("\n---Load---\n");

        ListTriangle trianglesListOne = new ListTriangle();
        RightListTriangle rightTrianglesListOne = new RightListTriangle();
        ListTriangle trianglesListTwo = new ListTriangle();
        RightListTriangle rightTriangleListTwo = new RightListTriangle();

        try {
            trianglesListOne = DataBase.deserializeTriangle();
            rightTrianglesListOne = DataBase.deserializeRightTriangle();

            trianglesListTwo = BaseJSONE.deserializeTriangleJSON();
            rightTriangleListTwo = BaseJSONE.deserializeRightTriangleJSON();

            System.out.println(trianglesListOne);
            System.out.println(rightTrianglesListOne);

            System.out.println("\n--------------------------------\n");

            System.out.println(trianglesListTwo);
            System.out.println(rightTriangleListTwo);
        } catch (Exception e) {
            for (int i = 0; i < M; i++) {
                while (!Triangle.existsTriangle(sideOne = ((int) (Math.random() * MAX_SIDE + 1)), sideTwo = ((int) (Math.random() * MAX_SIDE + 1)), sideThree = ((int) (Math.random() * MAX_SIDE + 1)))) {
                    //System.out.println(sideOne + " " + sideTwo + " " + sideThree);
                }
                trianglesListOne.add(new Triangle(sideOne, sideTwo, sideThree));
                trianglesListTwo.add(new Triangle(sideOne, sideTwo, sideThree));
            }
            System.out.println(trianglesListOne);
            System.out.println(trianglesListOne.maxSquare());


            System.out.println("\n--------------------------------\n");


            for (int i = 0; i < N; i++) {
                while (!RightTriangle.existsRightTriangle(sideOne = ((int) (Math.random() * MAX_SIDE + 1)), sideTwo = ((int) (Math.random() * MAX_SIDE + 1)), sideThree = ((int) (Math.random() * MAX_SIDE + 1)))) {
                    //System.out.println(sideOne + " " + sideTwo + " " + sideThree);
                }
                rightTrianglesListOne.add(new RightTriangle(sideOne, sideTwo, sideThree));
                rightTriangleListTwo.add(new RightTriangle(sideOne, sideTwo, sideThree));
            }
            System.out.println(rightTrianglesListOne);
            System.out.println(rightTrianglesListOne.minHypotenuseRightTriangle());


            System.out.println("\n--------------------------------\n");

        }

        DataBase.serializeTriangle(trianglesListOne);
        DataBase.serializeRightTriangle(rightTrianglesListOne);


        BaseJSONE.serializeTriangleJSON(trianglesListTwo);
        BaseJSONE.serializeRightTriangleJSON(rightTriangleListTwo);

    }
}
