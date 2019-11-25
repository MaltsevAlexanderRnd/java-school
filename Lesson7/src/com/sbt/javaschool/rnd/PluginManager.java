package com.sbt.javaschool.rnd;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class PluginManager extends ClassLoader{
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) {
        try {
            URL myUrl = new URL("file:" + pluginRootDirectory + normalize(pluginName, pluginRootDirectory) + ".class");
            URLConnection connection = myUrl.openConnection();
            InputStream input = connection.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int data = input.read();

            while (data != -1) {
                buffer.write(data);
                data = input.read();
            }

            input.close();

            byte[] classData = buffer.toByteArray();

            return (Plugin) defineClass(pluginName,
                    classData, 0, classData.length).newInstance();
        }catch (Exception e){
            return null;
        }
    }
    private String normalize(String str, String dir) {

        if(dir.charAt(dir.length()-1) == '/')
            return str.replace('.', '/');
        else
            return str.replace('.', '\\');
    }
}



