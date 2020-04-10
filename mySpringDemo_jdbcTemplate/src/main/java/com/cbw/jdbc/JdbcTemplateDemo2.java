package com.cbw.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *JdbcTemplate的crud操作
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取JdbcTemplate对象
        JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate",JdbcTemplate.class);
        jt.execute("insert into account(name,money)values('xxx',10000)");

/*        //准备数据源：c3p0，dbcp都能用，但是这里我们使用spring内置的数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/myspringspace");
        ds.setUsername("root");
        ds.setPassword("123456");
        //1.创建JdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate();
        //2.设置数据源
        jt.setDataSource(ds);
        //3.执行操作
        jt.execute("insert into account(name,money)values('ccc',1000)");*/
    }
}
