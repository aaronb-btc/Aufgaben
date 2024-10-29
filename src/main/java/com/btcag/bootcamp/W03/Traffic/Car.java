package com.btcag.bootcamp.W03.Traffic;

public class Car {
    private double x;
    private double y;
    private int direction;
    private int speed = 0;
    private Map map;
    private char lastChar = ' ';

    public Car(double x, double y, Map map, int direction) {
        this.x = x;
        this.y = y;
        this.map = map;
        this.direction = direction;
    }

    private double posMod(double a, double b) {
        double result = a % b;
        if (result < 0) result += b;
        return result;
    }
    void moveForward() {
        char myChar = map.getChar((int) this.x, (int) this.y);
        String charString = "" + myChar;
        if ("─│╫".contains(charString) || (this.direction % 2) == 1 && myChar == '┬') {
            if (this.speed < 100) this.speed += 20;
            if (this.speed > 100) this.speed = 100;
        } else if (lastChar != myChar) {
            this.speed /= 2;
            switch (myChar) {
                case('┘'):
                    this.direction = (int) ((int) 2 / (posMod(this.direction + 2, 4) + 1)) - 1;
                    break;
                case('└'):
                    this.direction = (int) ((int) 4 / (posMod(this.direction + 2, 4) + 1)) - 1;
                    break;
                case('┐'):
                    this.direction = (int) ((int) 6 / (posMod(this.direction + 2, 4) + 1)) - 1;
                    break;
                case('┌'):
                    this.direction = (int) ((int) 12 / (posMod(this.direction + 2, 4) + 1)) - 1;
                    break;
                case('┬'):
                    this.direction = 3;
                    break;
            }
        }

        switch (this.direction) {
            case 0:
                this.y -= (double) this.speed / 100;
                break;
            case 1:
                this.x -= (double) this.speed / 100;
                break;
            case 2:
                this.y += (double) this.speed / 100;
                break;
            case 3:
                this.x += (double) this.speed / 100;
                break;
        }
        this.lastChar = myChar;
    }

    Map getMap() {
        return new Map(this.map.getMap());
    }

    int getX() {
        return (int) this.x;
    }

    int getY() {
        return (int) this.y;
    }

    @Override
    public String toString() {
        return "Car{" +
                "map=" + map +
                ", speed=" + (double) speed / 100 +
                ", direction=" + direction +
                ", y=" + y +
                ", x=" + x +
                '}';
    }
}