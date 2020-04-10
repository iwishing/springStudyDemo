package com.cbw.factory;

import com.cbw.service.IAccountService;
import com.cbw.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建service的代理对象的工厂
 */
public class BeanFactory {

    private IAccountService accountService;
    private TransactionManager transactionManager;

    public final void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    /**
     * 用于注入的set方法
     * @param accountService
     */
    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 获取service代理对象的方法
     * @return
     */
    public IAccountService getAccountService(){
       return  (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 添加事务的支持
             * @param proxy
             * @param method
             * @param args
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object rtValue = null;
                try {
                    //1.开启事务
                    transactionManager.beginTranscation();
                    //2.执行操作
                    rtValue = method.invoke(accountService,args);
                    //3.提交事务
                    transactionManager.commit();
                    //4.返回结果
                    return rtValue;
                }catch (Exception e){
                    //5.回滚事务
                    transactionManager.rollback();
                }finally {
                    //6.释放连接
                    transactionManager.release();
                }
                return rtValue;
            }
        });
    }
}
