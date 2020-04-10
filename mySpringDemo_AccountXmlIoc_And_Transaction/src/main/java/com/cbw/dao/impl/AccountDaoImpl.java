package com.cbw.dao.impl;

import com.cbw.dao.IAccountDao;
import com.cbw.domain.Account;
import com.cbw.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户持久层的实现类
 */

public class AccountDaoImpl implements IAccountDao {

    private QueryRunner runner;
    private ConnectionUtils connectionUtils;

    public QueryRunner getRunner() {
        return runner;
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public List<Account> findAllAccount() {
        try {
            return runner.query(connectionUtils.getThreadConnection(),"SELECT * FROM account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account findAccountById(Integer accountId) {
        try {
            return runner.query(connectionUtils.getThreadConnection(),"SELECT * FROM account WHERE id = ?",new BeanHandler<Account>(Account.class),accountId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"INSERT INTO account (name,money)values(?,?)",account.getName(),account.getMoney());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"UPDATE account SET name=?,money=? WHERE id=?",account.getName(),account.getMoney(),account.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAccountJ(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"DELETE FROM account WHERE id=?",account.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Account findAccountByName(String accountName) {
        try {
            List<Account> accountList=runner.query(connectionUtils.getThreadConnection(),"SELECT * FROM account WHERE name = ?",new BeanListHandler<Account>(Account.class),accountName);
            if(accountList == null || accountList.size() == 0){
                return null;
            }
            if ( accountList.size() > 1){
                throw new RuntimeException("结果集不唯一，数据有问题");
            }
            return accountList.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
