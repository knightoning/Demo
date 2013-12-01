package com.knight.inheritance;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class InstrumentedHashSetForward<E> extends ForwardingSet<E>{

	private int addCount = 0;

	public InstrumentedHashSetForward(Set<E> s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
    
	@Override public boolean add(E e){
		addCount ++ ;
		return super.add(e);
	}
	
	@Override public boolean addAll(Collection<? extends E> c){
		addCount += c.size();
		return super.addAll(c);
	}
	
	public  int getAddCount(){
	    	 return addCount;
	}
	
    @Override public String  toString(){
   	 return "add 的总的次数是：" + getAddCount();
    }
	
	public static void main(String[] args){
 	
		String [] str = {"Snap", "Crackle", "Pop"};
		Set<String> s= new HashSet<String>();
		s.add(str[0]);
		s.add(str[1]);
		s.add(str[2]);
		InstrumentedHashSetForward st = new InstrumentedHashSetForward(s);
		st.addAll(s);
		System.out.println(st.toString());
	}
}
