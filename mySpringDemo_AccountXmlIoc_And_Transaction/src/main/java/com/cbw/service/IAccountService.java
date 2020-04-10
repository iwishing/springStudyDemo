package com.cbw.service;

import com.cbw.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface IAccountService {
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
    /**
     * 转账
     * @param sourceName：转出账户名称
     * @param targetName：转入账户名称
     * @param money：转账金额
     */
    public void transfer(String sourceName,String targetName,Float money);
}
