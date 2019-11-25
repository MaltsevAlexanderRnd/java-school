package com.sbt.javaschool.rnd;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;



public class BeanUtils {

    public static void assign(Object to, Object from) {
        Class<?> objectTo = to.getClass();

        List<Method> publicGetterMethodsFrom = getMethodsForPrefix(getOnlyPublicMethods(from), "get");
        System.out.println(" getter object from:");
        publicGetterMethodsFrom.forEach(System.out::println);

        for (Method methodGet : publicGetterMethodsFrom) {
            String name = "set" + methodGet.getName().substring(3);
            try {
                Method method = objectTo.getMethod(name, methodGet.getReturnType());
                Object value = methodGet.invoke(from);
                method.invoke(to, value);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<Method> getOnlyPublicMethods(Object object) {
        List<Method> methods = new ArrayList<>();
        Class<?> clazz = object.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            if (Modifier.isPublic(method.getModifiers())) {
                methods.add(method);
            }
        }

        return methods;
    }

    private static List<Method> getMethodsForPrefix(List<Method> list, String prefix) {
        List<Method> result = new ArrayList<>();
        for (Method method : list) {
            String n = method.getName();
            if (method.getName().contains(prefix)) {
                result.add(method);
            }
        }

        return result;
    }
}
