package com.knight.demo.algorithms;

import java.util.*;


/**
 * input :
 *      ["eat", "tea", "tan", "ate", "nat", "bat"]
 *
 * output:
 *     [[eat, tea, ate], [bat], [tan, nat]]
 */
public class Anagrams {

    public static void main(String[] args){

        String[] strs ={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution(strs));
    }

    public static List<List<String>> solution(String[] strs){

        if(strs.length == 0)
            return new ArrayList<>();

        Map<String,List> ans = new HashMap<String, List>();

        for(String str : strs){

            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String key = String.valueOf(chars);

            if(!ans.containsKey(key)){
                ans.put(key,new ArrayList());
            }

            ans.get(key).add(str);
        }

        return new ArrayList(ans.values());

    }
}
