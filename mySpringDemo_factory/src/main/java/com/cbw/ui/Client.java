package com.cbw.ui;

import com.cbw.factory.BeanFactory;
import com.cbw.service.IAccountService;
import com.cbw.service.impl.AccountServiceImpl;

/**
 **模拟一个表现层，用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
        IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
        as.saveAccount();
    }
}
