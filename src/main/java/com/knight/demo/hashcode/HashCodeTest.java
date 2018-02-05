package com.knight.demo.hashcode;

/**
 * 1、str1和str2的hashCode是相同的，是因为String类重写了hashCode方法，
 *    它根据String的值来确定hashCode的值，所以只要值一样，hashCode就会一样。
 * 2、2、str1和str2的identityHashCode不一样，虽然String重写了hashCode方法，
 *    identityHashCode永远返回根据对象物理内存地址产生的hash值，所以每个String对象的物理地址不一样，
 *    identityHashCode也会不一样。
 * 3、User对象没重写hashCode方法，所以hashCode和identityHashCode返回的值一样。
 *
 * hashCode方法可以被重写并返回重写后的值，identityHashCode会返回对象的hash值而不管对象是否重写了hashCode方法。
 */
public class HashCodeTest {


    public static void main(String[] args){

        String str1 = new String("abc");
        String str2 = new String("abc");

        System.out.println("str1 hashcode :"+str1.hashCode());
        System.out.println("str2 hashcode :"+str2.hashCode());

        System.out.println("str1 identityHashCode " + System.identityHashCode(str1));
        System.out.println("str2 identityHashCode " + System.identityHashCode(str2));

        User user = new User("hujie",29);

        System.out.println("user hashcode " + user.hashCode());
        System.out.println("user identityHashCode " + System.identityHashCode(user));


    }

    static class User{

        private String userName;
        private int age;

        public User(String userName,int age){
            this.userName = userName;
            this.age = age;
        }
    }

}
