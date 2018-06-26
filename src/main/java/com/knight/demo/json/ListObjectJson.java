package com.knight.demo.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListObjectJson {

    public static void main(String[] args) {
        
        

        List<A> aList = new ArrayList<>();

        A a1 = new A();
        a1.setId("111");
        a1.setAge(20);
        a1.setOld(44444444);
        aList.add(a1);
        A a2 = new A();
        a2.setId("222");
        a2.setAge(40);
        a2.setOld(55555);
        aList.add(a2);


        for (A a: aList){
            System.out.println("转换前 id:"+a.getId()+"age:"+a.getAge());
        }


        System.out.println("List 转 json :" +JSON.toJSONString(aList));

        String jsonStr = JSON.toJSONString(aList);


        System.out.println("Json 转 List :" +JSON.parseArray(jsonStr,B.class));

        List<B> aList1 = JSON.parseArray(jsonStr,B.class);

        for (B a: aList1){
            System.out.println("id:"+a.getId()+"age:"+a.getAge()+"old:"+a.getOld());
        }



    }
}
