package com.cbw.service.impl;

import com.cbw.dao.IAccountDao;
import com.cbw.domain.Account;
import com.cbw.service.IAccountService;
import com.cbw.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 账户的业务层实现类
 * 事务的控制都是在业务层的
 */

public class AccountServiceImpl_new implements IAccountService {
    private IAccountDao accountDao;

    public IAccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        //2.执行操作
            List<Account> accountList = accountDao.findAllAccount();
            return accountList;

    }

    public Account findAccountById(Integer accountId) {

            //2.执行操作
            Account account = accountDao.findAccountById(accountId);
            //4.返回结果
            return account;
    }

    public void saveAccount(Account account) {
            //2.执行操作
            accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
            //2.执行操作
            accountDao.updateAccount(account);
    }

    public void deleteAccountJ(Account account) {

            //2.执行操作
            accountDao.deleteAccountJ(account);
    }

    public Account findAccountByName(String accountName) {
            //2.执行操作
            Account account = accountDao.findAccountByName(accountName);
            //4.返回结果
            return account;
    }

    public void transfer(String sourceName, String targetName, Float money) {
        //2.执行操作
            //1.根据名称查询转出账户
            Account sourceAccount = accountDao.findAccountByName(sourceName);
            //2.根据名称查询转入账户
            Account targetAccount = accountDao.findAccountByName(targetName);
            //3.转出账户减钱
            sourceAccount.setMoney(sourceAccount.getMoney() - money);
            int i=1/0;
            //4.转入账户加钱
            targetAccount.setMoney(targetAccount.getMoney() + money);
            //5.更新转出账户
            accountDao.updateAccount(sourceAccount);
            //6.更新转入账户
            accountDao.updateAccount(targetAccount);
    }
}
