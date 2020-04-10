package com.cbw;

import com.cbw.domain.Account;
import com.cbw.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用junit单元测试测试我们的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class accountTest2 {
    @Autowired
    private IAccountService accountService = null;

    /**
     * 测试查询所有方法
     */
    @Test
    public void testFindAll(){

        //3.执行方法
        List<Account> accountList = accountService.findAllAccount();
        for (Account aclist:accountList
             ) {
            System.out.println(aclist);
        }
    }

    /**
     * 测试根据id查询账户方法
     */
    @Test
    public void testFindById(){

        Account accountList = accountService.findAccountById(4);
        System.out.println(accountList);

    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSaveAccount(){

        //3.执行方法
        Account account = new Account();
        account.setMoney(8000f);
        account.setName("陈博文");
        accountService.saveAccount(account);
    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdateAccount(){

        Account account = new Account();
        account.setMoney(10000f);
        account.setId(4);
        accountService.updateAccount(account);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDeleteAccount(){

        Account account = new Account();
        account.setId(4);
        accountService.deleteAccountJ(account);
    }
}
