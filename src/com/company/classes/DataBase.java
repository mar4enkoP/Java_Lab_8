package com.company.classes;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class DataBase {
    public static void serializeTriangle(ListTriangle trianglesList) {
        try {
            FileOutputStream fileOut = new FileOutputStream("./src/DataBase/" + LocalDate.now() + "-" + LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getMinute() + "-" + LocalDateTime.now().getSecond() + ".Tr");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(trianglesList);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void serializeRightTriangle(RightListTriangle rightTriangleList) {
        try {
            FileOutputStream fileOut = new FileOutputStream("./src/DataBase/" + LocalDate.now() + "-" + LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getMinute() + "-" + LocalDateTime.now().getSecond() + ".RigTr");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(rightTriangleList);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static ListTriangle deserializeTriangle() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(Objects.requireNonNull(new File("./src/DataBase").listFiles())[Objects.requireNonNull(new File("./src/DataBase").listFiles()).length - 1]);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ListTriangle trianglesList = (ListTriangle) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return trianglesList;
    }

    public static RightListTriangle deserializeRightTriangle() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(Objects.requireNonNull(new File("./src/DataBase").listFiles())[Objects.requireNonNull(new File("./src/DataBase").listFiles()).length - 2]);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        RightListTriangle rightTriangleList = (RightListTriangle) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return rightTriangleList;
    }
}
