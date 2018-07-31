package com.knight.demo.algorithms.stack;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 字符串反转：原字符串：i do it 反转后字符串：ti od i
 */
public class ReverseTest {

    public static void main(String[] args) {


        String input,output;

        while (true){
            System.out.print("Enter a string:");
            System.out.flush();

            input =getString();

            if (StringUtils.equals(input," ")){
                break;
            }

            Reverse reverse = new Reverse(input);
            output = reverse.doRev();

            System.out.println("Reversed :" + output);
        }
    }

    public static String getString(){

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String s = null;
        try {
            s = bufferedReader.readLine();
        } catch (IOException e) {
        }

        return s;
    }
}
