package com.cbw.test;

import com.cbw.service.IAccountService;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.test.context.ContextConfiguration;
        import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试aop的配置是否成功
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AopTest {
    @Autowired
    IAccountService accountService;

    /**
     * 测试存储账户方法
     */
    @Test
    public void testSaveAccount(){
        accountService.saveAccount();

    }

    /**
     * 测试更新账户方法
     */
    @Test
    public void testUpdateAccount(){

     accountService.updateAccount(1);

}
    /**
     * 测试删除账户方法
     */
    @Test
    public void testdeleteAccount(){
        accountService.deleteAccount();
    }

    /**
     * 测试所有方法
     */
    @Test
    public void testAllMethod(){
        accountService.saveAccount();
        System.out.println("-----------------------");
        accountService.updateAccount(1);
        System.out.println("-----------------------");
        accountService.deleteAccount();
    }
}
