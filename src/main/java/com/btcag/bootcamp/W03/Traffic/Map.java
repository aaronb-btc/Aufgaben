package com.btcag.bootcamp.W03.Traffic;

import java.util.Objects;
import java.util.Scanner;

public class Map {
    private int startX;
    private int startY;
    private int height;
    private int width;
    private String map = "";

    public Map(String map) {
        Scanner scanner = new Scanner(map);
        String line;
        while (scanner.hasNextLine()) {
            height++;
            line = scanner.nextLine();
            if (width < line.length()) width = line.length();
        }
        scanner.close();

        scanner = new Scanner(map);
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            this.map += line;
            for (int i = 0; i < this.width - line.length(); i++) {
                this.map += ' ';
            }
            if (scanner.hasNextLine()) this.map += '\n';
        }
        scanner.close();
        for (int i = 0; i < this.map.length(); i++) {
            if (this.map.charAt(i) == '╫') {
                this.startY = i / this.width;
                this.startX = i % this.width - this.startY;
                i = this.map.length();
            }
        }
    }

    int getHeight() {
        return this.height;
    }

    int getWidth() {
        return this.width;
    }

    int getStartX() {
        return this.startX;
    }

    int getStartY() {
        return this.startY;
    }

    char getChar(int x, int y) {
        return this.map.charAt(y * (this.width + 1) + x);
    }

    String getMap() {
        return this.map;
    }

    @Override
    public String toString() {
        return "Map{" +
                "height=" + height +
                ", width=" + width +
                ", map='" + map + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Map map1 = (Map) o;
        return height == map1.height && width == map1.width && Objects.equals(map, map1.map);
    }
}
