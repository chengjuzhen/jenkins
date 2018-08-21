package com.ldd;

import com.javasampleapproach.multipartfile.SpringUploadDownloadMultipartFileApplication;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.beans.Transient;
import java.io.File;
import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration()
public class AppTest {

    //成员变量
    int age;
    double l;
    boolean b;

    String[] food;
    App app;
    String str;


//    成员方法
    @Before
    public void init(){
        food = new String[]{"chicken","apple","pear"};

    }

    @Test
    public void eatTest(){

        Assert.assertEquals("eat food","chicken", App.eat("fish"));
//        Assert.assertEquals("",App.eat("chicken"));
        Assert.assertNotEquals("fish",App.eat(food[0]));
        Assert.assertNotEquals("fish",App.eat(food[1]));
        Assert.assertNotEquals("fish",App.eat(food[2]));
        Assert.assertEquals("is ture?",true, new App().drink());
    }
    @Test
    public void drinkTest(){
        Assert.assertTrue(new App().drink());
        Assert.assertNotEquals("fish",App.eat("chicken"));
        Assert.assertNotEquals("fish",App.eat("apple"));
        Assert.assertNotEquals("fish",App.eat("pear"));

    }

    @After
    public void finish(){
        food = null;
        System.out.println("test finish");


    }

}
