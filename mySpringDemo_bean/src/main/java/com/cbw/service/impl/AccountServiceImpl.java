package com.cbw.service.impl;

import com.cbw.dao.IAccountDao;
import com.cbw.dao.Impl.AccountDaoImpl;
import com.cbw.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao iAccountDao;

    public void saveAccount() {
        iAccountDao.saveAccount();
    }
}
