package com.btcag.bootcamp.W03.performantQueueList;

public class PerformantQueueList implements IQueueList{
    private int startIndex = 0;
    private int endIndex = 1;
    private int[] myArray = new int[1];

    private int[] extendList(int[] arr) {
        int[] copiedArray = new int[arr.length * 2];
        for (int i=0; i < arr.length; i++) {
            copiedArray[i] = arr[i];
        }
        return copiedArray;
    }

    private int posMod(int a, int b) {
        int result = a % b;
        if (result < 0) return result + b;
        return result;
    }

    @Override
    public int pushFront(int value) {
        int elements = posMod(this.endIndex - this.startIndex, this.myArray.length);
        if (this.myArray.length - elements < 2) {
            this.myArray = extendList(this.myArray);
            if (this.endIndex < this.startIndex) {
                for (int i=0; i <= this.endIndex; i++) {
                    this.myArray[this.startIndex + (elements - this.endIndex) + i] = this.myArray[i];
                }
                this.endIndex = this.startIndex + elements;
            }
        }
        this.startIndex = posMod(this.startIndex - 1, this.myArray.length);
        this.myArray[startIndex] = value;
        return value;
    }

    @Override
    public int pushLast(int value) {
        int elements = posMod(this.endIndex - this.startIndex, this.myArray.length);
        if (this.myArray.length - elements < 2) {
            this.myArray = extendList(this.myArray);
            if (this.endIndex < this.startIndex) {
                for (int i=0; i <= this.endIndex; i++) {
                    this.myArray[this.startIndex + (elements - this.endIndex) + i] = this.myArray[i];
                }
                this.endIndex = this.startIndex + elements;
            }
        }
        this.endIndex = posMod(this.endIndex + 1, this.myArray.length);
        this.myArray[endIndex] = value;
        return value;
    }

    @Override
    public int popFront() {
        int value = this.myArray[this.startIndex];
        int newIndex = posMod(this.startIndex + 1, this.myArray.length);
        if (newIndex == this.endIndex) {
            return -1;
        }
        this.startIndex = newIndex;
        return value;
    }

    @Override
    public int popLast() {
        int value = this.myArray[this.endIndex];
        int newIndex = posMod(this.endIndex - 1, this.myArray.length);
        if (newIndex == this.startIndex) {
            return -1;
        }
        this.endIndex = newIndex;
        return value;
    }

    @Override
    public int get(int index) {
        index = posMod(this.startIndex + index, this.myArray.length);
        if (index >= posMod(this.endIndex - this.startIndex, this.myArray.length) || index < 0) {
            return -1;
        }
        return this.myArray[index];
    }

    @Override
    public String toString() {
        String list = "[";
        for (int i=this.startIndex; posMod(i, this.myArray.length) != this.endIndex; i++) {
            list += this.myArray[posMod(i, this.myArray.length)] + ", ";
        }
        list += this.myArray[this.endIndex] + "]";
        return "PerformantQueueList{" +
                list +
                '}';
    }


}
