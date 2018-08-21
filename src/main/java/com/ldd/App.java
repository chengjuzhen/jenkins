package com.ldd;

public class App {
    public static void main(String[] args) {
        System.out.println(eat("fish"));
        System.out.println(new App().drink());
    }

    public static String eat(String food){
        System.out.println("choose "+food);

        if(food.equals("fish")){
            return "chicken";

        }
        return food;

    }
    public boolean drink(){

        System.out.println("drink beer");
        return true;
    }
}
