package com.sbt.javaschool.rnd.pluginRootDirectory.pluginName;

import com.sbt.javaschool.rnd.Plugin;

public class Plugin_one implements Plugin  {
    public Plugin_one() {
        System.out.println("Constructor of Plugin_one");
    }

    @Override
    public void doSomething() {
        System.out.println("Plugin_one executes - doSomething");
    }
}
