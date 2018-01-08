/**
  * Bestpay.com.cn Inc.
  * Copyright (c) 2011-2018 All Rights Reserved.
  */
package com.knight.demo.scala

;

/**
  *
  * 斐波那契数列
  *
  * @author hujie
  * @version Id: Fin.java, v 0.1 2018/1/7 14:22 hujie Exp $$
  */
object Fin {


  def fin(n:Int) : Int =

    if (n == 1)
      0
    else if (n == 2)
      1
    else
      fin(n - 1) + fin(n -2)

  def main(args: Array[String]): Unit = {
    println(fin(5));
  }
}
