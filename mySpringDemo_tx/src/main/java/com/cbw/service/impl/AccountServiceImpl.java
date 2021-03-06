package com.cbw.service.impl;

import com.cbw.dao.IAccountDao;
import com.cbw.domain.Account;
import com.cbw.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    public Account findAccountByID(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        //1.查询出转账人
        Account source = accountDao.findAccountByName(sourceName);
        //2.查询出收账人
        Account target = accountDao.findAccountByName(targetName);
        //3.转账人减钱
        source.setMoney(source.getMoney() - money);
        //4.收账人加钱
        target.setMoney(target.getMoney() + money);
        //5.更新两个账户
        accountDao.updateAccount(source);
        accountDao.updateAccount(target);

    }
}
