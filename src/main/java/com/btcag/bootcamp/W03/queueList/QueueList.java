package com.btcag.bootcamp.W03.queueList;

import java.util.Arrays;

public class QueueList {
    private int elementsInList = 0;
    private int[] myArray = new int[1];

    private void copyArray(int[] inArr, int[] outArr) {
        if (inArr.length <= outArr.length) {
            for (int i=0; i < inArr.length; i++) {
                outArr[i] = inArr[i];
            }
        }
    }

    private int[] extendArray(int[] arr) {
        int[] copiedArr = new int[arr.length * 2];
        this.copyArray(arr, copiedArr);
        return copiedArr;
    }

    void pushBack(int element) {
        this.elementsInList += 1;
        if (this.elementsInList > this.myArray.length) {
            this.myArray = this.extendArray(this.myArray);
        }
        this.myArray[this.elementsInList - 1] = element;
    }

    void pushFront(int element) {
        this.elementsInList += 1;
        if (this.elementsInList > this.myArray.length) {
            this.myArray = this.extendArray(this.myArray);
        }
        for (int i=elementsInList - 1; i > 0; i--) {
            this.myArray[i] = this.myArray[i - 1];
        }
        this.myArray[0] = element;
    }

    int popBack() {
        this.elementsInList -= 1;
        int value = this.myArray[this.elementsInList];
        this.myArray[this.elementsInList] = 0;
        return value;
    }

    int popFront() {
        this.elementsInList -= 1;
        int value = this.myArray[0];
        for (int i=0; i < this.myArray.length - 1; i++) {
            this.myArray[i] = this.myArray[i + 1];
        }
        this.myArray[this.elementsInList] = 0;
        return value;
    }

    int getIndex(int index) {
        if (index > this.elementsInList) {
            return this.myArray[index];
        }
        System.err.println("ERR: Index not in list");
        return 0;
    }

    @Override
    public String toString() {
        String s = "QueueList{" +
                "myArray=" + Arrays.toString(myArray) +
                '}';
        return s;
    }
}
