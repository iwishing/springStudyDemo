package com.cbw.dao;

import com.cbw.domain.Account;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {
    /**
     * 根据id查询账户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 根据账户名称查询账户
     * @param accountName
     * @return
     */
    Account findAccountByName(String accountName);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account  account);
}
