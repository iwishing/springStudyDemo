package com.cbw.Factory;

import com.cbw.service.IAccountService;
import com.cbw.service.impl.AccountServiceImpl;

public class StaticFactory {
    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
