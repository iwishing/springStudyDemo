package com.cbw;

import com.cbw.domain.Account;
import com.cbw.service.IAccountService;
import com.cbw.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用junit单元测试测试我们的配置
 */
public class accountTest {
    private IAccountService accountService;

    /**
     * 测试查询所有方法
     */
    @Test
    public void testFindAll(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取bean对象
        accountService = ac.getBean("accountService",IAccountService.class);
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

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        accountService = ac.getBean("accountService",IAccountService.class);

        Account accountList = accountService.findAccountById(4);
        System.out.println(accountList);

    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSaveAccount(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取bean对象
        accountService = ac.getBean("accountService",IAccountService.class);
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
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        accountService = ac.getBean("accountService",IAccountService.class);
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
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        accountService = ac.getBean("accountService",IAccountService.class);
        Account account = new Account();
        account.setId(4);
        accountService.deleteAccountJ(account);
    }
}
