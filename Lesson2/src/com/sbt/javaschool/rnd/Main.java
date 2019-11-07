package com.sbt.javaschool.rnd;

public class Main {

    public static void main(String[] args) {
        Person alexander = new Person(true, "Alexander", 26);
        Person victroria = new Person(false, "Victroria", 22);
        Person sergei = new Person(true, "Sergei", 25);
        Person ekaterina = new Person(false, "Ekaterina", 20);
        alexander.marry(victroria);
        sergei.marry(ekaterina);
        System.out.println(victroria.getSpouseName());
        System.out.println(ekaterina.getSpouseName());
    }
}
