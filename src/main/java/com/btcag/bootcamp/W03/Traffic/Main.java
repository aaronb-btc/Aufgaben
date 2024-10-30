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
        Car car1 = new Car(map.getStartX(), map.getStartY(), map, 1);
        Car car2 = new Car(map.getStartX(), map.getStartY(), map, 3);
        System.out.println(getMapWithCars(map, car1, car2));
        Scanner scanner = new Scanner(System.in);
        String currentState;
        int lastCar1X = -1;
        int lastCar1Y = -1;
        int lastCar2X = -1;
        int lastCar2Y = -1;
        while (true) {
            System.out.println("\nPress Enter to simulate the next step");
            scanner.nextLine();
            car1.moveForward();
            car2.moveForward();
            currentState = getMapWithCars(map, car1, car2);
            System.out.println(currentState);
            if (
                    currentState.contains("X") ||
                    car2.getX() == lastCar1X &&
                    car2.getY() == lastCar1Y &&
                    car1.getX() == lastCar2X &&
                    car1.getY() == lastCar2Y
            ) System.out.println("Crash detected.");
            lastCar1X = car1.getX();
            lastCar1Y = car1.getY();
            lastCar2X = car2.getX();
            lastCar2Y = car2.getY();
        }
    }

    public static String getMapWithCars(Map map, Car car1, Car car2) { // look, I can use numbers in variable names
        if (
            map.getMap().equals(car1.getMap().getMap()) &&
            map.getMap().equals(car2.getMap().getMap())
        ) {
            String myMap = "";
            int width = map.getWidth();
            int height = map.getHeight();
            for (int y=0; y < height; y++) {
                for (int x=0; x < width; x++) {
                    if (
                            x == car1.getX() && y == car1.getY() &&
                            x == car2.getX() && y == car2.getY()
                    ) {
                        myMap += 'X';
                    }
                    else if (x == car1.getX() && y == car1.getY()) {
                        myMap += 1;
                    } else if (x == car2.getX() && y == car2.getY()) {
                        myMap += 2;
                    } else {
                        myMap += map.getChar(x, y);
                    }
                }
                myMap += '\n';
            }
            return myMap;
        } else {
            return "";
        }
    }
}
