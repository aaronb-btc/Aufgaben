package com.btcag.bootcamp.W03.Traffic;

public class Car {
    private double x;
    private double y;
    private int direction;
    private double speed = 0;
    private Map map;

    public Car(double x, double y, Map map) {
        this.x = x;
        this.y = y;
        this.map = map;
    }

    void moveForward() {
        char myChar = map.getChar((int) this.x, (int) this.y);
        String charString = "" + myChar;
        if (!"─│╫".contains(charString)) {
            if (this.speed < 1) this.speed += 0.2;
            if (this.speed > 1) this.speed = 1;
        } else {

            if ("┘┬┌".contains(charString)) {
                direction = (direction + 1) % 4;
                this.speed /= 2;
            } else if ("┐└".contains(charString)) {
                direction = (direction - 1) % 4;
                this.speed /= 2;
            }
            if (this.speed < 0.1) speed = 0.1;
        }

        switch (this.direction) {
            case 0:
                this.y -= this.speed;
                break;
            case 1:
                this.x -= this.speed;
                break;
            case 2:
                this.y += this.speed;
                break;
            case 3:
                this.x += this.speed;
                break;
        }
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
}