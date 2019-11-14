package com.sbt.javaschool.rnd;

public class  LengthComparator implements  java.util.Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length () - o2.length ();
    }
}
