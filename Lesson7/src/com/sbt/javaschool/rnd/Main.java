package com.sbt.javaschool.rnd;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Plugin_three plugin_three = new Plugin_three();
        plugin_three.doSomething();

        String path =  System.getProperty("user.dir");

        path += "/out/production/Lesson7/";

        ArrayList<File> files = new ArrayList<>();

        File directory = new File(path + "com/sbt/javaschool/rnd/pluginRootDirectory/pluginName");

        if(directory.exists()) {
            findFiles(directory,".class", files);
            for (int i = 0; i < files.size(); i++) {
                PluginManager pluginManager = new PluginManager(path);

                //System.out.println(files.get(i).getAbsolutePath()) ;

                String pluginName = files.get(i).getAbsolutePath().substring(
                        files.get(i).getAbsolutePath().indexOf("com\\"),
                        files.get(i).getAbsolutePath().length()-6
                );

               // System.out.println(pluginName);

                LinkedList<String> Array = new LinkedList();
                for (String retval : pluginName.split("\\\\")) {
                    Array.add(retval);
                }

                String plugin_ClassName = Array.get(6);

                Plugin plugin = pluginManager.load( normalize(pluginName), plugin_ClassName);
                plugin.doSomething();

            }
        }
    }
    public static void findFiles(File file, String wordStr, ArrayList<File> arrayList) {
        if (file.isDirectory()) {
            File[] files = file.listFiles(); // All files and subdirectories
            for (int i = 0; files != null && i < files.length; i++) {
                if(files[i].getAbsolutePath().indexOf(wordStr)!=-1) {
                    arrayList.add(files[i]);
                }
                findFiles(files[i], wordStr, arrayList); // Recursive call
            }
        }
    }
    private static String normalize(String str) {

        if(str.indexOf("/") >=0)
            return str.replace('/', '.');
        else
            return str.replace('\\', '.');
    }
}