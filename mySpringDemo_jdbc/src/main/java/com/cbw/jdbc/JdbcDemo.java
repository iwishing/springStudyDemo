package com.cbw.jdbc;

import java.sql.*;

/**
 * 程序的耦合
 *  耦合：程序间的依赖关系
 *      包括：
 *          类之间的依赖
 *          方法之间的依赖
 *
 *  解耦：降低程序间的依赖关系
 *
 *  实际开发中：
 *      应该做到，编译器不依赖，运行时才依赖
 *
 *  解耦的思路：
 *      第一步：使用反射创建对象，而避免使用new创建对象
 *          （如下面的mysql驱动，这又会产生一个问题，这个字符串是写死的，如果后来要修改数据库驱动，就很麻烦）
 *      第二部：通过读取配置文件来获取要创建的对象的全限定名
 *          （properties文件）
 */
public class JdbcDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myspringspace","root","123456");
        //3.获取操作数据的预处理对象
        PreparedStatement pstmt = con.prepareStatement("select * from account");
        //4.执行sql，得到结果集
        ResultSet rs = pstmt.executeQuery();
        //5.遍历结果集
        while (rs.next()){
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
        }
        //6.释放资源
        pstmt.close();
        con.close();
        rs.close();
    }
}
