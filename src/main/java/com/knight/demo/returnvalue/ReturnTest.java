package com.knight.demo.returnvalue;

/**
 * 测试 finally return 顺序
 *
 * 现在执行try 中的  i++  此时 i=2 ，此时将数值压入栈中，没立刻return
 * 而是执行finally 中 ++i
 *
 * 最后return try 中压入栈的值
 */
public class ReturnTest {

    public static void main(String[] args){

        System.out.println(getI());
    }

    public static int getI(){

        int i = 1;
        try {


            return ++i;

        }catch (Exception e){

        }finally {

           System.out.println("try ++ i"+i);

            ++i;

            System.out.println("finally ++ i"+i);
        }

      // System.out.println("getI ++ i"+i);
        return i;
    }
}
