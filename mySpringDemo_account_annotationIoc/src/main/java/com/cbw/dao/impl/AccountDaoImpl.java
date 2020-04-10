package com.cbw.dao.impl;

import com.cbw.dao.IAccountDao;
import com.cbw.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户持久层的实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private QueryRunner runner;

    public QueryRunner getRunner() {
        return runner;
    }


    public List<Account> findAllAccount() {
        try {
            return runner.query("SELECT * FROM account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account findAccountById(Integer accountId) {
        try {
            return runner.query("SELECT * FROM account WHERE id = ?",new BeanHandler<Account>(Account.class),accountId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveAccount(Account account) {
        try {
            runner.update("INSERT INTO account (name,money)values(?,?)",account.getName(),account.getMoney());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update("UPDATE account SET name=?,money=? WHERE id=?",account.getName(),account.getMoney(),account.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAccountJ(Account account) {
        try {
            runner.update("DELETE FROM account WHERE id=?",account.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
