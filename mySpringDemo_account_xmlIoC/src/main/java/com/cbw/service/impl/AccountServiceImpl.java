package com.cbw.service.impl;

import com.cbw.dao.IAccountDao;
import com.cbw.domain.Account;
import com.cbw.service.IAccountService;

import java.util.List;

/**
 * 账户的业务层实现类
 */

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public IAccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccountJ(Account account) {
        accountDao.deleteAccountJ(account);
    }
}
