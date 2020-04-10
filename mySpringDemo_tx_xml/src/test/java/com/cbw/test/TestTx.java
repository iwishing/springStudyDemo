package com.cbw.test;

import com.cbw.domain.Account;
import com.cbw.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestTx {

    @Autowired
    private IAccountService as;

    @Test
    public void testTransfer(){
        //转账前
        System.out.println("转账前");
        Account source = as.findAccountByID(1);
        Account target = as.findAccountByID(2);
        System.out.println("转账人：" + source);
        System.out.println("收账人：" + target);

        //转账
        as.transfer(source.getName(),target.getName(),200f);

        //转账后
        System.out.println("转账后");
        source = as.findAccountByID(1);
        target = as.findAccountByID(2);
        System.out.println("转账人：" + source);
        System.out.println("收账人：" + target);
    }
}
