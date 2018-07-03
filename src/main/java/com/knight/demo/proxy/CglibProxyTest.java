package com.knight.demo.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyTest {

    public static void main(String[] args) {

        //目标对象
        UserDao target = new UserDao();

        //代理对象
        UserDao proxy = (UserDao)new ProxyFactory(target).getProxyInstance();

        //执行代理对象的方法
        proxy.save();
    }
}


class UserDao{

    public void save(){

        System.out.println("-----数据已保存----");
    }
}

/**
 * Cglib子类代理工厂
 * 对UserDao在内存中动态构建一个子类对象
 */
class ProxyFactory implements MethodInterceptor {

    //维护目标对象
    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }


    //给目标对象创建一个代理对象
    public Object getProxyInstance(){

        //1.工具类
        Enhancer enhancer = new Enhancer();
        //2.设置父类
        enhancer.setSuperclass(target.getClass());
        //3.设置回调函数
        enhancer.setCallback(this);
        //4.创建子类(代理对象)
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("开始事务...");

        //执行目标对象的方法
        Object returnValue = method.invoke(target,objects);

        System.out.println("提交事务...");


        return returnValue;
    }
}