package ru.rishat;

public class App {

    public static void main(String[] args) {

        ListDemo<String> listDemo = new ArrayListDemo<>();

//        listDemo.add(1);
        listDemo.add("one");

        System.out.println(listDemo.get(0));
        System.out.println(listDemo.size());

//        System.out.println(2 << 1);
    }
}
