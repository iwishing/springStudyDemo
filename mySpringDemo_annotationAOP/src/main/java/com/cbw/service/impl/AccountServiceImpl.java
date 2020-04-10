package com.cbw.service.impl;

import com.cbw.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * 账户的业务层实现类
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    public AccountServiceImpl() {
        System.out.println("AccountServiceImpl的构造方法");
    }

    /**
     * 保存账户方法
     */
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    /**
     * 更新账户方法
     * @param i
     */
    public void updateAccount(int i) {
        System.out.println("执行了更新" + i);
    }

    /**
     * 删除账户方法
     * @return
     */
    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
