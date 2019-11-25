package com.sbt.javaschool.rnd;

public class Plugin_three implements Plugin {

    public Plugin_three() {
        System.out.println("Constructor of Plugin_tree");
    }

    @Override
    public void doSomething() {
        System.out.println("Plugin_three executes - doSomething!");
    }
}

