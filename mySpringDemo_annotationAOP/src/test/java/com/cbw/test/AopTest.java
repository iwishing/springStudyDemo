package com.cbw.test;

import com.cbw.service.IAccountService;
import com.cbw.utils.Logger;
import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
        import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试aop的配置是否成功
 */
public class AopTest {
    IAccountService accountService;

    /**
     * 测试存储账户方法
     */
    @Test
    public void testSaveAccount(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(Logger.class);
        accountService = (IAccountService) ac.getBean("accountService");
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
