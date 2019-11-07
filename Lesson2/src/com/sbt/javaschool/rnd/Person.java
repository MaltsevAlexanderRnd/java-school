package com.sbt.javaschool.rnd;

public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;
    private int age;

    public boolean isMan() {
        return man;
    }

    public String getName() {
        return name;
    }

    public String getSpouseName() {
        if (this.spouse != null) {
            return spouse.name;
        }
        return "—";
    }

    public int getAge() {
        return age;
    }

    public void increaseAge() {
        this.age += 1;
    }

    public Person(boolean man, String name, int age) {
        this.man = man;
        this.name = name;
        this.age = age;
    }

    public boolean marry(Person person) {
        if (this.age < 18 || person.getAge() < 18){
            return false;
        }
        if (this.isMan() != person.isMan()){
            if (this.spouse != null) {
                if (this.spouse.equals(person)){
                    return false;
                }
                this.spouse.divorce();
                this.divorce();
            }
            if (person.spouse != null){
                person.spouse.divorce();
                person.divorce();
            }
            this.spouse = person;
            person.spouse = this;
            return true;
        }
        return false;
    }


    public boolean divorce() {
        if (this.spouse == null) {
            return false;
        }
        this.spouse = null;
        return true;
    }
}
