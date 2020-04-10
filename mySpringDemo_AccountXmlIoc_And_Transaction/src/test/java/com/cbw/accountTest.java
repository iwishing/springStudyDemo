package com.cbw;

import com.cbw.domain.Account;
import com.cbw.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用junit单元测试测试我们的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class accountTest {
    @Autowired
    @Qualifier("proxyAccountService")
    private IAccountService accountService;

    /**
     * 测试转账方法
     */
    @Test
    public void testTransfer(){
        System.out.println("转账前");
        testFindAll();
        accountService.transfer("aaa","bbb",200f);
        System.out.println("转账后");
        testFindAll();
    }

    /**
     * 测试查找全部方法
     */
    @Test
    public void testFindAll(){
        List<Account> accountList = accountService.findAllAccount();
        System.out.println(accountList);
    }
}
