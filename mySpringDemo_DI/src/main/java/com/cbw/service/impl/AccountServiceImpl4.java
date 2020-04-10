package com.cbw.service.impl;

import com.cbw.service.IAccountService;

import java.util.*;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl4 implements IAccountService {

    //如果是经常变化的数据，并不适用于注入的方式
    private Map<Date,Date> myMap;

    public void setMyMap(Map<Date, Date> myMap) {
        this.myMap = myMap;
    }

    public void saveAccount() {
        System.out.println(myMap);
    }
}
