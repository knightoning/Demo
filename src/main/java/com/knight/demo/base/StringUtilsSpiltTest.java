package com.knight.demo.base;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsSpiltTest {

    public static void main(String[] args) {

        String[] bankCodes = StringUtils.split("ICBC#9888,ABC#977", ",");

        for (int i=0;i<bankCodes.length;i++){
           // System.out.println(StringUtils.substring(bankCodes[i], 0, bankCodes[i].indexOf("#")) + StringUtils.substring(bankCodes[i],bankCodes[i].indexOf("#") + 1));

            System.out.println(StringUtils.substring(bankCodes[i], 0,StringUtils.indexOf(bankCodes[i],"#")) + StringUtils.substring(bankCodes[i],StringUtils.indexOf(bankCodes[i],"#")+1));
        }
    }
}
