package com.btcag.bootcamp.W03.Traffic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Path filepath = Paths.get("C:/Users/AABLESSM/IdeaProjects/BootcampScripts/src/main/java/com/btcag/bootcamp/W03/Traffic/Map.txt");
        String content = Files.readString(filepath);
        Map map = new Map(content);
        content = null;
        filepath = null;
        Car car1 = new Car(map.getStartX(), map.getStartY(), map);
        Car car2 = new Car(map.getStartX(), map.getStartY(), map);
        drawMapWithCars(map, car1, car2);
    }

    public static void drawMapWithCars(Map map, Car car1, Car car2) { // look, I can use numbers in variable names
        if (
            map.getMap().equals(car1.getMap().getMap()) &&
            map.getMap().equals(car2.getMap().getMap())
        ) {
            int width = map.getWidth();
            int height = map.getHeight();
            for (int y=0; y < height; y++) {
                for (int x=0; x < width; x++) {
                    if (
                            x == car1.getX() && y == car1.getY() &&
                            x == car2.getX() && y == car2.getY()
                    ) {
                        System.out.print('X');
                    }
                    else if (x == car1.getX() && y == car1.getY()) {
                        System.out.print(1);
                    } else if (x == car2.getX() && y == car2.getY()) {
                        System.out.print(2);
                    } else {
                        System.out.print(map.getChar(x, y));
                    }
                }
                System.out.println();
            }
        }
    }
}
