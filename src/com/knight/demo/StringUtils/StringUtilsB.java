/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2017 All Rights Reserved.
 */
package com.knight.demo.StringUtils;

/**
 * @author hujie
 * @version Id: StringUtilsB.java, v 0.1 2017/12/21 10:10 hujie Exp $$
 */
public class StringUtilsB {

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }
}