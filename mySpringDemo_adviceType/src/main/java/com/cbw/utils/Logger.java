package com.cbw.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于记录日志的工具类，它里面提供了公共的代码
 */
public class Logger {

    /**
     * 前置通知
     */
    public void beforePrintLog(){
        System.out.println("前置通知：Logger类中的printLog方法开始执行");
    }
    /**
     * 后置通知
     */
    public void afterReturningPrintLog(){
        System.out.println("后置通知：Logger类中的afterReturningPrintLog方法开始执行");
    }
    /**
     * 异常通知
     */
    public void afterThrowingPrintLog(){
        System.out.println("异常通知：Logger类中的afterThrowingPrintLog方法开始执行");
    }
    /**
     * 最终通知
     */
    public void afterPrintLog(){
        System.out.println("最终通知：Logger类中的afterPrintLog方法开始执行");
    }

    /**
     * 环绕通知
     * 问题：
     *      当我们配置了环绕通知的时候，切入点方法却没有执行，而环绕方法执行了
     * 分析；
     *      通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知中有明确的切入点方法的调用，而这段代码中没有
     * 解决：
     *      spring框架为我们提供了一个接口，ProceedingJoinPoint。该接口有一个方法proceed()，此方法就相当于明确调用切入点方法。
     *      该接口可以作为环绕通知的方法参数，在程序执行时spring框架会为我们提供该接口的实现类供我们使用
     * spring中的环绕通知：
     *      它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        //明确调用切入点方法
        try {
            //得到方法执行所需参数
            Object [] args = pjp.getArgs();
            //明确调用业务层方法
            rtValue = pjp.proceed(args);
            return rtValue;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("Logger类中的arountPrintLog方法开始执行");
        return rtValue;
    }
}
