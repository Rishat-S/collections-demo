package ru.rishat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListDemoTest {
    LinkedListDemo<Integer> listDemo = new LinkedListDemo<>();

    @BeforeEach
    void setUp() {
        for (int i = 0; i < 100; i++) {
            listDemo.add(i);
        }
    }

    @Test
    public void testToContains100element() {
        Assertions.assertEquals(100, listDemo.size());
    }

    @Test
    public void testGetElement() {
        Assertions.assertEquals(99, listDemo.get(100));
    }

    @Test
    public void testRemove() {
        Assertions.assertTrue(listDemo.remove(5));
        Assertions.assertEquals(99, listDemo.size());
    }

    @Test
    public void testAddOfIndex() {
        listDemo.add(5, 25);
        Assertions.assertEquals(101, listDemo.size());
        Assertions.assertEquals(25, listDemo.get(5));
    }

    @Test
    public void testAddOfIndexFirst() {
        listDemo.add(listDemo.size()-1, 55);
        Assertions.assertEquals(101, listDemo.size());
        Assertions.assertEquals(55, listDemo.get(listDemo.size()-1));
    }

    @Test
    public void testAddOfIndexLast() {
        listDemo.add(0, 55);
        Assertions.assertEquals(101, listDemo.size());
        Assertions.assertEquals(55, listDemo.get(0));
    }

    @Test
    public void removeFirst() {
        listDemo.remove(listDemo.size()-1);
        Assertions.assertEquals(99, listDemo.size());
        Assertions.assertEquals(98, listDemo.get(99));
    }

    @Test
    public void removeLast() {
        listDemo.remove(0);
        Assertions.assertEquals(99, listDemo.size());
        Assertions.assertEquals(1, listDemo.get(0));
    }

}