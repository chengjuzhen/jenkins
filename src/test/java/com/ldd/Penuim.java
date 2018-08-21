package com.ldd;

import org.junit.Before;

public class Penuim extends Animal {




    int age;

    public Penuim(String myName, int myid) {
        super(myName, myid);
    }

    public Penuim(String myName, int myid, int age) {
        super(myName, myid);
        setAge(age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
