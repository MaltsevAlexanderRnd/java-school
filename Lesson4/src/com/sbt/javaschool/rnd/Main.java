package com.sbt.javaschool.rnd;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(100);
        arr.add(101);
        arr.add(102);

        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(40);
        list.add(5);
        list.add(2);
        list.add(17);
        list.add(89);
        list.add(9);
        list.add(32);

        System.out.println("1) Первоначальный список:");
        list.OutputList();

        System.out.println("2) Добавлен элемент 22 по индексу 2:");
        list.add(2, 22);
        list.OutputList();

        System.out.print("3) Поиск элемента с индексом 4: ");
        //list.get(4);
        System.out.println(list.get(4));

        System.out.println("4) Удаление элемента по индексу 4:");
        list.remove(4);
        list.OutputList();

        System.out.println("5) Добавление нового листа к текущему (addAll):");
        list.addAll(arr);
        list.OutputList();

        System.out.println("6) Добавление нового листа к текущему c заменой (copy):");
        list.copy(arr);
        list.OutputList();

    }
}
