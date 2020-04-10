package com.cbw.jdbc;

import com.cbw.dao.IAccountDao;
import com.cbw.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *JdbcTemplate的crud操作
 */
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取持久层对象
        IAccountDao accountDao = (IAccountDao)ac.getBean("accountDao",IAccountDao.class);
        //查找
        Account account = accountDao.findAccountById(1);
        //更前数据
        System.out.println("更新前");
        System.out.println(account);
        //执行更新
        account.setName("cbw");
        account.setMoney(100000f);
        accountDao.updateAccount(account);
        //更后数据
        System.out.println("更新后");
        account = accountDao.findAccountById(1);
        System.out.println(account);
    }
}
