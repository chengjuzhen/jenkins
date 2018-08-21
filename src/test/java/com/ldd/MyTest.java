package com.ldd;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class MyTest {

    List list1 = new ArrayList();


    @Test
    public void myTest(){

        List list = mock(List.class);

        when(list.get(0)).thenReturn(111);
        when(list.get(1)).thenReturn(121);
        list.add(123);
        list.add(456);



         when(list.get(0)).thenReturn(0).thenReturn(1);
         when(list.get(1)).thenReturn(111,121);
         when(list.get(anyInt())).thenReturn("000");

        Assert.assertEquals("000", list.get(0) );
//        Assert.assertEquals(1,list.get(0));
//        Assert.assertEquals(111,list.get(1));
//        Assert.assertEquals(121,list.get(1));
////        verify(list,times(2)).get(0);
//        /* 当调用 someMethod() 方法时会抛出异常 */
////        when(list.get(0)).thenThrow(new IOException());
//
//        /* 对 void 方法设定 */
////        doThrow(new RuntimeException()).when(mock).someMethod();
//        doThrow(new IOException()).when(list).get(0);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.size());

        List list1 = new ArrayList();
        List list2 = spy(list1);

        list2.add("hello");
        list2.add("hi");
//stub
        when(list2.get(0)).thenReturn("hello world");
        when(list2.get(1)).thenReturn("hi world");

        System.out.println(list2.get(0));
        System.out.println(list2.get(1));
        System.out.println(list2.size());







    }



}
