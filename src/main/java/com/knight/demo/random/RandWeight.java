/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.random;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 根据每台服务器ip对应的权重取对应随机数，该随机数为ip出现的次数
 *
 * @author hujie
 * @version Id: RandWeight.java, v 0.1 2018/6/5 09:16 hujie Exp $$
 */
public class RandWeight {



    public static void main(String[] args){

        int j1 = 0;//统计172.168.56.1出现次数
        int j2 = 0;//统计172.168.56.2出现次数
        int j3 = 0;//统计172.168.56.3出现次数

        for (int i =0 ; i<10000;i++) { //测试循环

            
            List<Weight> weights = new ArrayList<>();
            Random random = new Random();
            Weight w1 = new Weight("172.168.56.1", 10);
            Weight w2 = new Weight("172.168.56.2", 70);
            Weight w3 = new Weight("172.168.56.3", 20);

            weights.add(w1);
            weights.add(w2);
            weights.add(w3);

            int totalWeight = 0;
            for (Weight weight : weights) {
                totalWeight += weight.weight;
            }

            if (totalWeight <= 0) {
                System.out.println("Error wight sum....");
            }

            int n = random.nextInt(totalWeight);
            int m = 0;


            for (Weight weight : weights) {

                if ((m <= n) && n < (m + weight.weight)) {
                    System.out.println("This random Weight" + weight.ip);

                    /**
                     * 测试数据统计
                     */
                    if(StringUtils.equals(weight.ip,"172.168.56.1")){
                        j1 ++;
                    }
                    if(StringUtils.equals(weight.ip,"172.168.56.2")){
                        j2 ++;
                    }

                    if(StringUtils.equals(weight.ip,"172.168.56.3")){
                        j3 ++;
                    }

                    break;
                }
                m += weight.weight;
            }

        }

        System.out.println("172.168.56.1出现次数："+j1+",172.168.56.2出现次数："+j2+",172.168.56.3出现次数："+j3);
    }

    static class Weight{


        public Weight(String ip,int weight){
            this.ip = ip;
            this.weight = weight;
        }

        /**
         * 服务器ip
         */
        private String ip;

        /**
         * 权重
         */
        private int weight;

        /**
         * 返回ip
         * @return
         */
        public String getIp() {
            return ip;
        }

        public int getWeight() {
            return weight;
        }
    }
}