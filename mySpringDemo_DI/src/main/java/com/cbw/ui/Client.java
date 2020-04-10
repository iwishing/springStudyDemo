package com.cbw.ui;


import com.cbw.service.IAccountService;
import com.sun.org.apache.xml.internal.utils.XML11Char;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * auther:iwishing
 **获取spring的IoC容器，并根据id获取对象
 */
public class Client {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        IAccountService as = (IAccountService)ac.getBean("accountService");

        as.saveAccount();

    }
}
