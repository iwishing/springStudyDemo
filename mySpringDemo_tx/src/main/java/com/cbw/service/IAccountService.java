package com.cbw.service;

import com.cbw.domain.Account;

/**
 * 账户的业务层接口
 */
public interface IAccountService {

    /**
     * 根据账户id查询账户
     * @param accountId
     * @return
     */
    Account findAccountByID(Integer accountId);

    /**
     * 转账方法
     * @param sourceName：转账人
     * @param targetName：收账人
     * @param money：转账金额
     */
    void transfer(String sourceName,String targetName,Float money);
}
