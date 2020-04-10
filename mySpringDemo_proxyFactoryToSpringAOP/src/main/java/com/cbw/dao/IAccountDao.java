package com.cbw.dao;

import com.cbw.domain.Account;

import java.util.List;

/**
 * 账户持久层接口
 */
public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 根据id查询账户
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存账户
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除账户
     * @param account
     */
    void deleteAccountJ(Account account);
    /**
     * 根据用户名查找账户
     * @param accountName
     */
    Account findAccountByName(String accountName);

}
