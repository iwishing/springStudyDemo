package com.cbw.ui;

import com.cbw.dao.IAccountDao;
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
 * ApplicationContext的三个常用实现类
 *      ClassPathXmlApplicationContext：它可以加载类路径下的xml文件，要求配置文件必须在类路径下，否则加载不了(实际开发更常用)
 *      FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件，前提是有访问权限
 *      AnnotationConfigApplicationContext：它是用于读取注解创建容器
 *
 * ApplicationContext和BeanFactory的区别
 *      ApplicationContext：--------------单例对象适用（一创建就存进去），开发时常用
 *          它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件
 *          中配置的对象
 *          测试方法：给对象添加一个构造函数，里面打印一句语句，然后yogaApplicationContext构造容器的时候可以看到这条语句打印出来了
 *      BeanFactory：--------------多例对象适用（即用即创），顶层接口，功能没有子接口完善，故开发常使用上个接口
 *          它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象
 */
public class Client {
    public static void main(String[] args) {
/*     //ApplicationContext接口
       //1.通过ClassPathXmlApplicationContext实现类获取核心容器对象
        //ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过FileSystemXmlApplicationContext实现类获取核心容器对象
        ApplicationContext ac = new FileSystemXmlApplicationContext("E:\\myCodeSpace\\mySpringDemo\\mySpringDemo_spring\\src\\main\\resources\\applicationContext.xml");
        //2.根据id获取bean对象
        //根据唯一标识符，获取object对象再强转
        IAccountService as = (IAccountService)ac.getBean("accountService");
        //根据字节码自己强转
        IAccountDao ad = ac.getBean("accountDao",IAccountDao.class);
        as.saveAccount();*/

     //BeanFactory接口
        //1.通过ClassPathResource实现类找到配置文件
        Resource resource = new ClassPathResource("applicationContext.xml");
        //2.通过XmlBeanFactory实现类构建容器
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        //3.通过id创建bean对象
        IAccountService as = (IAccountService) beanFactory.getBean("accountService");
        as.saveAccount();
    }
}
