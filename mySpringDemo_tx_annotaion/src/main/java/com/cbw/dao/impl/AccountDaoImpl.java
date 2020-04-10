package com.cbw.dao.impl;

import com.cbw.dao.IAccountDao;
import com.cbw.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Account findAccountById(Integer accountId) {
        List<Account> accountList = jdbcTemplate.query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return accountList.isEmpty()?null:accountList.get(0);
    }

    public Account findAccountByName(String accountName) {
        List<Account> accountList = jdbcTemplate.query("select * from account where name =?",new BeanPropertyRowMapper<Account>(Account.class),accountName);
        return accountList.isEmpty()?null:accountList.get(0);
    }

    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }
}
