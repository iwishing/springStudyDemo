package com.cbw.service.impl;

import com.cbw.dao.IAccountDao;
import com.cbw.dao.Impl.AccountDaoImpl;
import com.cbw.factory.BeanFactory;
import com.cbw.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao iAccountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    public void saveAccount() {
        iAccountDao.saveAccount();
    }
}
