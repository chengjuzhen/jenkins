package com.ldd;

import org.springframework.context.annotation.Bean;

public class CallAnimal {

    public void call(){

        Animal animal = new Animal("kitty", 2);

        animal.introduction("kitty");

    }

}
