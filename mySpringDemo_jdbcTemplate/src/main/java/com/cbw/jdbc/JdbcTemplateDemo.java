package com.cbw.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *JdbcTemplate最基础用法
 */
public class JdbcTemplateDemo {
    public static void main(String[] args) {
        //准备数据源：c3p0，dbcp都能用，但是这里我们使用spring内置的数据源
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
        jt.execute("insert into account(name,money)values('ccc',1000)");
    }
}
