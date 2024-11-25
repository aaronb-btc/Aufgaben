package com.btcag.bootcamp.W03.performantQueueList;

public interface IQueueList {
    int popFront();
    int popLast();
    int pushFront(int element);
    int pushLast(int element);
    int get(int index);
}
