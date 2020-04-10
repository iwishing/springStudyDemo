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

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public IAccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        try {
            //1.开启事务
            transactionManager.beginTranscation();
            //2.执行操作
            List<Account> accountList = accountDao.findAllAccount();
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return accountList;
        }catch (Exception e){
            //5.回滚事务
            transactionManager.rollback();
        }finally {
            //6.释放连接
            transactionManager.release();
        }
        return null;
    }

    public Account findAccountById(Integer accountId) {
        try {
            //1.开启事务
            transactionManager.beginTranscation();
            //2.执行操作
            Account account = accountDao.findAccountById(accountId);
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return account;
        }catch (Exception e){
            //5.回滚事务
            transactionManager.rollback();
        }finally {
            //6.释放连接
            transactionManager.release();
        }
        return null;
    }

    public void saveAccount(Account account) {
        try {
            //1.开启事务
            transactionManager.beginTranscation();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
        }catch (Exception e){
            //5.回滚事务
            transactionManager.rollback();
        }finally {
            //6.释放连接
            transactionManager.release();
        }
    }

    public void updateAccount(Account account) {
        try {
            //1.开启事务
            transactionManager.beginTranscation();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
        }catch (Exception e){
            //5.回滚事务
            transactionManager.rollback();
        }finally {
            //6.释放连接
            transactionManager.release();
        }
    }

    public void deleteAccountJ(Account account) {
        try {
            //1.开启事务
            transactionManager.beginTranscation();
            //2.执行操作
            accountDao.deleteAccountJ(account);
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
        }catch (Exception e){
            //5.回滚事务
            transactionManager.rollback();
        }finally {
            //6.释放连接
            transactionManager.release();
        }
    }

    public Account findAccountByName(String accountName) {
        try {
            //1.开启事务
            transactionManager.beginTranscation();
            //2.执行操作
            Account account = accountDao.findAccountByName(accountName);
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return account;
        }catch (Exception e){
            //5.回滚事务
            transactionManager.rollback();
        }finally {
            //6.释放连接
            transactionManager.release();
        }
        return null;
    }

    public void transfer(String sourceName, String targetName, Float money) {
        try {
            //1.开启事务
            transactionManager.beginTranscation();
            //2.执行操作
            //1.根据名称查询转出账户
            Account sourceAccount = accountDao.findAccountByName(sourceName);
            //2.根据名称查询转入账户
            Account targetAccount = accountDao.findAccountByName(targetName);
            //3.转出账户减钱
            sourceAccount.setMoney(sourceAccount.getMoney() - money);
            //4.转入账户加钱
            targetAccount.setMoney(targetAccount.getMoney() + money);
            //5.更新转出账户
            accountDao.updateAccount(sourceAccount);
            //6.更新转入账户
            accountDao.updateAccount(targetAccount);
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
        }catch (Exception e){
            //5.回滚事务
            transactionManager.rollback();
        }finally {
            //6.释放连接
            transactionManager.release();
        }
    }
}
