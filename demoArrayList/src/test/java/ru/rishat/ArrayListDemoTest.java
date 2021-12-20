package ru.rishat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArrayListDemoTest {

    ArrayListDemo<Object> arrayListDemo;

    @BeforeEach
    void setUp() {
        arrayListDemo = new ArrayListDemo<>();
        for (int i = 0; i < 100; i ++) {
          arrayListDemo.add(i);
        }
    }

    @Test
    @DisplayName("Test add")
    void addTest() {
        arrayListDemo.add(new Object());
        Assertions.assertEquals(101, arrayListDemo.size());
    }

    @Test
    @DisplayName("Test remove")
    void removeTest() {
        arrayListDemo.remove(10);
        Assertions.assertEquals(99, arrayListDemo.size());
    }

    @Test
    @DisplayName("Test get")
    void getTest() {
        Assertions.assertEquals(0, arrayListDemo.get(0));
    }

    @Test
    @DisplayName("Test indexOf")
    void indexOfTest() {
        Assertions.assertEquals(10, arrayListDemo.indexOf(10));
    }

    @Test
    @DisplayName("Test size")
    void sizeTest() {
        Assertions.assertEquals(100, arrayListDemo.size());
    }
}