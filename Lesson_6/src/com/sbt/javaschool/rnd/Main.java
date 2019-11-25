package com.sbt.javaschool.rnd;


public class Main {
    public static void main(String[] args) {
        MyClass from = new MyClass(25, 37, 186);
        MyClass to = new MyClass();

        System.out.println(" ");
        System.out.println(" -/Before/-");
        print(from, to);
        BeanUtils.assign(to, from);
        System.out.println(" ");
        System.out.println(" -/After/-");
        print(from, to);

    }

    static void print(Object from, Object to) {
        System.out.println(" from: " + from.toString());
        System.out.println(" to: " + to.toString());
        System.out.println(" Equals from to? : " + from.equals(to));
        System.out.println(" ");
    }
}