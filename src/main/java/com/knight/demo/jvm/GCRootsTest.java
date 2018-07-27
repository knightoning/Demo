package com.knight.demo.jvm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GCRootsTest {

    public static final Map<Object,String> result = new HashMap<>();
    public static void main(String[] args) {


        for(int i=0;i<10000000;i++){

            A a = new A();
            result.put(a,String.valueOf(i));

        }
    }
}
