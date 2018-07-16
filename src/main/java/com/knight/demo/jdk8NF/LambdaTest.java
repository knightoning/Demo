package com.knight.demo.jdk8NF;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {

    public static void main(String[] args) {

        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};

        List<String> players =  Arrays.asList(atp);

        for(String str : players){
            System.out.print(str + ";");
        }

        System.out.println();
        System.out.println("-----------------Lambda-----------------");

        players.forEach((player)->System.out.print(player + ";"));

    }
}
