package com.ldd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Animal {
    public String name;
    private int id;
    public Animal(String myName, int myid) {
        name = myName;
        id = myid;
    }
    public void eat(){

//        int age = 23 "select age from student ";

        int[] array = new int[3];

        array[0] = 0;
        array[1] = 0;
        array[2] = 0;

        List arraylist = new ArrayList();
        List Linkedlist = new LinkedList();





        System.out.println(name+"正在吃");
    }
    public void sleep(){
        System.out.println(name+"正在睡");
    }
    public String introduction(String name) {
        System.out.println("大家好！我是"         + id + "号" + name + ".");

        return name;
    }
}
