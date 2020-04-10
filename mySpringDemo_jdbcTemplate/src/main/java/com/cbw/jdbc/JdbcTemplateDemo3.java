package com.cbw.jdbc;

import com.cbw.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *JdbcTemplate最基础用法
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取JdbcTemplate对象
        JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate",JdbcTemplate.class);

        //保存
            //jt.update("insert into account(name,money)values(?,?)","zzz",1000f);
        //更新
            //jt.update("update account set name=?,money=? where id=?","llll",20000f,8);
        //删除
            //jt.update("delete from account where id=?",9);
        //查询所有
       /*List<Account> accountList = jt.query("select * from account where money=?",new BeanPropertyRowMapper<Account>(Account.class),1000f);
        for (Account al:accountList
             ) {
            System.out.println(al);
        }*/
        //查询一个
/*
        List<Account> accountList = jt.query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),1);
        System.out.println(accountList.isEmpty() ? "没有内容" : accountList.get(0));
*/
        //查询返回一行一列(使用聚合函数，但是不加group by字句)
        long count = jt.queryForObject("select count(*) from account where money>?",long.class,1000f);
        System.out.println(count);
    }


}
/**
 * 定义account封装策略
 */
class AccountRowMapper implements RowMapper {

    /**
     * 把结果集中的数据封装到Account中，并由spring把每个Account加入到List集合中
     *
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));

        return account;
    }
}