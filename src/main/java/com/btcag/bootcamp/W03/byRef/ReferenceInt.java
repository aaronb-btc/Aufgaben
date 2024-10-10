package com.btcag.bootcamp.W03.byRef;

public class ReferenceInt {
    private int myInt;

    public ReferenceInt(int myInt) {
        this.myInt = myInt;
    }

    void addToInt(int val) {
        this.myInt += val;
    }

    int getInt() {
        return this.myInt;
    }
}
