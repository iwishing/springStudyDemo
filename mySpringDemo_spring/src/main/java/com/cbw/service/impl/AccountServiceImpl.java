package com.cbw.service.impl;

import com.cbw.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    public AccountServiceImpl(String s){}
    public AccountServiceImpl(){}
    public void saveAccount() {
        System.out.println("accountService中的saveAccount方法执行了");
    }
    public void init(){
        System.out.println("对象初始化了");
    }
    public void destroy(){
        System.out.println("对象销毁了");
    }
}
