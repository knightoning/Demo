package com.knight.demo.base;

public class ARandom {

    public static void main(String[] args) {

        for(int j=0;j<100000;j++){
            char arr = 0;
            for(int i = 0; i < 100; i++) {
                arr = (char) (Math.random() * 26 + 'A');
            }

            System.out.print(arr);
        }

    }
}
