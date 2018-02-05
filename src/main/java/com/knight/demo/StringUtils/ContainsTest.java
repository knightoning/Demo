/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.StringUtils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author hujie
 * @version Id: ContainsTest.java, v 0.1 2018/1/29 14:31 hujie Exp $$
 */
public class ContainsTest {

    public static void main(String[] args) {
        String failureCode = "004238|006016|006502";
        String retCode = "2";
        System.out.println(StringUtils.contains(failureCode,retCode));
    }
}