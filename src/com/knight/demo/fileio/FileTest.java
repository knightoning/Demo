package com.knight.demo.fileio;

import java.io.File;
import java.io.IOException;

public class FileTest {


    public static void main(String[] args){

        File file = new File("/Users/hujie/Downloads/111.txt");

        if(!file.exists()){

            System.out.println("不存在");

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
