package ru.rishat;

public interface ListDemo<T> {

    void add(T t);

    boolean remove(T t);

    T get(int index);

    int indexOf(T t);

    int size();
}
