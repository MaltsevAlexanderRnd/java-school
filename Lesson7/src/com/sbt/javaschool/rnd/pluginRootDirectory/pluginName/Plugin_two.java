package com.sbt.javaschool.rnd.pluginRootDirectory.pluginName;

import com.sbt.javaschool.rnd.Plugin;

public class Plugin_two  implements Plugin {
    public Plugin_two() {
        System.out.println("Constructor of Plugin_two");
    }

    @Override
    public void doSomething() {
        System.out.println("Plugin_two executes - doSomething");
    }
}
