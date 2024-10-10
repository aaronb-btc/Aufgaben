package com.btcag.bootcamp.W03.queueList;

public class Main {
    public static void main(String[] args) {
        QueueList list = new QueueList();
        for (int i = 1; i < 10; i++) {
            list.pushFront(i);
        }
        System.out.println(list);
        for (int i = 1; i < 10; i++) {
            list.pushBack(i);
        }
        System.out.println(list);
        int value = list.popFront();
        System.out.println("popped value: " + value);
        System.out.println(list);
        value = list.popBack();
        System.out.println("popped value: " + value);
        System.out.println(list);
    }
}
