package ru.rishat;

public class ArrayListDemo<T> implements ListDemo<T> {

    private Object[] array;
    private int size = 0;

    public ArrayListDemo() {
        array = new Object[10];
    }

    private void checkLength() {
        if (size == array.length) {
            Object[] newArray = new Object[array.length*3/2+1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }

    @Override
    public void add(T t) {
        checkLength();
        array[size++] = t;
    }

    @Override
    public boolean remove(T t) {
        int index = indexOf(t);

        if (checkIndex(index)) {
            if (array.length - 1 - index >= 0) {
                System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
            }
            size--;
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(T t) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(t)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public T get(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (checkIndex(index)) {
            return (T) array[index];
        }
        return null;
    }

    private boolean checkIndex(int index) {
        return index <= size;
    }

    @Override
    public int size() {
        return size;
    }

}
