package com.cbw.Factory;

import com.cbw.service.IAccountService;
import com.cbw.service.impl.AccountServiceImpl;

public class InstanceFactory {
    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
