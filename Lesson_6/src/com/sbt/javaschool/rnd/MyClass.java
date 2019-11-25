package com.sbt.javaschool.rnd;


import java.util.Objects;

public class MyClass {
    private int value1;
    private int value2;
    private int value3;

    public MyClass(int value1, int value2, int value3) {
        this.value1  = value1 ;
        this.value2  = value2 ;
        this.value3  = value3 ;
    }

    public MyClass() {
        this.value1  = 0;
        this.value2  = 0;
        this.value3  = 0;
    }

    public int getValue1 () {
        return value1 ;
    }

    private void getValue2() {
    }

    private int getValue3 () {
        return value3 ;
    }

    public void setValue1 (int value1 ) {
        this.value1  = value1 ;
    }

    private void setValue2 () {
        value2  = 0;
    }

    public void setValue3 (int value3) {
        this.value3  = value3 ;
    }

    @Override
    public String toString() {
        return String.format("value1 = %d, value2 = %d, value3 = %d", value1 , value2 , value3);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object .getClass()) return false;

        MyClass myClass = (MyClass) object;
        return  value1  == myClass.value1 &&
                value2  == myClass.value2  &&
                value3  == myClass.value3;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value1 , value2 , value3);
    }
}