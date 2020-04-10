package com.cbw.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


import java.lang.reflect.Method;


/**
 * 模拟一个消费着
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();

        /*
        *动态代理：
        *   特点：字节码随用随创建，随用随加载
        *   作用：不修改源码的基础上对方法增强
        *   分类：
        *       1.基于接口的动态代理
        *       2.基于子类的动态代理
        * 这里我们使用基于子类的动态代理：
        *       涉及的类：Enhancer
        *       提供者：第三方cglib库
        * 学习过程：
        *       1.如何创建代理对象：
        *           使用Enhancer类中的create方法
        *       2.创建代理对象的要求：
        *           被代理对象不能是最终类
        *       3.create方法参数：
        *           Class：字节码，用于指定被代理对象的字节码，固定写法，类.getClass()
        *           Callback：用于让我们写如何代理，一般写一个该接口的实现类，常用MethodInterceptor，通常情况下都是写匿名内部类，但不是必须的，谁用谁写
         */
        Producer proxyProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {

            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //这里进行方法增强，比如，这里我们可以抽取部分提成
                Object returnValue = null;
                //1.获取方法执行的参数
                Float money = (Float)args[0];
                //2.判断当前方法是不是销售
                if("saleProduct".equals(method.getName())){
                    System.out.println("售价:" + money);
                    returnValue = method.invoke(producer,money*0.8f);
                }
                return returnValue;
            }
        });
        proxyProducer.saleProduct(10000f);

    }
}