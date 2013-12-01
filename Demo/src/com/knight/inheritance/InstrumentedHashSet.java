package com.knight.inheritance;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<E>  extends HashSet<E> {
      
	 /**
	 * 这样直接的继承而生成的类是非常脆弱的，我们需要借助包装类，做个中间类的转换
	 */
	private static final long serialVersionUID = 2512407858863135965L;
	private static int addCount = 0;
	 
      public InstrumentedHashSet(){
    	  
      }
      
      public InstrumentedHashSet(int initCap, float loadFactor){
    	  super(initCap, loadFactor);
      }
      
     @Override public boolean add(E e){
    	  addCount ++;
    	  return super.add(e);
      }
     
     /**
      * main 函数首先调用HashSet 中的addAll() ，让执行addCount += c.size()让addCount加3
      * 然后再super.addAll 其实addAll在hashSet中与add邦定（自用性-self-use），先调用add,这样每个元素调用一次add
      * 所以addCount再加3 共计6
      * 这样简单的继承，有时会达不到我们想想的效果
      * 这样的类是非常脆弱的，当HashSet 发型版本变化后会直接破坏继承的类
      */
     @Override public boolean addAll(Collection<?  extends  E> c){
    	  addCount += c.size();
    	  return super.addAll(c);
     }
     
     public static int getAddCount(){
    	 return addCount;
     }
     
     @Override public String  toString(){
    	 return "add 的总的次数是：" + getAddCount();
     }
     
    
     public static void main(String[] args){
    	   
    	   InstrumentedHashSet<String> s = new InstrumentedHashSet<String>();
    	   s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
    	   System.out.println(s.toString());
     }
}
