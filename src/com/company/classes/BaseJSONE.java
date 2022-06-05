package com.company.classes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class BaseJSONE {

    public static void serializeTriangleJSON (ListTriangle trianglesList) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("./src/DatabaseJSON/" + LocalDate.now() + "-" + LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getMinute() + "-" + LocalDateTime.now().getSecond() +"f.json"), trianglesList);
    }

    public static void serializeRightTriangleJSON (RightListTriangle rightTriangleList) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("./src/DatabaseJSON/" + LocalDate.now() + "-" + LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getMinute() + "-" + LocalDateTime.now().getSecond() +"s.json"), rightTriangleList);
    }

    public static ListTriangle deserializeTriangleJSON() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Objects.requireNonNull(new File("./src/DatabaseJSON").listFiles())[Objects.requireNonNull(new File("./src/DatabaseJSON").listFiles()).length-1], ListTriangle.class);
    }

    public static RightListTriangle deserializeRightTriangleJSON() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Objects.requireNonNull(new File("./src/DatabaseJSON").listFiles())[Objects.requireNonNull(new File("./src/DatabaseJSON").listFiles()).length-2], RightListTriangle.class);
    }

}
