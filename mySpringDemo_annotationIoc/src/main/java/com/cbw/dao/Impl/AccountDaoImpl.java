package com.cbw.dao.Impl;

import com.cbw.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 *     <bean id="accountDao" class="com.cbw.dao.Impl.AccountDaoImpl"></bean>
 *
 * 账户的持久层实现类
 */
@Repository("accountDaoImpl")
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
