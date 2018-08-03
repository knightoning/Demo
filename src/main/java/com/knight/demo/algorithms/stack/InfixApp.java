package com.knight.demo.algorithms.stack;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InfixApp {

    public static void main(String[] args) {

        String input,output;

        while(true){

            System.out.print("Enter infix: ");
            System.out.flush();

            input = getString();

            if(StringUtils.equals(" ",input)){
                break;
            }

            InToPost inToPost = new InToPost(input);

            output = inToPost.doTrans();

            System.out.println("Postfix is " + output +'\n');
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
