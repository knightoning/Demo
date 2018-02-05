package com.knight.demo.StringUtils;

import org.apache.commons.lang3.StringUtils;

/**
 * 自定义StringUtis和apache Utils 效率比较
 *
 * 自定义 6 毫秒
 *
 * apache 自带 13毫秒
 */
public class StringUtilsTest {

    public static void main(String[] args){

        String str = "aaaaa";

        long start = System.currentTimeMillis();
        for (int i=0;i<100000000;i++){
            StringUtils.isNotEmpty(str);
        }
        long end = System.currentTimeMillis();

        System.out.println("StringUtils 测试 耗时"+(end-start));


        long start1 = System.currentTimeMillis();
        for (int i=0;i<100000000;i++) {
           StringUtilsB.isNotEmpty(str);
        }
        long end1 = System.currentTimeMillis();

        System.out.println("StringUtilsB 测试 耗时"+(end1-start1));


    }
}
