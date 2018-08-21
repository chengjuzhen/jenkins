package com.ldd;

public class Seeheoll {
    public static void main(String[] args) {
//        Mouse mouse = new Mouse("kitty",1);
////        mouse.eat();
////        mouse.sleep();
////        mouse.introduction();
////        System.out.println(mouse.name);
////        Penuim pen = new Penuim("QQ",2);
////        pen.eat();
////        pen.sleep();
////        pen.introduction();
////        System.out.println(pen.name);


        Penuim penuim = new Penuim("QQ",3);
//        penuim.introduction();
        penuim.sleep();
        penuim.eat();
        System.out.println("QQ age is "+penuim.getAge());
        penuim.setAge(12);
        System.out.println("QQ age is "+penuim.getAge());


    }
}
